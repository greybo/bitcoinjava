import utils.Pairs;


public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//                GUI gui = new GUI("Test");
//                gui.setVisible(true);


            }
        });

        String balanceUSD = "18.66812213";
        String type = "buy";
        double priseLimit = 2727;
        String amount = "3";


        Controller controller = new Controller(Pairs.BTC_USD);
//        controller.sendRequest();
//        controller.requestOpenBook();
//        controller.createOrder("sell","2.5",price);
        controller.userInfo();
//        CalcOrder calc = controller.calculateQuantity(amount,type);
//        controller.createOrder(type,calc.getQuantity(),calc.getPrice());
//        controller.userOpenOrder();
//        controller.sendRequest();
//        controller.userTrades();
//        controller.requiredAmount("0.11");

    }
}

