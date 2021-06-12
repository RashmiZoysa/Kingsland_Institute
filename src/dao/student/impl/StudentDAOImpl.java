package dao.student.impl;

import com.sun.xml.internal.bind.v2.model.core.ID;
import dao.CrudUtill;
import dao.student.StudentDAO;
import entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean saveStudent(Student student) throws Exception {
        return CrudUtill.execute("INSERT INTO STUDENT VALUES(?,?,?,?,?,?)",student.getId(),student.getName(), student.getAddress(),student.getContact(),student.getDob());
    };


    @Override
    public boolean updateStudent(Student student) throws Exception {
        return false;
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return CrudUtill.execute("DELETE FROM Student WHERE id=?",id);
    }

    @Override
    public Student getStudent(String id) throws Exception {
        return null;
    }

    @Override
    public boolean save(Student student) throws Exception {
        return false;
    }

    @Override
    public boolean update(Student student) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Student get(String s) throws Exception {
        ResultSet resultSet = CrudUtill.execute("SELECT * FROM Student WHERE id=?", s);
        if (resultSet.next()) {
            return new Student(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6));
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getAll() throws Exception {
        ResultSet resultSet = CrudUtill.execute("SELECT * FROM Student");
        ArrayList<Student> customerList = new ArrayList<>();
        while (resultSet.next()) {
            customerList.add(
                    new Student(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
        return customerList;
    }
}

