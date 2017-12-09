package cn.jbit.empty.praitice1;

import java.sql.PreparedStatement;

/**
 * 
 * @author ly
 *
 */
public class MasterDaoSQLServerlmpl extends BaseDao implements MasterDao{

	@Override
	public int add(Master master) {
		String sql="insert into master(id,name,password)values(?,?,?)";
		Object[] param={master.getId(),master.getName(),master.getPwd()};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

	@Override
	public int del(Master master) {
		String sql="delete from master where id=? ";
		Object[]param={master.getId()};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

	@Override
	/**
	 * 改更新宠物状态
	 */
	public int update(Master master) {
		String sql="update master set name='唐唐' where id=?";
		Object[] param={master.getId()};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

	@Override
	public String findMaster(Master master) {
		String sql="select * from master where name=? and password=?";
		Object[] param={master.getName(),master.getPwd()};
		String result=this.regist(sql, param);
		return result;
	}

}
