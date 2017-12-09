package cn.jbit.empty.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import cn.jbit.empty.dao.BaseDao;
import cn.jbit.empty.dao.PetDao;
import cn.jbit.empty.entity.Pet;



/**
 * PetDao针对数据库的实现类
 * @author ly
 *
 */
public class PetDaoMySQLImpl extends BaseDao implements PetDao{

	@Override
	public int save(Pet pet) {
		return 0;
	}

	@Override
	public int del(Pet pet) {
		return 0;
	}

	@Override
	public int update(Pet pet) {
//		Connection conn=null;
//		PreparedStatement stmt=null;
//		int result=0;
//		//1.加载驱动
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		try {
//			//2.建立连接
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/empty?useUnicode=true&characterEncoding=utf-8","ly","luoyi");
//			stmt=conn.prepareStatement("update animal set status=0 where bid=?");
//			stmt.setInt(1,0);
//			result=stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			//关闭连接
//			try {
//				if(stmt!=null){
//				stmt.close();
//				}
//				if(conn!=null){
//					conn.close();
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	
//		return result;
		String sql="update animal set status=0 where bid=?";
		Object [] param={pet.getBid()};
		int result=this.executeUpdate(sql, param);
		return result;		
	}

	@Override
	public Pet getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pet> findByName(String naem) {
		return null;
	}

	@Override
	public List<Pet> findByType(String stain) {
		return null;
	}

}
