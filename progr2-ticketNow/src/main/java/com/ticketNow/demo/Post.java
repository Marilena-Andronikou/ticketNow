package ticketNow;

import java.util.Scanner;
package ticketNow.ConnectionwithSQL;

public class Post {
	    private String label;
	    private int likes = 0;
	    private ConnectionwithSQL connect = new ConnectionwithSQL ();
		private Scanner input = new Scanner(System.in);
		private String username;

	    public Post(String username) {
	        this.username = username;
	    }

	    public void viewPosts () {

			Scanner input = new Scanner(System.in);
			connect.availablePost();
			System.out.println("Press 1 to comment on a post, 2 to like a post");
			System.out.println("Any other key to stop viewing posts");
			ans3 = input.next();
			if (ans3 == 1) {
				addComment();
			} else if (ans3 == 2) {
				likePost();
			}

		}

        public void addComment() {

			Scanner input = new Scanner(System.in);
			System.out.println("Please insert the post's code you want to comment on");
			int pcode = input.nextInt();
			System.out.println("Insert your comment");
			String comtext = input.next();
			connect.insertComment(pcode,username,comtext);
		}

		public void likePost() {

			Scanner input = new Scanner(System.in);
			System.out.println("Please insert the code of the post you want to like");
			int pcode = input.nextInt();
			connect.addLike(pcode);
			likes ++;

		}

		public void addPost() {

			Scanner input = new Scanner(System.in);
			System.out.println("Please insert the label of your post");
			labelP = input.next();
			connect.insertPost(labelP);

		}

	    public void setLabel(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

	    public void addLikes() {
	        likes++ ;
	    }

	    public int getLikes() {
	        return likes;
	    }

	    public void printLabel() {
	        System.out.println(label);
	    }

	    public void printLikes() {
	        System.out.println(likes);
	    }

	    public void insertComment(){
	        Scanner input = new Scanner(System.in);
	        String comment = input.nextLine();
    }




}