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
		String url = "jdbc:sqlserver://LAPTOP-RQ3S8RU7:1433;" + "DatabaseName=TicketNow;user=sophia;password=thakopoume!?;encrypt=true;trustServerCertificate=true;";
	  	try {
	  		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	  	}catch(java.lang.ClassNotFoundException e){
	  		System.out.print("ClassNotFoundException: ");
	  		System.out.println(e.getMessage());
	  	}
		try {
			Connection conn = DriverManager.getConnection(url);
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
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				System.out.print("User ");
				String uname = rs.getString("username");
				System.out.print(uname + " posted: ");
				String postdescr = rs.getString("labelP");
				System.out.println(postdescr);
				int numoflikes = rs.getInt("likes");
				System.out.println(numoflikes + " people are interested in this ticket");
				int pcode = rs.getInt("pcode");
				System.out.println("This post's code is: "+pcode);
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

	public void insertPost(String labelP, String username){
		try {
			Connection conn = connection();
			Statement statement = conn.createStatement();
			statement.executeUpdate("INSERT INTO Posts(labelP,likes,username) VALUES('" + labelP + "'," + 0 + ",'" + username+"')");
			
		} catch (SQLException e) {
			System.err.println("SQL exception happened during connetion with SQL");
			e.printStackTrace();
		}
	}
	public void insertComment(int pcode, String username, String cometext){
			try {
				Connection conn = connection();
				Statement statement = conn.createStatement();
				statement.executeUpdate("INSERT INTO Comments (comtext,pcode,username) VALUES(" +
				  ",'" + cometext + "'," + pcode + ",'" + username +"')");
			} catch (SQLException e) {
				System.err.println("SQL exception happened during connetion with SQL");
				e.printStackTrace();
			}
	}

	public void insertUser( String username, String password, String email){
			try {
				Connection conn = connection();
				Statement statement = conn.createStatement();
				statement.executeUpdate("INSERT INTO Users (username,passwordU,email)" + "VALUES('" +
				username + "','" + password + "','" + email + "')");
			} catch (SQLException e) {
				System.err.println("SQL exception happened during connetion with SQL");
				e.printStackTrace();
			}
	}

	public static int search(String username,int y ){
		Connection conn = connection();
		Statement s;
		Scanner in = new Scanner(System.in);
		String x = null;
		int response = 0;
		try {
			s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Users");
			boolean z = true;
			while (rs.next()){
				if (username.equals(rs.getString("username"))){
					if ( y == 1){
						z = false;
						x = rs.getString("passwordU");
						break;
					} else if (y ==2){
						z = false;
						break;
					}
				}
			}
			if (y == 1) {
				if (z == false) {
					System.out.println("Insert your password");
					String pw = in.nextLine();
					do {
						if (pw.equals(x)) {
							response = 1;
						return response;
						} else {
							System.out.println("Insert your password again");
							pw = in.nextLine();
						}
					}while (!(pw.equals(x)));
				} else {
					System.out.println("This user does not exist. Insert the username again");
					username = in.nextLine();
					do {
						search(username, 1);
						System.out.println("This user does not exist. Insert the username again");
						username = in.nextLine();
					} while(response != 1);
				}
			} else {
				if (z == true) {
					response = 2;
					User u = new User();
					u.setUsername(username);
					return response;
				} else {
					System.out.println("This username is already taken. Insert the username again");
					username = in.nextLine();
					do {
						search(username, 2);
						System.out.println("This username is already taken. Insert the username again");
						username = in.nextLine();
					} while (response != 2);
				}
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;




	}
}
