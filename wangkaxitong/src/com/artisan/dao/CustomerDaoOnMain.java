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

public class CustomerDaoOnMain extends BaseDao {
	public boolean addCustomer(Customer customer){
		//INSERT INTO `s_customer` (`id`, `name`, `password`, `computer`) VALUES ('32', '¿©', '3', '39')
		String sql = "insert into s_customer values(null,?,?,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setInt(2, 2);
			preparedStatement.setString(3, customer.getPassword());
			preparedStatement.setString(4, null);
			preparedStatement.setInt(5, customer.getComputer());
			preparedStatement.setString(6, customer.getontime());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
