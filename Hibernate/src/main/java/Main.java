import project.entity.PersonEntity;
import project.service.DatabaseService;

public class Main {
    public static void main(String[] args) {
//        Session session = HibernateConfig.create();
//        Transaction transaction = session.beginTransaction();
//        PersonEntity person = PersonEntity.builder()
//                .name("Jorik")
//                .birthDate(new Date())
//                .job(Job.WORKER)
//                .isMarried(true)
//                .build();
//
//
//        PhoneEntity phone = PhoneEntity.builder()
//                .number("124125125")
//                .person(person)
//                .build();
//
//        PhoneEntity phone1 = PhoneEntity.builder()
//                .number("1346256434")
//                .person(person)
//                .build();
//
//        session.save(person);
//        session.save(phone);
//        session.save(phone1);
//        transaction.commit();
//        session.close();

        DatabaseService dbs = new DatabaseService();
        PersonEntity person = dbs.getPerson("8e30480a-fd5a-49b7-8194-e98d81b620f8");

    }

}
