package entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;

/**
 * Created by m on 18.07.17.
 */
@DatabaseTable(tableName = "openbook")
public class OpenBook {

    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private String ask_quantity;
    @DatabaseField
    private String ask_amount;
    @DatabaseField
    private String ask_top;
    @DatabaseField
    private String bid_quantity;
    @DatabaseField
    private String bid_amount;
    @DatabaseField
    private String bid_top;
    @DatabaseField(columnName = "bid", foreign = true)
    private ArrayList<BookBid> bid;

//    @ForeignCollectionField
//    private ArrayList<double[]> ask;

    public OpenBook() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAsk_quantity() {
        return ask_quantity;
    }

    public void setAsk_quantity(String ask_quantity) {
        this.ask_quantity = ask_quantity;
    }

    public String getAsk_amount() {
        return ask_amount;
    }

    public void setAsk_amount(String ask_amount) {
        this.ask_amount = ask_amount;
    }

    public String getAsk_top() {
        return ask_top;
    }

    public void setAsk_top(String ask_top) {
        this.ask_top = ask_top;
    }

    public String getBid_quantity() {
        return bid_quantity;
    }

    public void setBid_quantity(String bid_quantity) {
        this.bid_quantity = bid_quantity;
    }

    public String getBid_amount() {
        return bid_amount;
    }

    public void setBid_amount(String bid_amount) {
        this.bid_amount = bid_amount;
    }

    public String getBid_top() {
        return bid_top;
    }

    public void setBid_top(String bid_top) {
        this.bid_top = bid_top;
    }

    public ArrayList<BookBid> getBid() {
        return bid;
    }

    public void setBid(ArrayList<BookBid> bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "OpenBook{" +
                "id=" + id +
                ", ask_quantity='" + ask_quantity + '\'' +
                ", ask_amount='" + ask_amount + '\'' +
                ", ask_top='" + ask_top + '\'' +
                ", bid_quantity='" + bid_quantity + '\'' +
                ", bid_amount='" + bid_amount + '\'' +
                ", bid_top='" + bid_top + '\'' +
                ", bid=" + bid +
                '}';
    }
}
