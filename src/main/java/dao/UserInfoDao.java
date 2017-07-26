package dao;

import java.util.List;

public class UserInfoDao extends AbsDao {
    //    private Dao<Trades, String> dao;
    private String method = "user_info";


    public UserInfoDao() {
//        dao = DaoManager.createDao(getSource(), UserInfo.class);
//        TableUtils.createTableIfNotExists(getSource(), UserInfo.class);
    }

    public Object save(Object o) {
        return null;
    }

    public List getAll() {
        return null;
    }

    public long getCount() {
        return 0;
    }

    public void request(Pairs pair) {
        String json = makeRequest(method, pair, null);
        System.out.println("=================================UserInfo==============================\n" + json);
//        return null;
    }
}
