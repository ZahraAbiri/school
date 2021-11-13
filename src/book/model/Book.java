package book.model;

import java.util.Objects;

public class Book implements  Comparable<Book> {
    private int id;
    ;
    private String isbn;
    private String bookTitle;
    private String author;
    private String publishdYear;
    private int price;
    private int count;

    public Book(int id, String isbn, String bookTitle, String author, String publishdYear, int price, int count) {
        this.id = id;
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publishdYear = publishdYear;
        this.price = price;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishdYear() {
        return publishdYear;
    }

    public void setPublishdYear(String publishdYear) {
        this.publishdYear = publishdYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && price == book.price && count == book.count && Objects.equals(isbn, book.isbn) && Objects.equals(bookTitle, book.bookTitle) && Objects.equals(author, book.author) && Objects.equals(publishdYear, book.publishdYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, bookTitle, author, publishdYear, price, count);
    }

    @Override
    public String toString() {
        return "Book{" +

                ", isbn='" + isbn + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", publishdYear='" + publishdYear + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }

    public <BooKlib> Comparable author() {
        return null;
    }

    @Override
    public int compareTo(Book o) {
        return this.getPublishdYear().compareTo(o.getPublishdYear());
    }
}
