package dao;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by m on 20.07.17.
 */
public abstract class AbsDao<T> {
    private static final dao.Exmo EXMO = new dao.Exmo("K-3e85f38ed3ce354a357ce13953953f90242d9bbd", "S-c87c32ae21bb72eed3f6e94dcc8d1c4869b6dbb8");
    private static final String URL = "jdbc:sqlite:bitcoin.sqlite";
    private ConnectionSource source;

    public String makeRequest(String method, Pairs pair, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<String, String>() {{
                put("limit", "1");
                put("offset", "0");
            }};
        }
        return EXMO.Request(method + "/?pair=" + pair, map);
    }

    public ConnectionSource getSource() {
        try {
            if (source == null)
                source = new JdbcConnectionSource(URL);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return source;
    }

//    public abstract ArrayList<T> jsonParse(String json);

    public abstract T save(T t);

    public abstract List<T> getAll();

    public abstract long getCount();

    public abstract ArrayList<T>  request(Pairs pair);
}



