
public class LibraryBook implements Identifiable,Registrable{
    private  String bookId;
    private String isbn;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;

    public LibraryBook(String bookId, String isbn, String title, String author, int totalCopies, int availableCopies) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    @Override
    public String getId() {
        return bookId;
    }

    @Override
    public String getDisplayName() {
        return title;
    }

    @Override
    public boolean isActive() {
        return availableCopies>0;
    }

    @Override
    public void validate() throws ValidationException {
        if (bookId == null || bookId.trim().isEmpty()) {
            throw new ValidationException("Book ID is required");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new ValidationException("Title is required");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new ValidationException("Author is required");
        }
        if (totalCopies <= 0) {
            throw new ValidationException("Total Copies can not be 0");
        }
        if (availableCopies < 0) {
            throw new ValidationException("Available Copies can not be negative");
        }
        if (totalCopies < availableCopies) {
            throw new ValidationException("Total Copies can not be less than Available Copies");
        }
        if (isbn == null || isbn.trim().isEmpty()) {

            throw new ValidationException(
                    "ISBN is required.");
        }

    }

    @Override
    public void printDetails() {
        System.out.println("===========Library Information============");
        System.out.println("Book ID: " + bookId);
        System.out.println("Book ISBN: " + isbn);
        System.out.println("Book Title: " + title);
        System.out.println("Book Author: " + author);
        System.out.println("Total Copies: " + totalCopies);
        System.out.println("Available Copies: " + availableCopies);
    }

    @Override
    public String getRegistrationSummary() {
        return "Book ID "
                + bookId
                + ", Book ISBN"
                + isbn
                + ", Book Title"
                + title
                + ", Book Author"
                + author;
    }

    @Override
    public String toString() {
        return "LibraryBook{" +
                "bookId='" + bookId + '\'' +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", totalCopies=" + totalCopies +
                ", availableCopies=" + availableCopies +
                '}';
    }
}
