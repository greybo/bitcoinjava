package entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Ask {

    @DatabaseField(generatedId = true)
    private long idAsk;
    @DatabaseField(unique = true)
    private double price;
    @DatabaseField
    private double lot;
    @DatabaseField
    private double vol;
    @DatabaseField(foreign = true)
    private OpenBook openBook;
    @DatabaseField
    private long idBook;

    public Ask() {
    }

    public Ask(double price, double lot, double vol) {
        this.price = price;
        this.lot = lot;
        this.vol = vol;
    }

    public long getIdAsk() {
        return idAsk;
    }

    public void setIdAsk(long idAsk) {
        this.idAsk = idAsk;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getLot() {
        return lot;
    }

    public void setLot(double lot) {
        this.lot = lot;
    }

    public double getVol() {
        return vol;
    }

    public void setVol(double vol) {
        this.vol = vol;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public OpenBook getOpenBook() {
        return openBook;
    }

    public void setOpenBook(OpenBook openBook) {
        this.openBook = openBook;
    }

    @Override
    public String toString() {
        return "Ask{" +
                "idAsk=" + idAsk +
                ", price=" + price +
                ", lot=" + lot +
                ", vol=" + vol +
                ", openBook=" + openBook +
                ", idBook=" + idBook +
                '}';
    }
}
