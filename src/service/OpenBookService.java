package service;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import entity.OpenBook;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by m on 18.07.17.
 */
public class OpenBookService {
    private final String url = "jdbc:sqlite:main.sqlite";
    private ConnectionSource source;
    private Dao<OpenBook, String> dao;

    public OpenBookService() {
        try {
            source = new JdbcConnectionSource(url);
            dao = DaoManager.createDao(source, OpenBook.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<OpenBook> getAll() {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void create(OpenBook openBook) {
        try {
            dao.create(openBook);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long getCount() {
        try {
            return dao.countOf();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<OpenBook> toJsonOpenOrders(String strJson, Pairs pair) {
        ArrayList<OpenBook> list = new ArrayList<>();
        JSONObject dataJsonObj = new JSONObject(strJson);

        JSONObject object = dataJsonObj.getJSONObject(pair.toString());
//        System.out.println(object.toString());

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


//        openBook.setBid(getStrings(bid));

//            arrayList=new ArrayList<>();
//            for (int i = 0; i < bid.length(); i++) {
//                arrayList.add(ask.getString(i));
//            }
//            openBook.setAsk(arrayList);

//        } catch (JSONException e) {
//            System.out.println("wrong");
//        }


//        list.add(openBook);
        create(openBook);
//        }
        return list;
    }

    private static ArrayList<double[]> getStrings(JSONArray array) {
        ArrayList<double[]> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            JSONArray a = array.getJSONArray(i);
            list.add(new double[]{a.getDouble(0), a.getDouble(1), a.getDouble(2)});

        }
        return list;
    }
}
