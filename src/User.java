import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
    private String name;
    private Book issuedBook;
    private LocalDate issueDate;
    private static final int RETURN_DAYS = 7;


    public User(String name) {
        this.name = name;
        this.issuedBook = null;
    }

    public String getName() {
        return name;
    }

    public Book getIssuedBook() {
        return issuedBook;
    }

    public void issueBook(Book book) {
        this.issuedBook = book;
        this.issueDate = LocalDate.now();
    }

    public void returnBook() {
        this.issuedBook = null;
        this.issueDate = null;
    }


    @Override
    public String toString() {
        if (issuedBook != null && issueDate != null) {
            LocalDate returnDate = issueDate.plusDays(RETURN_DAYS);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return name + " has issued: " + issuedBook.getTitle() +
                    " | Issued on: " + issueDate.format(formatter) +
                    " | Return by: " + returnDate.format(formatter);
        } else {
            return name + " has no book issued.";
        }
    }

}

