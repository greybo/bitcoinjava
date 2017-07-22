package entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Ask {

    @DatabaseField(generatedId = true)
    private long id_ask;
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

    public Ask() {
    }

    public Ask(double price, double lot, double vol) {
        this.price = price;
        this.lot = lot;
        this.vol = vol;
    }

    public long getId_ask() {
        return id_ask;
    }

    public void setId_ask(long id_ask) {
        this.id_ask = id_ask;
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

    public long getId_book() {
        return id_book;
    }

    public void setId_book(long id_book) {
        this.id_book = id_book;
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
                "id_ask=" + id_ask +
                ", price=" + price +
                ", lot=" + lot +
                ", vol=" + vol +
                ", openBook=" + openBook +
                ", id_book=" + id_book +
                '}';
    }
}
