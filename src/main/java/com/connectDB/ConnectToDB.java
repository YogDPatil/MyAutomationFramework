package com.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDB {

	public static void main(String []args) throws SQLException {

		// here JDBC is a database connector,
		//mysql is a database
		//139.59.91.96:3306 is a database url and SR_DEV is a datbase name
		Connection connection = DriverManager.getConnection("jdbc:mysql://139.59.91.96:3306/SR_DEV", "produser", "qweQWe123!");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * from SR_DEV.mst_role where id =3");
		MstRolePojo mst;
		while(resultSet.next()) {
			mst = new MstRolePojo(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("code"),resultSet.getString("description"),resultSet.getInt("is_active"),
					resultSet.getString("created_at"),resultSet.getString("modified_at"));
			System.out.println(mst);
			
			System.out.println(mst.getDescription());
		}
	}
}
