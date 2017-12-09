package cn.jbit.class1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 实现增删改查
 * @author ly
 *
 */
public class Test1 {
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		//一节菜单
		firstMeun();
	}
	private static void firstMeun() {
		System.out.println("欢迎进入数据库测试系统");
		System.out.println("1.注册\t2.登录\t3.退出");
		int choice=input.nextInt();
		switch (choice) {
		case 1:
			//注册
			regist();
			break;
		case 2:
			//登录
			login();
			break;
		case 3:
			//3.退出
			exit();
			break;
		default:
			break;
		}
	}
	private static void exit() {
		//3.退出
		System.out.println("欢迎下次光临");
	}
	private static void login() {
		//登录
		Connection con=null;//连接对象
		Statement stmt=null;//
		ResultSet rs=null;//
		//注册
		System.out.println("请输入用户名");
		String loginName=input.next();
		System.out.println("请输入密码");
		String pwd=input.next();
		//通过反射机制加载数据库驱动包
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//建立连接
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/easybuy?useUnicode=true&characterEncoding=utf-8","ly","luoyi");
			String sql="select * from easybuy_user where loginName='"+loginName+"' and password='"+pwd+"'";
			//通过连接创建Statement对象
			stmt=con.createStatement();
			//执行executeUpdate
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				System.out.println("登录成功！");
				//二级菜单
				secondMenu();
			}else{
				System.out.println("登录失败！");
				//一级菜单
				firstMeun();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭连接
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
		System.out.println("请选择你要进行的操作");
		System.out.println("1.修改用户\t2.删除用户\t3.返回主菜单");
		int chooce=input.nextInt();
		switch (chooce) {
		case 1:
			//修改
			upade();
			break;
		case 2:
			//删除
			del();
			break;
		case 3:
			//返回
			firstMeun();
			break;

		default:
			break;
		}
		
	}
	//删除
	private static void del() {
		Connection con=null;
		Statement stmt=null;
		System.out.println("请输入要删除的用户名");
		String uName=input.next();
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//2.建立连接
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/easybuy?useUnicode=true&characterEncoding=utf-8","ly","luoyi");
			String sql="delete from easybuy_user where loginName='"+uName+"'";
			stmt=con.createStatement();
			int rowNum = stmt.executeUpdate(sql);
			if(rowNum>0){
				System.out.println("删除成功！");
			}else{
				System.out.println("删除失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//修改
	private static void upade() {
		Connection con=null;
		Statement stmt=null;
		System.out.println("请输入用户名");
		String uName1=input.next();
		System.out.println("请输入要修改的用户名");
		String uName=input.next();
		System.out.println("请输入要修改的密码");
		String pwd=input.next();
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//2.建立连接
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/easybuy?useUnicode=true&characterEncoding=utf-8","ly","luoyi");
			String sql="update easybuy_user set loginName='"+uName+"',password='"+pwd+"' where loginName='"+uName1+"'";
			stmt=con.createStatement();
			int rowNum = stmt.executeUpdate(sql);
			if(rowNum>0){
				System.out.println("修改成功！");
			}else{
				System.out.println("修改失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void regist() {
		Connection con=null;//连接对象
		Statement stmt=null;//
		//注册
		System.out.println("请输入注册用户名");
		String loginName=input.next();
		System.out.println("请输入真实用户名");
		String userName=input.next();
		System.out.println("请输入注册密码");
		String pwd=input.next();
		System.out.println("请输入性别（1.男0.女）");
		int	sex=input.nextInt();
		System.out.println("请输入身份证号码");
		String identityCode=input.next();
		System.out.println("请输入邮箱");
		String email=input.next();
		System.out.println("请输入电话号码");
		String mobile=input.next();
		//通过反射机制加载数据库驱动包
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//建立连接
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/easybuy?useUnicode=true&characterEncoding=utf-8","ly","luoyi");
			String sql="insert into easybuy_user(loginName,userName,password,sex,identityCode,email,mobile)"
					+ "values('"+loginName+"','"+userName+"','"+pwd+"',"+sex+",'"+identityCode+"','"+email+"','"+mobile+"')";
			//通过连接创建Statement对象
			stmt=con.createStatement();
			//执行executeUpdate
			int rowNum=stmt.executeUpdate(sql);
			if(rowNum>0){
				System.out.println("注册成功！");
			}else{
				System.out.println("注册失败！");
			}
			firstMeun();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭连接
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
