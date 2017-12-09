package cn.jbit.class1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * ʵ����ɾ�Ĳ�
 * @author ly
 *
 */
public class Test1 {
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		//һ�ڲ˵�
		firstMeun();
	}
	private static void firstMeun() {
		System.out.println("��ӭ�������ݿ����ϵͳ");
		System.out.println("1.ע��\t2.��¼\t3.�˳�");
		int choice=input.nextInt();
		switch (choice) {
		case 1:
			//ע��
			regist();
			break;
		case 2:
			//��¼
			login();
			break;
		case 3:
			//3.�˳�
			exit();
			break;
		default:
			break;
		}
	}
	private static void exit() {
		//3.�˳�
		System.out.println("��ӭ�´ι���");
	}
	private static void login() {
		//��¼
		Connection con=null;//���Ӷ���
		Statement stmt=null;//
		ResultSet rs=null;//
		//ע��
		System.out.println("�������û���");
		String loginName=input.next();
		System.out.println("����������");
		String pwd=input.next();
		//ͨ��������Ƽ������ݿ�������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//��������
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/easybuy?useUnicode=true&characterEncoding=utf-8","ly","luoyi");
			String sql="select * from easybuy_user where loginName='"+loginName+"' and password='"+pwd+"'";
			//ͨ�����Ӵ���Statement����
			stmt=con.createStatement();
			//ִ��executeUpdate
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				System.out.println("��¼�ɹ���");
				//�����˵�
				secondMenu();
			}else{
				System.out.println("��¼ʧ�ܣ�");
				//һ���˵�
				firstMeun();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	private static void secondMenu() {
		System.out.println("��ѡ����Ҫ���еĲ���");
		System.out.println("1.�޸��û�\t2.ɾ���û�\t3.�������˵�");
		int chooce=input.nextInt();
		switch (chooce) {
		case 1:
			//�޸�
			upade();
			break;
		case 2:
			//ɾ��
			del();
			break;
		case 3:
			//����
			firstMeun();
			break;

		default:
			break;
		}
		
	}
	//ɾ��
	private static void del() {
		Connection con=null;
		Statement stmt=null;
		System.out.println("������Ҫɾ�����û���");
		String uName=input.next();
		try {
			//1.��������
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//2.��������
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/easybuy?useUnicode=true&characterEncoding=utf-8","ly","luoyi");
			String sql="delete from easybuy_user where loginName='"+uName+"'";
			stmt=con.createStatement();
			int rowNum = stmt.executeUpdate(sql);
			if(rowNum>0){
				System.out.println("ɾ���ɹ���");
			}else{
				System.out.println("ɾ��ʧ�ܣ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//�޸�
	private static void upade() {
		Connection con=null;
		Statement stmt=null;
		System.out.println("�������û���");
		String uName1=input.next();
		System.out.println("������Ҫ�޸ĵ��û���");
		String uName=input.next();
		System.out.println("������Ҫ�޸ĵ�����");
		String pwd=input.next();
		try {
			//1.��������
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//2.��������
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/easybuy?useUnicode=true&characterEncoding=utf-8","ly","luoyi");
			String sql="update easybuy_user set loginName='"+uName+"',password='"+pwd+"' where loginName='"+uName1+"'";
			stmt=con.createStatement();
			int rowNum = stmt.executeUpdate(sql);
			if(rowNum>0){
				System.out.println("�޸ĳɹ���");
			}else{
				System.out.println("�޸�ʧ�ܣ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void regist() {
		Connection con=null;//���Ӷ���
		Statement stmt=null;//
		//ע��
		System.out.println("������ע���û���");
		String loginName=input.next();
		System.out.println("��������ʵ�û���");
		String userName=input.next();
		System.out.println("������ע������");
		String pwd=input.next();
		System.out.println("�������Ա�1.��0.Ů��");
		int	sex=input.nextInt();
		System.out.println("���������֤����");
		String identityCode=input.next();
		System.out.println("����������");
		String email=input.next();
		System.out.println("������绰����");
		String mobile=input.next();
		//ͨ��������Ƽ������ݿ�������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//��������
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/easybuy?useUnicode=true&characterEncoding=utf-8","ly","luoyi");
			String sql="insert into easybuy_user(loginName,userName,password,sex,identityCode,email,mobile)"
					+ "values('"+loginName+"','"+userName+"','"+pwd+"',"+sex+",'"+identityCode+"','"+email+"','"+mobile+"')";
			//ͨ�����Ӵ���Statement����
			stmt=con.createStatement();
			//ִ��executeUpdate
			int rowNum=stmt.executeUpdate(sql);
			if(rowNum>0){
				System.out.println("ע��ɹ���");
			}else{
				System.out.println("ע��ʧ�ܣ�");
			}
			firstMeun();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
