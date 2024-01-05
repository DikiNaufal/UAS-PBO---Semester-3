/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.sun.javafx.font.FontConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Campaign;
import model.Donasi;
import model.Donatur;

public class DonasiDAO extends BaseDAO {
    private static String DB_NAME = "foodshare";
    private static String DB_HOST = "localhost";
    private static String DB_USER = "root";
    private static String DB_PASS = "";
    
    public static Connection getCon() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + ":3306/" + DB_NAME, DB_USER, DB_PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public void saveDonation(Donasi donasi, Campaign campaign, Donatur donatur) {
        try (Connection con = getCon();
             PreparedStatement st = con.prepareStatement(
                     "INSERT INTO donasi (Judul, jenisMakanan, jumlahDonasi, deadline, NamaDonatur, tanggal, id_donasi, id_donatur, id_campaign) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            st.setString(1, campaign.getJudul());
            st.setString(2, donasi.getJenisMakanan());
            st.setInt(3, donasi.getJumlahDonasi());
            st.setDate(4, new java.sql.Date(donasi.getDeadline().getTime()));
            st.setString(5, donatur.getNama());
            st.setDate(6, new java.sql.Date(donasi.getTanggal().getTime()));
            st.setInt(7, donatur.getIdDonatur());
            st.setInt(8, campaign.getId_campaign());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateDonation(Donasi donasi, Campaign campaign, Donatur donatur) {
        String query = "UPDATE donasi SET Judul=?, jenisMakanan=?, jumlahDonasi=?, deadline=?, NamaDonatur=?, tanggal=?, id_donatur=?, id_campaign=? WHERE id=?";
        try (Connection con = getCon();
             PreparedStatement st = con.prepareStatement(query)) {
            st.setString(1, campaign.getJudul());
            st.setString(2, donasi.getJenisMakanan());
            st.setInt(3, donasi.getJumlahDonasi());
            st.setDate(4, new java.sql.Date(donasi.getDeadline().getTime()));
            st.setString(5, donatur.getNama());
            st.setDate(6, new java.sql.Date(donasi.getTanggal().getTime()));
            st.setInt(7, donatur.getIdDonatur());
            st.setInt(8, campaign.getId_campaign());
            st.setInt(9, donasi.getIdDonasi());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM donasi WHERE id=?";
        try (Connection con = getCon();
             PreparedStatement st = con.prepareStatement(query)) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Donasi> getAllDonations(Campaign campaign, Donatur donatur) {
        List<Donasi> donasiList = new ArrayList<>();
        String query = "SELECT * FROM donasi";
        try (Connection con = getCon();
             PreparedStatement st = con.prepareStatement(query);
             ResultSet resultSet = st.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String Judul = resultSet.getString("Judul");
                String jenisMakanan = resultSet.getString("jenisMakanan");
                int jumlahDonasi = resultSet.getInt("jumlahDonasi");
                java.sql.Date deadline = resultSet.getDate("deadline");
                String namaDonatur = resultSet.getString("NamaDonatur");
                java.sql.Date tanggal = resultSet.getDate("tanggal");

                Donasi donasi = new Donasi(campaign, jenisMakanan, jumlahDonasi, deadline, donatur, tanggal);
                donasiList.add(donasi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return donasiList;
    }
}
