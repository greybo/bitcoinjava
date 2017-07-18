package service;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import entity.OpenBook;
import entity.Trades;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by m on 18.07.17.
 */
public class TradesService {
    private final String url="jdbc:sqlite:main.db";
    private ConnectionSource source;
    private Dao<Trades,String> dao;

    public TradesService() throws SQLException {
        source=new JdbcConnectionSource(url);
        dao= DaoManager.createDao(source,Trades.class);
    }

    public List<Trades> getAll() throws SQLException{
        return dao.queryForAll();
    }
}
