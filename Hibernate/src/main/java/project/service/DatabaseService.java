package project.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.config.HibernateConfig;
import project.entity.PersonEntity;

import java.util.UUID;

public class DatabaseService {


    public PersonEntity getPerson(String id) {
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();


        PersonEntity personEntity = session.find(PersonEntity.class, UUID.fromString(id));


        System.out.println(personEntity);
        transaction.commit();
        session.close();
        return personEntity;

    }
}
