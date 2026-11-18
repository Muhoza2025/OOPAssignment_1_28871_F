
import java.time.LocalDate;

public class Enrollment implements Identifiable, Registrable{
    private String enrollmentId;
    private Student student;
    private Course course;
    private LocalDate enrollmentDate;
    private String semester;
    private String enrollmentStatus;

    public Enrollment(String enrollmentId, Student student, Course course, LocalDate enrollmentDate, String semester, String enrollmentStatus) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.semester = semester;
        this.enrollmentStatus = enrollmentStatus;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    @Override
    public String getId() {
        return enrollmentId;
    }

    @Override
    public String getDisplayName() {
        return student.getDisplayName();
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void validate() throws ValidationException {
        if (enrollmentId == null || enrollmentId.trim().isEmpty()) {
            throw new ValidationException(
                    "A enrollment ID must be provided.");
        }
        if (enrollmentDate == null) {
            throw new ValidationException(
                    "A enrollment date must be provided.");
        }
        if (enrollmentDate.isAfter(LocalDate.now())){
            throw new ValidationException(
                    "A enrollment date must not be in the future.");
        }
        if (enrollmentStatus == null ||  enrollmentStatus.trim().isEmpty()) {
            throw new ValidationException(
                    "A enrollment status must be provided.");
        }
        if (student == null) {
            throw new ValidationException(
                    "You must enter a student to be assigned.");
        }
        if (course == null) {
            throw new ValidationException(
                    "You must enter a course to be assigned.");
        }
        if (semester == null || semester.trim().isEmpty()) {
            throw new ValidationException(
                    "You must select a semester.");
        }

    }

    @Override
    public void printDetails() {
        System.out.println("===========Enrollment Details===========");
        System.out.println("Enrollment Id: " + enrollmentId);
        System.out.println("Student: " + student.getDisplayName());
        System.out.println("Course: " + course.getDisplayName());
        System.out.println("Enrollment Date: " + enrollmentDate);
        System.out.println("Semester: " + semester);
        System.out.println("Enrollment Status: " + enrollmentStatus);


    }

    @Override
    public String getRegistrationSummary() {
        return "Enrollment Id: "
                + enrollmentId
                + ", Student: "
                + student.getDisplayName()
                + ", Course: "
                + course.getDisplayName();

    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollmentId='" + enrollmentId + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", semester='" + semester + '\'' +
                ", enrollmentStatus='" + enrollmentStatus + '\'' +
                '}';
    }
}
