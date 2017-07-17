import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Pairs pair = Pairs.BTC_USD;
        String method = "trades";
        Exmo e = new Exmo("K-3e85f38ed3ce354a357ce13953953f90242d9bbd", "S-c87c32ae21bb72eed3f6e94dcc8d1c4869b6dbb8");
        String result = e.Request(method + "/?pair=" + Pairs.BTC_USD, new HashMap<String, String>() {{
            put("limit", "100");
            put("offset", "0");
        }});

        ArrayList<String[]> list = ToJSON.toJsonTrades(result, pair);
        for (String[] s : list)
            System.out.println(Arrays.asList(s));

    }

}
