
public class Classroom implements Identifiable, Registrable{
    private String classroomId;
    private String buildingName;
    private String roomNumber;
    private int capacity;
    private int floorNumber;
    private boolean available;

    public Classroom(String classroomId, String buildingName, String roomNumber, int capacity, int floorNumber, boolean available) {
        this.classroomId = classroomId;
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.floorNumber = floorNumber;
        this.available = available;
    }

    public String getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String getId() {
        return classroomId;
    }

    @Override
    public String getDisplayName() {
        return buildingName;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void validate() throws ValidationException {

        if (classroomId == null || classroomId.isEmpty()) {
            throw new ValidationException(
                    "A Classroom can not be empty.");
        }
        if (buildingName == null || buildingName.trim().isEmpty()) {
            throw new ValidationException(
                    "There should be at least one building name.");
        }
        if (roomNumber == null || roomNumber.isEmpty()) {
            throw new ValidationException(
                    "There should be at least one room number.");
        }
        if (capacity < 40 || capacity > 70) {
            throw new ValidationException(
                    "Capacity must be between 40 and 70.");
        }
        if (floorNumber < 1) {
            throw new ValidationException(
                    "Floor number must be greater than 0.");
        }

    }

    @Override
    public void printDetails() {
        System.out.println("========Classroom Information=======");
        System.out.println("ID: " + classroomId);
        System.out.println("Building Name: " + buildingName);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Capacity: " + capacity);
        System.out.println("Floor Number: " + floorNumber);
        System.out.println("Available: " + available);

    }

    @Override
    public String getRegistrationSummary() {
        return "Classroom "
                + classroomId
                + ", Building "
                + buildingName
                + ", Availability "
                + available;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomId='" + classroomId + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", capacity=" + capacity +
                ", floorNumber=" + floorNumber +
                ", available=" + available +
                '}';
    }
}
