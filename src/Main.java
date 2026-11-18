import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
 
    static ArrayList<Person> people = new ArrayList<>();
    static ArrayList<Department> departments = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Teacher> teachers = new ArrayList<>();
    static ArrayList<Administrator> administrators = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Classroom> classrooms = new ArrayList<>();
    static ArrayList<Enrollment> enrollments = new ArrayList<>();
    static ArrayList<Assessment> assessments = new ArrayList<>();
    static ArrayList<FeePayment> payments = new ArrayList<>();
    static ArrayList<LibraryBook> books = new ArrayList<>();
    static ArrayList<BookLoan> loans = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n============== AUCA ID SCHOOL MANAGEMENT ==============");
            System.out.println("1. Register Department");
            System.out.println("2. Register Student");
            System.out.println("3. Register Teacher");
            System.out.println("4. Register Administrator");            
            System.out.println("0. Exit");

            System.out.print("Select Option: ");

            try {

                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        registerDepartment();
                        break;

                    case 2:
                        registerStudent();
                        break;

                    case 3:
                        registerTeacher();
                        break;

                    case 4:
                        registerAdministrator();
                        break;
                        
                    case 0:
                        System.out.println("Application Closed.");
                        break;

                    default:
                        System.out.println("Invalid Option.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
                choice = -1;
            }

        } while (choice != 0);

        sc.close();
    }


    public static void registerDepartment() {
        try {

            System.out.print("Department ID: ");
            String id = sc.nextLine();

            System.out.print("Department Name: ");
            String name = sc.nextLine();

            System.out.print("Department Code: ");
            String code = sc.nextLine();

            System.out.print("Office Location: ");
            String office = sc.nextLine();

            System.out.print("Contact Email: ");
            String email = sc.nextLine();

            Department department = new Department(id, name, code, office, email, null);

            department.validate();

            departments.add(department);

            System.out.println("Department Registered");

        } catch(Exception e) {

            System.out.println(e.getMessage());
        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }
    }


    public static void registerStudent() {

        try {

            if (Main.departments.isEmpty()) {

                System.out.println(
                        "Register a Department First.");

                return;
            }

            System.out.print("Person ID: ");
            String personId = Main.sc.nextLine();

            System.out.print("First Name: ");
            String firstName = Main.sc.nextLine();

            System.out.print("Last Name: ");
            String lastName = Main.sc.nextLine();

            System.out.print("Email: ");
            String email = Main.sc.nextLine();

            System.out.print("Phone Number: ");
            String phone = Main.sc.nextLine();

            System.out.print("Date Of Birth: ");
            LocalDate dob = LocalDate.parse(Main.sc.nextLine());

            System.out.print("Member Number: ");
            String memberNumber = Main.sc.nextLine();

            System.out.println("\nSelect Department");

            for(int i = 0;
                i < Main.departments.size();
                i++) {

                System.out.println(
                        (i + 1)
                                + ". "
                                + Main.departments.get(i));
            }

            int depChoice = Integer.parseInt(Main.sc.nextLine());

            Department department =
                    Main.departments.get(depChoice - 1);

            System.out.print("Join Date: ");
            LocalDate joinDate = LocalDate.parse(Main.sc.nextLine());

            System.out.print("Academic Status: ");
            String academicStatus = Main.sc.nextLine();

            System.out.print("Institutional Email: ");
            String institutionalEmail = Main.sc.nextLine();

            System.out.print("Advisor Name: ");
            String advisorName = Main.sc.nextLine();

            System.out.print("Student Number: ");
            String studentNumber = Main.sc.nextLine();

            System.out.print("Program Name: ");
            String programName = Main.sc.nextLine();

            System.out.print("Admission Date: ");
            LocalDate admissionDate = LocalDate.parse(
                            Main.sc.nextLine());

            System.out.print("Study Year: ");
            int studyYear = Integer.parseInt(Main.sc.nextLine());

            System.out.print("Guardian Phone: ");
            String guardianPhone = Main.sc.nextLine();

            System.out.print("Scholarship Status (true/false): ");

            boolean scholarship = Boolean.parseBoolean(
                            Main.sc.nextLine());

            Student student = new Student(
                            personId,
                            firstName,
                            lastName,
                            email,
                            phone,
                            dob,
                            memberNumber,
                            department,
                            joinDate,
                            academicStatus,
                            institutionalEmail,
                            advisorName,
                            studentNumber,
                            programName,
                            admissionDate,
                            studyYear,
                            guardianPhone,
                            scholarship
                    );

            student.validate();

            Main.students.add(student);

            Main.people.add(student);

            System.out.println("Student Registered Successfully.");

        }
         catch (ValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void registerTeacher() {
            try {

                if (Main.departments.isEmpty()) {

                    System.out.println(
                            "No Department Exists.");

                    System.out.println(
                            "Register Department First.");

                    return;
                }

                System.out.print("Person ID: ");
                String personId = Main.sc.nextLine();

                System.out.print("First Name: ");
                String firstName = Main.sc.nextLine();

                System.out.print("Last Name: ");
                String lastName = Main.sc.nextLine();

                System.out.print("Email: ");
                String email = Main.sc.nextLine();

                System.out.print("Phone Number: ");
                String phone = Main.sc.nextLine();

                System.out.print("Date Of Birth (YYYY-MM-DD): ");
                LocalDate dob = LocalDate.parse(Main.sc.nextLine());

                System.out.print("Member Number: ");
                String memberNo = Main.sc.nextLine();

                System.out.println(
                        "\nSelect Department");

                for(int i = 0;
                    i < Main.departments.size();
                    i++) {

                    System.out.println(
                            (i + 1)
                                    + ". "
                                    + Main.departments.get(i));
                }

                int depChoice =
                        Integer.parseInt(Main.sc.nextLine());

                Department department = Main.departments.get(depChoice - 1);

                System.out.print("Join Date: ");
                LocalDate joinDate = LocalDate.parse(Main.sc.nextLine());

                System.out.print("Academic Status: ");
                String academicStatus = Main.sc.nextLine();

                System.out.print("Institutional Email: ");
                String instEmail = Main.sc.nextLine();

                System.out.print("Advisor Name: ");
                String advisorName = Main.sc.nextLine();

                System.out.print("Employee Number: ");
                String employeeNumber = Main.sc.nextLine();

                System.out.print("Specialization: ");
                String specialization = Main.sc.nextLine();

                System.out.print("Hire Date: ");
                LocalDate hireDate = LocalDate.parse(Main.sc.nextLine());

                System.out.print("Salary: ");
                BigDecimal salary = new BigDecimal(Main.sc.nextLine());

                System.out.print("Office Number: ");
                String officeNumber = Main.sc.nextLine();

                System.out.print("Employment Type: ");
                String employmentType = Main.sc.nextLine();

                Teacher teacher = new Teacher(
                                personId,
                                firstName,
                                lastName,
                                email,
                                phone,
                                dob,
                                memberNo,
                                department,
                                joinDate,
                                academicStatus,
                                instEmail,
                                advisorName,
                                employeeNumber,
                                specialization,
                                hireDate,
                                salary,
                                officeNumber,
                                employmentType
                        );

                teacher.validate();

                Main.teachers.add(teacher);

                Main.people.add(teacher);

                System.out.println(
                        "Teacher Registered Successfully.");

            }
             catch (ValidationException e) {
                throw new RuntimeException(e);
            }
    }

    public static void registerAdministrator() {
        try {

            System.out.print("Person ID: ");
            String personId = Main.sc.nextLine();

            System.out.print("First Name: ");
            String firstName = Main.sc.nextLine();

            System.out.print("Last Name: ");
            String lastName = Main.sc.nextLine();

            System.out.print("Email: ");
            String email = Main.sc.nextLine();

            System.out.print("Phone Number: ");
            String phone = Main.sc.nextLine();

            System.out.print("Date Of Birth: ");
            LocalDate dob = LocalDate.parse(Main.sc.nextLine());

            System.out.print("Staff Number: ");
            String staffNumber =Main.sc.nextLine();

            System.out.print("Job Title: ");
            String jobTitle = Main.sc.nextLine();

            System.out.print("Assigned Office: ");
            String office = Main.sc.nextLine();

            System.out.print("Employment Date: ");
            LocalDate employmentDate = LocalDate.parse(Main.sc.nextLine());

            System.out.print("Access Level: ");
            int accessLevel = Integer.parseInt(Main.sc.nextLine());

            System.out.print("Active (true/false): ");
            boolean active = Boolean.parseBoolean(Main.sc.nextLine());

            Administrator admin = new Administrator(
                            personId,
                            firstName,
                            lastName,
                            email,
                            phone,
                            dob,
                            staffNumber,
                            jobTitle,
                            office,
                            employmentDate,
                            accessLevel,
                            active
                    );

            admin.validate();

            Main.administrators.add(admin);

            Main.people.add(admin);

            System.out.println("Administrator Registered Successfully.");

        }
        catch (ValidationException e) {
            throw new RuntimeException(e);
        }
    }

}
