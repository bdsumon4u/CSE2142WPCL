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
            BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
            String r = s.readLine();
            String []i = r.split(", ");
            for (String j : i) {
                System.out.println(j);
            }
        } catch (Exception e) {
            //
        }
        System.out.println("Data Loaded.");
    }

    private static void getRandom() {
        System.out.println("Loading data ...");
        try {
            BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
            String r = s.readLine();
            // System.out.println(r);
            String []i = r.split(", ");
            Random x = new Random();
            int y = x.nextInt(i.length);
            System.out.println(i[y]);
        } catch (Exception e) {
            //
        }
        System.out.println("Data Loaded.");
    }

    private static void addNew(String t) {
        System.out.println("Loading data ...");
        try {
            String students = new Scanner(new FileInputStream("students.txt")).nextLine();
            PrintWriter out = new PrintWriter("students.txt");
            Date d = new Date();
            String df = "dd/mm/yyyy-hh:mm:ss a";
            DateFormat dateFormat = new SimpleDateFormat(df);
            String fd= dateFormat.format(d);
            out.write(students + ", " + t + "\nList last updated on " + fd);
            out.close();
        } catch (Exception e) {
            //
        }

        System.out.println("Data Loaded.");
    }

    private static void search(String t) {
        System.out.println("Loading data ...");
        try {
            BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
            String r = s.readLine();
            String []i = r.split(", ");
            boolean done = false;
            for (int idx = 0; idx < i.length && !done; idx++) {
                if (i[idx].equals(t)) {
                    System.out.println("We found it!");
                    done = true;
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