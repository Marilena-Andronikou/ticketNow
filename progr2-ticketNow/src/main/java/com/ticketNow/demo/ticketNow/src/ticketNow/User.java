package ticketNow;

import java.util.Scanner;
import ticketNow.ConnectionwithSQL;

public class User {
	private String username;
	private String password;
	private String email;
	ConnectionwithSQL con = new ConnectionwithSQL();
	public User() {
		
	}

	public void login(int ans1) {

		Scanner inp = new Scanner(System.in);
		System.out.println("Insert your name");
		String name = inp.nextLine();
		int result = con.search(name,ans1);
		System.out.println("Successful login!");
		this.username = name;
		this.password = password;
		this.email = email;
	}

	public void register(int ans1) {

		Scanner inp = new Scanner(System.in);
		System.out.println("Insert your name");
		String name = inp.next();
		int result = con.search(name,ans1);
		System.out.println("Insert your password");
		String password = inp.next();
		System.out.println("Insert your e-mail");
		String email = inp.next();
		this.username = name;
		this.password = password;
		this.email = email;
		con.insertUser(name, password, email);
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