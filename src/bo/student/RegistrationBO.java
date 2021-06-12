package bo.student;

import dto.CourseDTO;
import dto.RegistrationDTO;

import java.util.ArrayList;

public interface RegistrationBO {
    public boolean saveCourse(RegistrationDTO dto) throws Exception;

    public boolean updateCourse(RegistrationDTO dto) throws Exception;

    public boolean deleteCourse(String id) throws Exception;

    public RegistrationDTO getCourse(String id) throws Exception;

    public ArrayList<RegistrationDTO> getAllCourse() throws Exception;

}
