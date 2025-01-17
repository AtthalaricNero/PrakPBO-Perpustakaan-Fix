/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class Pegawai {

    private int idpegawai;
    private String nama;
    private String alamat;
    private String notelp;
    private String jabatan;
    private String username;
    private String password;

    public Pegawai() {
    }

    public Pegawai(String nama, String alamat, String notelp, String jabatan, String username, String password) {
        this.nama = nama;
        this.alamat = alamat;
        this.notelp = notelp;
        this.jabatan = jabatan;
        this.username = username;
        this.password = password;
    }

    public int getIdpegawai() {
        return idpegawai;
    }

    public void setIdpegawai(int idpegawai) {
        this.idpegawai = idpegawai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Pegawai getById(int id) {
        Pegawai pg = new Pegawai();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pegawai "
                + " WHERE idpegawai = '" + id + "'");

        try {
            while (rs.next()) {
                pg = new Pegawai();
                pg.setIdpegawai(rs.getInt("idpegawai"));
                pg.setNama(rs.getString("nama"));
                pg.setAlamat(rs.getString("alamat"));
                pg.setNotelp(rs.getString("notelp"));
                pg.setJabatan(rs.getString("jabatan"));
                pg.setUsername(rs.getString("username"));
                pg.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pg;
    }

    public ArrayList<Pegawai> getAll() {
        ArrayList<Pegawai> ListPegawai = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pegawai");

        try {
            while (rs.next()) {
                Pegawai pg = new Pegawai();
                pg.setIdpegawai(rs.getInt("idpegawai"));
                pg.setNama(rs.getString("nama"));
                pg.setAlamat(rs.getString("alamat"));
                pg.setNotelp(rs.getString("notelp"));
                pg.setJabatan(rs.getString("jabatan"));
                pg.setUsername(rs.getString("username"));
                pg.setPassword(rs.getString("password"));

                ListPegawai.add(pg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPegawai;
    }

    public ArrayList<Pegawai> search(String keyword) {
        ArrayList<Pegawai> ListPegawai = new ArrayList();

        String sql = "SELECT * FROM pegawai WHERE "
                + " nama LIKE '%" + keyword + "%'"
                + " OR alamat LIKE '%" + keyword + "%' "
                + " OR notelp LIKE '%" + keyword + "%' "
                + " OR jabatan LIKE '%" + keyword + "%' "
                + " OR username LIKE '%" + keyword + "%' ";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Pegawai pg = new Pegawai();
                pg.setIdpegawai(rs.getInt("idpegawai"));
                pg.setNama(rs.getString("nama"));
                pg.setAlamat(rs.getString("alamat"));
                pg.setNotelp(rs.getString("notelp"));
                pg.setJabatan(rs.getString("jabatan"));
                pg.setUsername(rs.getString("username"));
                pg.setPassword(rs.getString("password"));

                ListPegawai.add(pg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListPegawai;
    }

    public void save() {
        if (getById(idpegawai).getIdpegawai() == 0) {
            String SQL = "INSERT INTO pegawai (nama, alamat, notelp, jabatan, username, password) VALUES("
                    + " '" + this.nama + "', "
                    + " '" + this.alamat + "', "
                    + " '" + this.notelp + "', "
                    + " '" + this.jabatan + "', "
                    + " '" + this.username + "', "
                    + " '" + this.password + "' "
                    + ")";
            this.idpegawai = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE pegawai SET "
                    + " nama = '" + this.nama + "', "
                    + " alamat = '" + this.alamat + "', "
                    + " telepon = '" + this.notelp + "', "
                    + " jabatan = '" + this.jabatan + "', "
                    + " username = '" + this.username + "', "
                    + " password = '" + this.password + "'"
                    + " WHERE idpegawai = '" + this.idpegawai + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM pegawai WHERE idpegawai = '" + this.idpegawai + "'";
        DBHelper.executeQuery(SQL);
    }
}
