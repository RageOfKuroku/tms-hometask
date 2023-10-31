package project.service.interfaces;

import org.hibernate.Session;
import project.config.HibernateConfig;

public interface DAO<T> {

    T getById(String id);

    void delete(T obj);

    static Session openSessionAndTransaction(){
        Session session = HibernateConfig.create();
        session.getTransaction().begin();
        return session;
    }
    static void closeSessionAndTransaction(Session session){
        session.getTransaction().commit();
        session.close();
    }
}
