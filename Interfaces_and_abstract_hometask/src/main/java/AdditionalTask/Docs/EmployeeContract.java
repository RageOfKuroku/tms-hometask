package AdditionalTask.Docs;

import AdditionalTask.Service.Document;

import java.util.Date;

public class EmployeeContract extends Document {
    public EmployeeContract(Date dateOfDocument, int numberOfDocument, Date dateOfExpire, String nameOfEmployee) {
        super(dateOfDocument, numberOfDocument);
        this.dateOfExpire = dateOfExpire;
        this.nameOfEmployee = nameOfEmployee;
    }
    private Date dateOfExpire;
    private String nameOfEmployee;

    public void infoAboutDoc(){
        System.out.println("Документ №" + numberOfDocument + "\n" + "Сотрудник: " + nameOfEmployee + "\n" + "Окончание контракта: " + dateOfExpire + "\n" + "Дата: " + dateOfDocument);
    }
}
