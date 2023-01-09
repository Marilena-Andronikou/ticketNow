package com.ticketNow;

import java.util.Scanner;
import com.ticketNow.User;
import com.ticketNow.Post;

public class TicketNow {
	private static User u ; 
	public static void main (String[] args) {
		u = new User(); 
		openingScreen(); 
		
	}
	public static void openingScreen() {
		int a = 0;
		Scanner inp = new Scanner(System.in);
		System.out.println("Please press 1 for login \n 2 for register");
		int ans1 = inp.nextInt();
		while (a == 0) {
			if (ans1 == 1) {
				a = u.login(ans1);
			} else if(ans1 ==2) {
				a = u.register(ans1);
			}
		}
		
		mainCourse();
	}

	public static void mainCourse () {
		System.out.println("Press 1 to view latest posts,2 to add a new post, 3 to log out");
		Scanner inp = new Scanner(System.in);
		Post p = new Post(u.getUsername());
		int ans2 = inp.nextInt();
		if (ans2 == 1) {
			p.viewPosts();
		} else if (ans2 == 2) {
			p.addPost();
		} else if (ans2 == 3) {
			System.out.println("See you later");
			openingScreen();
		}
	}
}
































