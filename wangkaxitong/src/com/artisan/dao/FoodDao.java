package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artisan.model.Customer;
import com.artisan.model.Food;
import com.artisan.util.StringUtil;

public class FoodDao extends BaseDao {
	public boolean addFood(Food food){
		String sql = "insert into s_food(name,type,price,product)  values(?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, food.getName());
			preparedStatement.setString(2, food.getType());
			preparedStatement.setInt(3, food.getPrice());
			preparedStatement.setString(4, food.getProduct());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Food> getFoodList(Food food) {
		// TODO Auto-generated method stub
		List<Food> retList = new ArrayList<Food>();
		StringBuffer sqlString = new StringBuffer("select * from s_food");
		if(!StringUtil.isEmpty(food.getName())){
			sqlString.append(" where name like '%"+food.getName()+"%'");
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString());
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Food t = new Food();
				t.setId(executeQuery.getInt("id"));
				t.setName(executeQuery.getString("name"));
				t.setType(executeQuery.getString("type"));
				t.setPrice(executeQuery.getInt("price"));
				t.setProduct(executeQuery.getString("product"));
				retList.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id){
		String sql = "delete from s_food where id=?";
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
	public boolean update(Food food){
		String sql = "update s_food set name=?,type=?,price=?,product=? where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(5, food.getId());
			preparedStatement.setString(1, food.getName());
			preparedStatement.setString(2, food.getType());
			preparedStatement.setInt(3, food.getPrice());
			preparedStatement.setString(4,food.getProduct());
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
