package dao;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import exmo.Exmo;
import utils.Pairs;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by m on 20.07.17.
 */
public class AbsDao<T> {

    private static final String URI = "jdbc:sqlite:bitcoin.sqlite";
    private static Exmo exmo;
    private ConnectionSource source;
    private static Pairs pair;

    static {
        if (exmo == null) initExmo();
    }

    public String makeRequest(String method ) {
        return makeRequest(method,null);
    }
    public String makeRequest(String method, Map<String, String> map) {
        return exmo.request(method, pair, map);
    }

    public void setPair(Pairs pair) {
        AbsDao.pair = pair;
    }

    public static Pairs getPair() {
        return pair;
    }

    ConnectionSource getSource() {
        try {
            if (source == null)
                source = new JdbcConnectionSource(URI);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return source;
    }

    static void initExmo() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(new File("config.properties")));
            String key = prop.getProperty("key");
            String secret = prop.getProperty("secret");
            exmo = new Exmo(key, secret);
            System.out.println("======================KEY==================");
            System.out.println("key: " + key + "\nsecret: " + secret);
        } catch (Exception e) {
            System.out.println("Exception: ========================================\n" + e);
        }
        prop.clear();
        if (exmo == null)
            exmo = new Exmo();
    }

//    public abstract ArrayList<T> jsonParse(String json);

//    public abstract T save(T t);
//
//    public abstract List<T> getAll();
//
//    public abstract long getCount();

//    public abstract ArrayList<T> request(Pairs pair);
}



