import java.time.LocalDate;

public abstract class Person implements Identifiable, Registrable{
    protected String personId;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;
    protected LocalDate dateOfBirth;

    public Person() {}

    public Person(String personId, String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String getId() {
        return personId;
    }

    @Override
    public String getDisplayName(){

        return firstName+" "+lastName;
    }

    @Override
    public void validate() throws ValidationException {
        if(firstName == null || firstName.trim().length() < 2){
            throw new ValidationException(
                    "Invalid first name");
        }

        if(lastName == null || lastName.trim().length() < 2){
            throw new ValidationException(
                    "Invalid last name");
        }

        if(email == null || !email.contains("@")){
            throw new ValidationException(
                    "Invalid email");
        }
    }

    @Override
    public void printDetails() {
        System.out.println("ID: " + personId);
        System.out.println("Name: " + getDisplayName());
        System.out.println("Email: " + email);

    }
    public abstract String getRoleDescription();
}
