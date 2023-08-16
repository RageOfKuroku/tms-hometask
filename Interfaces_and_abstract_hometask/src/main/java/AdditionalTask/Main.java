package AdditionalTask;

import AdditionalTask.Docs.*;
import AdditionalTask.Service.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Document doc1 = new EmployeeContract(new Date(), 3246, new Date(), "Герасимов");
        Document doc2 = new FinancialInvoice(new Date(), 124, 12, 65893);
        Document doc3 = new SupplyContract(new Date(), 123, typeOfGood.Toys, 60);

        Register register = new Register();

        register.safeDocument(doc1);
        register.safeDocument(doc2);
        register.safeDocument(doc3);

        register.aboutDocs();
    }
}
