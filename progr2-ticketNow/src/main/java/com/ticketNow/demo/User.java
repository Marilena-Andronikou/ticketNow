package ticketNow;

public class User {
	private String username;
	private long password;
	private String email;
	ConnectionwithSQL con = new ConnectionwithSQL();
	public User(String u, long p, String em) {
		username = u;
		password = p;
		email = em;
		con.insertUser(u,p,e);
	}

	public int login(int ans1) {
		system.out.println("Insert your name");
		String name = inp.nextString();
		String result = con.search(name,ans1);
		a = 0;
		if (result == "invalid name") {
			System.out.println("Username does not exist");
		} else {
			system.out.println("Insert your password");
			String password = inp.nextString();
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
		system.out.println("Insert your name");
		String name = inp.nextString();
		String result = con.search(name,ans1);
		a = 0;
		if (result == "Username taken") {
			System.out.println ("Username is already taken, try again");
		} else {
			system.out.println("Insert your password");
			system.out.println("Insert your email");
			System.out.println ("Welcome" + name);
			String password = inp.nextString();
			String email = inp.nextString();
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

	public void setPassword(long y) {
		password = y;
	}

	public long getPassword() {
		return password;
	}

	public void setEmail(String z) {
		email = z;
	}

	public String getEmail() {
		return email;
	}
}