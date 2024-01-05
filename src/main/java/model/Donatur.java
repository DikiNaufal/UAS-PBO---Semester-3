package model;

public class Donatur {
    private String nama;
    private String password;
    private int idDonatur;
    
    public void setIdDonatur(int idDonatur){
        this.idDonatur = idDonatur;
        
    }
            
        public int getIdDonatur(){
            return idDonatur;
        }  

    public Donatur(String nama, String password) {
        this.nama = nama;
        this.password = password;
    }
    
 

    public String getNama() {
        return nama;
    }

    public String getPassword() {
        return password;
    }


    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}