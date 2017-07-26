package kukila.dailyibadah.Adapter.model;

/**
 * Created by Mindha on 17/07/2017.
 */

public class IbadahWajibModel {
    int id;
    String namaIbadah, waktu, menit, kategori;

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getMenit() {
        return menit;
    }

    public void setMenit(String menit) {
        this.menit = menit;
    }

    public IbadahWajibModel(int id, String namaIbadah, String waktu, String menit, String kategori) {

        this.id = id;
        this.namaIbadah = namaIbadah;
        this.waktu = waktu;
        this.menit = menit;
        this.kategori = kategori;
    }

    public IbadahWajibModel(String namaIbadah) {
        this.namaIbadah = namaIbadah;
    }

    public String getNamaIbadah() {
        return namaIbadah;
    }

    public void setNamaIbadah(String namaIbadah) {
        this.namaIbadah = namaIbadah;
    }
}
