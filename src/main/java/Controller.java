import dao.*;
import entity.OpenBook;
import entity.Trades;

public class Controller {
    private Pairs pair;
    private TradesDao trades;
    private OpenBookDao openBook;
    private UserInfoDao userInfoDao;

    public Controller() {
    }

    public Controller(Pairs pair) {
        this.pair = pair;
        trades = new TradesDao();
        openBook = new OpenBookDao();
        userInfoDao = new UserInfoDao();
    }

    public void sendRequest() {
        for (Trades t : trades.request(pair)) {
            System.out.println(t);
        }
        for (OpenBook t : openBook.request(pair)) {
            System.out.println("===========================request===========================\n" + t);
        }
        userInfoDao.request(pair);
    }
}
