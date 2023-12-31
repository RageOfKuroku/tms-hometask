package AdditionalTask.Docs;

import AdditionalTask.Service.Document;

import java.util.Date;

public class EmployeeContract extends Document {
    public EmployeeContract(Date dateOfDocument, int numberOfDocument, Date dateOfExpire, String nameOfEmployee) {
        super(dateOfDocument, numberOfDocument);
        this.dateOfExpire = dateOfExpire;
        this.nameOfEmployee = nameOfEmployee;
    }

    public EmployeeContract(Date dateOfDocument, int numberOfDocument) {
        super(dateOfDocument, numberOfDocument);
    }

    private Date dateOfExpire;
    private String nameOfEmployee;
    @Override
    public void infoAboutDoc(){
        System.out.println("Документ №" + numberOfDocument + "\n" + "Сотрудник: " + nameOfEmployee + "\n" + "Окончание контракта: " + dateOfExpire + "\n" + "Дата: " + dateOfDocument);
    }
}
