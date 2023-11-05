import project.entity.TaskEntity;
import project.entity.UserEntity;
import project.service.additions.Sex;
import project.service.additions.Status;
import project.service.additions.Type;
import project.service.implementations.TaskImpl;
import project.service.implementations.UserImpl;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        UserEntity ue = new UserEntity();
        TaskEntity te = new TaskEntity();
        TaskImpl ti = new TaskImpl();
        UserImpl ui = new UserImpl();

        UserEntity egor = ui.create("Egor", new Date(), Sex.MALE, Type.ADMIN);
        UserEntity vladimeow = ui.create("Vladimeow", new Date(), Sex.WALMART_BAG, Type.SUPPORT);

        TaskEntity taskEntity = ti.create("Pomitsya", "Pomoysya", Status.IN_PROGRESS, egor);
        TaskEntity taskEntity1 = ti.create("Popit", "drink water", Status.NEW, vladimeow);
        TaskEntity taskEntity2 = ti.create("Poest", "eat food", Status.IN_PROGRESS, vladimeow);

        egor.addTask(taskEntity);
        vladimeow.addTask(taskEntity1);
        vladimeow.addTask(taskEntity2);

        ti.update(taskEntity1, Status.IN_PROGRESS);
        ti.update(taskEntity2, Status.DONE);

        System.out.println(ui.returnByStatus(Status.IN_PROGRESS));


        ui.delete(vladimeow);
        ui.delete(egor);




    }
}
