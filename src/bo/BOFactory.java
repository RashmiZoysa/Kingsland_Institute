package bo;

import bo.student.impl.CourseBoImpl;
import bo.student.impl.RegistrationBoImpl;
import bo.student.impl.StudentBoImpl;

import java.security.PublicKey;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }
    public enum BoType{
        STUDENT, COURSE, REGISTRATION
    }

    public <T>T getBo(BoType type){
        switch (type){
            case STUDENT:
                return(T) new StudentBoImpl();
            case COURSE:
                return (T) new CourseBoImpl();
            case REGISTRATION:
                return (T)new RegistrationBoImpl();
            default:
                return null;
        }

    }
}

