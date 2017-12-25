import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
    public static void main(String[] args) {
        Employee harry = new Employee("harry", 3000, 1990, 3, 25);
        Manager jack = new Manager("jack", 6000, 1988, 6, 30);
        jack.setSecretary(harry);
        Manager cary = new Manager("cary", 7000, 1985, 8, 19);
        cary.setSecretary(harry);

        Employee[] staff = new Employee[3];
        staff[0] = jack;
        staff[1] = harry;
        staff[2] = cary;

        try {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.txt"))) {
                out.writeObject(staff);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }

    }
}

class Manager extends Employee {
    private Employee secretary;

    public Manager(String name, double salary, int year, int month, int date) {
        super(name, salary, year, month, date);
    }

    public void setSecretary(Employee employee) {
        this.secretary = employee;
    }
}