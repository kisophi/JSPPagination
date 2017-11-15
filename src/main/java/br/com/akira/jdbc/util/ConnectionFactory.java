package br.com.akira.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jsppaginationdb?useTimezone=true&serverTimezone=UTC&useSSL=false"
					, "root"
					, "123456");
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

}
