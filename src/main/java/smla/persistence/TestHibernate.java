package smla.persistence;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import smla.objects.Stock;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by bobyk on 25/04/16.
 */
public class TestHibernate {

   /* public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Add new Employee object
        Stock usr = new Stock();

        usr.setName("Misha");
        usr.setNickname("Misha228");
        usr.setPassword("Mishutalavkitose");
        session.save(usr);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }*/

    public void addUser(Stock usr){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(usr);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }

    public Collection getAllUsers() throws SQLException{
        Session session = null;
        List users = new ArrayList<Stock>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            users = session.createCriteria(Stock.class).list();
        }catch (Exception e){
            System.out.println("Error getAllUsers() " + e);
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }
}
