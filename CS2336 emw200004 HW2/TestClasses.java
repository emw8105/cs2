import java.util.*;

// Person is the grandfather class, everything inherits it except myDate
class Person {
    protected String name;
    private String address;
    private long phoneNum;
    private String emailAdd;

    Person(String name, String address, long phoneNum, String emailAdd) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.emailAdd = emailAdd;
    }

    // Override toString of Person
    public String toString() {
        String output = "Person, name: " + name + "\n";
        System.out.print(output);
        return output;
    }
}
class Employee extends Person {  // inherits person and both Faculty and Staff are children
    private String office;
    private double salary;
    private myDate dateHired;

    Employee(String name, String address, long phoneNum, String emailAdd, String office, double salary, myDate dateHired) {
        super(name, address, phoneNum, emailAdd); // use super to call constructor to Person
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    // Override toString of Employee
    public String toString() {
        String output = "Employee, name: " + name + "\n";
        System.out.print(output);
        return output;
    }
}
class Faculty extends Employee { // Person --> Employee --> Faculty
    private String officeHours;
    private String rank;
    Faculty(String name, String address, long phoneNum, String emailAdd, String office, double salary, myDate dateHired, String officeHours, String rank) {
        super(name, address, phoneNum, emailAdd, office, salary, dateHired); // use super to call constructor to Employee --> Person
        this.officeHours = officeHours;
        this.rank = rank;

    }

    // Override toString of Faculty
    public String toString() {
        String output = "Faculty, name: " + name + "\n";
        System.out.print(output);
        return output;
    }
}
class Staff extends Employee { // Person --> Employee --> Staff
    private String title;
    Staff(String name, String address, long phoneNum, String emailAdd, String office, double salary, myDate dateHired, String title) {
        super(name, address, phoneNum, emailAdd, office, salary, dateHired); // use super to call constructor to Employee --> Person
        this.title = title;

    }

    // Override toString of Staff
    public String toString() {
        String output = "Staff, name: " + name + "\n";
        System.out.print(output);
        return output;
    }
}
class Student extends Person { // Student has no children, and only inherits Person
    private final String status;

    Student(String name, String address, long phoneNum, String emailAdd, String status) {
        super(name, address, phoneNum, emailAdd); // use super to call constructor to Person
        this.status = status;
    }

    // Override toString of Student
    public String toString() {
        String output = "Student, name: " + name + "\n";
        System.out.print(output);
        return output;
    }
}
class myDate {
    private int year;
    private int month;
    private int day;

    // constructors
    public myDate() { // no args sets date to be current date at runtime
        // use a temporary calendar from the java GregorianCalendar class to access real-world time
        GregorianCalendar tempDate = new GregorianCalendar();
        // use built-in methods from Calendar to split into different components of time
        year = tempDate.get(Calendar.YEAR);
        month = tempDate.get(Calendar.MONTH);
        day = tempDate.get(Calendar.DAY_OF_MONTH);
    }
    public myDate(long elapsedTime) { // specific elapsed time since midnight January 1, 1970 in milliseconds
        // use a temporary calendar from the java GregorianCalendar class to access real-world time
        GregorianCalendar tempDate = new GregorianCalendar();
        tempDate.setTimeInMillis(elapsedTime); // set the time to be the parameter

        // use built-in methods from Calendar to split into different components of time at that elapsed time amount
        year = tempDate.get(Calendar.YEAR);
        month = tempDate.get(Calendar.MONTH);
        day = tempDate.get(Calendar.DAY_OF_MONTH);
    }
    public myDate(int year, int month, int day) { // specified time components assigns those to date instead
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // getter methods
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }

    // set date method
    public void setDate(long elapsedTime) { // same as constructor, use to change the date at any given time
        // use a temporary calendar from the java GregorianCalendar class to access real-world time
        GregorianCalendar tempDate = new GregorianCalendar();
        tempDate.setTimeInMillis(elapsedTime); // set the time to be the parameter

        // use built-in methods from Calendar to split into different components of time at that elapsed time amount
        year = tempDate.get(Calendar.YEAR);
        month = tempDate.get(Calendar.MONTH);
        day = tempDate.get(Calendar.DAY_OF_MONTH);
    }
}

public class TestClasses {
    public static void main(String[] args) {

        // create objects of each type and then use overridden .toString() method to output information
        Person a = new Person("Patty", "857 Cardinal Lane",2148934477L, "pty@gmail.com");
        a.toString();

        myDate date1 = new myDate(2022, 9, 29);
        Employee b = new Employee("Jeff", "idk", 8713061518L, "b@gmail.com",
                "Mega Driving School", 32000.0, date1);
        b.toString();

        myDate date2 = new myDate(2005, 10,22);
        Faculty c = new Faculty("Herbert", "74 Albuquerque NM", 7924202469L, "herb@gmail.com",
                "Dashcam Nation Headquarters", 90000.0, date2, "2:00-7:00", "General President");
        c.toString();

        myDate date3 = new myDate();
        Staff d = new Staff("Finn", "123 Portland Drive", 7894327974L, "finn@nycap.rr.com",
                "Roadrunner Inc.", 700000.0, date3, "CEO");
        d.toString();

        Student e = new Student("Nicole","131 Castlebury Court", 2141446798L, "nlr8765@outlook.com",
                "Senior");
        e.toString();
    }
}