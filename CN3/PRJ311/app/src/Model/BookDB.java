package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
//                b.setBookID(rs.getString(1));
//                b.setTitle(rs.getString(2));
//                b.setAuthor(rs.getString(3));
//                b.setCategory(rs.getString(4));
//                b.setKeyword(rs.getString(5));
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

    //--------------------------------------------------------------------
    public static ArrayList<Book> searchByCategory(String cat) {

        ArrayList<Book> bo = new ArrayList<Book>();
        Book b = null;
        try {
            Connection conn = ConnectDB.getConnection();
            String sql = "select * from Books where Category='" + cat + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // show data
            while (rs.next()) {
                b.setBookID(rs.getString(1));
                b.setTitle(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setCategory(rs.getString(4));
                b.setKeyword(rs.getString(5));
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
    public static ArrayList<Book> searchByKeyword(String key) {
        ArrayList<Book> bo = new ArrayList<Book>();
        Book b = null;
        try {
            Connection conn = ConnectDB.getConnection();
            String sql = "select * from Books where Keyword='" + key + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // show data
            while (rs.next()) {
                b.setBookID(rs.getString(1));
                b.setTitle(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setCategory(rs.getString(4));
                b.setKeyword(rs.getString(5));
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
    public static void addNewBook(Book b) {
        try {
            // connnect to database
            Connection conn = ConnectDB.getConnection();
            // create statement
            String sql = "INSERT INTO books(BookID, Title, Author, Category,Keyword) VALUES(?,?,?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // set parameter values
            stmt.setString(1, b.getBookID());
            stmt.setString(2, b.getTitle());
            stmt.setString(3, b.getAuthor());
            stmt.setString(4, b.getCategory());
            stmt.setString(5, b.getKeyword());
            // execute sql
            stmt.executeUpdate();
            //a=stmt.execute();
            // close connection
            conn.close();
            System.out.println("Insert Book successfully!");
        } catch (Exception ex) {
            System.out.println("Insert book failure!");
            ex.printStackTrace();
        }
    }

    //--------------------------------------------------------------------
    public static Vector<Book> searchByTitle(String title) {

        Vector<Book> bo = new Vector<>();
        Book b = null;
        try {
            Connection conn = ConnectDB.getConnection();
            String sql = "select * from Books where Title='" + title + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // show data
            while (rs.next()) {
                b.setBookID(rs.getString(1));
                b.setTitle(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setCategory(rs.getString(4));
                b.setKeyword(rs.getString(5));
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
}
