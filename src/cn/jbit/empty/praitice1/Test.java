package cn.jbit.empty.praitice1;

import java.util.Scanner;

/**
 * 测试类
 * @author ly
 *
 */
public class Test {
	public static void main(String[] args) {
		/**
		 * 更改数据
		 */
/*		MasterDao masterDao=new MasterDaoSQLServerlmpl();//使用接口创建实现类对象
		Master master=new Master();
		master.setId(2);
		System.out.println(master.getId());
		masterDao.update(master);//调用接口方法
*/		
		/**
		 * 新增数据
		 */
/*		MasterDao masterDao=new MasterDaoSQLServerlmpl();
		Master master=new Master();
		master.setId(3);
		master.setName("旭旭");
		master.setPwd("333");
		masterDao.add(master);
		System.out.println("数据更新成功");
*/
		/**
		 * 删除数据
		 */
/*		MasterDao masterDao=new MasterDaoSQLServerlmpl();
		Master master=new Master();
		master.setId(3);
		masterDao.del(master);
*/
		/**
		 * 登录验证
		 */
		MasterDao masterDao=new MasterDaoSQLServerlmpl();
		Master master=new Master();
		Scanner input=new Scanner(System.in);
		System.out.println("\t\t登录验证");
		System.out.println("请输入用户名");
		String name=input.next();
		System.out.println("请输入密码");
		String pwd=input.next();
		//将信息添加到用户
		master.setName(name);
		master.setPwd(pwd);
		//测试---get有值
		System.out.println(master.getName()+master.getPwd());
		
		System.out.println(masterDao.findMaster(master));
	}
}
