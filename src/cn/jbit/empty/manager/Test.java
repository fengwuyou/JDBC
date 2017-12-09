package cn.jbit.empty.manager;

import cn.jbit.empty.dao.PetDao;
import cn.jbit.empty.dao.impl.PetDaoMySQLImpl;
import cn.jbit.empty.entity.Pet;
/**
 * 测试类
 * @author ly
 *
 */
public class Test {
	public static void main(String[] args) {		
		PetDao petDao=new PetDaoMySQLImpl();//多态
		Pet pet=new Pet();
		pet.setBid(2);
		int result=petDao.update(pet);
		if(result>0){
			System.out.println("狗狗信息更新成功！ ");
		}else{
			System.out.println("狗狗信息更新失败！");
		}
	}
}
