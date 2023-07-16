package AdditionalTask.Service;

import java.util.Date;

public abstract class Document implements Doc {
    public Document(Date dateOfDocument, int numberOfDocument) {
        this.dateOfDocument = dateOfDocument;
        this.numberOfDocument = numberOfDocument;
    }

    protected Date dateOfDocument;
    protected int numberOfDocument;
}
