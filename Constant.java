import java.util.Random;

public final class Constant {
    public static char QUERY_ALL = 'a';
    public static char QUERY_COUNT = 'c';
    public static char QUERY_HELP = 'h';
    public static char QUERY_RANDOM = 'r';
    public static char QUERY_INSERT = '+';
    public static char QUERY_SEARCH = '?';

    public static String FILE_STUDENTS = "students.txt";
    public static String STUDENT_DATA_DELIMITER = ", ";

    public static String SIMPLE_DATE_FORMAT = "dd/mm/yyyy-hh:mm:ss a";

    public static String MSG_EMPTY_ARGUMENT = "Argument must not be empty";
    public static String MSG_INVALID_ARGUMENT = "Invalid argument";
    public static String MSG_SUGGEST_FOR_HELP = "Use 'h' flag for help";
    public static String MSG_DATA_LOADING = "Loading data ...";
    public static String MSG_DATA_LOADED = "Data Loaded.";
    public static String MSG_STUDENT_FOUND = "We found it!";
    public static String MSG_FOUND_COUNT = "%d word(s) found.\n";
    public static String MSG_LIST_UPDATED = "List last updated on %s\n";

    public static String HELP_QUERY_ALL = "Use: " + QUERY_ALL + " - for all students.";
    public static String HELP_QUERY_COUNT = "Use: " + QUERY_COUNT + " - for number of words.";
    public static String HELP_QUERY_HELP = "Use: " + QUERY_HELP + " - for getting help.";
    public static String HELP_QUERY_RANDOM = "Use: " + QUERY_RANDOM + " - for random student.";
    public static String HELP_QUERY_INSERT = "Use: " + QUERY_INSERT + "StudentName - for adding a new student.";
    public static String HELP_QUERY_SEARCH = "Use: " + QUERY_SEARCH + "StudentName - for searching a student.";
}
