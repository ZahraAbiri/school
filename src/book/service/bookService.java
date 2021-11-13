package book.service;

import book.model.Book;
import book.dao.BookDao;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class bookService {
    BookDao bookDao = new BookDao();
    List<Book> findbook = bookDao.findAll();

    public bookService() throws SQLException {
    }

    public List<Book> findbook() throws SQLException {
        List<Book> book = bookDao.findAll();

        Comparator<Book> booksAuthor = (a, b) -> a.getAuthor().compareTo(b.getAuthor());


        book.sort(booksAuthor);
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%5s %15s %15s %12s %14s", "Author","BookTitle", "SPublishdYear","getCount()", "sumPrice");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");

        for(Book bookIterate: book)
        {
            Integer sumPrice = getSumPrice(bookIterate);
            System.out.format("%7s %14s %14s %10s %15s", bookIterate.getAuthor(),bookIterate.getBookTitle(),bookIterate.getPublishdYear()
            ,bookIterate.getCount(),sumPrice);
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------");

        return book;
    }

    public Integer getSumPrice(Book bookTitle) {
        Integer sum = findbook.stream().filter(i -> i.getBookTitle().equals(bookTitle.getBookTitle())&&i.getAuthor().equals(bookTitle.getAuthor())).
                map(Book::getPrice).
                reduce(0, Integer::sum);
        int count=bookTitle.getCount();


        return sum*count;
    }

}
