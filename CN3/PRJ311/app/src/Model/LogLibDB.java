package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class LogLibDB {
    //---------------------------------------------------------------------------------------
    public static LogLib getLog(int logID) {
        LogLib b = null;
        try {
            Connection conn = ConnectDB.getConnection();
            String sql = "select * from LogLibs where LogID='" + logID + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // show data
            if (rs.next()) {
//                b.setBookID(rs.getString(1));
//                b.setTitle(rs.getString(2));
//                b.setAuthor(rs.getString(3));
//                b.setCategory(rs.getString(4));
//                b.setKeyword(rs.getString(5));
                b = new LogLib(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            System.out.println("Get books failure!");
            ex.printStackTrace();
        }
        return b;
    }

    //---------------------------------------------------------------------------------------
    public static void updateLog(LogLib log) {
        try {
            // connnect to database
            Connection conn = ConnectDB.getConnection();
            // create statement
            String sql = "Update LogLib set BookID=?,NgayDat=?,NgayMuon=?,NgayPtra=?,NgayTra=?,MaNV=?,LogID=? where BookID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // set parameter values
            stmt.setString(1, log.getLogID());
            stmt.setString(2, log.getBookID());
            stmt.setString(3, log.getNgayDat());
            stmt.setString(4, log.getNgayMuon());
            stmt.setString(5, log.getNgayPtra());
            stmt.setString(6, log.getNgayTra());
            stmt.setString(7, log.getMaNV());
            stmt.setString(8, log.getLogID());
            // execute sql
            stmt.executeUpdate();
            // close connection
            conn.close();
            System.out.println("Update Book successfully!");
        } catch (Exception ex) {
            System.out.println("Update Book failure!");
            ex.printStackTrace();
        }
    }

    //---------------------------------------------------------------------------------------
    public static int writeLog(LogLib log) {

        return -1;
    }

    //---------------------------------------------------------------------------------------
    public static Vector<Vector> viewLogByUser(String uid) {
        return null;
    }

    //---------------------------------------------------------------------------------------
    public static ArrayList<LogLib> getLogsByUser(String uid) {
        ArrayList<LogLib> bo = new ArrayList<LogLib>();
        LogLib log = null;
        try {
            Connection conn = ConnectDB.getConnection();
            String sql = "select * from LogLib where UserID ='" + uid + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // show data
            while (rs.next()) {
                log.setLogID(rs.getString(1));
                log.setBookID(rs.getString(2));
                log.setNgayDat(rs.getString(3));
                log.setNgayMuon(rs.getString(4));
                log.setNgayPtra(rs.getString(5));
                log.setNgayTra(rs.getString(6));
                log.setMaNV(rs.getString(7));
                log.setLogID(rs.getString(8));
                bo.add(log);
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            System.out.println("Get log lib failure!");
            ex.printStackTrace();
        }
        return bo;
    }
}
