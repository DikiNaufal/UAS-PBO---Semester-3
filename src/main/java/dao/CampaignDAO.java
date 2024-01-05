/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Campaign;
import model.Organisasi;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Donasi;
import model.Donatur;

/**
 *
 * @author Administrator
 */
public class CampaignDAO extends BaseDAO {
    private static String DB_NAME = "foodshare";
    private static String DB_HOST = "localhost";
    private static String DB_USER = "root";
    private static String DB_PASS = "";
    private static PreparedStatement st;
    private static Connection con;
    
    
    public static void saveCampaign(Campaign campaign, Donasi donasi){
        try {
            con = getCon();
            String query = "INSERT INTO campaign (id_campaign, id_organisasi, nama_judul, jenis_makanan, jumlah_donasi, deadline, nama_donatur, tanggal)"
                    + " values (%d, '%d', '%s', '%s', %d, %s, '%s', %s)";
            query = String.format(query,
        campaign.getId_campaign(),
        campaign.getIdOrganisasi(),
        campaign.getJudul(),
        campaign.getjenisMakanan(),
        campaign.getjumlahDonasi(),
        campaign.getDeadline(),
        campaign.getNamaDonatur(),
           donasi.getTanggal());
            st = con.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error inserting data" + e.getMessage());
        } finally {
            closeCon(con);
        }
    }
    public static void updateCampaign(Campaign campaign, Donasi donasi, Donatur donatur, Organisasi organisasi) {
        String query = "UPDATE donasi SET Judul=?, jenisMakanan=?, jumlahDonasi=?, NamaDonatur =?,tanggal = ?, id_organisasi=?, id_campaign=? WHERE id=?";
        try {
            con = getCon();
            st = con.prepareStatement(query);
            st.setString(1, campaign.getJudul());
            st.setString(2, campaign.getjenisMakanan());
            st.setInt(3, campaign.getjumlahDonasi());
            st.setString(4, campaign.getNamaDonatur().getNama());
            st.setDate(5, (Date) donasi.getTanggal());
            st.setInt(6, organisasi.getId_organisasi());
            st.setInt(7, campaign.getId_campaign());
            st.setInt(8, campaign.getId_campaign());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
    }

    public static void delete(int id) {
        String query = "DELETE FROM campain ?";
        try {
            con = getCon();
            st = con.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
    }

    public ArrayList<Campaign> selectCampaign(Campaign campaign, Donatur donatur){
        var donasiList = new ArrayList<Campaign>();
        try {
            String query = "SELECT * FROM donasi";
            con = getCon();
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String namaJudul = resultSet.getString("Judul");
                String jenisMakanan = resultSet.getString("jenisMakanan");
                int jumlahDonasi = resultSet.getInt("jumlahDonasi");
                java.sql.Date deadline = resultSet.getDate("deadline");
                String NamaDonatur = resultSet.getString("NamaDonatur");
                java.sql.Date tanggal = resultSet.getDate("tanggal");
               
               

                Donasi donasi = new Donasi(campaign, jenisMakanan, jumlahDonasi, deadline, donatur, tanggal);
                donasiList.add(campaign);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }

        return donasiList;
    }
    
}