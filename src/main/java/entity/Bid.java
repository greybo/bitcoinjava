package entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Bid {
    @DatabaseField(generatedId = true)
    private long id_bid;
    @DatabaseField(unique = true)
    private double price;
    @DatabaseField
    private double lot;
    @DatabaseField
    private double vol;
    @DatabaseField(foreign = true)
    private OpenBook openBook;
    @DatabaseField
    private long id_book;

    public Bid() {
    }

    public Bid(double price, double lot, double vol) {
        this.price = price;
        this.lot = lot;
        this.vol = vol;
    }

    public long getId_bid() {
        return id_bid;
    }

    public void setId_bid(long id_bid) {
        this.id_bid = id_bid;
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

    public long getId_book() {
        return id_book;
    }

    public void setId_book(long id_book) {
        this.id_book = id_book;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id_bid=" + id_bid +
                ", price=" + price +
                ", lot=" + lot +
                ", vol=" + vol +
                ", id_book=" + id_book +
                '}';
    }
}
