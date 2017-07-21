package dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;
import entity.Trades;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by m on 18.07.17.
 */
public class TradesDao extends AbsDao<Trades> {
    private Dao<Trades, String> dao;
    private String method = "trades";
    private Pairs pair;

    public TradesDao() {
        try {
            dao = DaoManager.createDao(getSource(), Trades.class);
            TableUtils.createTableIfNotExists(getSource(), Trades.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Trades> getAll() {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
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

    public ArrayList<Trades> request(Pairs pair) {
        this.pair = pair;
        String json = makeRequest(method, pair, new HashMap<String, String>() {{
            put("limit", "50");
            put("offset", "0");
        }});
        return jsonParse(json);
    }

    public Trades save(Trades trades) {
        try {
            return dao.createIfNotExists(trades);
        } catch (SQLException e) {
            System.out.println("duplicate");
//            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Trades> jsonParse(String strJson) {
        ArrayList<Trades> list = new ArrayList<Trades>();
        JSONObject jsonObject = new JSONObject(strJson);

        JSONArray array = jsonObject.getJSONArray(pair.toString());

        for (int i = 0; i < array.length(); i++) {
            Trades trades = new Trades();
            JSONObject object = array.getJSONObject(i);

            trades.setTrade_id(object.getLong("trade_id"));
            trades.setDate(object.get("date").toString());
            trades.setAmount(object.get("amount").toString());
            trades.setQuantity(object.get("quantity").toString());
            trades.setPrice(object.get("price").toString());
            trades.setType(object.get("type").toString());

            Trades t = save(trades);
            if (t != null) {
                list.add(t);
//                System.out.println("====================================================================");
//                System.out.println(t);
//                System.out.println("====================================================================");
            }
        }
        return list;
    }
}
