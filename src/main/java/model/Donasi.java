package model;

import java.util.Date;

public class Donasi {
    private Campaign Judul;
    private String jenisMakanan;
    private int jumlahDonasi;
    private Date deadline;
    private Donatur namaDonatur;
    private Date tanggal;
    private int idDonasi;

    public Donasi(Campaign Judul, String jenisMakanan, int jumlahDonasi, Date deadline, Donatur namaDonatur, Date tanggal) {
        this.Judul = Judul;
        this.jenisMakanan = jenisMakanan;
        this.jumlahDonasi = jumlahDonasi;
        this.deadline = deadline;
        this.namaDonatur = namaDonatur;
        this.tanggal = tanggal;
    }

    public Donasi() {
    }

    public int getIdDonasi() {
        return idDonasi;
    }

    public void setIdDonasi(int idDonasi) {
        this.idDonasi = idDonasi;
    }
    
    

    public Campaign getJudul() {
        return Judul;
    }

    public void setJudul(Campaign Judul) {
        this.Judul = Judul;
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }

    public void setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan = jenisMakanan;
    }

    public int getJumlahDonasi() {
        return jumlahDonasi;
    }

    public void setJumlahDonasi(int jumlahDonasi) {
        this.jumlahDonasi = jumlahDonasi;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Donatur getNamaDonatur() {
        return namaDonatur;
    }

    public void setNamaDonatur(Donatur namaDonatur) {
        this.namaDonatur = namaDonatur;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }


}
