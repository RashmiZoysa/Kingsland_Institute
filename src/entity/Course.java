package entity;

public class Course implements SuperEntity {
    private String Code;
    private String CourseName;
    private String Duration;
    private String CourseType;

    public Course() {
    }

    public Course(String code, String courseName, String duration, String courseType) {
        Code = code;
        CourseName = courseName;
        Duration = duration;
        CourseType = courseType;
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

    @Override
    public String toString() {
        return "Course{" +
                "Code='" + Code + '\'' +
                ", CourseName='" + CourseName + '\'' +
                ", Duration='" + Duration + '\'' +
                ", CourseType='" + CourseType + '\'' +
                '}';
    }
}


