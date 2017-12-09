package cn.jbit.empty.dao;

import java.util.List;

import cn.jbit.empty.entity.Pet;
/**
 * 宠物Pet接口
 * @author ly
 *
 */
public interface PetDao {
	int save(Pet pet);
	int del(Pet pet);
	int update(Pet pet);
	Pet getByName(String name);
	List<Pet> findByName(String naem);//返回宠物列表
	List<Pet> findByType(String stain);//返回指定类型的宠物列表
}
