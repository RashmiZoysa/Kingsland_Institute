package bo.student.impl;


import bo.student.CourseBO;
import dao.DAOFactory;
import dao.QueryDAO;
import dao.student.CourseDAO;
import dto.CourseDTO;
import entity.Course;
import entity.Student;


import java.util.ArrayList;
import java.util.List;

public class CourseBoImpl implements CourseBO {
    private CourseDAO dao = DAOFactory.getInstance().getDao(DAOFactory.DAOType.STUDENT);
    private QueryDAO qDao = DAOFactory.getInstance().getDao(DAOFactory.DAOType.QUERY);


    @Override
    public boolean saveCourse(CourseDTO dto) throws Exception {
        return dao.save(new Course(dto.getCode(), dto.getCourseName(), dto.getDuration(), dto.getCourseType()));
    }

    @Override
    public boolean updateCourse(CourseDTO dto) throws Exception {
        //return dao.update(new Student(dto.getCode(), dto.getCourseName(), dto.getDuration(), dto.getCourseType()));
        return false;
    }

    @Override
    public boolean deleteCourse(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public CourseDTO getCourse(String id) throws Exception {
        Course course = dao.get(id);
        return new CourseDTO(course.getCode(), course.getCourseName(), course.getDuration(), course.getCourseType());
    }

    @Override
    public ArrayList<CourseDTO> getAllCourse() throws Exception{
        List<Course> cList=dao.getAll();
        ArrayList<CourseDTO> dtoList=new ArrayList();
        for (Course c:cList) {
            dtoList.add(new CourseDTO(c.getCode(), c.getCourseName(), c.getDuration(), c.getCourseType()));
        }
            return dtoList;
        }

    public String getID() throws Exception{
        return null;

        }


}

