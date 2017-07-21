package dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
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

    private int create(Bid bookBid) {
        try {
            return dao.create(bookBid);
        } catch (SQLException e) {
            System.out.println("duplicate not create bid");
//            e.printStackTrace();
        }
        return 0;
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

    private Bid findByObject(Bid bid) {
        try {
            dao.queryForSameId(bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Bid> findByField(String field, double price) {
        try {
            return dao.queryForEq(field, price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
    public void saveAll(Collection<Bid> bids,long id) {
        for (Bid b : bids) {
            b.setId_book(id);
//            create(b);
            boolean create = saveOrUpdate(b);
            if (!create) {
                System.out.println("bookBid: " + b);
                System.out.println("find: " + findByField("price", b.getPrice()));

            } else {
                System.out.println("====save: " + b);
            }
        }
    }
    public ArrayList<Bid> request(Pairs pair) {
        return null;
    }



    public Collection<Bid> jsonParce(JSONArray array,long id_book) {
        Collection<Bid> list = new ArrayList<Bid>();
        for (int i = 0; i < array.length(); i++) {
            JSONArray a = array.getJSONArray(i);
            Bid bookBid = new Bid(a.getDouble(0), a.getDouble(1), a.getDouble(2));
            bookBid.setId_book(id_book);
            boolean create = saveOrUpdate(bookBid);
            if (!create) {
                System.out.println("bookBid: " + bookBid);
                System.out.println("find: " + findByField("price", bookBid.getPrice()));
            } else {
                System.out.println("====save: " + bookBid);
            }

//            long l = create(bookBid);
//            long l = save(bookBid).getId_bid();
            System.out.println("==================================================== ");
            list.add(bookBid);
        }
        return list;
    }


//        ArrayList<Long> list = new ArrayList<Long>();
//        for (int i = 0; i < array.length(); i++) {
//            JSONArray a = array.getJSONArray(i);
//            int l =create( new Bid(a.getDouble(0), a.getDouble(1), a.getDouble(2)));
//            System.out.println("==================================================== "+i);
//            list.add((long) l);
//        }

    //    private  ArrayList<Long> getRow(JSONArray array) {
//        ArrayList<Long> list = new ArrayList<Long>();
//        for (int i = 0; i < array.length(); i++) {
//            JSONArray a = array.getJSONArray(i);
//            Bid b=new Bid(a.getDouble(0), a.getDouble(1), a.getDouble(2));
//            list.add(b.getId());
//        }
//        return list;
//    }


//    private static ArrayList<double[]> getRow(JSONArray array) {
//        ArrayList<double[]> list = new ArrayList<double[]>();
//        for (int i = 0; i < array.length(); i++) {
//            JSONArray a = array.getJSONArray(i);
//            list.add(new double[]{a.getDouble(0), a.getDouble(1), a.getDouble(2)});
//
//        }
//        return list;
//    }

//    private static Collection<Bid> getRow(JSONArray array) {
//        Collection<Bid> list = new ArrayList<Bid>();
//        for (int i = 0; i < array.length(); i++) {
//            JSONArray a = array.getJSONArray(i);
//            list.add(new Bid(a.getDouble(0), a.getDouble(1), a.getDouble(2)));
//        }
//        return  list;
//    }

}
