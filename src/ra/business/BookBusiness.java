package ra.business;

import ra.entity.Book;
import ra.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookBusiness {
    public static List<Book> getAllBook() {
        List<Book> books = new ArrayList<Book>();
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "select * from book";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setBookId(resultSet.getInt("BookId"));
                book.setBookName(resultSet.getString("BookName"));
                book.setTitle(resultSet.getString("Title"));
                book.setAuthor(resultSet.getString("Author"));
                book.setTotalPages(resultSet.getInt("TotalPages"));
                book.setContent(resultSet.getString("Content"));
                book.setPublisher(resultSet.getString("Publisher"));
                book.setPrice(resultSet.getFloat("Price"));
                book.setTypeId(resultSet.getInt("TypeId"));
                book.setDeleted(resultSet.getBoolean("IsDeleted"));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return books;
    }

    public static Book findBookById(int id) {
        Connection connection = null;
        Book book = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "select * from book where typeId=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            int count = 0;
            book = new Book();
            while (resultSet.next()) {
                count++;
                book.setBookId(resultSet.getInt("BookId"));
                book.setBookName(resultSet.getString("BookName"));
                book.setTitle(resultSet.getString("Title"));
                book.setAuthor(resultSet.getString("Author"));
                book.setTotalPages(resultSet.getInt("TotalPages"));
                book.setContent(resultSet.getString("Content"));
                book.setPublisher(resultSet.getString("Publisher"));
                book.setPrice(resultSet.getFloat("Price"));
                book.setTypeId(resultSet.getInt("TypeId"));
                book.setDeleted(resultSet.getBoolean("IsDeleted"));
            }
            if (count == 0) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return book;
    }

    public static boolean createBook(Book book) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "insert into book(BookName, Title, Author, TotalPages, Content, Publisher, Price, TypeId, IsDeleted) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getBookName());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setInt(4, book.getTotalPages());
            statement.setString(5, book.getContent());
            statement.setString(6, book.getPublisher());
            statement.setFloat(7, book.getPrice());
            statement.setInt(8, book.getTypeId());
            statement.setBoolean(9, book.isDeleted());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    public static boolean updateBook(Book book) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "update book set BookName = ?, Title = ?, Author = ?, TotalPages = ?, Content = ?, Publisher = ?, Price = ?, TypeId = ?, IsDeleted = ? where BookId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getBookName());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setInt(4, book.getTotalPages());
            statement.setString(5, book.getContent());
            statement.setString(6, book.getPublisher());
            statement.setFloat(7, book.getPrice());
            statement.setInt(8, book.getTypeId());
            statement.setBoolean(9, book.isDeleted());
            statement.setInt(10, book.getBookId());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    public static boolean deleteBook(int id) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "delete from booktype where BookId=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }
}
