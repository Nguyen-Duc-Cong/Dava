package Model;

import java.util.ArrayList;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookDB {

    //--------------------------------------------------------------------
    public Book getBook(String bid) {
        String bookID, title, author, category, keyword;
        Book book = null;
        try {
            Connection con;
            con = ConnectDB.getConnection();
            Statement stmt = con.createStatement();
            String sql = "Select * from Books where bookID='" + bid + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                bookID = rs.getString(1);
                title = rs.getString(2);
                author = rs.getString(3);
                category = rs.getString(4);
                keyword = rs.getString(5);
                book = new Book(bookID, title, author, category, keyword);
                System.out.println(book.toString());
                con.close();
                System.out.println("Get book  successfully");
            } else {
                System.out.println("This book id does not exist");
            }
        } catch (Exception e) {
            System.out.println("" + e);
            System.out.println("Get book error");
        }
        return book;
    }

    public ArrayList<Book> getALlBooks() {
        ArrayList<Book> allBooks = new ArrayList<>();
        String bookID, title, author, category, keyword;
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Select * from Books";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                bookID = rs.getString(1);
                title = rs.getString(2);
                author = rs.getString(3);
                category = rs.getString(4);
                keyword = rs.getString(5);
                Book book = new Book(bookID, title, author, category, keyword);
                allBooks.add(book);
                System.out.println(book.toString());
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("" + e);
            System.out.println("Get error");
        }
        return allBooks;
    }

    public int addBook(String bid, String title, String author, String category, String keyword) {
        int rc = 0;
        try {

            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Insert into Books Values(?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, Helper.generateRandomString());
            st.setString(2, title);
            st.setString(3, author);
            st.setString(4, category);
            st.setString(5, keyword);
            rc = st.executeUpdate();
            conn.close();
            System.out.println("Insert book successfully");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Insert book error");

        }
        return rc;
    }

    public int deleteBook(String bid) {
        int rc = 0;
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Delete from Books where bookID='" + bid + "'";
            Statement st = conn.createStatement();
            rc = st.executeUpdate(sql);
            conn.close();
        } catch (Exception e) {
            System.out.println("" + e);
            System.out.println("Delete Book error");
        }
        return rc;
    }

    public int updateBook(String bid, String title, String author, String cat, String kword) {
        int rc = 0;
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Update Books set Title=?, Author=?, Category=?, Keyword=? where BookID='" + bid + "'";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, title);
            st.setString(2, author);
            st.setString(3, cat);
            st.setString(4, kword);
            rc = st.executeUpdate();
            conn.close();
            System.out.println("Update book successfully!!");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Update fail");
        }
        return rc;
    }

    public Vector<Book> searchByAuthor(String author) {
        Vector<Book> allBooks = new Vector<>();
        String title, bookID, category, keyword;
        String sql = "Select * from Books where author Like '%" + author + "%'";
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                bookID = rs.getString(1);
                title = rs.getString(2);
                author = rs.getString(3);
                category = rs.getString(4);
                keyword = rs.getString(5);
                Book book = new Book(bookID, title, author, category, keyword);
                System.out.println(book.toString());
                allBooks.add(book);
            }
            conn.close();
            System.out.println("Search Successfully");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Search Error");
        }
        return allBooks;

    }

    public Vector<Book> searchByTitle(String title) {
        Vector<Book> allBooks = new Vector<>();
        String bookID, author, category, keyword;
        String sql = "Select * from Books where title Like '%" + title + "%'";
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                bookID = rs.getString(1);
                title = rs.getString(2);
                author = rs.getString(3);
                category = rs.getString(4);
                keyword = rs.getString(5);
                Book book = new Book(bookID, title, author, category, keyword);
                System.out.println(book.toString());
                allBooks.add(book);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Search eror!!");
        }
        return allBooks;
    }

    public Vector<Book> searchByCategory(String category) {
        Vector<Book> allBooks = new Vector<>();
        String title, bookID, author, keyword;
        String sql = "Select *from Books where category Like '%" + category + "'";
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                bookID = rs.getString(1);
                title = rs.getString(2);
                author = rs.getString(3);
                category = rs.getString(4);
                keyword = rs.getString(5);
                Book book = new Book(bookID, title, author, category, keyword);
                System.out.println(book.toString());
                allBooks.add(book);
            }
            conn.close();
            System.out.println("Search successfully!");
        } catch (Exception e) {
            System.out.println("Search error!!");
        }
        return allBooks;
    }

    public Vector<Book> sbyid(String id) {
        Vector<Book> allBooks = new Vector<>();
        String title, category, author, keyword;
        String sql = "Select *from Books where BookID Like '%" + id + "'";
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getString(1);
                title = rs.getString(2);
                author = rs.getString(3);
                category = rs.getString(4);
                keyword = rs.getString(5);
                Book book = new Book(id, title, author, category, keyword);
                System.out.println(book.toString());
                allBooks.add(book);
            }
            conn.close();
            System.out.println("Search successfully!");
        } catch (Exception e) {
            System.out.println("Search error!!");
        }
        return allBooks;
    }
    public Vector<Book> searchByKeyWord(String keyword) {
        Vector<Book> allBooks = new Vector<>();
        String title, bookID, author, category;
        String sql = "Select * from Books where keyword Like '%" + keyword + "%'";
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                bookID = rs.getString(1);
                title = rs.getString(2);
                author = rs.getString(3);
                category = rs.getString(4);
                keyword = rs.getString(5);
                Book book = new Book(bookID, title, author, category, keyword);
                System.out.println(book.toString());
                allBooks.add(book);
            }
            conn.close();
            System.out.println("Search successfully!");
        } catch (Exception e) {
            System.out.println("Search error!!");
        }
        return allBooks;
    }
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