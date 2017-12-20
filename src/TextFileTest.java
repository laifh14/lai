import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;

public class TextFileTest {
    public static void main(String[] args){

    }

    private Employee[] readData(Scanner in){
        //TODO
        return null;
    }

    private void writeData(Employee[] employees, PrintWriter out){

    }

    private Employee readEmployee(Scanner in){
        //TODO
        return null;
    }

    private void writeEmployee(Employee employee,PrintWriter out){

    }
}
class Employee{
    private String name;
    private double salary;
    private Calendar birthDate;

    public Employee(String name,double salary,Calendar birthDate){
        this.birthDate=birthDate;
        this.name=name;
        this.salary=salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }
}