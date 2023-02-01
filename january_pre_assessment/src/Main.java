import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    int code;
    String hardwareName, type, employeeName;
    static boolean found;

    Main() {

    }

    Main(int code, String hardwareName, String type, String employeeName) {
        this.code = code;
        this.hardwareName = hardwareName;
        this.type = type;
        this.employeeName = employeeName;
    }

    public int getCode() {
        return this.code;
    }

    public String getHardwareName() {
        return this.hardwareName;
    }

    public String getType() {
        return this.type;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public String toString() {
        return "Code. " + this.getCode() + "   " + "Hardware: " + this.getHardwareName() + "   " + "Type: "
                + this.getType() + "   " + "Assigned Employee: " + this.employeeName;
    }

    public static Iterator<Main> listIterator;
    public static ArrayList<Main> list = new ArrayList<Main>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int i = 1;

        while (i != 0) {

            System.out.println("A. Add Record");
            System.out.println("B. View Record");
            System.out.println("C. Edit Record");
            System.out.println("D. Delte Record");
            System.out.println("E.Generate Report");
            System.out.println("F. Exit");
            char r = 'o';
            System.out.print("enter :");
            r = in.next().charAt(0);

            switch (Character.toUpperCase(r)) {

                case 'A':
                    System.out.print("Enter code: ");
                    int code = in.nextInt();
                    System.out.print("Enter Hardware Name: ");
                    String hardwareName = in.next();
                    System.out.print("Enter Peripheral Type: ");
                    String type = in.next().toUpperCase();
                    System.out.print("Enter employee name: ");
                    String employeeName = in.next();

                    Main object = new Main(code, hardwareName, type, employeeName);
                    list.add(object);

                    break;

                case 'B':
                    System.out.println("----------------------------------------------------------------------------");

                    listIterator = list.iterator();

                    while (listIterator.hasNext()) {
                        Main e = listIterator.next();
                        System.out.println(e);
                    }

                    System.out.println("----------------------------------------------------------------------------");

                    break;
                case 'C':
                    try {
                        found = false;
                        System.out.print("Please enter Number  : ");
                        code = in.nextInt();

                        System.out.println("----------------------------");
                        listIterator = list.iterator();
                        while (listIterator.hasNext()) {
                            Main e = listIterator.next();
                            if (e.getCode() == code) {

                                System.out.print("Enter Hardware Name: ");
                                hardwareName = in.next();
                                System.out.print("Enter Peripheral Type: ");
                                type = in.next();
                                System.out.print("Enter employee name: ");
                                employeeName = in.next();

                                list.set(0, new Main(code, hardwareName, type, employeeName));
                                found = true;
                            }

                        }
                        if (!found)
                            System.out.println("Record not Found");
                        else
                            System.out.println("Record was Updated Successfully..!");

                        System.out.println("----------------------------");
                    } catch (Exception e) {
                        // TODO: handle exception
                    }

                    break;
                case 'D':
                    found = false;
                    System.out.print("Please enter Number  : ");
                    code = in.nextInt();

                    System.out.println("----------------------------");
                    listIterator = list.iterator();
                    while (listIterator.hasNext()) {
                        Main e = listIterator.next();
                        if (e.getCode() == code) {
                            listIterator.remove();
                            found = true;
                        }

                    }
                    if (!found)
                        System.out.println("Record not Found");
                    else
                        System.out.println("Record was Deleted Successfully..!");

                    System.out.println("----------------------------");
                    break;
                case 'E':
                    showReport();
                    break;
                case 'F':
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Thank You!!");
                    System.out.println("Please Come Again.!!");
                    i = 0;
                    System.out.println("-----");
                    break;
                default:
                    System.out.println("An error occured");
            }
        }
    }

    public static void showReport() {
        Scanner in = new Scanner(System.in);

        System.out.println("<====Generate Report=====>");
        System.out.println("A. Total input devices");
        System.out.println("B. Total output devices");
        System.out.println("c. Exit");
        System.out.print("Enter: ");

        char newOption = in.next().charAt(0);
        int count = 0;
        switch (Character.toLowerCase(newOption)) {

            case 'a':
                listIterator = list.iterator();
                while (listIterator.hasNext()) {
                    Main e = listIterator.next();
                    if (e.getType().equals("INPUT")) {
                        count++;
                    }
                }
                System.out.println("Total input: " + count);
                break;
            case 'b':
                listIterator = list.iterator();
                while (listIterator.hasNext()) {
                    Main e = listIterator.next();
                    if (e.getType().equals("OUTPUT")) {
                        count++;
                    }
                }
                System.out.println("Total input: " + count);
                break;
            case 'c':
                System.out.println("Thank you");
            default:
                break;
        }

    }
}