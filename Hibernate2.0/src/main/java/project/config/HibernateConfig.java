package project.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import project.entity.TaskEntity;
import project.entity.UserEntity;

public class HibernateConfig {
    private static SessionFactory sessionFactory;

    public HibernateConfig() {
    }

    public static Session create() {
        return sessionFactory.openSession();
    }
    static {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hib_db");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "postgres");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        configuration.addAnnotatedClass(UserEntity.class);
        configuration.addAnnotatedClass(TaskEntity.class);
        sessionFactory = configuration.buildSessionFactory();
    }


}
