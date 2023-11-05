package project.service.implementations;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.config.HibernateConfig;
import project.entity.TaskEntity;
import project.entity.UserEntity;
import project.service.additions.Status;
import project.service.interfaces.DAO;

import javax.persistence.Query;
import java.util.UUID;

public class TaskImpl implements DAO<TaskEntity> {

    public TaskEntity create(String name, String description, Status status, UserEntity user) {
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();
        TaskEntity task = TaskEntity.builder()
                .taskName(name)
                .description(description)
                .status(status)
                .user(user)
                .build();
        session.save(task);
        transaction.commit();
        session.close();
        return task;
    }

    public void update(TaskEntity task, Status newStatus) {
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update TaskEntity as te set te.status =: statusUpdated where te.task_id =: task_uuid");
        query.setParameter("statusUpdated", newStatus);
        query.setParameter("task_uuid", task.getTask_id());
        query.executeUpdate();
        task.setStatus(newStatus);
        transaction.commit();
        session.close();
    }
    @Override
    public TaskEntity getById(String id) {
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();
        TaskEntity taskEntity = session.find(TaskEntity.class, UUID.fromString(id));
        System.out.println(taskEntity);
        transaction.commit();
        session.close();
        return taskEntity;
    }
    @Override
    public void delete(TaskEntity task){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();
        session.delete(task);
        transaction.commit();
        session.close();
    }



}

