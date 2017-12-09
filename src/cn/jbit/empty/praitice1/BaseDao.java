package cn.jbit.empty.praitice1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 工具类
 * @author ly
 *
 */
public class BaseDao {
	private String driver="com.mysql.jdbc.Driver";//数据库驱动字符
	private String url="jdbc:mysql://localhost:3306/empty1?useUnicode=true&characterEncoding=utf-8";//数据库连接地址
	private String user="ly";//用户名
	private String pwd="luoyi";//密码
	Connection conn=null;
	/**
	 * 连接数据库
	 */
	public Connection getConnection(){
	//1.加载驱动
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	//2.建立连接
	try {
		conn=DriverManager.getConnection(url,user,pwd);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return conn;
	}
	/**
	 * 关闭数据库
	 */
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
	/**
	 * 增、删、改的方法
	 */
	public int exceuteUpdate(String sql, Object[] param){
		PreparedStatement stmt=null;
		int num=0;
		conn=getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			if(param!=null){
				for(int i=0;i<param.length;i++){
					//为预编译SQL设置参数
					stmt.setObject(i+1, param[i]);
				}	
			}
			num=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, stmt, null);
		}
		return num;
	}
	//查询的方法
	public String regist(String sql,Object[] param){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String result=null;
		
		//1.加载驱动
		conn=getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			//将参数替换占位符
			if(param!=null){
				for(int i=0;i<param.length;i++){
					stmt.setObject(i+1, param[i]);
				}
			}
			rs=stmt.executeQuery();
			if(rs.next()){
				result="登录成功！";
			}else{
				result="登录失败！";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, stmt, rs);
		}
		return result;
		
	}
}
