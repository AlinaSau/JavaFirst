import java.util.ArrayList;

class Book {
    String name;
    String author;
    String genre;
    String shelf;

    public Book (String name, String author, String genre, String shelf) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.shelf = shelf;
    }
}

public class Library {
    public ArrayList<Book> Library = new ArrayList<>();

    public static void main(String[] args) {

    }
    //добавить новую книгу
    public void add(String name, String author, String genre, String shelf) {
        Book trial = new Book(name, author, genre, shelf);
        if (!Library.contains(trial))
            Library.add(trial);
    }
    //удалить книгу
    public void delete(String name, String author, String genre, String shelf) {
        Book trial = new Book(name, author, genre, shelf);
        for (int i = 0; i < Library.size(); i += 1)
            if ((trial.name.equals(Library.get(i).name)) && (trial.author.equals(Library.get(i).author)) &&
                    (trial.genre.equals(Library.get(i).genre)) && (trial.shelf.equals(Library.get(i).shelf)))
                Library.remove(Library.get(i));
    }
    //изменить существующую книгу
    public void change(Book later, String name, String author, String genre, String shelf) {
        String nameBook = later.name;
        String authorBook = later.author;
        String genreBook = later.genre;
        String shelfBook = later.shelf;
        for (int i = 0; i < Library.size(); i += 1)
            if (((later.name.equals(Library.get(i).name)) && (later.author.equals(Library.get(i).author)) &&
                    (later.genre.equals(Library.get(i).genre)) && (later.shelf.equals(Library.get(i).shelf)))) {
                if (!(name.isEmpty() || name.equals(" ")))
                    nameBook = name;
                if (!(author.isEmpty() || author.equals(" ")))
                    authorBook = author;
                if (!(genre.isEmpty() || genre.equals(" ")))
                    genreBook = genre;
                if (!(shelf.isEmpty() || shelf.equals(" ")))
                    shelfBook = shelf;
                Book update = new Book(nameBook, authorBook, genreBook, shelfBook);
                Library.set(i, update);
            }
    }
    //переместить книгу на другую полку
    public void move(Book later, String newShelf) {
        Book sh = new Book(later.name, later.author, later.genre, later.shelf);
        for (int i = 0; i< Library.size(); i += 1)
            if ((sh.name.equals(Library.get(i).name)) && (sh.author.equals(Library.get(i).author)) &&
                    (sh.genre.equals(Library.get(i).genre)) && (sh.shelf.equals(Library.get(i).shelf))) {
                Book up = new Book(sh.name, sh.author, sh.genre, newShelf);
                Library.set(i, up);
            }
    }
    //поиск книги по разным признакам
    public Book search(String name, String author, String genre, String shelf) {
        for (int i = 0; i < Library.size(); i += 1) {
            if (((name.equals(Library.get(i).name)) || (name.isEmpty())) && ((author.equals(Library.get(i).author)) ||
                    (author.isEmpty())) && ((genre.equals(Library.get(i).genre)) || (genre.isEmpty())) &&
                    ((shelf.equals(Library.get(i).shelf))) || (shelf.isEmpty()))
                return Library.get(i);
        }
        return new Book("","", "", "");
    }
}
