package project.service.implementations;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import project.config.HibernateConfig;
import project.entity.UserEntity;
import project.service.additions.Sex;
import project.service.additions.Status;
import project.service.additions.Type;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserImpl {

    public UserEntity createUser(String name, Date dateOfBirth, Sex sex, Type type) {
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();
        UserEntity user = UserEntity.builder()
                .name(name)
                .dateOfBirth(dateOfBirth)
                .sex(sex)
                .type(type)
                .build();
        session.save(user);
        transaction.commit();
        session.close();
        return user;
    }


    public void delete(UserEntity userEntity) {
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();
        session.delete(userEntity);
        transaction.commit();
        session.close();

    }

    public void delete(String uuid) {
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from UserEntity as ue where ue.user_id =: user_uuid");
        query.setParameter("user_uuid", UUID.fromString(uuid));
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public static void getUserById(String id) {
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();
        UserEntity userEntity = session.find(UserEntity.class, UUID.fromString(id));
        System.out.println(userEntity);
        transaction.commit();
        session.close();
    }

    public List<UserEntity> returnByStatus(Status status){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select ue from UserEntity as ue join ue.tasks as ts where ts.status =: statusActive");
        query.setParameter("statusActive", status);
        List list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

}
