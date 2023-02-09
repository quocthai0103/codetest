package long002;

import java.util.Scanner;

/**
 *
 * @author CE160598 Tran Quoc Thai
 */
public class CheckInput {

    /**
     * get user valid integer input
     *
     * @param scanner Scanner
     * @param message instruction message for user input
     * @return the valid Integer
     */
    public static int getInputInteger(Scanner scanner, String message) {
        Integer input = null;
        //loop until the input is valid integer
        while (input == null) {
            try { //try to convert string to number
                input = Integer.parseInt(getInputString(scanner, message));
            } catch (NumberFormatException e) {
                System.out.println("Your input must be an integer");
            }
        }
        return input;
    }

    /**
     * Function to get integer input from a specific range
     *
     * @param scanner Scanner
     * @param message instruction message for user input
     * @param min minimum value of the input
     * @param max maximum value of the input
     * @return the correct integer value
     */
    public static int getInputInteger(Scanner scanner, String message, int min, int max) {
        Integer input = null;
        //loop until the input is valid integer
        while (input == null) {
            input = getInputInteger(scanner, message);
            if (input < min || input > max) {
                if (min != max) {
                    System.out.println("Your input must be from " + min + " to " + max);
                } else {
                    System.out.println("Your input must be " + min);
                }
                input = null;
            }
        }
        return input;
    }

    /**
     * get user valid string input (not empty)
     *
     * @param scanner Scanner
     * @param message instruction message for user input
     * @return the valid String
     */
    public static String getInputString(Scanner scanner, String message) {
        String input = "";
        //loop until the input is not empty
        while (input.equals("")) {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (input.equals("")) {
                System.out.println("Your input can not be empty.");
            }
        }
        return input;
    }

    /**
     * get and check id from user
     *
     * @param scanner Scanner
     * @param message instruction message for user input
     * @return input id
     */
    public static String getStudentId(Scanner scanner, String message) {
        String input = null;
        //loop until the input is valid integer
        while (input == null) {
            input = getInputString(scanner, message);
            //if input dont matches
            if (!input.matches("^[A-Za-z0-9]+$")) {
                System.out.println("Student id must not contain special character or spaces.");
                input = null;
            }
        }
        return input;
    }
    
    

    /**
     * get and check name of student
     *
     * @param scanner Scanner
     * @param message instruction message for user input
     * @return student of name
     */
    public static String getStudentName(Scanner scanner, String message) {
        String input = null;
        //loop until the input is valid integer
        while (input == null) {
            input = getInputString(scanner, message);
            //if input dont matches
            if (!input.matches("^[A-Za-z][A-Za-z0-9_ ]{0,}$")) {
                System.out.println("Student name must start with a letter and not contain special character.");
                input = null;
            }
        }
        return input;
    }
    
    /**
     * get and check name of student
     *
     * @param scanner Scanner
     * @param message instruction message for user input
     * @return student of name
     */
    public static String getStudentSemester(Scanner scanner, String message) {
        String input = null;
        //loop until the input is valid integer
        while (input == null) {
            input = getInputString(scanner, message);
            //if input dont matches
            if (!input.matches("^[A-Za-z][A-Za-z0-9_ ]{0,}$")) {
                System.out.println("Student Semester must start with a letter and not contain special character.");
                input = null;
            }
        }
        return input;
    }

    /**
     * get and check course name
     *
     * @param scanner Scanner
     * @param message instruction message for user input
     * @return course name
     */
    public static String getCourseName(Scanner scanner, String message) {
        String input = null;
        //loop until the input is valid integer
        while (input == null) {
            input = getInputString(scanner, message);
            //if input do not equals
            if (!input.equals("Java") && !input.equals(".Net")
                    && !input.equals("C/C++")) {
                System.out.println("There are only three courses: Java, .Net, C/C++");
                input = null;
            }
        }
        return input;
    }

    /**
     * Function for getting Yes/No input from user
     *
     * @param scanner _ Scanner
     * @param message _ instruction message for user input
     * @return true if the input is Y, false otherwise
     */
    public static boolean getInputYN(Scanner scanner, String message) {
        String input = null;
        //loop until the input is not empty
        while (input == null) {
            input = getInputString(scanner, message);
            if (input.equalsIgnoreCase("y")) {
                return true; //return true
            }
            if (input.equalsIgnoreCase("N")) {
                return false; //return false
            }
            System.out.println("Your input must be Y/y or N/n");
            input = null;
        }
        return false;
    }

    /**
     * Function for getting Update/Delete input from user
     *
     * @param scanner
     * @param message
     * @return true if the input is U, false otherwise
     */
    public static String getInputUD(Scanner scanner, String message) {
        String input = null;
        //loop until the input is not empty
        while (input == null) {
            input = getInputString(scanner, message);
            if (input.equalsIgnoreCase("U")) {
                return "U";
            }
            if (input.equalsIgnoreCase("D")) {
                return "D";
            }
            System.out.println("Your input must be U/u or D/d.");
            input = null;
        }
        return input;
    }
}
