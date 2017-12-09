package cn.jbit.empty.praitice1;
/**
 * master接口提供数据库的方法定义
 * @author ly
 *
 */
public interface MasterDao {
	int add(Master master);//新增方法
	int del(Master master);//删除方法
	int update(Master master);//修改方法
	String findMaster(Master master);//登录验证方法
	
	
}
