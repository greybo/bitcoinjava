package entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by m on 18.07.17.
 */
@DatabaseTable
public class Trades {
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField(columnName = "trade_id",uniqueIndex = true)
    private long tradeId;
    @DatabaseField
    private String type;
    @DatabaseField
    private String quantity;
    @DatabaseField
    private String price;
    @DatabaseField
    private String amount;
    @DatabaseField
    private String date;

    public Trades() {

    }

    public long getTradeId() {
        return tradeId;
    }

    public void setTradeId(long tradeId) {
        this.tradeId = tradeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Trades{" +
                "tradeId='" + tradeId + '\'' +
                ", type='" + type + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                ", amount='" + amount + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
