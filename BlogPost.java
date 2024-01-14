import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BlogPost {
    private static int nextId = 1;

    private int postId;
    private String title;
    private String content;

    public BlogPost(String title, String content) {
        this.postId = nextId++;
        this.title = title;
        this.content = content;
    }

    public int getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

public class BlogPlatform {
    private List<BlogPost> blogPosts;

    public BlogPlatform() {
        this.blogPosts = new ArrayList<>();
    }

    public void createPost(String title, String content) {
        BlogPost newPost = new BlogPost(title, content);
        blogPosts.add(newPost);
        System.out.println("Blog post created successfully.");
    }

    public void editPost(int postId, String newContent) {
        BlogPost post = findPost(postId);
        if (post != null) {
            post.setContent(newContent);
            System.out.println("Blog post edited successfully.");
        } else {
            System.out.println("Blog post not found.");
        }
    }

    public void deletePost(int postId) {
        BlogPost post = findPost(postId);
        if (post != null) {
            blogPosts.remove(post);
            System.out.println("Blog post deleted successfully.");
        } else {
            System.out.println("Blog post not found.");
        }
    }

    public void displayAllPosts() {
        System.out.println("All Blog Posts:");
        for (BlogPost post : blogPosts) {
            System.out.println("Post ID: " + post.getPostId());
            System.out.println("Title: " + post.getTitle());
            System.out.println("Content: " + post.getContent());
            System.out.println("-------------------------");
        }
    }

    private BlogPost findPost(int postId) {
        for (BlogPost post : blogPosts) {
            if (post.getPostId() == postId) {
                return post;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BlogPlatform blogPlatform = new BlogPlatform();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Blog Post");
            System.out.println("2. Edit Blog Post");
            System.out.println("3. Delete Blog Post");
            System.out.println("4. Display All Blog Posts");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter content: ");
                    String content = scanner.nextLine();
                    blogPlatform.createPost(title, content);
                    break;
                case 2:
                    System.out.print("Enter Post ID to edit: ");
                    int editPostId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter new content: ");
                    String newContent = scanner.nextLine();
                    blogPlatform.editPost(editPostId, newContent);
                    break;
                case 3:
                    System.out.print("Enter Post ID to delete: ");
                    int deletePostId = scanner.nextInt();
                    blogPlatform.deletePost(deletePostId);
                    break;
                case 4:
                    blogPlatform.displayAllPosts();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
