package model;


import java.util.Date;

public class Campaign {
    private String nama;
    private String jenisMakanan;
    private int jumlahDonasi;
    private Date deadline;
    private Organisasi pemilik; // Foreign key dari class Organisasi
    private int id_campaign;
    private String judul;
    private Organisasi idOrganisasi;
    private Donatur namaDonatur;

    public Donatur getNamaDonatur() {
        return namaDonatur;
    }

    public void setNamaDonatur(Donatur namaDonatur) {
        this.namaDonatur = namaDonatur;
    }

    
    public Organisasi getIdOrganisasi() {
        return idOrganisasi;
    }

    public void setIdOrganisasi(Organisasi idOrganisasi) {
        this.idOrganisasi = idOrganisasi;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getId_campaign() {
        return id_campaign;
    }

    public void setId_campaign(int id_campaign) {
        this.id_campaign = id_campaign;
    }
    

    // Constructor
    public Campaign(String nama, String jenisMakanan, int jumlahDonasi,Date deadline, Organisasi pemilik) {
        this.nama = nama;
        this.jenisMakanan = jenisMakanan;
        this.jumlahDonasi = jumlahDonasi;
        this.deadline = deadline;
        this.pemilik = pemilik;
    }

    // Getter

    public String getNama() {
        return nama;
    }

    public String getjenisMakanan() {
    return jenisMakanan;
    }
    public int getjumlahDonasi() {
    return jumlahDonasi;
    }
    public Date getDeadline() {
        return deadline;
    }

    // Setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setjenisMakanan(String jenisMakanan) {
    this.jenisMakanan = jenisMakanan;
    }
    public void setjumlahDonasi(int jumlahDonasi) {
    this.jumlahDonasi = jumlahDonasi;
    }
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Organisasi getPemilik() {
        return pemilik;
    }

    public void setPemilik(Organisasi pemilik) {
        this.pemilik = pemilik;
    }    
}