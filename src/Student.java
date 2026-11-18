
import java.time.LocalDate;

public class Student extends AcademicMember{
    private String studentNumber;
    private String programName;
    private LocalDate admissionDate;
    private int studyYear;
    private String guardianPhone;
    private boolean scholarshipStatus;

    public Student(String personId, String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth, String memberNumber, Department department, LocalDate joinDate, String academicStatus, String institutionalEmail, String advisorName, String studentNumber, String programName, LocalDate admissionDate, int studyYear, String guardianPhone, boolean scholarshipStatus) {
        super(personId, firstName, lastName, email, phoneNumber, dateOfBirth, memberNumber, department, joinDate, academicStatus, institutionalEmail, advisorName);
        this.studentNumber = studentNumber;
        this.programName = programName;
        this.admissionDate = admissionDate;
        this.studyYear = studyYear;
        this.guardianPhone = guardianPhone;
        this.scholarshipStatus = scholarshipStatus;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    public String getGuardianPhone() {
        return guardianPhone;
    }

    public void setGuardianPhone(String guardianPhone) {
        this.guardianPhone = guardianPhone;
    }

    public boolean isScholarshipStatus() {
        return scholarshipStatus;
    }

    public void setScholarshipStatus(boolean scholarshipStatus) {
        this.scholarshipStatus = scholarshipStatus;
    }

    @Override
    public boolean isActive() {
        return "ACTIVE".equalsIgnoreCase(getAcademicStatus());
    }

    @Override
    public String getRoleDescription() {
        return "Student";
    }

    @Override
    public String getAcademicCategory() {

        return "Undergraduate Student";
    }

    @Override
    public void validate() throws ValidationException {

        if (studentNumber == null || studentNumber.trim().isEmpty()) {
            throw new ValidationException(
                    "Student number cannot be empty");
        }

        if (programName == null || programName.trim().isEmpty()) {
            throw new ValidationException(
                    "Program name cannot be empty");
        }

        if (studyYear < 1 || studyYear > 6) {
            throw new ValidationException(
                    "Study year must be between 1 and 6");
        }

        if (guardianPhone == null ||
                guardianPhone.trim().isEmpty()) {

            throw new ValidationException(
                    "Guardian phone cannot be empty");
        }
    }

    @Override
    public void printDetails() {

        System.out.println("========= STUDENT =========");
        System.out.println("Student Number: " + studentNumber);

        System.out.println("Name: " + getDisplayName());

        System.out.println("Program: " + programName);

        System.out.println("Study Year: " + studyYear);

        System.out.println("Guardian Phone: " + guardianPhone);

        System.out.println("Scholarship Status: " + scholarshipStatus);

        if (getDepartment() != null) {
            System.out.println("Department: " + getDepartment().getDepartmentName());
        }

        System.out.println("===========================");
    }

    @Override
    public String getRegistrationSummary() {

        String departmentName = "No Department";

        if (getDepartment() != null) {
            departmentName = getDepartment().getDepartmentName();
        }
        return "Student Number: " + studentNumber +
                ", Name: " + getDisplayName() +
                ", Program: " + programName +
                ", Department: " + departmentName;
    }
}
