package long002;

/**
 *
 * @author CE160598 Tran Quoc Thai
 */
public class Row implements Comparable<Row> {

    private String id; //id of student
    private String name;//name of student
    private String semester;//semester of student
    private String courseName;//course of student

    //constructor
    public Row(String id, String name, String semester, String courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    //method getter, setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public int compareTo(Row o) {
        return this.name.compareTo(o.name);
    }
}
