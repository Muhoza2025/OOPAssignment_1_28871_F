

import java.math.BigDecimal;
import java.time.LocalDate;

public class Teacher extends AcademicMember{
    private String employeeNumber;
    private String specialization;
    private LocalDate hireDate;
    private BigDecimal salary;
    private String officeNumber;
    private String employmentType;


    public Teacher(String personId, String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth, String memberNumber, Department department, LocalDate joinDate, String academicStatus, String institutionalEmail, String advisorName, String employeeNumber, String specialization, LocalDate hireDate, BigDecimal salary, String officeNumber, String employmentType) {
        super(personId, firstName, lastName, email, phoneNumber, dateOfBirth, memberNumber, department, joinDate, academicStatus, institutionalEmail, advisorName);
        this.employeeNumber = employeeNumber;
        this.specialization = specialization;
        this.hireDate = hireDate;
        this.salary = salary;
        this.officeNumber = officeNumber;
        this.employmentType = employmentType;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        if (salary != null && salary.compareTo(BigDecimal.ZERO) > 0) {

            this.salary = salary;
        } else {
            System.out.println(
                    "Salary must be greater than zero.");
        }
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    @Override
    public boolean isActive() {
        return "ACTIVE".equalsIgnoreCase(
                getAcademicStatus());
    }

    @Override
    public String getRoleDescription() {
        return "Teacher";
    }

    @Override
    public String getAcademicCategory() {
        return "Teaching Staff";
    }

    @Override
    public void validate() throws ValidationException {

        if (employeeNumber == null ||
                employeeNumber.trim().isEmpty()) {

            throw new ValidationException(
                    "Employee number cannot be empty.");
        }

        if (specialization == null ||
                specialization.trim().isEmpty()) {

            throw new ValidationException(
                    "Specialization cannot be empty.");
        }

        if (salary == null ||
                salary.compareTo(BigDecimal.ZERO) <= 0) {

            throw new ValidationException(
                    "Salary must be greater than zero.");
        }

        if (officeNumber == null ||
                officeNumber.trim().isEmpty()) {

            throw new ValidationException(
                    "Office number cannot be empty.");
        }

        if (employmentType == null ||
                employmentType.trim().isEmpty()) {

            throw new ValidationException(
                    "Employment type cannot be empty.");
        }
    }

    @Override
    public void printDetails() {

        System.out.println("===== TEACHER DETAILS =====");

        System.out.println("Employee Number: " + employeeNumber);

        System.out.println("Name: " + getDisplayName());

        System.out.println("Specialization: " + specialization);

        System.out.println("Hire Date: " + hireDate);

        System.out.println("Salary: " + salary);

        System.out.println("Office Number: " + officeNumber);

        System.out.println("Employment Type: " + employmentType);

        if (getDepartment() != null) {

            System.out.println("Department: " + getDepartment().getDepartmentName());
        }
    }

    @Override
    public String getRegistrationSummary() {

        String departmentName = "No Department";

        if (getDepartment() != null) {

            departmentName = getDepartment().getDepartmentName();
        }
        return "Employee Number: "
                + employeeNumber
                + ", Name: "
                + getDisplayName()
                + ", Department: "
                + departmentName;
    }

    @Override
    public String toString() {

        return "Teacher{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", name='" + getDisplayName() + '\'' +
                ", specialization='" + specialization + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                '}';
    }
}
