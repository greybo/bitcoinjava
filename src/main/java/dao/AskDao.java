package dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.table.TableUtils;
import entity.Ask;
import org.json.JSONArray;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AskDao extends AbsDao<Ask> {
    private Dao<Ask, String> dao;

    public AskDao() {
        try {
            dao = DaoManager.createDao(getSource(), Ask.class);
            TableUtils.createTableIfNotExists(getSource(), Ask.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Ask save(Ask bookAsk) {
        try {
            return dao.createIfNotExists(bookAsk);
        } catch (SQLException e) {
            System.out.println("duplicate not saved ask");
//            e.printStackTrace();
        }
        return null;
    }

    public boolean saveOrUpdate(Ask bookAsk) {
        try {
            dao.createOrUpdate(bookAsk);
            return true;
        } catch (SQLException e) {
            System.out.println("duplicate saveOrUpdate ask  update: false");
//            e.printStackTrace();
        }
        return false;
    }

    public List<Ask> getAll() {
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

    public ArrayList<Ask> request(Pairs pair) {
        return null;
    }

    private void removeByPrice(String arg) {
        DeleteBuilder<Ask, String> deleteBuilder = dao.deleteBuilder();
        try {
            deleteBuilder.where().lt("price", arg);
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Collection<Ask> jsonParce(JSONArray array, long id_book, String price) {
        Collection<Ask> list = new ArrayList<Ask>();
        removeByPrice(String.valueOf(price));
        for (int i = 0; i < array.length(); i++) {
            JSONArray a = array.getJSONArray(i);
            Ask bookAsk = new Ask(a.getDouble(0), a.getDouble(1), a.getDouble(2));
            bookAsk.setIdBook(id_book);
            saveOrUpdate(bookAsk);
            System.out.println("========================ASK============================ ");
            list.add(bookAsk);
        }
        return list;
    }
}
