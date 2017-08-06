package dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;
import entity.OpenBook;
import org.json.JSONObject;
import utils.Pairs;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by m on 18.07.17.
 */
public class OpenBookDao extends AbsDao {
    private Dao<OpenBook, String> dao;

    private String method = "order_book";
    private Pairs pair;

    public OpenBookDao() {
//        dao=initDao();
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

    public long getCount() {
        try {
            return dao.countOf();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public OpenBook getLastRow() {
        try {
            List<OpenBook> openBooks = dao.query(dao.queryBuilder()
                    .orderBy("id", false).limit(1L).prepare());
            return openBooks.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public OpenBook jsonParse(String json) {
        JSONObject dataJsonObj = new JSONObject(json);
        JSONObject object = dataJsonObj.getJSONObject(getPair().toString());
        OpenBook openBook = new OpenBook();
        System.out.println(object.toString());

        openBook.setAskQuantity(object.get("ask_quantity").toString());
        openBook.setAskAmount(object.get("ask_amount").toString());
        openBook.setAskTop(object.get("ask_top").toString());
        openBook.setBidAmount(object.get("bid_amount").toString());
        openBook.setBidQuantity(object.get("bid_quantity").toString());
        openBook.setBidTop(object.get("bid_top").toString());

        openBook.setBid(new BidDao().jsonParce(object.getJSONArray("bid"), getCount() + 1, openBook.getBidTop()));
        openBook.setAsk(new AskDao().jsonParce(object.getJSONArray("ask"), getCount() + 1, openBook.getAskTop()));

        return save(openBook);
    }

    //    public ArrayList<OpenBook> request(Pairs pair) {
    public OpenBook request(Pairs pair) {
        this.pair = pair;
        String json = makeRequest(method,  new HashMap<String, String>() {{
            put("limit", "10");
            put("offset", "0");
        }});
//        ArrayList<OpenBook> list = new ArrayList<OpenBook>();
//        list.add(jsonParse(json));
        return jsonParse(json);
//        return list;
    }

}
