package kukila.dailyibadah.Adapter.model;

/**
 * Created by Mindha on 18/06/2017.
 */

public class GrafikDetailIbadahModel {
    int id, persen;
    String judul;


    public GrafikDetailIbadahModel(int id, int persen, String judul) {
        this.id = id;
        this.persen = persen;
//        String percent = String.valueOf(persen);
        this.judul = judul;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersen() {
        return persen;
    }

    public void setPersen(int persen) {
        this.persen = persen;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
}
