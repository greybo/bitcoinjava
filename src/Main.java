import service.OpenBookService;
import service.Pairs;
import service.TradesService;

import java.util.HashMap;


public class Main {


    public static void main(String[] args) {
        OpenBookService obs = new OpenBookService();

        Pairs pair = Pairs.BTC_USD;
//        String method = "trades";
        String method = "order_book";

        Exmo e = new Exmo("K-3e85f38ed3ce354a357ce13953953f90242d9bbd", "S-c87c32ae21bb72eed3f6e94dcc8d1c4869b6dbb8");
        String result = e.Request(method + "/?pair=" + pair, new HashMap<String, String>() {{
            put("limit", "2");
            put("offset", "0");
        }});

       obs.toJsonOpenOrders(result, pair);

//        for (OpenBook t : obs.getAll()) {
//            System.out.println(t.toString());
//            for (BookBid b : t.getBid()) {
//                System.out.println(b.getId() + " " + b.getPrice() + " " +b.getLot()+" "+b.getVol());
//            }
//        }


    }
}

