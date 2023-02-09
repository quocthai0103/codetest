package long002;

/**
 *
 * @author CE160598 Tran Quoc Thai
 */
public class ReportRow {

    private String name; //name of student
    private String course; //course of student
    private int totalOfCourse;//total course of student

    //constructor
    public ReportRow(String name, String course, int totalOfCourse) {
        this.name = name;
        this.course = course;
        this.totalOfCourse = totalOfCourse;
    }

    //method getter, setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getTotalOfCourse() {
        return totalOfCourse;
    }

    public void setTotalOfCourse(int totalOfCourse) {
        this.totalOfCourse = totalOfCourse;
    }
}
