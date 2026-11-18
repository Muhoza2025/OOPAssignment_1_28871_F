
import java.time.LocalDate;

public class BookLoan implements Identifiable,Registrable{
    private String loanId;
    private Student student;
    private LibraryBook book;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public BookLoan(String loanId, Student student, LibraryBook book, LocalDate borrowDate, LocalDate dueDate, LocalDate returnDate) {
        this.loanId = loanId;
        this.student = student;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LibraryBook getBook() {
        return book;
    }

    public void setBook(LibraryBook book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String getId() {
        return loanId;
    }

    @Override
    public String getDisplayName() {
        return book.getDisplayName();
    }

    @Override
    public boolean isActive() {
        return returnDate == null;
    }

    @Override
    public void validate() throws ValidationException {
        if (loanId == null || loanId.trim().isEmpty()) {
            throw new ValidationException("Loan ID is required");
        }
        if (student == null) {
            throw new ValidationException("Student is required");
        }
        if (book == null) {
            throw new ValidationException("Book is required");
        }
        if (borrowDate == null||borrowDate.isAfter(LocalDate.now())) {
            throw new ValidationException("Borrow Date is required");
        }
        if (dueDate == null||dueDate.isAfter(LocalDate.now())) {
            throw new ValidationException("Due Date is required");
        }
        if (returnDate != null &&
                returnDate.isBefore(borrowDate)) {

            throw new ValidationException(
                    "Return date cannot be before borrow date.");
        }

    }

    @Override
    public void printDetails() {
        System.out.println("==========Book Loan==========");
        System.out.println("Loan Id: " + loanId);
        System.out.println("Student Id: " + student.getId());
        System.out.println("Book Title: " + book.getTitle());
        System.out.println("Book Author: " + book.getAuthor());
        System.out.println("Borrow Date: " + borrowDate);
        System.out.println("Due Date: " + dueDate);

    }

    @Override
    public String getRegistrationSummary() {
        return "Loan Id:"
                + loanId
                + ", Book Title:"
                + book.getTitle()
                + ", Book Author:"
                + book.getAuthor();
    }

    @Override
    public String toString() {
        return "BookLoan{" +
                "loanId='" + loanId + '\'' +
                ", borrowDate=" + borrowDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
