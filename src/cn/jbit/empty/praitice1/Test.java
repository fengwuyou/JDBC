package cn.jbit.empty.praitice1;

import java.util.Scanner;

/**
 * ������
 * @author ly
 *
 */
public class Test {
	public static void main(String[] args) {
		/**
		 * ��������
		 */
/*		MasterDao masterDao=new MasterDaoSQLServerlmpl();//ʹ�ýӿڴ���ʵ�������
		Master master=new Master();
		master.setId(2);
		System.out.println(master.getId());
		masterDao.update(master);//���ýӿڷ���
*/		
		/**
		 * ��������
		 */
/*		MasterDao masterDao=new MasterDaoSQLServerlmpl();
		Master master=new Master();
		master.setId(3);
		master.setName("����");
		master.setPwd("333");
		masterDao.add(master);
		System.out.println("���ݸ��³ɹ�");
*/
		/**
		 * ɾ������
		 */
/*		MasterDao masterDao=new MasterDaoSQLServerlmpl();
		Master master=new Master();
		master.setId(3);
		masterDao.del(master);
*/
		/**
		 * ��¼��֤
		 */
		MasterDao masterDao=new MasterDaoSQLServerlmpl();
		Master master=new Master();
		Scanner input=new Scanner(System.in);
		System.out.println("\t\t��¼��֤");
		System.out.println("�������û���");
		String name=input.next();
		System.out.println("����������");
		String pwd=input.next();
		//����Ϣ��ӵ��û�
		master.setName(name);
		master.setPwd(pwd);
		//����---get��ֵ
		System.out.println(master.getName()+master.getPwd());
		
		System.out.println(masterDao.findMaster(master));
	}
}
