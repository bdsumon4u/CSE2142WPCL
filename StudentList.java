import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println(Constant.MSG_EMPTY_ARGUMENT);
            getHelp();
            System.exit(1);
        }

        char query = args[0].charAt(0);

        if (query == Constant.QUERY_ALL) {
            getAll();
        } else if (query == Constant.QUERY_COUNT) {
            getCount();
        } else if (query == Constant.QUERY_HELP) {
            getHelp();
        } else if (query == Constant.QUERY_RANDOM) {
            getRandom();
        } else if (query == Constant.QUERY_INSERT) {
            addNew(args[0].substring(1).trim());
        } else if (query == Constant.QUERY_SEARCH) {
            search(args[0].substring(1).trim());
        } else {
            System.out.println(Constant.MSG_INVALID_ARGUMENT);
            System.out.println(Constant.MSG_SUGGEST_FOR_HELP);
            System.exit(1);
        }
    }

    private static void getAll() {
        System.out.println(Constant.MSG_DATA_LOADING);
        try {
            for (String studentName : studentArray()) {
                System.out.println(studentName);
            }
        } catch (Exception e) {
            //
        }
        System.out.println(Constant.MSG_DATA_LOADED);
    }

    private static void getRandom() {
        System.out.println(Constant.MSG_DATA_LOADING);
        try {
            String []studentList = studentArray();
            int random = new Random().nextInt(studentList.length);
            System.out.println(studentList[random]);
        } catch (Exception e) {
            //
        }
        System.out.println(Constant.MSG_DATA_LOADED);
    }

    private static void addNew(String studentName) {
        System.out.println(Constant.MSG_DATA_LOADING);
        try {
            String students = readStudents();
            PrintWriter out = new PrintWriter(Constant.FILE_STUDENTS);
            DateFormat dateFormat = new SimpleDateFormat(Constant.SIMPLE_DATE_FORMAT);
            String formattedDate = dateFormat.format(new Date());
            out.println(students + Constant.STUDENT_DATA_DELIMITER + studentName);
            out.printf( Constant.MSG_LIST_UPDATED, formattedDate);
            out.close();
        } catch (Exception e) {
            //
        }

        System.out.println(Constant.MSG_DATA_LOADED);
    }

    private static void search(String studentName) {
        System.out.println(Constant.MSG_DATA_LOADING);
        try {
            for (String name : studentArray()) {
                if (name.equals(studentName)) {
                    System.out.println(Constant.MSG_STUDENT_FOUND);
                    break;
                }
            }
        } catch (Exception e) {
            //
        }
        System.out.println(Constant.MSG_DATA_LOADED);
    }

    private static void getCount() {
        System.out.println(Constant.MSG_DATA_LOADING);
        try {
            System.out.printf(
                Constant.MSG_FOUND_COUNT,
                readStudents().split("( )+").length
            );
        } catch (Exception e) {
            //
        }
        System.out.println(Constant.MSG_DATA_LOADED);
    }

    private static String readStudents() throws IOException {
        try (BufferedReader studentReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constant.FILE_STUDENTS)))) {
            return studentReader.readLine();
        } catch (Exception e) {
            throw e;
        }
    }

    private static String[] studentArray() throws IOException {
        return readStudents().split(Constant.STUDENT_DATA_DELIMITER);
    }

    private static void getHelp() {
        System.out.println(Constant.HELP_QUERY_ALL);
        System.out.println(Constant.HELP_QUERY_COUNT);
        System.out.println(Constant.HELP_QUERY_HELP);
        System.out.println(Constant.HELP_QUERY_RANDOM);
        System.out.println(Constant.HELP_QUERY_INSERT);
        System.out.println(Constant.HELP_QUERY_SEARCH);
    }
}