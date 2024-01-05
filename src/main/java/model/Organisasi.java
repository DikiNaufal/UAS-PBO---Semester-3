package model;

public class Organisasi {
   private String nama;
    private String password;
//    private ArrayList<Campaign> daftarCampaign = new ArrayList<>();
    private String username;
    private String alamat;
    private int id_organisasi;

    public int getId_organisasi() {
        return id_organisasi;
    }

    public void setId_organisasi(int id_organisasi) {
        this.id_organisasi = id_organisasi;
    }
   

    public Organisasi(String nama, String password, String username, String alamat) {
        this.nama = nama;
        this.password = password;
        this.username = username;
        this.alamat = alamat;
    }
    

    public Organisasi(String nama, String password) {
        this.nama = nama;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

//    public List<Campaign> getDaftarCampaign() {
//        return daftarCampaign;
//    }

//    public void buatCampaign(String judul, String deskripsi) {
//        Campaign campaign = new Campaign(judul, deskripsi);
//        daftarCampaign.add(campaign);
//    }

//    static class Campaign {
//        private String judul;
//        private String deskripsi;
//
//        public Campaign(String judul, String deskripsi) {
//            this.judul = judul;
//            this.deskripsi = deskripsi;
//        }
//
//        public String getJudul() {
//            return judul;
//        }
//
//        public String getDeskripsi() {
//            return deskripsi;
//        }
//    }

    
}