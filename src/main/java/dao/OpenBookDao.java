package dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;
import entity.Bid;
import entity.OpenBook;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by m on 18.07.17.
 */
public class OpenBookDao extends AbsDao<OpenBook> {

    private Dao<OpenBook, String> dao;
    private String method = "order_book";
    private Pairs pair;

    public OpenBookDao() {
        try {
            dao = DaoManager.createDao(getSource(), OpenBook.class);
            TableUtils.createTableIfNotExists(getSource(), OpenBook.class);
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

    public OpenBook save(OpenBook openBook) {
        try {
            return dao.createIfNotExists(openBook);
        } catch (SQLException e) {
            System.out.println("duplicate");
//            e.printStackTrace();
        }
        return null;
    }

    public Dao<OpenBook, String> getDao() {
        return null;
    }

    public long getCount() {
        try {
            return dao.countOf();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public OpenBook jsonParse(String json) {

        JSONObject dataJsonObj = new JSONObject(json);
        JSONObject object = dataJsonObj.getJSONObject(pair.toString());
        OpenBook openBook = new OpenBook();
        System.out.println(object.toString());

        openBook.setAsk_quantity(object.get("ask_quantity").toString());
        openBook.setAsk_amount(object.get("ask_amount").toString());
        openBook.setAsk_top(object.get("ask_top").toString());
        openBook.setBid_amount(object.get("bid_amount").toString());
        openBook.setBid_quantity(object.get("bid_quantity").toString());
        openBook.setBid_top(object.get("bid_top").toString());

        openBook.setBid(new BidDao().jsonParce(object.getJSONArray("bid"), getCount()+1));
//        JSONArray bid = object.getJSONArray("bid");
//        openBook.setBid(getRow(bid));
        save(openBook);
//        new BidDao().saveAll(openBook.getBid(),getCount() );

//        JSONArray ask = object.getJSONArray("ask");


        return openBook;
    }

    private static Collection<Bid> getRow(JSONArray array) {
        Collection<Bid> list = new ArrayList<Bid>();
        for (int i = 0; i < array.length(); i++) {
            JSONArray a = array.getJSONArray(i);
            list.add(new Bid(a.getDouble(0), a.getDouble(1), a.getDouble(2)));
        }
        return list;
    }

    public ArrayList<OpenBook> request(Pairs pair) {
        this.pair = pair;
        String json = makeRequest(method, pair, new HashMap<String, String>() {{
            put("limit", "10");
            put("offset", "0");
        }});
        ArrayList<OpenBook> list = new ArrayList<OpenBook>();
        list.add(jsonParse(json));
        return list;
    }

}
