package dao;

import bo.BOFactory;
import bo.student.impl.StudentBoImpl;
import dao.student.impl.CourseDAOImpl;
import dao.student.impl.QueryDAOImpl;
import dao.student.impl.StudentDAOImpl;

public class DAOFactory {
    //1st Step
    private static DAOFactory daoFactory;

    //2nd Step
    private DAOFactory() {
    }

    //3rd Step
    public static DAOFactory getInstance() {
        return (daoFactory == null) ?
                (daoFactory = new DAOFactory()) : (daoFactory);
    }

    //4th Step
    public enum DAOType {
        STUDENT,COURSE,REGISTRATION,QUERY
    }

    //5th Step
  /*  public SuperDAO getDao(DAOType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return null;
            case ORDER_DETAIL:
                return null;
            default:
                return null;
        }
    }*/

    public <T> T getDao(DAOType type) {
        switch (type) {
            case STUDENT:
                return (T) new StudentDAOImpl();
            case COURSE:
                return (T) new CourseDAOImpl();
            case REGISTRATION:
                return null;
            case QUERY:
                return (T) new QueryDAOImpl();
            default:
                return null;
        }
    }

}
