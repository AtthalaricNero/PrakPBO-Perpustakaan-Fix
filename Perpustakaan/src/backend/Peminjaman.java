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

public class Peminjaman {

    private int idpeminjaman;
    private Pegawai pegawai = new Pegawai();
    private Anggota anggota = new Anggota();
    private Buku buku = new Buku();
    private String tglpinjam;
    private String tglkembali = "";

    public int getIdpeminjaman() {
        return idpeminjaman;
    }

    public void setIdpeminjaman(int idpeminjaman) {
        this.idpeminjaman = idpeminjaman;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public String getTglpinjam() {
        return tglpinjam;
    }

    public void setTglpinjam(String tglpinjam) {
        this.tglpinjam = tglpinjam;
    }

    public String getTglkembali() {
        return tglkembali;
    }

    public void setTglkembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }

    public Peminjaman() {
    }

    public Peminjaman(Pegawai pegawai, Anggota anggota, Buku buku, String tglpinjam, String tglkembali) {
        this.pegawai = pegawai;
        this.anggota = anggota;
        this.buku = buku;
        this.tglpinjam = tglpinjam;
        this.tglkembali = tglkembali;
    }

    public Peminjaman getById(int id) {
        Peminjaman peminjaman = new Peminjaman();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "     p.idpeminjaman AS idpeminjaman, "
                + "     p.tglpinjam AS tglpinjam, "
                + "     p.tglkembali AS tglkembali, "
                + "     peg.idpegawai AS idpegawai, "
                + "     peg.nama AS namapegawai, "
                + "     peg.alamat AS alamatpegawai, "
                + "     ang.idanggota AS idanggota, "
                + "     ang.nama AS namaanggota, "
                + "     ang.alamat AS alamatanggota, "
                + "     b.idbuku AS idbuku, "
                + "     b.judul AS judulbuku, "
                + "     b.penerbit AS penerbitbuku, "
                + "     b.penulis AS penulisbuku "
                + " FROM peminjaman p "
                + " LEFT JOIN pegawai peg ON p.idpegawai = peg.idpegawai "
                + " LEFT JOIN anggota ang ON p.idanggota = ang.idanggota "
                + " LEFT JOIN buku b ON p.idbuku = b.idbuku "
                + " WHERE p.idpeminjaman = '" + id + "' ");

        try {
            while (rs.next()) {
                peminjaman.setIdpeminjaman(rs.getInt("idpeminjaman"));
                peminjaman.setTglpinjam(rs.getString("tglpinjam"));
                peminjaman.setTglkembali(rs.getString("tglkembali"));

                peminjaman.getPegawai().setIdpegawai(rs.getInt("idpegawai"));
                peminjaman.getPegawai().setNama(rs.getString("namapegawai"));
                peminjaman.getPegawai().setAlamat(rs.getString("alamatpegawai"));

                peminjaman.getAnggota().setIdanggota(rs.getInt("idanggota"));
                peminjaman.getAnggota().setNama(rs.getString("namaanggota"));
                peminjaman.getAnggota().setAlamat(rs.getString("alamatanggota"));

                peminjaman.getBuku().setIdbuku(rs.getInt("idbuku"));
                peminjaman.getBuku().setJudul(rs.getString("judulbuku"));
                peminjaman.getBuku().setPenerbit(rs.getString("penerbitbuku"));
                peminjaman.getBuku().setPenulis(rs.getString("penulisbuku"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peminjaman;
    }

    public ArrayList<Peminjaman> getAll() {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "     p.idpeminjaman AS idpeminjaman, "
                + "     p.tglpinjam AS tglpinjam, "
                + "     p.tglkembali AS tglkembali, "
                + "     peg.idpegawai AS idpegawai, "
                + "     peg.nama AS namapegawai, "
                + "     peg.alamat AS alamatpegawai, "
                + "     ang.idanggota AS idanggota, "
                + "     ang.nama AS namaanggota, "
                + "     ang.alamat AS alamatanggota, "
                + "     b.idbuku AS idbuku, "
                + "     b.judul AS judulbuku, "
                + "     b.penerbit AS penerbitbuku, "
                + "     b.penulis AS penulisbuku "
                + " FROM peminjaman p "
                + " LEFT JOIN pegawai peg ON p.idpegawai = peg.idpegawai "
                + " LEFT JOIN anggota ang ON p.idanggota = ang.idanggota "
                + " LEFT JOIN buku b ON p.idbuku = b.idbuku ");

        try {
            while (rs.next()) {
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.setIdpeminjaman(rs.getInt("idpeminjaman"));
                peminjaman.setTglpinjam(rs.getString("tglpinjam"));
                peminjaman.setTglkembali(rs.getString("tglkembali"));

                peminjaman.getPegawai().setIdpegawai(rs.getInt("idpegawai"));
                peminjaman.getPegawai().setNama(rs.getString("namapegawai"));
                peminjaman.getPegawai().setAlamat(rs.getString("alamatpegawai"));

                peminjaman.getAnggota().setIdanggota(rs.getInt("idanggota"));
                peminjaman.getAnggota().setNama(rs.getString("namaanggota"));
                peminjaman.getAnggota().setAlamat(rs.getString("alamatanggota"));

                peminjaman.getBuku().setIdbuku(rs.getInt("idbuku"));
                peminjaman.getBuku().setJudul(rs.getString("judulbuku"));
                peminjaman.getBuku().setPenerbit(rs.getString("penerbitbuku"));
                peminjaman.getBuku().setPenulis(rs.getString("penulisbuku"));

                ListPeminjaman.add(peminjaman);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPeminjaman;
    }

    public ArrayList<Peminjaman> search(String keyword) {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "     p.idpeminjaman AS idpeminjaman, "
                + "     p.tglpinjam AS tglpinjam, "
                + "     p.tglkembali AS tglkembali, "
                + "     peg.idpegawai AS idpegawai, "
                + "     peg.nama AS namapegawai, "
                + "     peg.alamat AS alamatpegawai, "
                + "     ang.idanggota AS idanggota, "
                + "     ang.nama AS namaanggota, "
                + "     ang.alamat AS alamatanggota, "
                + "     b.idbuku AS idbuku, "
                + "     b.judul AS judulbuku, "
                + "     b.penerbit AS penerbitbuku, "
                + "     b.penulis AS penulisbuku "
                + " FROM peminjaman p "
                + " LEFT JOIN pegawai peg ON p.idpegawai = peg.idpegawai "
                + " LEFT JOIN anggota ang ON p.idanggota = ang.idanggota "
                + " LEFT JOIN buku b ON p.idbuku = b.idbuku "
                + "     WHERE p.tglpinjam LIKE '%" + keyword + "%' "
                + "         OR p.tglkembali LIKE '%" + keyword + "%' "
                + "         OR p.idpeminjaman LIKE '%" + keyword + "%' "
                + "         OR b.judul  LIKE '%" + keyword + "%'");

        try {
            while (rs.next()) {
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.setIdpeminjaman(rs.getInt("idpeminjaman"));
                peminjaman.setTglpinjam(rs.getString("tglpinjam"));
                peminjaman.setTglkembali(rs.getString("tglkembali"));

                peminjaman.getPegawai().setIdpegawai(rs.getInt("idpegawai"));
                peminjaman.getPegawai().setNama(rs.getString("namapegawai"));
                peminjaman.getPegawai().setAlamat(rs.getString("alamatpegawai"));

                peminjaman.getAnggota().setIdanggota(rs.getInt("idanggota"));
                peminjaman.getAnggota().setNama(rs.getString("namaanggota"));
                peminjaman.getAnggota().setAlamat(rs.getString("alamatanggota"));

                peminjaman.getBuku().setIdbuku(rs.getInt("idbuku"));
                peminjaman.getBuku().setJudul(rs.getString("judulbuku"));
                peminjaman.getBuku().setPenerbit(rs.getString("penerbitbuku"));
                peminjaman.getBuku().setPenulis(rs.getString("penulisbuku"));

                ListPeminjaman.add(peminjaman);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListPeminjaman;
    }

    public void save() {
        if (getById(idpeminjaman).getIdpeminjaman() == 0) {
            String SQL = "INSERT INTO peminjaman (idpegawai, idanggota, idbuku, tglpinjam) VALUES("
                    + " '" + this.getPegawai().getIdpegawai() + "', "
                    + " '" + this.getAnggota().getIdanggota() + "', "
                    + " '" + this.getBuku().getIdbuku() + "', "
                    + " '" + this.tglpinjam + "' "
                    + " )";
            this.idpeminjaman = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE peminjaman SET "
                    + " tglkembali = '" + this.tglkembali + "' "
                    + " WHERE idpeminjaman = '" + this.idpeminjaman + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete() {
        String SQL = "DELETE FROM peminjaman WHERE idpeminjaman = '" + this.idpeminjaman + "'";
        DBHelper.executeQuery(SQL);
    }
}
