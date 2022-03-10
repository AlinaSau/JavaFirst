import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void addBook() throws Exception {
        Library lib = new Library();
        lib.addBook("Униженнные и оскорбленные", "Фёдор Михайлович Достоевский", "Роман", "Р1");
        assertEquals("Униженнные и оскорбленные Фёдор Михайлович Достоевский Роман Р1", lib.Library.get(0).name + " " + lib.Library.get(0).author + " " +
                lib.Library.get(0).genre + " " + lib.Library.get(0).shelf);
    }

    @Test
    public void addRecurringBook() throws Exception {
        Library lib = new Library();
        lib.addBook("Униженнные и оскорбленные", "Фёдор Михайлович Достоевский", "Роман", "Р1");
        lib.addBook("Униженнные и оскорбленные", "Фёдор Михайлович Достоевский", "Роман", "Р1");
        lib.addBook("Искра жизни", "Эрих Мария Ремарк", "Роман", "Р4");
        assertEquals("Униженнные и оскорбленные Фёдор Михайлович Достоевский Роман Р1" + " " + "Искра жизни Эрих Мария Ремарк Роман Р4", lib.Library.get(0).name + " " + lib.Library.get(0).author + " " +
                lib.Library.get(0).genre + " " + lib.Library.get(0).shelf + " " + lib.Library.get(1).name + " " + lib.Library.get(1).author + " " +
                        lib.Library.get(1).genre + " " + lib.Library.get(1).shelf);
    }

    @Test
    public void deleteBook() throws Exception {
        Library lib = new Library();
        lib.addBook("Униженнные и оскорбленные", "Фёдор Михайлович Достоевский", "Роман", "Р1");
        lib.addBook("Маленький принц", "Антуан де Сент-Экзюпери", "Сказка", "С1");
        lib.deleteBook("Униженнные и оскорбленные", "Фёдор Михайлович Достоевский", "Роман", "Р1");
          assertEquals("Маленький принц Антуан де Сент-Экзюпери Сказка С1", lib.Library.get(0).name + " " + lib.Library.get(0).author + " " +
                lib.Library.get(0).genre + " " + lib.Library.get(0).shelf);
    }

    @Test
    public void deleteNonExistentBook() throws Exception {
        Library lib = new Library();
        lib.addBook("Униженнные и оскорбленные", "Фёдор Михайлович Достоевский", "Роман", "Р1");
        lib.addBook("Маленький принц", "Антуан де Сент-Экзюпери", "Сказка", "С1");
        lib.deleteBook("Гадкий утенок", " Ханс Кристиан Андерсен", "Сказка", "С8");
        assertEquals("Униженнные и оскорбленные Фёдор Михайлович Достоевский Роман Р1" + " " +
                "Маленький принц Антуан де Сент-Экзюпери Сказка С1", lib.Library.get(0).name + " " + lib.Library.get(0).author + " " +
                lib.Library.get(0).genre + " " + lib.Library.get(0).shelf + " " +
                lib.Library.get(1).name + " " + lib.Library.get(1).author + " " + lib.Library.get(1).genre + " " + lib.Library.get(1).shelf) ;
    }

    @Test
    public void changeBook() throws Exception {
        Library lib = new Library();
        lib.addBook("Униженные и оскорбленные", "Фёдор Достоевский", "Роман", "Р1");
        lib.addBook("Маленький принц", "Антуан де Сент-Экзюпери", "Сказка", "С1");
        lib.changeBook("Униженные и оскорбленные", "Фёдор Достоевский", "Роман", "Р1",
                "Униженные и оскорбленные", "Фёдор Михайлович Достоевский", "Роман","Р1");
        assertEquals("Униженные и оскорбленные Фёдор Михайлович Достоевский Роман Р1",lib.Library.get(0).name +
                " " + lib.Library.get(0).author + " " + lib.Library.get(0).genre + " " + lib.Library.get(0).shelf);
    }

    @Test
    public void moveBook() throws Exception {
        Library lib = new Library();
        lib.addBook("Униженнные и оскорбленные", "Фёдор Михайлович Достоевский", "Роман", "Р1");
        lib.addBook("Маленький принц", "Антуан де Сент-Экзюпери", "Сказка", "С1");
        lib.moveBook("Униженнные и оскорбленные", "Фёдор Михайлович Достоевский", "Роман", "Р1", "Р5");
        assertEquals("Р5", lib.Library.get(0).shelf);
    }

    @Test
    public void searchBook() throws Exception {
        Library lib = new Library();
        lib.addBook("Обняться, чтобы уцелеть", "Олег Рой", "Мистика", "М7");
        lib.addBook("Это началось не с тебя", "Марк Уолинн", "Психология", "П4");
        lib.addBook("Маленький принц", "Антуан де Сент-Экзюпери", "Сказка", "С3");
        Book last = lib.searchBook("", "Антуан де Сент-Экзюпери", "", "С3");
        assertEquals("Маленький принц Антуан де Сент-Экзюпери Сказка С3", last.name + " " + last.author + " " + last.genre + " " + last.shelf);
    }

    @Test
    public void searchForNonExistentBook() throws Exception {
        Library lib = new Library();
        lib.addBook("Обняться, чтобы уцелеть", "Олег Рой", "Мистика", "М7");
        lib.addBook("Это началось не с тебя", "Марк Уолинн", "Психология", "П4");
        Book last = lib.searchBook("Униженные и оскорбленные", "", "Роман", "");
        assertEquals("", "");
    }
}