package dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import entity.BookBid;
import entity.OpenBook;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by m on 18.07.17.
 */
public class OpenBookDao {
    private final String url = "jdbc:sqlite:bitcoin.sqlite";
    private ConnectionSource source;
    private Dao<OpenBook, String> dao;

    public OpenBookDao() {
        try {
            source = new JdbcConnectionSource(url);
            dao = DaoManager.createDao(source, OpenBook.class);
            TableUtils.createTableIfNotExists(source, OpenBook.class);
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

    public void save(OpenBook openBook) {
        try {
//            dao.createOrUpdate(openBook);
            Dao.CreateOrUpdateStatus cous = dao.createOrUpdate(openBook);
            System.out.println("save: "+cous.isCreated());
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

    public OpenBook toJsonOpenOrders(String strJson, Pairs pair) {

        JSONObject dataJsonObj = new JSONObject(strJson);
        JSONObject object = dataJsonObj.getJSONObject(pair.toString());
        OpenBook openBook = new OpenBook();
        System.out.println(object.toString());

        openBook.setAsk_quantity(object.get("ask_quantity").toString());
        openBook.setAsk_amount(object.get("ask_amount").toString());
        openBook.setAsk_top(object.get("ask_top").toString());
        openBook.setBid_amount(object.get("bid_amount").toString());
        openBook.setBid_quantity(object.get("bid_quantity").toString());
        openBook.setBid_top(object.get("bid_top").toString());
//
        JSONArray bid = object.getJSONArray("bid");
        JSONArray ask = object.getJSONArray("ask");

        save(openBook);

        return openBook;
    }

//    private static ArrayList<double[]> getRow(JSONArray array) {
//        ArrayList<double[]> list = new ArrayList<double[]>();
//        for (int i = 0; i < array.length(); i++) {
//            JSONArray a = array.getJSONArray(i);
//            list.add(new double[]{a.getDouble(0), a.getDouble(1), a.getDouble(2)});
//
//        }
//        return list;
//    }

    private static ArrayList<BookBid> getRow(JSONArray array) {
        ArrayList<BookBid> list = new ArrayList<BookBid>();
        for (int i = 0; i < array.length(); i++) {
            JSONArray a = array.getJSONArray(i);
            list.add(new BookBid(a.getDouble(0), a.getDouble(1), a.getDouble(2)));

        }
        return list;
    }
}
