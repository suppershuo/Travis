package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artisan.model.Admin;
import com.artisan.model.Customer;
import com.artisan.model.Area;
import com.artisan.util.StringUtil;

public class CustomerDao extends BaseDao {
	public boolean addCustomer(Customer customer){
		String sql = "insert into s_customer values(null,?,?,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setInt(2, customer.getAreaId());
			preparedStatement.setString(3, customer.getPassword());
			preparedStatement.setString(4, customer.getSex());
			preparedStatement.setInt(5, customer.getComputer());
			preparedStatement.setString(6, customer.getontime());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Customer> getStudentList(Customer customer){
		List<Customer> retList = new ArrayList<Customer>();
		StringBuffer sqlString = new StringBuffer("select * from s_customer");
		if(!StringUtil.isEmpty(customer.getName())){
			sqlString.append(" and name like '%"+customer.getName()+"%'");
		}
		if(customer.getAreaId() != 0){
			sqlString.append(" and areaId ="+customer.getAreaId());
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Customer s = new Customer();
				s.setId(executeQuery.getInt("id"));
				s.setName(executeQuery.getString("name"));
				s.setAreaId(executeQuery.getInt("areaId"));
				s.setSex(executeQuery.getString("sex"));
				s.setPassword(executeQuery.getString("password"));
				s.setComputer(executeQuery.getInt("computer"));
				s.setontime(executeQuery.getString("on time"));
				retList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id){
		String sql = "delete from s_customer where id=?";
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
	public boolean update(Customer customer){
		String sql = "update s_customer set name=?, areaId=?,sex=?,password=?,computer=? where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setInt(2, customer.getAreaId());
			preparedStatement.setString(3, customer.getSex());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.setInt(5, customer.getId());
			preparedStatement.setInt(6, customer.getComputer());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public String editPassword(Customer customer,String newPassword){
		String sql = "select * from s_customer where id=? and password=?";
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, customer.getId());
			prst.setString(2, customer.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(!executeQuery.next()){
				String retString = "旧密码错误！";
				return retString;
			}
			id = executeQuery.getInt("id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//把sql语句传给数据库操作对象
		String retString = "修改失败";
		String sqlString = "update s_customer set password = ? where id = ?";
		try {
			prst = con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int rst = prst.executeUpdate();
			if(rst > 0){
				retString = "密码修改成功！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//把sql语句传给数据库操作对象
		return retString;
	}
	public Customer login(Customer customer){
		String sql = "select * from s_customer where name=? and password=?";
		Customer customerRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, customer.getName());
			prst.setString(2, customer.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				customerRst = new Customer();
				customerRst.setId(executeQuery.getInt("id"));
				customerRst.setAreaId(executeQuery.getInt("areaId"));
				customerRst.setName(executeQuery.getString("name"));
				customerRst.setPassword(executeQuery.getString("password"));
				customerRst.setSex(executeQuery.getString("sex"));
				customerRst.setComputer(executeQuery.getInt("computer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerRst;
	}
}
