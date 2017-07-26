package dao;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import exmo.Exmo;
import util.Config;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by m on 20.07.17.
 */
public abstract class AbsDao<T> {
    private static Exmo exmo=Config.exmo;
    private static final String URI = "jdbc:sqlite:bitcoin.sqlite";
    private ConnectionSource source;

    String makeRequest(String method, Pairs pair, Map<String, String> map) {
        return exmo.request(method, pair, map);
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

//    public abstract ArrayList<T> jsonParse(String json);

    public abstract T save(T t);

    public abstract List<T> getAll();

    public abstract long getCount();

//    public abstract ArrayList<T> request(Pairs pair);
}



