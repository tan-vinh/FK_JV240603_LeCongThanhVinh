package ra.business;

import ra.entity.BookType;
import ra.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookTypeBusiness {
    public static List<BookType> getAllBookTypes() {
        List<BookType> bookTypes = new ArrayList<BookType>();
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "select * from booktype";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BookType bookType = new BookType();
                bookType.setTypeId(resultSet.getInt("TypeId"));
                bookType.setTypeName(resultSet.getString("TypeName"));
                bookType.setDescription(resultSet.getString("Description"));
                bookType.setDeleted(resultSet.getBoolean("IsDeleted"));
                bookTypes.add(bookType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return bookTypes;
    }

    public static BookType findBookTypeById(int id) {
        Connection connection = null;
        BookType bookType = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "select * from booktype where TypeId=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            int count = 0;
            bookType = new BookType();
            while (resultSet.next()) {
                count++;
                bookType.setTypeId(resultSet.getInt("TypeId"));
                bookType.setTypeName(resultSet.getString("TypeName"));
                bookType.setDescription(resultSet.getString("Description"));
                bookType.setDeleted(resultSet.getBoolean("IsDeleted"));
            }
            if (count == 0) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return bookType;
    }

    public static boolean createBookType(BookType bookType) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "insert into(TypeName, Description, IsDeleted) booktype values(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, bookType.getTypeName());
            statement.setString(2, bookType.getDescription());
            statement.setBoolean(3, bookType.isDeleted());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    public static boolean updateBookType(BookType bookType) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "update booktype set TypeName=?, Description=?, IsDeleted=? where TypeId=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, bookType.getTypeName());
            statement.setString(2, bookType.getDescription());
            statement.setBoolean(3, bookType.isDeleted());
            statement.setInt(4, bookType.getTypeId());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    public static boolean deleteBookType(int id) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "delete from booktype where TypeId=?";
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
