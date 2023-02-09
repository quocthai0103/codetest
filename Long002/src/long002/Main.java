package long002;

import java.util.Scanner;
import static long002.CheckInput.getInputInteger;

/**
 *
 * @author CE160598 Tran Quoc Thai
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //calling class StudentManagement
            StudentManagement sm = new StudentManagement();
            Scanner sc = new Scanner(System.in);
            int userChoice = -1;

            //add student
            sm.initialize();

            do {
                // menu of program
                System.out.println(" WELCOME TO STUDENT MANAGEMENT\n"
                        + "1. Create\n"
                        + "2. Find and Sort\n"
                        + "3. Update/Delete\n"
                        + "4. Report\n"
                        + "5. Exit");
                //only acctept from 1 to 5
                userChoice = getInputInteger(sc, "Please enter: ", 1, 5);
                switch (userChoice) {
                    //Creating student
                    case 1:
                        sm.create();
                        sc.nextLine();
                        break;
                    //finding and sorting student
                    case 2:
                        sm.findAndSort();
                        sc.nextLine();
                        break;
                    //updating and deleting student
                    case 3:
                        sm.updateAndDelete();
                        sc.nextLine();
                        break;
                    //report of student
                    case 4:
                        sm.report();
                        sc.nextLine();
                        break;
                    //Quit program
                    case 5:
                        System.out.println("Thank you for using our program.");
                        break;
                    default:
                        break;
                }
            } while (userChoice != 5);
        } catch (Exception e) {

        }
    }

}
