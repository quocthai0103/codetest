package long002;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import static long002.CheckInput.getCourseName;
import static long002.CheckInput.getInputString;
import static long002.CheckInput.getInputUD;
import static long002.CheckInput.getInputYN;
import static long002.CheckInput.getStudentId;
import static long002.CheckInput.getStudentName;
import static long002.CheckInput.getStudentSemester;

/**
 *
 * @author CE160598 Tran Quoc Thai
 */
public class StudentManagement {

    //Initialize array list
    ArrayList<Row> table = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    //add students to array list
    public void initialize() {
        table.add(new Row("1", "thai", "SU22", ".Net"));
        table.add(new Row("2", "khanh", "SP22", "C/C++"));
        table.add(new Row("3", "Phuc", "SU21", "Java"));

    }

    /**
     * crating student and adding to array list
     */
    public void createEach() {
        String id = getStudentId(sc, "ID: ");

        //find all data with this ID
        ArrayList<Row> result = findRowByID(id);
        // if result has size > 0
        if (result.size() > 0) {
            String rightName = result.get(0).getName();
            // get name
            String name = getStudentName(sc, "Name: ");
            //if name do not equals right name
            if (!name.equals(rightName)) {
                System.out.println("This ID already has a student.");
                return;
            } else {
                //get semester
                String semester = getStudentSemester(sc, "Semester: ");
                //get course name
                String courseName = getCourseName(sc, "Course name: ");
                for (Row row : result) {
                    //comparing course name and result
                    if (row.getSemester().equals(semester) && row.getCourseName().equals(courseName)) {
                        System.out.println("This course is already exist in this semester.");
                        return;
                    }
                }
                //adding student to array list
                this.table.add(new Row(id, name, semester, courseName));
                System.out.println("Add successfully.");
            }
            //if not already id to array list
        } else {
            String name = getStudentName(sc, "Name: ");
            String semester = getStudentSemester(sc, "Semester: ");
            String courseName = getCourseName(sc, "Course name: ");
            this.table.add(new Row(id, name, semester, courseName));
            System.out.println("Add successfully.");
        }
    }

    /**
     * Function creating student and asking the user if they want to continue
     */
    public void create() {
        do {
            createEach();
        } while (getInputYN(sc, "Do you want to continue?(Y/N) "));
    }

    /**
     * Function finding by id
     *
     * @param id get id from user
     * @return result
     */
    public ArrayList<Row> findRowByID(String id) {
        //Initialize array list
        ArrayList<Row> result = new ArrayList<>();
        for (Row row : this.table) {
            //comparing id and result
            if (row.getId().equals(id)) {
                result.add(row);
            }
        }
        return result;
    }

    /**
     * Function finding row index by id
     *
     * @param id get id from user
     * @return result
     */
    public ArrayList<Integer> findRowIndexByID(String id) {
        //Initialize array list
        ArrayList<Integer> result = new ArrayList<>();
        //loop till the end table size
        for (int i = 0; i < this.table.size(); i++) {
            //comparing
            if (this.table.get(i).getId().equals(id)) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * checking id is exist
     *
     * @param id get id from user
     * @return
     */
    public boolean isExist(String id) {
        for (Row row : this.table) {
            //comparing
            if (row.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Function find and sort
     */
    public void findAndSort() {
        //if table size == 0
        if (this.table.size() == 0) {
            System.out.println("There are no data to display.");
            return;
        }
        String keyword = getInputString(sc, "Key word: ");
        //Initialize array list
        ArrayList<Row> result = new ArrayList<Row>();
        //loop still the end
        for (Row row : this.table) {
            //if stdent name contains keyword
            if (row.getName().contains(keyword)) {
                result.add(row);
            }
        }

        if (result.size() == 0) {
            System.out.println("Not found");
            return;
        }
        //sort them in alphabetical increments
        Collections.sort(result);
        //display them inscreen
        displayTable(result);
    }

    /**
     * display data in screen
     *
     * @param result
     */
    public void displayTable(ArrayList<Row> result) {
        int widthID = 2; //id of width
        int widthStudentName = 12;//name of width
        int widthSemester = 8;//semester of width
        int widthCourseName = 11;//course name width

        //length update id, student's name, semester and course name
        for (Row row : result) {
            widthID = Math.max(widthID, row.getId().length());
            widthStudentName = Math.max(widthStudentName, row.getName().length());
            widthSemester = Math.max(widthSemester, row.getSemester().length());
            widthCourseName = Math.max(widthCourseName, row.getCourseName().length());
        }
        //creating border and table of student
        String bar = "+";
        for (int i = 0; i < widthID + 2; i++) {
            bar += "-";
        }
        bar += "+";

        for (int i = 0; i < widthStudentName + 2; i++) {
            bar += "-";
        }
        bar += "+";

        for (int i = 0; i < widthSemester + 2; i++) {
            bar += "-";
        }
        bar += "+";

        for (int i = 0; i < widthCourseName + 2; i++) {
            bar += "-";
        }
        bar += "+";

        String template = "| %" + widthID + "s | %-" + widthStudentName + "s | %-" + widthSemester + "s | %-" + widthCourseName + "s |\n";
        //printing out to dislpay
        System.out.println(bar);
        System.out.printf(template, "ID", "Student Name", "Semester", "Course Name");
        System.out.println(bar);

        for (Row row : result) {
            System.out.printf(template, row.getId(), row.getName(), row.getSemester(), row.getCourseName());
        }
        System.out.println(bar);

    }

    /**
     * Function deleting by id
     *
     * @param id get id from user
     */
    public void deleteById(String id) {
        Iterator<Row> i = this.table.iterator();
        while (i.hasNext()) {
            Row row = i.next();
            //if row id equals get id
            if (row.getId().equals(id)) {
                i.remove();
            }
        }
    }

    /**
     * Function updating and deleting
     */
    public void updateAndDelete() {
        //if table size == 0
        if (this.table.size() == 0) {
            System.out.println("There are no data to display.");
            return;
        }
        String id = getStudentId(sc, "ID: ");

        ArrayList<Integer> result = findRowIndexByID(id);
        //if rasult size > 0
        if (result.size() > 0) {
            //asking user want to update or delete
            if (getInputUD(sc, "Do you want to update (U) or delete (D) student? ").equals("U")) {
                //delete student with given id for updating
                deleteById(id);
                String newName = getStudentName(sc, "New name: ");

                do {
                    String newSemester = getStudentSemester(sc, "Semester: ");
                    String newCourseName = getCourseName(sc, "Course name: ");

                    boolean isExist = false;
                    for (Row row : this.table) {
                        //if old id equals new id, old semester equals new equals, old course name equals new course name 
                        if (row.getId().equals(id) && row.getSemester().equals(newSemester) && row.getCourseName().equals(newCourseName)) {
                            System.out.println("This course is already exist in this semester.");
                            isExist = true;
                        }
                    }
                    // if is not exist
                    if (!isExist) {
                        //adding them to array list
                        this.table.add(new Row(id, newName, newSemester, newCourseName));
                        System.out.println("Add successfully.");
                    }
                } while (getInputYN(sc, "Do you want to continue add new course for this student?(Y/N) "));
            } else {
                //delete student with given id for updating
                deleteById(id);
                System.out.println("Delete successfully.");
            }

        } else {
            System.out.println("There are no student with ID " + id);
        }

    }

    /**
     * Function printing report out display
     */
    public void report() {
        //Initialize array list
        ArrayList<ReportRow> reportList = new ArrayList<ReportRow>();
        //if table size == 0
        if (this.table.size() == 0) {
            System.out.println("There are no data to display.");
            return;
        }
        for (Row row : this.table) {
            int total = 0;
            String id = row.getId();
            String name = row.getName();
            String courseName = row.getCourseName();
            for (Row lRow : this.table) {
                if (lRow.getName().equals(name) && lRow.getCourseName().equals(courseName)) {
                    total++;
                }
            }
            //adding them to arraylist
            ReportRow newReport = new ReportRow(name, courseName, total);
            if (!checkReportExist(newReport, reportList)) {
                reportList.add(newReport);
            }
        }
        //creating table and show to screen
        displayReportTable(reportList);

    }

    /**
     * display report equals table
     *
     * @param reportList
     */
    public void displayReportTable(ArrayList<ReportRow> reportList) {
        //Initialize width of variables 
        int widthNo = Math.max(2, reportList.size() + 1);
        int widthStudentName = 12;
        int widthCourse = 6;
        int widthTotalOfCourse = 16;
        //updata width
        for (ReportRow row : reportList) {
            widthStudentName = Math.max(widthStudentName, row.getName().length());
            widthCourse = Math.max(widthCourse, row.getCourse().length());
        }
        //creating table
        String bar = "+";
        for (int i = 0; i < widthNo + 2; i++) {
            bar += "-";
        }
        bar += "+";

        for (int i = 0; i < widthStudentName + 2; i++) {
            bar += "-";
        }
        bar += "+";

        for (int i = 0; i < widthCourse + 2; i++) {
            bar += "-";
        }
        bar += "+";

        for (int i = 0; i < widthTotalOfCourse + 2; i++) {
            bar += "-";
        }
        bar += "+";

        String template = "| %" + widthNo + "s | %-" + widthStudentName + "s | %-" + widthCourse + "s | %" + widthTotalOfCourse + "s |\n";
        System.out.println(bar);
        System.out.printf(template, "No", "Student Name", "Course", "Total of Course");
        System.out.println(bar);

        int index = 1;
        for (ReportRow row : reportList) {
            System.out.printf(template, index++ + "", row.getName(), row.getCourse(), row.getTotalOfCourse());
        }
        System.out.println(bar);
    }

    /**
     * checking report is exist
     *
     * @param newReport get new report
     * @param reportList get report row
     * @return true if it is exist, false otherwise
     *
     */
    public boolean checkReportExist(ReportRow newReport, ArrayList<ReportRow> reportList) {
        for (ReportRow rRow : reportList) {
            if (rRow.getName().equals(newReport.getName())
                    && rRow.getCourse().equals(newReport.getCourse())
                    && rRow.getTotalOfCourse() == newReport.getTotalOfCourse()) {
                return true;
            }
        }
        return false;
    }
}
