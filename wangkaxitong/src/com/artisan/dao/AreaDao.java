package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artisan.model.Area;
import com.artisan.util.StringUtil;

/**
 * 
 * 机区信息与数据库的操作
 * @author llq
 *
 */
public class AreaDao extends BaseDao {
	public boolean addClass(Area scl){
		String sql = "insert into s_area values(null,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, scl.getName());
			preparedStatement.setString(2, scl.getInfo());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Area> getAreaList(Area customerArea){
		List<Area> retList = new ArrayList<Area>();
		String sqlString = "select * from s_area";
		if(!StringUtil.isEmpty(customerArea.getName())){
			sqlString += " where name like '%"+customerArea.getName()+"%'";
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Area sc = new Area();
				sc.setId(executeQuery.getInt("id"));
				sc.setName(executeQuery.getString("name"));
				sc.setInfo(executeQuery.getString("info"));
				retList.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id){
		String sql = "delete from s_area where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(Area sc){
		String sql = "update s_area set name=?, info=? where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, sc.getName());
			preparedStatement.setString(2, sc.getInfo());
			preparedStatement.setInt(3, sc.getId());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
