package entity;

import org.json.JSONObject;

public class UserInfo {

    private int uid;
    private long serverDate;
    private Balances balances;
    private Reserved reserved;


    public UserInfo() {
    }

    public UserInfo jsonParce(String json) {
        Balances balances = new Balances();
        Reserved reserved = new Reserved();
        JSONObject jsonData = new JSONObject(json);
        uid = jsonData.getInt("uid");
        serverDate = jsonData.getLong("server_date");
        JSONObject jsonBalances = jsonData.getJSONObject("balances");
        JSONObject jsonReserved = jsonData.getJSONObject("reserved");
        balances.USD = jsonBalances.getString("USD");
        balances.EUR = jsonBalances.getString("EUR");
        balances.RUB = jsonBalances.getString("RUB");
        balances.UAH = jsonBalances.getString("UAH");
        balances.BTC = jsonBalances.getString("BTC");
        balances.LTC = jsonBalances.getString("LTC");
        balances.DOGE = jsonBalances.getString("DOGE");
        balances.DASH = jsonBalances.getString("DASH");
        balances.ETH = jsonBalances.getString("ETH");
        balances.WAVES = jsonBalances.getString("WAVES");

        reserved.USD = jsonReserved.getString("USD");
        reserved.EUR = jsonReserved.getString("EUR");
        reserved.RUB = jsonReserved.getString("RUB");
        reserved.UAH = jsonReserved.getString("UAH");
        reserved.BTC = jsonReserved.getString("BTC");
        reserved.LTC = jsonReserved.getString("LTC");
        reserved.DOGE = jsonReserved.getString("DOGE");
        reserved.DASH = jsonReserved.getString("DASH");
        reserved.ETH = jsonReserved.getString("ETH");
        reserved.WAVES = jsonReserved.getString("WAVES");

        this.reserved = reserved;
        this.balances = balances;
        return this;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public long getServerDate() {
        return serverDate;
    }

    public void setServerDate(long serverDate) {
        this.serverDate = serverDate;
    }


    public Balances getBalances() {
        return balances;
    }

    public void setBalances(Balances balances) {
        this.balances = balances;
    }

    public Reserved getReserved() {
        return reserved;
    }

    public void setReserved(Reserved reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", serverDate=" + serverDate +
                ", balances=" + balances +
                ", reserved=" + reserved +
                '}';
    }

    class Balances {
        private String USD;
        private String EUR;
        private String RUB;
        private String UAH;
        private String BTC;
        private String LTC;
        private String DOGE;
        private String DASH;
        private String ETH;
        private String WAVES;

        public String getUSD() {
            return USD;
        }

        public void setUSD(String USD) {
            this.USD = USD;
        }

        public String getEUR() {
            return EUR;
        }

        public void setEUR(String EUR) {
            this.EUR = EUR;
        }

        public String getRUB() {
            return RUB;
        }

        public void setRUB(String RUB) {
            this.RUB = RUB;
        }

        public String getUAH() {
            return UAH;
        }

        public void setUAH(String UAH) {
            this.UAH = UAH;
        }

        public String getBTC() {
            return BTC;
        }

        public void setBTC(String BTC) {
            this.BTC = BTC;
        }

        public String getLTC() {
            return LTC;
        }

        public void setLTC(String LTC) {
            this.LTC = LTC;
        }

        public String getDOGE() {
            return DOGE;
        }

        public void setDOGE(String DOGE) {
            this.DOGE = DOGE;
        }

        public String getDASH() {
            return DASH;
        }

        public void setDASH(String DASH) {
            this.DASH = DASH;
        }

        public String getETH() {
            return ETH;
        }

        public void setETH(String ETH) {
            this.ETH = ETH;
        }

        public String getWAVES() {
            return WAVES;
        }

        public void setWAVES(String WAVES) {
            this.WAVES = WAVES;
        }

        @Override
        public String toString() {
            return "Balances{" +
                    "USD=" + USD +
                    ", EUR=" + EUR +
                    ", RUB=" + RUB +
                    ", UAH=" + UAH +
                    ", BTC=" + BTC +
                    ", LTC=" + LTC +
                    ", DOGE=" + DOGE +
                    ", DASH=" + DASH +
                    ", ETH=" + ETH +
                    ", WAVES=" + WAVES +
                    '}';
        }
    }

    class Reserved {
        private String USD;
        private String EUR;
        private String RUB;
        private String UAH;
        private String BTC;
        private String LTC;
        private String DOGE;
        private String DASH;
        private String ETH;
        private String WAVES;

        public String getUSD() {
            return USD;
        }

        public void setUSD(String USD) {
            this.USD = USD;
        }

        public String getEUR() {
            return EUR;
        }

        public void setEUR(String EUR) {
            this.EUR = EUR;
        }

        public String getRUB() {
            return RUB;
        }

        public void setRUB(String RUB) {
            this.RUB = RUB;
        }

        public String getUAH() {
            return UAH;
        }

        public void setUAH(String UAH) {
            this.UAH = UAH;
        }

        public String getBTC() {
            return BTC;
        }

        public void setBTC(String BTC) {
            this.BTC = BTC;
        }

        public String getLTC() {
            return LTC;
        }

        public void setLTC(String LTC) {
            this.LTC = LTC;
        }

        public String getDOGE() {
            return DOGE;
        }

        public void setDOGE(String DOGE) {
            this.DOGE = DOGE;
        }

        public String getDASH() {
            return DASH;
        }

        public void setDASH(String DASH) {
            this.DASH = DASH;
        }

        public String getETH() {
            return ETH;
        }

        public void setETH(String ETH) {
            this.ETH = ETH;
        }

        public String getWAVES() {
            return WAVES;
        }

        public void setWAVES(String WAVES) {
            this.WAVES = WAVES;
        }

        @Override
        public String toString() {
            return "Reserved{" +
                    "USD=" + USD +
                    ", EUR=" + EUR +
                    ", RUB=" + RUB +
                    ", UAH=" + UAH +
                    ", BTC=" + BTC +
                    ", LTC=" + LTC +
                    ", DOGE=" + DOGE +
                    ", DASH=" + DASH +
                    ", ETH=" + ETH +
                    ", WAVES=" + WAVES +
                    '}';
        }
    }
}
