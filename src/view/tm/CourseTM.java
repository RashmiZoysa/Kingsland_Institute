package view.tm;

public class CourseTM {
    private String Code;
    private String CourseName;
    private String Duration;
    private String CourseType;

    public CourseTM() {

    }

    public CourseTM(String code, String courseName, String duration, String courseType) {
        setCode(code);
        setCourseName(courseName);
        setDuration(duration);
        setCourseType(courseType);
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getCourseType() {
        return CourseType;
    }

    public void setCourseType(String courseType) {
        CourseType = courseType;
    }
}
