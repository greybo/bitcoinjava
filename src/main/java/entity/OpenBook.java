package entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

/**
 * Created by m on 18.07.17.
 */
@DatabaseTable(tableName = "openbook")
public class OpenBook {

    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private String askQuantity;
    @DatabaseField
    private String askAmount;
    @DatabaseField
    private String askTop;
    @DatabaseField
    private String bidQuantity;
    @DatabaseField
    private String bidAmount;
    @DatabaseField
    private String bidTop;
    @ForeignCollectionField(eager = true)
    private Collection<Bid> bid;
    @ForeignCollectionField(eager = true)
    private Collection<Ask> ask;

    public OpenBook() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAskQuantity() {
        return askQuantity;
    }

    public void setAskQuantity(String askQuantity) {
        this.askQuantity = askQuantity;
    }

    public String getAskAmount() {
        return askAmount;
    }

    public void setAskAmount(String askAmount) {
        this.askAmount = askAmount;
    }

    public String getAskTop() {
        return askTop;
    }

    public void setAskTop(String askTop) {
        this.askTop = askTop;
    }

    public String getBidQuantity() {
        return bidQuantity;
    }

    public void setBidQuantity(String bidQuantity) {
        this.bidQuantity = bidQuantity;
    }

    public String getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(String bidAmount) {
        this.bidAmount = bidAmount;
    }

    public String getBidTop() {
        return bidTop;
    }

    public void setBidTop(String bidTop) {
        this.bidTop = bidTop;
    }

    public Collection<Bid> getBid() {
        return bid;
    }

    public void setBid(Collection<Bid> bid) {
        this.bid = bid;
    }

    public Collection<Ask> getAsk() {
        return ask;
    }

    public void setAsk(Collection<Ask> ask) {
        this.ask = ask;
    }

    @Override
    public String toString() {
        return "OpenBook{" +
                "id=" + id +
                ", askQuantity='" + askQuantity + '\'' +
                ", askAmount='" + askAmount + '\'' +
                ", askTop='" + askTop + '\'' +
                ", bidQuantity='" + bidQuantity + '\'' +
                ", bidAmount='" + bidAmount + '\'' +
                ", bidTop='" + bidTop + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                '}';
    }
}
