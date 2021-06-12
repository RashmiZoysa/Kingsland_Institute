package dao.student;

import dao.CrudDAO;
import entity.Student;

public interface StudentDAO extends CrudDAO<Student,String> {
   public boolean saveStudent(Student student) throws Exception;

   public boolean updateStudent(Student student) throws Exception;

   public boolean deleteStudent(String id) throws Exception;

   public Student getStudent(String id) throws Exception;
}
