import dao.Pairs;


public class Main {

    public static void main(String[] args) {
        Controller c = new Controller(Pairs.BTC_USD);
        c.sendRequest();

    }
}

