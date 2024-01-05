package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Donatur;

/**
 *
 * @author administrator
 */
public class DonaturDAO extends BaseDAO{
    private static PreparedStatement st;
    private static Connection con;
    
     public void registerDonatur(Donatur d) {
        try {
            con = getCon();
            String query = "insert into donatur (username, password)"
                    + " values ('%s', '%s') ";
            query = String.format(query,
                    d.getNama(),
                    d.getPassword());
            st = con.prepareStatement(query);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
    }
    
     public Donatur loginDonatur(String username, String password){
         Donatur hasil = null;
         try {
             con = getCon();
             String query = "Select * from donatur where username = '%s' and password = '%s'";
             query = String.format(query,
                     username, password);
             st = con.prepareStatement(query);
             ResultSet rs = st.executeQuery();
             if (rs.next() != false) {
                hasil = new Donatur (
                        rs.getString("username"),
                        rs.getString("password"));
                hasil.setIdDonatur(rs.getInt("id_donatur"));
                return hasil;
            } else {
                System.out.println("username atau password salah");
                
            }
         } catch (Exception e){
            e.printStackTrace();
        } finally {
            closeCon(con);
        }     
         return hasil;
     }
     
     public static void updateDonatur(Donatur oldDonatur, Donatur newDonatur){
         try {
             con = getCon();
             String query = "UPDATE donatur" +
             "SET username = '%s', password = '%s'" +
             "WHERE username = '%s';";
             query = String.format(query,
                     newDonatur.getNama(),newDonatur.getPassword(), oldDonatur.getNama());
             st = con.prepareStatement(query);
             st.executeUpdate();
         } catch (Exception e){
            e.printStackTrace();
        } finally {
            closeCon(con);
        } 
         
     }
}
