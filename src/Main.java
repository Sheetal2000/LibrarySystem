import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        // Preload some books and users
        library.addBook(new Book("The Alchemist", "Paulo Coelho"));
        library.addBook(new Book("Clean Code", "Robert C. Martin"));
        library.addBook(new Book("Java Basics", "James Gosling"));
        library.addBook(new Book("Anatomy", "B.D. Chaurasiya"));

        library.registerUser(new User("Alice"));
        library.registerUser(new User("Bob"));
        library.registerUser(new User("Sheetal"));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Show Books");
            System.out.println("2. Show Users");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.println("6. Add Book");
            System.out.println("7. Register User");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    library.showUsers();
                    break;
                case 3:
                    System.out.print("Enter user name: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter book title: ");
                    String btitle = sc.nextLine();
                    library.issueBook(uname, btitle);
                    break;
                case 4:
                    System.out.print("Enter user name: ");
                    String returnUser = sc.nextLine();
                    library.returnBook(returnUser);
                    break;
                case 5:
                    System.out.println("👋 Exiting...");
                    break;
                case 6:
                    System.out.print("Enter book title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("Enter author name: ");
                    String newAuthor = sc.nextLine();
                    library.addBook(new Book(newTitle, newAuthor));
                    break;
                case 7:
                    System.out.print("Enter user name: ");
                    String newUser = sc.nextLine();
                    library.registerUser(new User(newUser));
                    break;

                default:
                    System.out.println("❌ Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
