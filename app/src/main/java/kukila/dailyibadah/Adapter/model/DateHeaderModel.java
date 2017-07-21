package kukila.dailyibadah.Adapter.model;

/**
 * Created by Mindha on 21/07/2017.
 */

public class DateHeaderModel {
    int idMasehi, idHijriah, tglMasehi, tglHijriah;
    String blnMasehi, thnMasehi, blnHijriah, thnHijriah;


    public DateHeaderModel(int tglMasehi, int tglHijriah, String blnMasehi, String thnMasehi, String blnHijriah, String thnHijriah) {
        this.tglMasehi = tglMasehi;
        this.tglHijriah = tglHijriah;
        this.blnMasehi = blnMasehi;
        this.thnMasehi = thnMasehi;
        this.blnHijriah = blnHijriah;
        this.thnHijriah = thnHijriah;
    }

    public DateHeaderModel(int idMasehi, int tglMasehi, String blnMasehi, String thnMasehi) {
        this.idMasehi = idMasehi;
        this.tglMasehi = tglMasehi;
        this.blnMasehi = blnMasehi;
        this.thnMasehi = thnMasehi;
    }

    public DateHeaderModel(int tglHijriah, String blnHijriah, String thnHijriah) {
        this.tglHijriah = tglHijriah;
        this.blnHijriah = blnHijriah;
        this.thnHijriah = thnHijriah;
    }

    public int getIdMasehi() {
        return idMasehi;
    }

    public void setIdMasehi(int idMasehi) {
        this.idMasehi = idMasehi;
    }

    public int getIdHijriah() {
        return idHijriah;
    }

    public void setIdHijriah(int idHijriah) {
        this.idHijriah = idHijriah;
    }

    public int getTglMasehi() {
        return tglMasehi;
    }

    public void setTglMasehi(int tglMasehi) {
        this.tglMasehi = tglMasehi;
    }

    public int getTglHijriah() {
        return tglHijriah;
    }

    public void setTglHijriah(int tglHijriah) {
        this.tglHijriah = tglHijriah;
    }

    public String getBlnMasehi() {
        return blnMasehi;
    }

    public void setBlnMasehi(String blnMasehi) {
        this.blnMasehi = blnMasehi;
    }

    public String getThnMasehi() {
        return thnMasehi;
    }

    public void setThnMasehi(String thnMasehi) {
        this.thnMasehi = thnMasehi;
    }

    public String getBlnHijriah() {
        return blnHijriah;
    }

    public void setBlnHijriah(String blnHijriah) {
        this.blnHijriah = blnHijriah;
    }

    public String getThnHijriah() {
        return thnHijriah;
    }

    public void setThnHijriah(String thnHijriah) {
        this.thnHijriah = thnHijriah;
    }
}
