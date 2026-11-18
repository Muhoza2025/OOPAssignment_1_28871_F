import java.time.LocalDate;

public abstract class AcademicMember extends Person {
    protected String memberNumber;
    protected Department department;
    protected LocalDate joinDate;
    protected String academicStatus;
    protected String institutionalEmail;
    protected String advisorName;

    public AcademicMember(String personId, String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth, String memberNumber, Department department, LocalDate joinDate, String academicStatus, String institutionalEmail, String advisorName) {
        super(personId, firstName, lastName, email, phoneNumber, dateOfBirth);
        this.memberNumber = memberNumber;
        this.department = department;
        this.joinDate = joinDate;
        this.academicStatus = academicStatus;
        this.institutionalEmail = institutionalEmail;
        this.advisorName = advisorName;
    }

    public abstract String getAcademicCategory();

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getAcademicStatus() {
        return academicStatus;
    }

    public void setAcademicStatus(String academicStatus) {
        this.academicStatus = academicStatus;
    }

    public String getInstitutionalEmail() {
        return institutionalEmail;
    }

    public void setInstitutionalEmail(String institutionalEmail) {
        this.institutionalEmail = institutionalEmail;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }


    public String getDisplayName() {
        super.getDisplayName();
        return getFirstName() + " " + getLastName();
    }

    @Override
    public String getRegistrationSummary() {
        return "Member Number: " + memberNumber
                + ", Department: "
                + department.getDepartmentName()
                + ", Status: "
                + academicStatus;
    }
}
