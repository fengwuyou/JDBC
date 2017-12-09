package cn.jbit.empty.praitice1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ������
 * @author ly
 *
 */
public class BaseDao {
	private String driver="com.mysql.jdbc.Driver";//���ݿ������ַ�
	private String url="jdbc:mysql://localhost:3306/empty1?useUnicode=true&characterEncoding=utf-8";//���ݿ����ӵ�ַ
	private String user="ly";//�û���
	private String pwd="luoyi";//����
	Connection conn=null;
	/**
	 * �������ݿ�
	 */
	public Connection getConnection(){
	//1.��������
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	//2.��������
	try {
		conn=DriverManager.getConnection(url,user,pwd);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return conn;
	}
	/**
	 * �ر����ݿ�
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
	 * ����ɾ���ĵķ���
	 */
	public int exceuteUpdate(String sql, Object[] param){
		PreparedStatement stmt=null;
		int num=0;
		conn=getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			if(param!=null){
				for(int i=0;i<param.length;i++){
					//ΪԤ����SQL���ò���
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
	//��ѯ�ķ���
	public String regist(String sql,Object[] param){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String result=null;
		
		//1.��������
		conn=getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			//�������滻ռλ��
			if(param!=null){
				for(int i=0;i<param.length;i++){
					stmt.setObject(i+1, param[i]);
				}
			}
			rs=stmt.executeQuery();
			if(rs.next()){
				result="��¼�ɹ���";
			}else{
				result="��¼ʧ�ܣ�";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, stmt, rs);
		}
		return result;
		
	}
}
