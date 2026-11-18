
public class Department implements Identifiable,Registrable{
    private String departmentId;
    private String departmentName;
    private String departmentCode;
    private String officeLocation;
    private String contactEmail;
    private Teacher headTeacher;

    public Department() {

        this.headTeacher = null;
    }

    public Department(String departmentId, String departmentName, String departmentCode, String officeLocation, String contactEmail, Teacher headTeacher) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.officeLocation = officeLocation;
        this.contactEmail = contactEmail;
        this.headTeacher = headTeacher;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Teacher getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(Teacher headTeacher) {
        this.headTeacher = headTeacher;
    }

    @Override
    public String getId() {
        return getDepartmentId();
    }

    @Override
    public String getDisplayName() {
        return getDepartmentName();
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void validate() throws ValidationException {

        if (departmentId == null ||
                departmentId.trim().isEmpty()) {

            throw new ValidationException(
                    "Department ID cannot be empty");
        }

        if (departmentName == null ||
                departmentName.trim().isEmpty()) {

            throw new ValidationException(
                    "Department name cannot be empty");
        }

        if (departmentCode == null ||
                departmentCode.trim().isEmpty()) {

            throw new ValidationException(
                    "Department code cannot be empty");
        }

        if (officeLocation == null ||
                officeLocation.trim().isEmpty()) {

            throw new ValidationException(
                    "Office location cannot be empty");
        }

        if (contactEmail == null ||
                !contactEmail.contains("@")) {

            throw new ValidationException(
                    "Invalid email address");
        }


    }

    @Override
    public void printDetails() {

        System.out.println("===== DEPARTMENT =====");
        System.out.println("Department ID: " + departmentId);
        System.out.println("Department Name: " + departmentName);
        System.out.println("Department Code: " + departmentCode);
        System.out.println("Office Location: " + officeLocation);
        System.out.println("Contact Email: " + contactEmail);

        if (headTeacher == null) {

            System.out.println(
                    "Head Teacher: Not Assigned");
        } else {

            System.out.println(
                    "Head Teacher: "
                            + headTeacher.getDisplayName());
        }
    }

    @Override
    public String getRegistrationSummary() {
        String teacherName = "Not Assigned";

        if (headTeacher != null) {
            teacherName =
                    headTeacher.getDisplayName();
        }

        return "Department ID: "
                + departmentId
                + ", Department Name: "
                + departmentName
                + ", Head Teacher: "
                + teacherName;
    }
    @Override
    public String toString() {

        if (headTeacher == null) {

            return departmentId + " - "
                    + departmentName
                    + " (Head Teacher: Not Assigned)";
        }

        return departmentId + " - "
                + departmentName
                + " (Head Teacher: "
                + headTeacher.getDisplayName()
                + ")";
    }
}
