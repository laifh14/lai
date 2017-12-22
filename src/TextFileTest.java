import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TextFileTest {
    public static void main(String[] args) {
        //System.out.println(System.getProperty("user.dir"));
        try {
            Employee employee1 = new Employee("jack", 5000, 1991, 6, 8);
            Employee employee2 = new Employee("ming", 8000, 1992, 9, 10);
            Employee employee3 = new Employee("mary", 3000, 1993, 10, 27);
            Employee[] employees = {employee1, employee2, employee3};
            TextFileTest test=new TextFileTest();

            try (PrintWriter out = new PrintWriter("employee.txt")) {
                test.writeData(employees,out);
            }

            try(Scanner in=new Scanner(new FileInputStream("employee.txt"))){
                Employee[] employees1=test.readData(in);
                for(Employee employee:employees){
                    System.out.println(employee);
                }
            }
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        }
    }

    private Employee[] readData(Scanner in) {
        int length;
        length = in.nextInt();
        Employee[] employees = new Employee[length];
        in.nextLine();
        for (int i = 0; i < length; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    private void writeData(Employee[] employees, PrintWriter out) {
        out.println(employees.length);
        for (int i = 0; i < employees.length; i++) {
            writeEmployee(employees[i], out);
        }
    }

    private Employee readEmployee(Scanner in) {
        String empStr = in.nextLine();
        String[] employStrs = empStr.split("\\|");
        Employee employee = new Employee();
        employee.setName(employStrs[0]);
        employee.setSalary(Double.parseDouble(employStrs[1]));
        GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(employStrs[2]), Integer.parseInt(employStrs[3]),
                Integer.parseInt(employStrs[4]));
        employee.setBirthDate(calendar.getTime());
        return employee;
    }

    private void writeEmployee(Employee employee, PrintWriter out) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(employee.getBirthDate());
        out.println(employee.getName() + "|" + employee.getSalary() + "|" + calendar.get(Calendar.YEAR) + "|" + calendar.
                get(Calendar.MONTH) + "|" + calendar.get(Calendar.DATE));
    }
}

class Employee {
    private String name;
    private double salary;
    private Date birthDate;

    public Employee() {
    }

    public Employee(String name, double salary, int year, int month, int date) {
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year, month, date);
        Date date1=new Date(calendar.getTimeInMillis());
        birthDate=date1;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return name+","+salary+","+birthDate.toString();
    }
}