package cn.jbit.empty.dao;

import java.util.List;

import cn.jbit.empty.entity.Pet;
/**
 * ����Pet�ӿ�
 * @author ly
 *
 */
public interface PetDao {
	int save(Pet pet);
	int del(Pet pet);
	int update(Pet pet);
	Pet getByName(String name);
	List<Pet> findByName(String naem);//���س����б�
	List<Pet> findByType(String stain);//����ָ�����͵ĳ����б�
}
