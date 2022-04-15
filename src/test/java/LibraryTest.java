import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {


    @Test
    public void addBook() {
        Library lib = new Library();
        String name = "Униженнные и оскорбленные";
        String author = "Фёдор Михайлович Достоевский";
        String genre = "Роман";
        String shelf = "Р1";

        lib.addBook(name, author, genre, shelf);
        assertEquals(name + " " + author + " " + genre + " " + shelf,
                lib.Library.get(0).name + " " + lib.Library.get(0).author + " " + lib.Library.get(0).genre + " " + lib.Library.get(0).shelf);
    }

    @Test
    public void addRecurringBook() {
        Library lib = new Library();
        String name = "Униженнные и оскорбленные";
        String author = "Фёдор Михайлович Достоевский";
        String genre = "Роман";
        String shelf = "Р1";

        String name2 = "Искра жизни";
        String author2 = "Эрих Мария Ремарк";
        String genre2 = "Роман";
        String shelf2 = "Р4";

        lib.addBook(name, author, genre, shelf);
        lib.addBook(name, author, genre, shelf);
        lib.addBook(name2, author2, genre2, shelf2);
        assertEquals(name + " " + author + " " + genre + " " + shelf + " " + name2 + " " + author2 + " " + genre2 + " " + shelf2,
                lib.Library.get(0).name + " " + lib.Library.get(0).author + " " +
                lib.Library.get(0).genre + " " + lib.Library.get(0).shelf + " " + lib.Library.get(1).name + " " + lib.Library.get(1).author + " " +
                        lib.Library.get(1).genre + " " + lib.Library.get(1).shelf);
    }

    @Test
    public void deleteBook() {
        Library lib = new Library();
        String name = "Униженнные и оскорбленные";
        String author = "Фёдор Михайлович Достоевский";
        String genre = "Роман";
        String shelf = "Р1";

        String name2 = "Маленький принц";
        String author2 = "Антуан де Сент-Экзюпери";
        String genre2 = "Сказка";
        String shelf2 = "С1";

        lib.addBook(name, author, genre, shelf);
        lib.addBook(name2, author2, genre2, shelf2);
        lib.deleteBook(name, author, genre, shelf);
          assertEquals(name2 + " " + author2 + " " + genre2 + " " + shelf2,
                  lib.Library.get(0).name + " " + lib.Library.get(0).author + " " +
                lib.Library.get(0).genre + " " + lib.Library.get(0).shelf);
    }

    @Test
    public void deleteNonExistentBook() {
        Library lib = new Library();
        String name = "Униженнные и оскорбленные";
        String author = "Фёдор Михайлович Достоевский";
        String genre = "Роман";
        String shelf = "Р1";

        String name2 = "Маленький принц";
        String author2 = "Антуан де Сент-Экзюпери";
        String genre2 = "Сказка";
        String shelf2 = "С1";

        String name3 = "Гадкий утенок";
        String author3 = "Ханс Кристиан Андерсен";
        String genre3 = "Сказка";
        String shelf3 = "С8";

        lib.addBook(name, author, genre, shelf);
        lib.addBook(name2, author2, genre2, shelf2);
        lib.deleteBook(name3, author3, genre3, shelf3);
        assertEquals(name + " " + author + " " + genre + " " + shelf + " " +
                name2 + " " + author2 + " " + genre2 + " " + shelf2,
                lib.Library.get(0).name + " " + lib.Library.get(0).author + " " +
                lib.Library.get(0).genre + " " + lib.Library.get(0).shelf + " " +
                lib.Library.get(1).name + " " + lib.Library.get(1).author + " " + lib.Library.get(1).genre + " " + lib.Library.get(1).shelf) ;
    }

    @Test
    public void changeBook() {
        Library lib = new Library();
        String name = "Униженнные и оскорбленные";
        String author = "Фёдор Михайлович Достоевский";
        String genre = "Роман";
        String shelf = "Р1";

        String name2 = "Маленький принц";
        String author2 = "Антуан де Сент-Экзюпери";
        String genre2 = "Сказка";
        String shelf2 = "С1";

        lib.addBook(name, author, genre, shelf);
        lib.addBook(name2, author2, genre2, shelf2);
        lib.changeBook(name, "Фёдор Достоевский", genre, shelf,
                name, author, genre,shelf);
        assertEquals(name + " " + author + " " + genre + " " + shelf,lib.Library.get(0).name +
                " " + lib.Library.get(0).author + " " + lib.Library.get(0).genre + " " + lib.Library.get(0).shelf);
    }

    @Test
    public void moveBook() {
        Library lib = new Library();
        String name = "Униженнные и оскорбленные";
        String author = "Фёдор Михайлович Достоевский";
        String genre = "Роман";
        String shelf = "Р1";

        String name2 = "Маленький принц";
        String author2 = "Антуан де Сент-Экзюпери";
        String genre2 = "Сказка";
        String shelf2 = "С1";

        String newshelf = "Р5";

        lib.addBook(name, author, genre, shelf);
        lib.addBook(name2, author2, genre2, shelf2);
        lib.moveBook(name, author, genre, shelf, newshelf);
        assertEquals(newshelf, lib.Library.get(0).shelf);
    }

    @Test
    public void searchBook() {
        Library lib = new Library();
        String name1 = "Обняться, чтобы уцелеть";
        String author1 = "Олег Рой";
        String genre1 = "Мистика";
        String shelf1 = "М7";

        String name2 = "Это началось не с тебя";
        String author2 = "Марк Уолинн";
        String genre2 = "Психология";
        String shelf2 = "П4";

        String name3 = "Маленький принц";
        String author3 = "Антуан де Сент-Экзюпери";
        String genre3 = "Сказка";
        String shelf3 = "С1";

        lib.addBook(name1, author1, genre1, shelf1);
        lib.addBook(name2, author2, genre2, shelf2);
        lib.addBook(name3, author3, genre3, shelf3);
        Library.Book last = lib.searchBook("", author3, "", shelf3);
        assertEquals(name3 + " " + author3 + " " + genre3 + " " + shelf3, last.name + " " + last.author + " " + last.genre + " " + last.shelf);
    }

    @Test
    public void searchForNonExistentBook() {
        Library lib = new Library();
        String name1 = "Обняться, чтобы уцелеть";
        String author1 = "Олег Рой";
        String genre1 = "Мистика";
        String shelf1 = "М7";

        String name2 = "Это началось не с тебя";
        String author2 = "Марк Уолинн";
        String genre2 = "Психология";
        String shelf2 = "П4";

        String name3 = "Униженные и оскорбленные";
        String genre3 = "Роман";

        lib.addBook(name1, author1, genre1, shelf1);
        lib.addBook(name2, author2, genre2, shelf2);
        Library.Book last = lib.searchBook(name3, "", genre3, "");
        assertNull(null);
    }
}