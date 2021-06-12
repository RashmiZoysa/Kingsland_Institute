package dao.student;

import dao.CrudDAO;
import entity.Course;
import entity.Student;

import java.util.List;

public interface CourseDAO extends CrudDAO<Course,String> {

    public boolean updateCourse(Student student) throws Exception;

    public boolean deleteCourse(String id) throws Exception;

    public Course getCourse(String id) throws Exception;

    public List<Course> getAllcourse() throws Exception;

    public boolean saveCourse(Course course) throws Exception;
}
