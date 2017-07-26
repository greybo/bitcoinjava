package entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Bid {
    @DatabaseField(generatedId = true)
    private long idBid;
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

    public Bid() {
    }

    public Bid(double price, double lot, double vol) {
        this.price = price;
        this.lot = lot;
        this.vol = vol;
    }

    public long getIdBid() {
        return idBid;
    }

    public void setIdBid(long idBid) {
        this.idBid = idBid;
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

    public OpenBook getOpenBook() {
        return openBook;
    }

    public void setOpenBook(OpenBook openBook) {
        this.openBook = openBook;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "idBid=" + idBid +
                ", price=" + price +
                ", lot=" + lot +
                ", vol=" + vol +
                ", idBook=" + idBook +
                '}';
    }
}
