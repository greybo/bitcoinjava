import dao.BidDao;
import dao.OpenBookDao;
import dao.Pairs;
import dao.TradesDao;
import entity.OpenBook;
import entity.Trades;

public class Controller {

    private Pairs pair;
    TradesDao trades;
    OpenBookDao openBook;
    BidDao bidDao;

    public Controller() {
    }

    public Controller(Pairs pair) {
        this.pair = pair;
        trades = new TradesDao();
        openBook = new OpenBookDao();
        bidDao=new BidDao();
    }

    public void sendRequest() {
        for (Trades t:trades.request(pair)){
            System.out.println(t);
        }
        System.out.println("============================Start==========================");
        for (OpenBook t:openBook.request(pair)){
            System.out.println(t);
        }
        System.out.println("============================End==========================");
    }
}
