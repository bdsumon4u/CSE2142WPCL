import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
    public static void main(String[] args) {

        // Check arguments
        switch (args[0].charAt(0)) {
            case 'a':
                getAll();
                break;
            case 'c':
                getCount();
                break;
            case 'r':
                getRandom();
                break;
            case '+':
                addNew(args[0].substring(1));
                break;
            case '?':
                search(args[0].substring(1));
                break;
            default:
                System.out.println("Invalid argument");
                System.exit(1);
        }
    }

    private static void getAll() {
        System.out.println("Loading data ...");
        try {
            BufferedReader studentReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
            String students = studentReader.readLine();
            String []studentList = students.split(", ");
            for (String studentName : studentList) {
                System.out.println(studentName);
            }
        } catch (Exception e) {
            //
        }
        System.out.println("Data Loaded.");
    }

    private static void getRandom() {
        System.out.println("Loading data ...");
        try {
            BufferedReader studentReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
            String students = studentReader.readLine();
            // System.out.println(students);
            String []studentList = students.split(", ");
            int random = new Random().nextInt(studentList.length);
            System.out.println(studentList[random]);
        } catch (Exception e) {
            //
        }
        System.out.println("Data Loaded.");
    }

    private static void addNew(String studentName) {
        System.out.println("Loading data ...");
        try {
            String students = new Scanner(new FileInputStream("students.txt")).nextLine();
            PrintWriter out = new PrintWriter("students.txt");
            DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a");
            String formattedDate = dateFormat.format(new Date());
            out.write(students + ", " + studentName + "\nList last updated on " + formattedDate);
            out.close();
        } catch (Exception e) {
            //
        }

        System.out.println("Data Loaded.");
    }

    private static void search(String studentName) {
        System.out.println("Loading data ...");
        try {
            BufferedReader studentReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
            String students = studentReader.readLine();
            String []studentList = students.split(", ");
            for (String name : studentList) {
                if (name.equals(studentName)) {
                    System.out.println("We found it!");
                    break;
                }
            }
        } catch (Exception e) {
            //
        }
        System.out.println("Data Loaded.");
    }

    private static void getCount() {
        System.out.println("Loading data ...");
        try {
            BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
            String D = s.readLine();
            char []a = D.toCharArray();
            int count = 1;
            for (char c : a) {
                if (c ==' ') {
                    count++;
                }
            }
            System.out.println(count + " word(s) found.");
        } catch (Exception e) {
            //
        }
        System.out.println("Data Loaded.");
    }
}