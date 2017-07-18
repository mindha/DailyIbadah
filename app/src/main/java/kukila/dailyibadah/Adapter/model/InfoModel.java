package kukila.dailyibadah.Adapter.model;

/**
 * Created by Mindha on 18/06/2017.
 */

public class InfoModel {
    int id;
    String judul;

    public InfoModel(int id, String judul) {
        this.id = id;
        this.judul = judul;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
}
