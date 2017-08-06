package entity;

public class CalcOrder {

    private String price;
    private String quantity;
    private String amount;
    private String type;

    public CalcOrder() {
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CalcByLimit{" +
                "price=" + price +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
