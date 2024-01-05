/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.BaseDAO.closeCon;
import static dao.BaseDAO.getCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Donatur;
import model.Organisasi;

/**
 *
 * @author Administrator
 */
public class OrganisasiDAO extends BaseDAO {
    private static PreparedStatement st;
    private static Connection con;
    
    public static void registerOrganisasi(Organisasi organisasi){
         try {
            con = getCon();
            String query = "insert into organisasi (nama, username, password,alamat)"
                    + " values ('%s', '%s','%s','%s') ";
            query = String.format(query,
                    organisasi.getNama(), organisasi.getUsername(), organisasi.getPassword(),organisasi.getAlamat());
            st = con.prepareStatement(query);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
    }
    
    public static Organisasi loginOrganisasi(String username,String password){
        Organisasi hasil = null;
         try {
             con = getCon();
             String query = "Select * from organisasi where username = '%s' and password = '%s'";
             query = String.format(query,
                     username, password);
             st = con.prepareStatement(query);
             ResultSet rs = st.executeQuery();
             if (rs.next() != false) {
                hasil = new Organisasi (
                        rs.getString("nama"),
                        password,
                        username,
                        rs.getString("alamat")
                );
                hasil.setId_organisasi(rs.getInt("id_organisasi"));
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
    
}
