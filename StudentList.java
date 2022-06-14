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
            case 'h':
                getHelp();
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
                System.out.println("Use 'h' flag for help");
                System.exit(1);
        }
    }

    private static void getAll() {
        System.out.println("Loading data ...");
        try {
            String []studentList = studentArray();
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
            String []studentList = studentArray();
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
            String students = readStudents();
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
            String []studentList = studentArray();
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
            String students = readStudents();
            char []chars = students.toCharArray();
            int count = 1;
            for (char ch : chars) {
                if (ch ==' ') {
                    count++;
                }
            }
            System.out.println(count + " word(s) found.");
        } catch (Exception e) {
            //
        }
        System.out.println("Data Loaded.");
    }

    private static String readStudents() throws IOException {
        BufferedReader studentReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
        String students = studentReader.readLine();
        studentReader.close();
        return students;
    }
    private static String[] studentArray() throws IOException {
        return readStudents().split(", ");
    }

    private static void getHelp() {
        System.out.println("Use: a - for all students.");
        System.out.println("Use: c - for number of words.");
        System.out.println("Use: h - for getting help.");
        System.out.println("Use: r - for random student.");
        System.out.println("Use: +StudentName - for adding a new student.");
        System.out.println("Use: ?StudentName - for searching a student.");
    }
}