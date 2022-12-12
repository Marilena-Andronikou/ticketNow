import java.util.Scanner;
package ticketNow;

public class Post {
	    private String label;
	    private int likes = 0;
	    private ConnectionwithSQL connect = new ConnectionwithSQL ();
		private Scanner input = new Scanner(System.in);
		private username;

	    public Post(String username) {
	        this.username = username;
	    }

	    public void viewPosts () {
			connect.availablePost();
			System.out.println("Press 1 to comment on a post, 2 to like a post");
			System.out.println("Any other key to stop viewing posts");
			ans3 = input.nextLine();
			if (ans3 == 1) {
				addComment();
			} else if (ans3 == 2) {
				likePost();
			}
		}

        public void addComment() {
			System.out.println("Please insert the post's code you want to comment on")
			int pcode = input.nextInt();
			System.out.println("Insert your comment");
			String comtext = input.nextString();
			connect.insertComment(pcode,username,comtext);
		}

		public void likePost() {
			System.out.println("Please insert the code of the post you want to like");
			int pcode = input.nextInt();
			connect.addLike(pcode);
			likes ++;
		}

		public void addPost() {
			System.out.println("Please insert the label of your post");
			labelP = input.nextString();
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