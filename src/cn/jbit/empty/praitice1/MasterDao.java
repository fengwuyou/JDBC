package cn.jbit.empty.praitice1;
/**
 * master�ӿ��ṩ���ݿ�ķ�������
 * @author ly
 *
 */
public interface MasterDao {
	int add(Master master);//��������
	int del(Master master);//ɾ������
	int update(Master master);//�޸ķ���
	String findMaster(Master master);//��¼��֤����
	
	
}
