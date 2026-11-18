
import java.math.BigDecimal;
import java.time.LocalDate;

public class FeePayment implements Identifiable,Registrable{
    private String paymentId;
    private Student student;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String receiptNumber;

    public FeePayment(String paymentId, Student student, BigDecimal amount, LocalDate paymentDate, String paymentMethod, String receiptNumber) {
        this.paymentId = paymentId;
        this.student = student;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.receiptNumber = receiptNumber;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    @Override
    public String getId() {
        return getPaymentId();
    }

    @Override
    public String getDisplayName() {
        return getPaymentMethod();
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void validate() throws ValidationException {
        if (paymentId == null || paymentId.trim().isEmpty()) {
            throw new ValidationException("Payment ID is required");
        }
        if (student == null) {
            throw new ValidationException("Student is required");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <=0) {
            throw new ValidationException("Amount must be greater than zero");
        }
        if (paymentDate == null|| paymentDate.isAfter(LocalDate.now())) {
            throw new ValidationException("Payment Date is required and it should not be in the future");
        }
        if (paymentMethod == null||paymentMethod.trim().isEmpty()) {
            throw new ValidationException("Payment Method is required");
        }
        if (receiptNumber == null||receiptNumber.trim().isEmpty()) {
            throw new ValidationException("Receipt Number is required");
        }

    }

    @Override
    public void printDetails() {
        System.out.println("=============Payment Details=============");
        System.out.println("PaymentId: " + getPaymentId());
        System.out.println("Student: " + getStudent().getDisplayName());
        System.out.println("Amount: " + getAmount());
        System.out.println("PaymentDate: " + getPaymentDate());
        System.out.println("PaymentMethod: " + getPaymentMethod());
        System.out.println("ReceiptNumber: " + getReceiptNumber());
    }

    @Override
    public String getRegistrationSummary() {
        return "Payment: "
                + getPaymentId()
                + ", Student: "
                + getStudent().getDisplayName()
                + ", Amount: "
                + getAmount();
    }

    @Override
    public String toString() {
        return "FeePayment{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", receiptNumber='" + receiptNumber + '\'' +
                '}';
    }
}
