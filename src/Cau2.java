import java.util.ArrayList;
import java.util.Scanner;


public class Cau2 {
    public static void main(String[] args) {
        //Danh sach luu tru cac doi tuong
        ArrayList<Person> personList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter information for person");
        String department;
        do {
            System.out.print("Department (ta/lec/gs): ");
            department = scanner.nextLine().toLowerCase();
        } while (!department.equals("ta") && !department.equals("lec") && !department.equals("gs"));
        System.out.print("Their name: ");
        String name = scanner.nextLine();
        System.out.print("their ID: ");
        String ID = scanner.nextLine();
        int age;
        do {
            System.out.print("Their age: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
            age = scanner.nextInt();
            scanner.nextLine();
        } while (age <= 0);
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Bank Account: ");
        String bank_account = scanner.nextLine();
        int numberOfCourses;
        int numberOfPublications;
        int numberOfProjects;
        do {
            System.out.print("Their number of courses: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next();
            }
            numberOfCourses = scanner.nextInt();
        } while (numberOfCourses < 0);
        do {
            System.out.print("Their number of publications: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next();
            }
            numberOfPublications = scanner.nextInt();
        } while (numberOfPublications < 0);
        do {
            System.out.print("Their number of projects: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next();
            }
            numberOfProjects = scanner.nextInt();
        } while (numberOfProjects < 0);

        Person person;
        if (department.equals("ta")) {
            person = new TeachingAssistant(name, age, gender, bank_account, ID, numberOfCourses);
        } else if (department.equals("lec")) {
            person = new Lecturer(name, age, gender, bank_account, ID, numberOfPublications);
        } else {
            person = new Professor(name, age, gender, bank_account, ID, numberOfPublications, numberOfProjects );
        }
        personList.add(person);

        System.out.println(person);
        person.getRole();
        double kpi = ((KPIEvaluator) person).calculateKPI();
        System.out.println("Their KPI is: " +kpi);

        // Hiển thị danh sách đối tượng và đếm số lượng đối tượng
        int professorCount = 0;
        System.out.println("\n Danh sach đối tượng: ");
        for (Person persons: personList) {
            System.out.println("Loại đối tượng: " + person.getRole());
            System.out.println("Tên: " + person.name);
            System.out.println("Tuổi: " + person.age);
            System.out.println("Giới tính: " + person.gender);
            if (person instanceof KPIEvaluator) {
                System.out.println("KPI: " + ((KPIEvaluator) person).calculateKPI()); // Tính KPI
            }
            System.out.println();

            if (person instanceof Professor) {
                professorCount++;
            }
        }

    }

}