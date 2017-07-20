package entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class BookBid {
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private double price;
    @DatabaseField
    private double lot;
    @DatabaseField
    private double vol;

    public BookBid() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "BookBid{" +
                "id=" + id +
                ", price=" + price +
                ", lot=" + lot +
                ", vol=" + vol +
                '}';
    }
}
