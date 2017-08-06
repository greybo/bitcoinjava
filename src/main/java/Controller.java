import dao.*;
import entity.CalcOrder;
import entity.OpenBook;
import entity.Trades;
import entity.UserInfo;
import utils.Pairs;

import java.util.HashMap;

public class Controller {
    private Pairs pair;
    private AbsDao absDao;
    private TradesDao trades;
    private OpenBookDao openBookDao;
    private UserInfoDao userInfoDao;
    private OpenBook openBook;

    public Controller() {
    }

    public Controller(Pairs pair) {
        this.pair = pair;
        this.absDao = new AbsDao();
        absDao.setPair(pair);
        trades = new TradesDao();
        openBookDao = new OpenBookDao();
        userInfoDao = new UserInfoDao();
    }

    public void sendRequest() {
        for (Trades t : trades.request(pair)) {
            System.out.println("=================================Trades==============================\n" + t);
        }
    }

    public UserInfo userInfo() {
        UserInfo userInfo = userInfoDao.request();
        System.out.println("=================================UserInfo==============================\n" + userInfo);
        return userInfo;
    }

    public void createOrderTopLimit(final String type, final String quantity) {
        final String priceTop = requestOpenBook().getBidTop();
        createOrder(type, quantity, priceTop);
    }

    public void createOrder(final String type, final String quantity, final String price) {
        String json = absDao.makeRequest("order_create", new HashMap<String, String>() {{
            put("quantity", String.valueOf(quantity));
            put("price", String.valueOf(price));
            put("type", type);
        }});
        System.out.println("================================CreateOrder============================\n"
                + "bidTop: " + price
                + "\ncreateOrder: " + json);
    }

    public void userTrades() {
        String json = absDao.makeRequest("user_trades", new HashMap<String, String>() {{
            put("pair", pair.toString());//"BTC_USD,BTC_EUR"
            put("limit", "1");//last order
//           put("offset", "0");
        }});
        System.out.println("================================userTrades============================\n"
                + "\nuserTrades: " + json);
    }

    public OpenBook requestOpenBook() {
        OpenBook o = openBookDao.request(pair);
        System.out.println("=================================requestOpenBook==============================" +
                "\nrequestOpenBook: " + openBookDao.getLastRow());
        return o;
    }

    public void requiredAmount(final String quantity) {
        String json = absDao.makeRequest("required_amount", new HashMap<String, String>() {{
            put("pair", pair.toString());//"BTC_USD,BTC_EUR"
            put("quantity", quantity);
        }});
        System.out.println("=================================requiredAmount==============================" +
                "\n" + json);
    }

    public void userOpenOrder() {
        String json = absDao.makeRequest("user_open_orders");
        System.out.println("=================================userOpenOrder==============================" +
                "\nuserOpenOrder: " + json);
//        return o;
    }

    public CalcOrder calculateQuantity(String amound, double price) {
        return calculateQuantity(amound, null, price);
    }

    public CalcOrder calculateQuantity(String amound, String type) {
        return calculateQuantity(amound, type, 0);
    }

    public CalcOrder calculateQuantity(String amound, String type, double price) {
        OpenBook o = requestOpenBook();
        CalcOrder c = new CalcOrder();
        c.setAmount(amound);
        c.setType(type);
        if (type == null) {
            c.setPrice(String.valueOf(price));
        } else {
            if (type.equals("buy")) {
                c.setPrice(o.getBidTop());
            }
            if (type.equals("sell")) {
                c.setPrice(o.getAskTop());
            }
        }
        double quantity = Double.parseDouble(c.getAmount()) / Double.parseDouble(c.getPrice());
        c.setQuantity(String.valueOf(quantity));
        System.out.println("=================================calculatePriceByLimit==============================" +
                "\n " + c.toString());
        return c;
    }

}
