package book;

import book.service.bookService;

import java.sql.SQLException;

public class main {
    static book.service.bookService bookService;

    static {
        try {
            bookService = new bookService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public main() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {

        bookService.findbook();
//        bookService.findbook().forEach(System.out::println);

    }
}
