package AdditionalTask.Docs;

import AdditionalTask.Service.Document;
import AdditionalTask.Service.typeOfGood;

import java.util.Date;

public class SupplyContract extends Document {
    typeOfGood typeOfGoods;
    int amountOfGoods;

    public SupplyContract(Date dateOfDocument, int numberOfDocument, typeOfGood typeOfGoods, int amountOfGoods) {
        super(dateOfDocument, numberOfDocument);
        this.typeOfGoods = typeOfGoods;
        this.amountOfGoods = amountOfGoods;
    }
    @Override
    public void infoAboutDoc() {
        System.out.println("Документ №" + numberOfDocument + "\n" + "Тип товара: " + typeOfGoods + "\n" + "Количество товара: " + amountOfGoods + "\n" + "Дата: " + dateOfDocument);
    }
}
