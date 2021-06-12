package bo.student.impl;

import bo.student.StudentBO;
import dao.DAOFactory;
import dao.QueryDAO;
import dao.student.StudentDAO;
import dto.CourseDTO;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;

public class StudentBoImpl implements StudentBO {
    private StudentDAO dao= DAOFactory.getInstance()
            .getDao(DAOFactory.DAOType.STUDENT);
   /* private QueryDAO qDao= DAOFactory.getInstance()
            .getDao(DAOFactory.DAOType.QUERY);*/

    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
        return dao.save(new Student(dto.getId(), dto.getName(), dto.getAddress(), dto.getContact(),dto.getDate(),dto.getGender()));
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
        return dao.update(new Student(dto.getId(), dto.getName(), dto.getAddress(), dto.getContact(),dto.getDate(),dto.getGender()));
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public StudentDTO getStudent(String id) throws Exception {
        Student student = dao.get(id);
        return new StudentDTO(student.getId(), student.getName(), student.getAddress(), student.getContact(),student.getDob(),student.getGender());
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
        return null;
    }

    @Override
    public String getId() throws Exception {
        return null;
    }
}
