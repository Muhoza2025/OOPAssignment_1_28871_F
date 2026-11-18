
import java.time.LocalDate;

public class Assessment implements Identifiable,Registrable{
    private String assessmentId;
    private Enrollment enrollment;
    private String assessmentType;
    private double maximumScore;
    private double obtainedScore;
    private LocalDate assessmentDate;

    public Assessment(String assessmentId, Enrollment enrollment, String assessmentType, double maximumScore, double obtainedScore, LocalDate assessmentDate) {
        this.assessmentId = assessmentId;
        this.enrollment = enrollment;
        this.assessmentType = assessmentType;
        this.maximumScore = maximumScore;
        this.obtainedScore = obtainedScore;
        this.assessmentDate = assessmentDate;
    }

    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public double getMaximumScore() {
        return maximumScore;
    }

    public void setMaximumScore(double maximumScore) {
        this.maximumScore = maximumScore;
    }

    public double getObtainedScore() {
        return obtainedScore;
    }

    public void setObtainedScore(double obtainedScore) {
        this.obtainedScore = obtainedScore;
    }

    public LocalDate getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(LocalDate assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    @Override
    public String getId() {
        return assessmentId;
    }

    @Override
    public String getDisplayName() {
        return assessmentType;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void validate() throws ValidationException {
        if (enrollment == null) {
            throw new ValidationException(
                    "Enrollment is null");
        }
        if (assessmentId == null || assessmentId.trim().isEmpty()) {

            throw new ValidationException(
                    "Assessment ID cannot be empty.");
        }
        if (assessmentType == null || assessmentType.trim().isEmpty()) {
            throw new ValidationException(
                    "AssessmentType can not be null");
        }
        if (maximumScore <= 0) {
            throw new ValidationException(
                    "Maximum score can not be negative and it must be bigger than 0");
        }
        if (obtainedScore < 0 || obtainedScore > maximumScore) {
            throw new ValidationException(
                    "Obtained score can not be negative or greater than maximum score");
        }
        if (assessmentDate == null) {
            throw new ValidationException(
                    "AssessmentDate can not be null");
        }

    }

    @Override
    public void printDetails() {
        System.out.println("=========Assessment Details=========");
        System.out.println("Assessment Id: " + assessmentId);
        System.out.println("Enrollment Id: " + enrollment.getEnrollmentId());
        System.out.println("AssessmentType: " + assessmentType);
        System.out.println("Maximum Score: " + maximumScore);
        System.out.println("Obtained Score: " + obtainedScore);
        System.out.println("AssessmentDate: " + assessmentDate);

    }

    @Override
    public String getRegistrationSummary() {
        return "Assessment Id: "
                + assessmentId
                + ", Enrollment Id: "
                + enrollment.getEnrollmentId()
                + ", AssessmentType: "
                + assessmentType;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "assessmentId='" + assessmentId + '\'' +
                ", assessmentType='" + assessmentType + '\'' +
                ", maximumScore=" + maximumScore +
                ", obtainedScore=" + obtainedScore +
                ", assessmentDate=" + assessmentDate +
                '}';
    }
}
