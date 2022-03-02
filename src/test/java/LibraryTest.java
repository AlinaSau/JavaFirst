import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void add() throws Exception {
        Library lib = new Library();
        lib.add("Униженнные и оскорбленные", "Фёдор Михайлович Достоевский", "Роман", "Р1");
        assertEquals("Униженнные и оскорбленные Фёдор Михайлович Достоевский Роман Р1", lib.Library.get(0).name + " " + lib.Library.get(0).author + " " +
                lib.Library.get(0).genre + " " + lib.Library.get(0).shelf);
    }

    @Test
    public void delete() throws Exception {
        Library lib = new Library();
        lib.add("Униженнные и оскорбленные", "Фёдор Михайлович Достоевский", "Роман", "Р1");
        lib.add("Маленький принц", "Антуана де Сент-Экзюпери", "Сказка", "С1");
        lib.delete("Униженнные и оскорбленные", "Фёдор Михайлович Достоевский", "Роман", "Р1");
          assertEquals("Маленький принц Антуана де Сент-Экзюпери Сказка С1", lib.Library.get(0).name + " " + lib.Library.get(0).author + " " +
                lib.Library.get(0).genre + " " + lib.Library.get(0).shelf);
    }

    @Test
    public void change() throws Exception {
        Library lib = new Library();
        lib.add("Униженные и оскорбленные", "Фёдор Достоевский", "Роман", "Р1");
        lib.add("Маленький принц", "Антуана де Сент-Экзюпери", "Сказка", "С1");
        lib.change(new Book("Униженные и оскорбленные", "Фёдор Достоевский", "Роман", "Р1"),
                "Униженные и оскорбленные", "Фёдор Михайлович Достоевский", "Роман","Р1");
        assertEquals("Униженные и оскорбленные Фёдор Михайлович Достоевский Роман Р1",lib.Library.get(0).name +
                " " + lib.Library.get(0).author + " " + lib.Library.get(0).genre + " " + lib.Library.get(0).shelf);
    }

    @Test
    public void move() throws Exception {
        Library lib = new Library();
        lib.add("Униженнные и оскорбленные", "Фёдор Михайлович Достоевский", "Роман", "Р1");
        lib.add("Маленький принц", "Антуана де Сент-Экзюпери", "Сказка", "С1");
        lib.move(new Book("Униженнные и оскорбленные", "Фёдор Михайлович Достоевский", "Роман", "Р1"), "Р5");
        assertEquals("Р5", lib.Library.get(0).shelf);
    }

    @Test
    public void search() throws Exception {
        Library lib = new Library();
        lib.add("Обняться, чтобы уцелеть", "Олег Рой", "Мистика", "М7");
        lib.add("Это началось не с тебя", "Марк Уолинн", "Психология", "П4");
        lib.add("Маленький принц", "Антуана де Сент-Экзюпери", "Сказка", "С3");
        Book last = lib.search("", "Антуана де Сент-Экзюпери", "", "С3");
        assertEquals("Маленький принц Антуана де Сент-Экзюпери Сказка С3", last.name + " " + last.author + " " + last.genre + " " + last.shelf);
    }
}