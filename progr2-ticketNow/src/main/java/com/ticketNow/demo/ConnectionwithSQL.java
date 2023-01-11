package com.ticketNow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectionwithSQL {

	public static Connection connection(){
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://sqlserver.LAPTOP-RQ3S8RU7:1433;" +
                "databaseName=TicketNow;";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			System.err.println("Class not found exception");
			e1.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection(url, driver, url);
			return conn;
		} catch (SQLException e) {
			System.err.println("SQL exception happened during connetion with SQL");
			e.printStackTrace();
			return null;
		}


	}

	public static void availablePost() {
		    try{
		    	Connection conn = connection();

			String query = "SELECT * FROM Posts";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				System.out.print("User ");
				String uname = rs.getString("username");
				System.out.print(uname + " posted: ");
				String postdescr = rs.getString("labelP");
				System.out.println(postdescr);
				int numoflikes = rs.getInt("likes");
				System.out.println(numoflikes + " people are interested in this ticket");
			}
		    } catch(SQLException e) {
				System.err.println("SQL exception happened during connetion with SQL");
				e.printStackTrace();

			}

	}

	public static void addLike(int pcode) {
		Connection conn = connection();

		Statement statement;
		try {
			statement = conn.createStatement();
			statement.executeUpdate("UPDATE Posts SET likes = likes + 1 WHERE pcode=" + pcode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertPost(String labelP){
		try {
			Connection conn = connection();
			Statement statement = conn.createStatement();
			statement.executeUpdate("INSERT INTO Posts(pcode,labelP,likes) VALUES( default" + "," +labelP + "," + 0 + ")");
		} catch (SQLException e) {
			System.err.println("SQL exception happened during connetion with SQL");
			e.printStackTrace();
		}
	}
	public void insertComment(int pcode, String username, String cometext){
			try {
				Connection conn = connection();
				Statement statement = conn.createStatement();
				statement.executeUpdate("INSERT INTO Comments (ccode,comtext,pcode,username)" + "VALUES( default"+
				  "," + cometext + "," + pcode + "," + username +")");
			} catch (SQLException e) {
				System.err.println("SQL exception happened during connetion with SQL");
				e.printStackTrace();
			}
	}

	public void insertUser( String username, String password, String email){
			try {
				Connection conn = connection();
				Statement statement = conn.createStatement();
				statement.executeUpdate("INSERT INTO Users (username,password,email)" + "VALUES(" +
				username + "," + password + "," + email + ")");
			} catch (SQLException e) {
				System.err.println("SQL exception happened during connetion with SQL");
				e.printStackTrace();
			}
	}

	public static String search(String username,int y ){
		Connection conn = connection();
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM User");
			boolean z = true;
			while (rs.next()){
				if (username == rs.getString("username")){
					if ( y == 1){
					z = false;
					String x = rs.getString("passwordU");
					return x;
					} else if (y ==2){
						 return "Username taken";
					}
				}


			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}




	}
}