import java.util.ArrayList;

class Book {
    public String name;
    public String author;
    public String genre;
    public String shelf;

    public Book (String name, String author, String genre, String shelf) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.shelf = shelf;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setShelf(String shelf) {
        this.shelf = shelf;
    }
}

public class Library {
    public ArrayList<Book> Library = new ArrayList<>();

    public static void main(String[] args) {

    }
    public void addBook(String name, String author, String genre, String shelf) {
        Book trialBook = new Book(name, author, genre, shelf);
        if (Library.size() == 0) Library.add(trialBook);
        for (int i = 0; i < Library.size(); i += 1)
            if ((trialBook.name.equals(Library.get(i).name)) && (trialBook.author.equals(Library.get(i).author)) &&
                    (trialBook.genre.equals(Library.get(i).genre)) && (trialBook.shelf.equals(Library.get(i).shelf)))
                break;
            else
                Library.add(trialBook);
    }

    public void deleteBook(String name, String author, String genre, String shelf) {
        Book trialBook = new Book(name, author, genre, shelf);
        for (int i = 0; i < Library.size(); i += 1)
            if ((trialBook.name.equals(Library.get(i).name)) && (trialBook.author.equals(Library.get(i).author)) &&
                    (trialBook.genre.equals(Library.get(i).genre)) && (trialBook.shelf.equals(Library.get(i).shelf)))
                Library.remove(Library.get(i));
    }

    public void changeBook(String laterName, String laterAuthor, String laterGenre, String laterShelf, String name, String author, String genre, String shelf) {
        Book laterVersionBook = new Book(laterName, laterAuthor, laterGenre, laterShelf);
        for (int i = 0; i < Library.size(); i += 1)
            if (((laterVersionBook.name.equals(Library.get(i).name)) && (laterVersionBook.author.equals(Library.get(i).author)) &&
                    (laterVersionBook.genre.equals(Library.get(i).genre)) && (laterVersionBook.shelf.equals(Library.get(i).shelf)))) {
                if (!(name.isEmpty() || name.trim().length() == 0))
                    laterVersionBook.setName(name);
                if (!(author.isEmpty() || author.trim().length() == 0))
                    laterVersionBook.setAuthor(author);
                if (!(genre.isEmpty() || genre.trim().length() == 0))
                    laterVersionBook.setGenre(genre);
                if (!(shelf.isEmpty() || shelf.trim().length() == 0))
                    laterVersionBook.setShelf(shelf);
                Library.set(i, laterVersionBook);
            }
    }

    public void moveBook(String name, String author, String genre, String shelf, String newShelf) {
        Book trialBook = new Book(name, author, genre, shelf);
        for (int i = 0; i< Library.size(); i += 1)
            if ((trialBook.name.equals(Library.get(i).name)) && (trialBook.author.equals(Library.get(i).author)) &&
                    (trialBook.genre.equals(Library.get(i).genre)) && (trialBook.shelf.equals(Library.get(i).shelf))) {
                trialBook.setShelf(newShelf);
                Library.set(i, trialBook);
            }
    }

    public Book searchBook(String name, String author, String genre, String shelf) {
        for (int i = 0; i < Library.size(); i += 1) {
            if (((name.equals(Library.get(i).name)) || (name.isEmpty())) && ((author.equals(Library.get(i).author)) ||
                    (author.isEmpty())) && ((genre.equals(Library.get(i).genre)) || (genre.isEmpty())) &&
                    ((shelf.equals(Library.get(i).shelf))) || (shelf.isEmpty()))
                return Library.get(i);
        }
        return new Book("", "", "","");
    }
}
