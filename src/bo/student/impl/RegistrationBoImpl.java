package bo.student.impl;

import bo.student.RegistrationBO;
import dto.RegistrationDTO;

import java.util.ArrayList;

public class RegistrationBoImpl implements RegistrationBO {
    @Override
    public boolean saveCourse(RegistrationDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateCourse(RegistrationDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteCourse(String id) throws Exception {
        return false;
    }

    @Override
    public RegistrationDTO getCourse(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<RegistrationDTO> getAllCourse() throws Exception {
        return null;
    }
}
