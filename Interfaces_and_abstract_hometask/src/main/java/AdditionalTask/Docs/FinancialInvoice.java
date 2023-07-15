package AdditionalTask.Docs;

import AdditionalTask.Service.Document;

import java.util.Date;

public class FinancialInvoice extends Document {
    private int codeOfDepartment;
    private int finalMonthSum;

    public FinancialInvoice(Date dateOfDocument, int numberOfDocument, int codeOfDepartment, int finalMonthSum) {
        super(dateOfDocument, numberOfDocument);
        this.codeOfDepartment = codeOfDepartment;
        this.finalMonthSum = finalMonthSum;
    }

    public void infoAboutDoc() {
        System.out.println("Документ №" + numberOfDocument + "\n" + "Сумма за месяц: " + finalMonthSum + "\n" + "Код департамента: " + codeOfDepartment + "\n" + "Дата: " + dateOfDocument);
    }
}
