import java.util.*;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(book.getTitle())) {
                System.out.println("❌ Book with this title already exists.");
                return;
            }
        }
        books.add(book);
        System.out.println("✅ Book added successfully.");
    }


    public void registerUser(User user) {
        for (User u : users) {
            if (u.getName().equalsIgnoreCase(user.getName())) {
                System.out.println("❌ User with this name already exists.");
                return;
            }
        }
        users.add(user);
        System.out.println("✅ User registered successfully.");
    }

    public void showBooks() {
        System.out.println("Books in Library:");
        for (Book book : books) {
            System.out.println(" - " + book);
        }
    }

    public void showUsers() {
        System.out.println("Registered Users:");
        for (User user : users) {
            System.out.println(" - " + user);
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public User findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    public void issueBook(String userName, String bookTitle) {
        User user = findUserByName(userName);
        Book book = findBookByTitle(bookTitle);

        if (user == null || book == null) {
            System.out.println("❌ User or Book not found.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("❌ Book is already issued.");
            return;
        }

        if (user.getIssuedBook() != null) {
            System.out.println("❌ User already has a book issued.");
            return;
        }

        book.issue();
        user.issueBook(book);
        System.out.println("✅ Book issued successfully.");
    }

    public void returnBook(String userName) {
        User user = findUserByName(userName);

        if (user == null || user.getIssuedBook() == null) {
            System.out.println("❌ No book to return for this user.");
            return;
        }

        Book book = user.getIssuedBook();
        book.returnBook();
        user.returnBook();
        System.out.println("✅ Book returned successfully.");
    }
}

