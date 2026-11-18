
public interface Registrable {
     int MIN_NAME_LENGTH=4;
     int MAX_NAME_LENGTH=50;
     int MAX_EMAIL_LENGTH=20;
     int MIN_PHONE_LENGTH=15;
     int MAX_PHONE_LENGTH=20;
     String DATE_PATTERN="dd/MM/yyyy";

    void validate() throws ValidationException;
    void printDetails();
    String getRegistrationSummary();

}
