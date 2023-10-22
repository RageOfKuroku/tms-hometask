package project.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import project.entity.PersonEntity;
import project.entity.PhoneEntity;

public class HibernateConfig {
    private static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hibernate_database");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "postgres");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.show.sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");

        configuration.addAnnotatedClass(PersonEntity.class);
        configuration.addAnnotatedClass(PhoneEntity.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session create(){
        return sessionFactory.openSession();
    }
}
