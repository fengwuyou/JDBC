package cn.jbit.empty.entity;

import java.util.Date;

public class Pet {
	private int bid;//宠物id
	private int masterId;//主人id
	private String name;//宠物昵称
	private int health;//宠物健康值
	private int love;//请密度
	private String stain;//品种
	private Date adopTime;//领养时间
	private String status;//领养状态
	//get和set方法
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
