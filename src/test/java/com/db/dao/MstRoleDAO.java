package com.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.pojo.MstRolePojo;

public class MstRoleDAO {
	MstRolePojo mstRolePojo;
	Connection connection;
	Statement statement;
	
	public MstRoleDAO() {
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://139.59.91.96:3306/SR_DEV", "produser", "qweQWe123!");
			 statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	public void getMstRoleDetails() {
		
	}
}
