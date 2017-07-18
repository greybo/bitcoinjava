package entity;

import java.util.ArrayList;

/**
 * Created by m on 18.07.17.
 */
public class OpenBook {

    private String ask_quantity;
    private String ask_amount;
    private String ask_top;
    private String bid_quantity;
    private String bid_amount;
    private String bid_top;
    private ArrayList<double[]> bid;
    private ArrayList<double[]> ask;

    public OpenBook() {
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


    public ArrayList<double[]> getBid() {
        return bid;
    }

    public void setBid(ArrayList<double[]> bid) {
        this.bid = bid;
    }

    public ArrayList<double[]> getAsk() {
        return ask;
    }

    public void setAsk(ArrayList<double[]> ask) {
        this.ask = ask;
    }

    @Override
    public String toString() {
        return "OpenBook{" +
                "ask_quantity='" + ask_quantity + '\'' +
                ", ask_amount='" + ask_amount + '\'' +
                ", ask_top='" + ask_top + '\'' +
                ", bid_quantity='" + bid_quantity + '\'' +
                ", bid_amount='" + bid_amount + '\'' +
                ", bid_top='" + bid_top + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                '}';
    }
}
