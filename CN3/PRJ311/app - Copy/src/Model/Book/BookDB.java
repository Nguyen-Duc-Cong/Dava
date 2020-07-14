package Model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class BookDB {
    //--------------------------------------------------------------------
    public static Book getBook(String bid) {
        Book b = null;
        try {
            Connection conn = ConnectDB.getConnection();
            String sql = "select * from Books where BookID='" + bid + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // show data
            if (rs.next()) {
                b = new Book(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            System.out.println("Get books failure!");
            ex.printStackTrace();
        }
        return b;
    }
    public  Vector<Book> getAllBook() {
        Vector book = new Vector<>();
        try {
            Connection conn = ConnectDB.getConnection();
            String sql = "select * from Books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // show data
            while (rs.next()) {
                Vector b = new Vector<>();
                b.add(rs.getString(1));
                b.add(rs.getString(2));
                b.add(rs.getString(3));
                b.add(rs.getString(4));
                b.add(rs.getString(5));

                book.add(b);
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return book;
    }
    //--------------------------------------------------------------------
    public static void deleteBook(String aBookID) {
        try {
            // connnect to database
            Connection conn = ConnectDB.getConnection();
            // create statement
            String sql = "Delete from Books where BookID='" + aBookID + "'";
            Statement stmt = conn.createStatement();
            // execute sql
            stmt.executeUpdate(sql);
            // close connection
            conn.close();
            System.out.println("Delete Book successfully!");
        } catch (Exception ex) {
            System.out.println("Delete Book failure!");
            ex.printStackTrace();
        }
    }
    //update a book

    public int updateBook(String aBookID, String aTitle, String aAuthor, String aCategory, String aKeyword) {
        int rc = 0;
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Update Books set Title=?, Author=?, Category=?, Keyword=? where BookID='" + aBookID + "'";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, aTitle);
            st.setString(2, aAuthor);
            st.setString(3, aCategory);
            st.setString(4, aKeyword);
            rc = st.executeUpdate();
            conn.close();
            System.out.println("Update book successfully!!");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Update fail");
        }
        return rc;
    }
    public static void addNewBook(Book b) {
        try {
            Connection conn = ConnectDB.getConnection();
            String sql = "INSERT INTO books(BookID, Title, Author, Category,Keyword) VALUES(?,?,?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, b.getBookID());
            stmt.setString(2, b.getTitle());
            stmt.setString(3, b.getAuthor());
            stmt.setString(4, b.getCategory());
            stmt.setString(5, b.getKeyword());
            stmt.executeUpdate();
            conn.close();
            System.out.println("Insert Book successfully!");
        } catch (Exception ex) {
            System.out.println("Insert book failure!");
            ex.printStackTrace();
        }
    }
    //--------------------------------------------------------------------
    public static Vector<Book> searchByCategory(String cat) {

        Vector bo = new Vector<>();
        try {
            Connection conn = ConnectDB.getConnection();
            String sql = "Select * from books where Category Like '%"+cat+"%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vector b = new Vector<>();
                b.add(rs.getString(1));
                b.add(rs.getString(2));
                b.add(rs.getString(3));
                b.add(rs.getString(4));
                b.add(rs.getString(5));
                bo.add(b);
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            System.out.println("Get books failure!");
            ex.printStackTrace();
        }
        return bo;
    }
    //--------------------------------------------------------------------
    public static Vector<Book> searchByKeyword(String key) {
        Vector bo = new Vector<>();
        try {
            Connection conn = ConnectDB.getConnection();
            String sql = "Select * from books where Keyword Like '%"+key+"%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // show data
            while (rs.next()) {
                Vector b = new Vector<>();
                b.add(rs.getString(1));
                b.add(rs.getString(2));
                b.add(rs.getString(3));
                b.add(rs.getString(4));
                b.add(rs.getString(5));
                bo.add(b);
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            System.out.println("Get books failure!");
            ex.printStackTrace();
        }
        return bo;
    }
    //--------------------------------------------------------------------
    public static Vector<Book> searchByTitle(String title) {

        Vector bo = new Vector<>();
        try {
            Connection conn = ConnectDB.getConnection();
            String sql = "Select * from books where Title Like '%"+title+"%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // show data
            while (rs.next()) {
                Vector b = new Vector<>();
                b.add(rs.getString(1));
                b.add(rs.getString(2));
                b.add(rs.getString(3));
                b.add(rs.getString(4));
                b.add(rs.getString(5));
                bo.add(b);
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            System.out.println("Get books failure!");
            ex.printStackTrace();
        }
        return bo;
    }
    //--------------------------------------------------------------------
    public static Vector<Book> searchByAuthor(String author) {

        Vector bo = new Vector<>();
        try {
            Connection conn = ConnectDB.getConnection();
            String sql = "Select * from books where Author Like '%"+author+"%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // show data
            while (rs.next()) {
                Vector b = new Vector<>();
                b.add(rs.getString(1));
                b.add(rs.getString(2));
                b.add(rs.getString(3));
                b.add(rs.getString(4));
                b.add(rs.getString(5));
                bo.add(b);
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            System.out.println("Get books failure!");
            ex.printStackTrace();
        }
        return bo;
    }
    //--------------------------------------------------------------------
    public static Vector<Book> searchByBookID(String book) {

        Vector bo = new Vector<>();
        //Book b = null;
        try {
            Connection conn = ConnectDB.getConnection();
            String sql = "Select * from books where BookID Like '%"+book+"%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // show data
            while (rs.next()) {
                Vector b = new Vector<>();
                b.add(rs.getString(1));
                b.add(rs.getString(2));
                b.add(rs.getString(3));
                b.add(rs.getString(4));
                b.add(rs.getString(5));
                bo.add(b);
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            System.out.println("Get books failure!");
            ex.printStackTrace();
        }
        return bo;
    }
}
