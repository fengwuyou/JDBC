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
 * ���ݿ����ͨ����
 * @author ly
 *
 */
public class BaseDao {
//	private String driver="com.mysql.jdbc.Driver";//���ݿ������ַ���
//	private String url="jdbc:mysql://localhost:3306/empty?useUnicode=true&characterEncoding=utf-8";//���ݿ������ַ�
//	private String user="ly";//���ݿ���
//	private String pwd="luoyi";
	
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	//���÷���
	static{
		init();

	}
	//�������ļ��ж�ȡ���Ӳ���
	public static void init(){
		Properties params=new Properties();
		String configfile="database.properties";
		//���ذ������ļ���������
		InputStream is=BaseDao.class.getClassLoader().getResourceAsStream(configfile);
		//���������ж�ȡ���Ա�
		try {
			params.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//����ָ���ļ���ȡ��Ӧ��ֵ
		driver=params.getProperty("driver");
		url=params.getProperty("url");
		user=params.getProperty("user");
		pwd=params.getProperty("password");
		
	}
	Connection conn=null;
	 //1.�����ݿ�
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
	//2.�ر�������Դ
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
	//3.����ɾ����ͨ�÷���
	public int executeUpdate(String sql,Object[] param){
		int num=0;//Ӱ������
		conn=this.getConnection();
		PreparedStatement stmt=null;
		try {
			stmt=conn.prepareStatement(sql);
			if(param!=null){
				for(int i=0;i<param.length;i++){
					stmt.setObject(i+1,param[i]);
				}
			}
			//ִ��SQL���
			num=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, stmt, null); 
		}
		return num;
				
	}
	
}
