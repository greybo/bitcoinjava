import entity.OpenBook;
import entity.Trades;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ToJSON {

    private static JSONObject dataJsonObj;
    private static JSONArray array;

    public static ArrayList<Trades> toJsonTrades(String strJson, Pairs pair) {
        ArrayList<Trades> list = new ArrayList<>();

        dataJsonObj = new JSONObject(strJson);
        array = dataJsonObj.getJSONArray(pair.toString());

        for (int i = 0; i < array.length(); i++) {
            Trades trades = new Trades();
            JSONObject object = array.getJSONObject(i);

            trades.setDate(object.get("date").toString());
            trades.setAmount(object.get("amount").toString());
            trades.setTrade_id(object.get("trade_id").toString());
            trades.setQuantity(object.get("quantity").toString());
            trades.setPrice(object.get("price").toString());
            trades.setType(object.get("type").toString());
            list.add(trades);
        }
        return list;
    }

    public static ArrayList<OpenBook> toJsonOpenOrders(String strJson, Pairs pair) {
        ArrayList<OpenBook> list = new ArrayList<>();
        dataJsonObj = new JSONObject(strJson);

        JSONObject object = dataJsonObj.getJSONObject(pair.toString());
        System.out.println(object.toString());

        OpenBook openBook = new OpenBook();

//        try {
            openBook.setAsk_quantity(object.get("ask_quantity").toString());
            openBook.setAsk_amount(object.get("ask_amount").toString());
            openBook.setAsk_top(object.get("ask_top").toString());

            openBook.setBid_amount(object.get("bid_amount").toString());
            openBook.setBid_quantity(object.get("bid_quantity").toString());
            openBook.setBid_top(object.get("bid_top").toString());

            JSONArray bid = object.getJSONArray("bid");
            JSONArray ask = object.getJSONArray("ask");


            openBook.setBid(getStrings(bid) );

//            arrayList=new ArrayList<>();
//            for (int i = 0; i < bid.length(); i++) {
//                arrayList.add(ask.getString(i));
//            }
//            openBook.setAsk(arrayList);

//        } catch (JSONException e) {
//            System.out.println("wrong");
//        }


        list.add(openBook);
//        }
        return list;
    }

    private static ArrayList<double[]> getStrings(JSONArray array) {
        ArrayList<double[]>list=new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            JSONArray a=array.getJSONArray(i);
            list.add(new double[]{a.getDouble(0),a.getDouble(1),a.getDouble(2)});

        }
        return list;
    }

}
