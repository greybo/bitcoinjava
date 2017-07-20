import entity.OpenBook;
import dao.OpenBookDao;
import dao.Pairs;
import dao.TradesDao;
import entity.Trades;

import java.util.ArrayList;
import java.util.HashMap;


public class Main {


    public static void main(String[] args) {
//        OpenBookDao obs = new OpenBookDao();
        TradesDao ts = new TradesDao();
        Pairs pair = Pairs.BTC_USD;
        String method = "trades";
//        String method = "order_book";

        Exmo e = new Exmo("K-3e85f38ed3ce354a357ce13953953f90242d9bbd", "S-c87c32ae21bb72eed3f6e94dcc8d1c4869b6dbb8");
        String result = e.Request(method + "/?pair=" + pair, new HashMap<String, String>() {{
            put("limit", "50");
            put("offset", "0");
        }});
        ts.jsonTrades(result, pair);
//        ArrayList<Trades> trades = ts.jsonTrades(result, pair);
//        for (Trades t : ts.getAll()) {
//            System.out.println(t.toString());
//        }


//        OpenBook openBook = obs.toJsonOpenOrders(result, pair);
//        for (OpenBook t : obs.getAll()) {
//            System.out.println(t.toString());

//            for (BookBid b : t.getBid()) {
//                System.out.println(b.getId() + " " + b.getPrice() + " " +b.getLot()+" "+b.getVol());
//            }
//        }



    }
}

