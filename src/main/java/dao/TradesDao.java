package dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import entity.Trades;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by m on 18.07.17.
 */
public class TradesDao {
    private final String url = "jdbc:sqlite:bitcoin.sqlite";
    private ConnectionSource source;
    private Dao<Trades, String> dao;

    public TradesDao() {
        try {
            source = new JdbcConnectionSource(url);
            dao = DaoManager.createDao(source, Trades.class);
            TableUtils.createTableIfNotExists(source, Trades.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Trades> getAll()  {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean save(Trades trades) {
        try {
            dao.createIfNotExists(trades);
            return true;
        } catch (SQLException e) {
            System.out.println("duplicate");
//            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Trades> jsonTrades(String strJson, Pairs pair) {
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

            if (save(trades)){
                System.out.println("====================================================================");
                System.out.println(trades);
                System.out.println("====================================================================");
            }
        }
        return list;
    }
}
