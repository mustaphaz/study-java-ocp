package exams;

import lombok.Data;

import java.util.*;

@Data
class Book {
    private String title, isbn;

    public boolean equals(Object o) {
        return (o instanceof Book && ((Book) o).isbn.equals(this.isbn));
    }

//    @Override
//    public int hashCode(){
//        return Integer.valueOf(isbn);
//    }

    // ... setters and getters for title and isbn
}

class BookStore {
    Map<Book, Integer> map = new HashMap<Book, Integer>();

    int getNumberOfCopies(Book b) {
        int hashcode = b.hashCode();
        Integer value = map.get(b);
        return value;
    }

    public void addBook(Book b, int numberofcopies) {
        map.put(b, numberofcopies);
    }

    // ... other useful methods.
}

public class BookTestClass {
    static BookStore bs = new BookStore();

    public static void main(String[] args) {
        Book b = new Book();
        b.setIsbn("111");
        bs.addBook(b, 10);
        System.out.println(bs.getNumberOfCopies(b));
        b = new Book();
        b.setIsbn("111");
        System.out.println(bs.getNumberOfCopies(b));
    }
}
