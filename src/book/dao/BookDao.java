package book.dao;

import book.model.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    Database dataBase = new Database();

    public BookDao() throws SQLException {
    }

    public List<Book> findAll() throws SQLException {
        PreparedStatement statement = dataBase.getConnection().prepareStatement("select * from book");
        ResultSet resultSet = statement.executeQuery();
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String isbn = resultSet.getString("isbn");
            String bookTitle = resultSet.getString("bookTitle");
            String author = resultSet.getString("author");
            String publishedYear = resultSet.getString("publishedYear");
            int price = resultSet.getInt("price");
            int count = resultSet.getInt("count");
            Book book = new Book(id, isbn, bookTitle, author, publishedYear, price,count);
            books.add(book);

        }
        return books;
    }
}
