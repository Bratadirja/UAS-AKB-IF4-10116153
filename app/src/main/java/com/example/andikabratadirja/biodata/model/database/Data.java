package com.example.andikabratadirja.biodata.model.database;

/*

 Tanggal Pengerjaan : 11-08-2019
 NIM : 10116153
 NAMA : Andika Bratadirja SJ
 KELAS : IF - 4

 */

public class Data {
    private String Id;
    private String Nim;
    private String Nama;
    private String Kelas;
    private String Telp;
    private String Email;
    private String Instagram;
    private String Facebook;

    public Data() {
    }

    public Data(String Id, String Nim, String Nama, String Kelas, String Telp, String Email, String Instagram, String Facebook) {
        this.setNim(Id);
        this.setNim(Nim);
        this.setNama(Nama);
        this.setKelas(Kelas);
        this.setTelp(Telp);
        this.setEmail(Email);
        this.setInstagram(Instagram);
        this.setFacebook(Facebook);
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNim() {
        return Nim;
    }

    public void setNim(String nim) {
        Nim = nim;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getKelas() {
        return Kelas;
    }

    public void setKelas(String kelas) {
        Kelas = kelas;
    }

    public String getTelp() {
        return Telp;
    }

    public void setTelp(String telp) {
        Telp = telp;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getInstagram() {
        return Instagram;
    }

    public void setInstagram(String instagram) {
        Instagram = instagram;
    }

    public String getFacebook() {
        return Facebook;
    }

    public void setFacebook(String facebook) {
        Facebook = facebook;
    }
}
