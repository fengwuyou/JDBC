package cn.jbit.empty.entity;

import java.util.Date;

public class Pet {
	private int bid;//����id
	private int masterId;//����id
	private String name;//�����ǳ�
	private int health;//���｡��ֵ
	private int love;//���ܶ�
	private String stain;//Ʒ��
	private Date adopTime;//����ʱ��
	private String status;//����״̬
	//get��set����
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getMasterId() {
		return masterId;
	}
	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public String getStain() {
		return stain;
	}
	public void setStain(String stain) {
		this.stain = stain;
	}
	public Date getAdopTime() {
		return adopTime;
	}
	public void setAdopTime(Date adopTime) {
		this.adopTime = adopTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
