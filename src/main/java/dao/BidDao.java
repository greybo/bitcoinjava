package dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.table.TableUtils;
import entity.Bid;
import org.json.JSONArray;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BidDao extends AbsDao<Bid> {
    private Dao<Bid, String> dao;

    public BidDao() {
        try {
            dao = DaoManager.createDao(getSource(), Bid.class);
            TableUtils.createTableIfNotExists(getSource(), Bid.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Bid save(Bid bookBid) {
        try {
            return dao.createIfNotExists(bookBid);
        } catch (SQLException e) {
            System.out.println("duplicate not saved bid");
//            e.printStackTrace();
        }
        return null;
    }

    public boolean saveOrUpdate(Bid bookBid) {
        try {
            dao.createOrUpdate(bookBid);
            return true;
        } catch (SQLException e) {
            System.out.println("duplicate saveOrUpdate bid  update: false");
//            e.printStackTrace();
        }
        return false;
    }

    public List<Bid> getAll() {
        try {
            dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public long getCount() {
        try {
            dao.countOf();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Bid> request(Pairs pair) {
        return null;
    }

    private void removeByPrice(String arg) {
        DeleteBuilder<Bid, String> deleteBuilder = dao.deleteBuilder();

        try {
            deleteBuilder.where().gt("price", arg);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Collection<Bid> jsonParce(JSONArray array, long id_book, String price) {
        Collection<Bid> list = new ArrayList<Bid>();
        removeByPrice(String.valueOf(price));
        for (int i = 0; i < array.length(); i++) {
            JSONArray a = array.getJSONArray(i);
            Bid bookBid = new Bid(a.getDouble(0), a.getDouble(1), a.getDouble(2));
            bookBid.setId_book(id_book);
            saveOrUpdate(bookBid);
            System.out.println("==================================================== ");
            list.add(bookBid);
        }
        return list;
    }

}
