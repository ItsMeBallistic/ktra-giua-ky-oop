import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Person {
    public String name;
    public int age;
    public String gender;
    protected String bank_account;

    public Person(String name, int age, String gender, String bank_account) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.bank_account = bank_account;
    }

    abstract String getRole();

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nGender: " + gender + "\nBank Account: " + bank_account + "\n";
    }
}

interface KPIEvaluator {
    public double calculateKPI();
}

class TeachingAssistant extends Person implements KPIEvaluator {

    public String employeeID;
    private int numberOfCourse;

    public TeachingAssistant(String name, int age, String gender, String bank_account, String employeeID, int numberOfCourse) {
        super(name, age, gender, bank_account);
        this.employeeID = employeeID;
        this.numberOfCourse = numberOfCourse;
    }

    @Override
    String getRole() {
        return "Teaching Assistant";
    }

    @Override
    public double calculateKPI() {
        return numberOfCourse * 5;
    }
}

class Lecturer extends Person implements KPIEvaluator {
    public String employeeID;
    private int numberOfPublications;

    public Lecturer(String name, int age, String gender, String bank_account, String employeeID, int numberOfPublications) {
        super(name, age, gender, bank_account);
        this.employeeID = employeeID;
        this.numberOfPublications = numberOfPublications;
    }

    @Override
    String getRole() {
        return "Lecturer";
    }

    @Override
    public double calculateKPI() {
        return numberOfPublications * 7;
    }
}

class Professor extends Lecturer implements KPIEvaluator {
    public static int countProfessors = 0;
    private int numberOfProjects;

    public Professor(String name, int age, String gender, String bank_account, String employeeID, int numberOfPublications, int numberOfProjects) {
        super(name, age, gender, bank_account, employeeID, numberOfPublications);
        countProfessors += 1;
        this.numberOfProjects = numberOfProjects;
    }

    @Override
    String getRole() {
        return "Professor";
    }

    @Override
    public double calculateKPI() {
        return super.calculateKPI() + numberOfProjects * 10;
    }
}
class Main {
    public static void main(String[] args) {
        TeachingAssistant teachingAssistant1 = new TeachingAssistant("Tien", 34, "Male", "09123654145", "TA1235419", 3);
        Lecturer lecturer1 = new Lecturer("Huy", 56, "Male", "9124091750", "LEC128451", 5);
        Professor professor1 = new Professor("Yen", 41, "Female", "15914128145", "PRO1085142", 9, 21);
        // GOI HAM GETROLE()
        System.out.println(teachingAssistant1.getRole());
        System.out.println(lecturer1.getRole());
        System.out.println(professor1.getRole());

        //GOI HAM CALCULATELKPI()
        System.out.println(teachingAssistant1.calculateKPI());
        System.out.println(lecturer1.calculateKPI());
        System.out.println(professor1.calculateKPI());

    }
}