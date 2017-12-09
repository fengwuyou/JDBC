package cn.jbit.empty.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库操作通用类
 * @author ly
 *
 */
public class BaseDao {
//	private String driver="com.mysql.jdbc.Driver";//数据库驱动字符串
//	private String url="jdbc:mysql://localhost:3306/empty?useUnicode=true&characterEncoding=utf-8";//数据库连接字符
//	private String user="ly";//数据库名
//	private String pwd="luoyi";
	
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	//调用方法
	static{
		init();

	}
	//从配置文件中读取连接参数
	public static void init(){
		Properties params=new Properties();
		String configfile="database.properties";
		//加载啊配置文件到输入流
		InputStream is=BaseDao.class.getClassLoader().getResourceAsStream(configfile);
		//从输入流中读取属性表
		try {
			params.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//根据指定的键获取对应的值
		driver=params.getProperty("driver");
		url=params.getProperty("url");
		user=params.getProperty("user");
		pwd=params.getProperty("password");
		
	}
	Connection conn=null;
	 //1.打开数据库
	public Connection getConnection(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//2.关闭所有资源
	public void closeAll(Connection conn,PreparedStatement stmt,ResultSet rs){
			try {
				if(rs!=null){
				rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
				try {
					if(stmt!=null){
					stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if(conn!=null){
					conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	//3.增、删、改通用方法
	public int executeUpdate(String sql,Object[] param){
		int num=0;//影响行数
		conn=this.getConnection();
		PreparedStatement stmt=null;
		try {
			stmt=conn.prepareStatement(sql);
			if(param!=null){
				for(int i=0;i<param.length;i++){
					stmt.setObject(i+1,param[i]);
				}
			}
			//执行SQL语句
			num=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, stmt, null); 
		}
		return num;
				
	}
	
}
