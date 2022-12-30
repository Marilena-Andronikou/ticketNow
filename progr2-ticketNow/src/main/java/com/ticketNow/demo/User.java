package ticketNow;

import java.util.Scanner;
import ticketNow.ConnectionwithSQL;

public class User {
	private String username;
	private String password;
	private String email;
	ConnectionwithSQL con = new ConnectionwithSQL();
	public User(String u, String p, String em) {
		username = u;
		password = p;
		email = em;
		con.insertUser(u,p,em);
	}

	public int login(int ans1) {

		Scanner inp = new Scanner(System.in);
		System.out.println("Insert your name");
		String name = inp.next();
		String result = con.search(name,ans1);
		int a = 0;
		if (result == "invalid name") {
			System.out.println("Username does not exist");
		} else {
			System.out.println("Insert your password");
			String password = inp.next();
			if (result == password) {
				System.out.println("Welcome back" + name);
				a = 1;
				this.username = name;
			} else {
				System.out.println("Wrong password try again");
			}
		}
		return a;
	}

	public int register(int ans1) {

		Scanner inp = new Scanner(System.in);
		System.out.println("Insert your name");
		String name = inp.next();
		String result = con.search(name,ans1);
		int a = 0;
		if (result == "Username taken") {
			System.out.println ("Username is already taken, try again");
		} else {
			System.out.println("Insert your password");
			System.out.println("Insert your email");
			System.out.println ("Welcome" + name);
			String password = inp.next();
			String email = inp.next();
			this.username = name;
			this.password = password;
			this.email = email;
			a = 1;
		}
		return a;
	}

	public void setUsername(String x) {
		username = x;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String y) {
		password = y;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String z) {
		email = z;
	}

	public String getEmail() {
		return email;
	}
}