package cn.jbit.empty.manager;

import cn.jbit.empty.dao.PetDao;
import cn.jbit.empty.dao.impl.PetDaoMySQLImpl;
import cn.jbit.empty.entity.Pet;
/**
 * ������
 * @author ly
 *
 */
public class Test {
	public static void main(String[] args) {		
		PetDao petDao=new PetDaoMySQLImpl();//��̬
		Pet pet=new Pet();
		pet.setBid(2);
		int result=petDao.update(pet);
		if(result>0){
			System.out.println("������Ϣ���³ɹ��� ");
		}else{
			System.out.println("������Ϣ����ʧ�ܣ�");
		}
	}
}
