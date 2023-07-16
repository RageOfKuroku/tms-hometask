package AdditionalTask.Service;

public class Register {
    Document[] docs = new Document[10];
    int index = 0;

    public void safeDocument(Document newDoc) {
        docs[index++] = newDoc;
    }

    public void aboutDocs() {
        for (int i = 0; i < index; i++) {
            docs[i].infoAboutDoc();
        }
    }
}
