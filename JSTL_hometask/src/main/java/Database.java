import domain.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Database {
    private static List<Book> books = new ArrayList();

    public Database() {
    }

    public void add(Book book) {
        book.setId(UUID.randomUUID());
        books.add(book);
    }

    public List<Book> getByAuthor(String author) {
        return author != null && !author.isBlank() ? books.stream().filter((book) -> {
            return author.equals(book.getAuthor());
        }).toList() : books;
    }
}