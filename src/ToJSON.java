import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ToJSON {

	public static ArrayList<String[]> toJsonTrades(String strJson, Pairs pair) {
		ArrayList<String[]> arrL = new ArrayList<String[]>();

		JSONObject dataJsonObj = new JSONObject(strJson);
		JSONArray array = dataJsonObj.getJSONArray(pair.toString());

		for (int i = 0; i < array.length(); i++) {
			arrL.add(new String[6]);
			arrL.get(arrL.size() - 1)[0] = array.getJSONObject(i).get("trade_id").toString();
			arrL.get(arrL.size() - 1)[1] = array.getJSONObject(i).get("type").toString();
			arrL.get(arrL.size() - 1)[2] = array.getJSONObject(i).get("quantity").toString();
			arrL.get(arrL.size() - 1)[3] = array.getJSONObject(i).get("price").toString();
			arrL.get(arrL.size() - 1)[4] = array.getJSONObject(i).get("amount").toString();
			arrL.get(arrL.size() - 1)[5] = array.getJSONObject(i).get("date").toString();
		}
		return arrL;
	}

	public static String[] toJsonPublStatist(String strJson, Pairs pair) {
		String[] arrL = new String[9];

		JSONObject dataJsonObj = new JSONObject(strJson);
		JSONObject object = dataJsonObj.getJSONObject(pair.toString());

		arrL[0] = object.get("buy_price").toString();
		arrL[1] = object.get("sell_price").toString();
		arrL[2] = object.get("last_trade").toString();
		arrL[3] = object.get("high").toString();
		arrL[4] = object.get("low").toString();
		arrL[5] = object.get("avg").toString();
		arrL[6] = object.get("vol").toString();
		arrL[7] = object.get("vol_curr").toString();
		arrL[8] = object.get("updated").toString();

		return arrL;
	}

	public static String[] toJsonUserInf(String strJson) {
		String[] arrL = new String[22];

		JSONObject dataJsonObj = new JSONObject(strJson);
		JSONObject balances = dataJsonObj.getJSONObject("balances");
		JSONObject reserved = dataJsonObj.getJSONObject("reserved");

		arrL[0] = dataJsonObj.get("uid").toString();
		arrL[1] = dataJsonObj.get("server_date").toString();

		arrL[2] = balances.get("USD").toString();
		arrL[3] = balances.get("EUR").toString();
		arrL[4] = balances.get("RUB").toString();
		arrL[5] = balances.get("UAH").toString();
		arrL[6] = balances.get("BTC").toString();
		arrL[7] = balances.get("LTC").toString();
		arrL[8] = balances.get("DOGE").toString();
		arrL[9] = balances.get("DASH").toString();
		arrL[10] = balances.get("ETH").toString();
		arrL[11] = balances.get("WAVES").toString();

		arrL[12] = reserved.get("USD").toString();
		arrL[13] = reserved.get("EUR").toString();
		arrL[14] = reserved.get("RUB").toString();
		arrL[15] = reserved.get("UAH").toString();
		arrL[16] = reserved.get("BTC").toString();
		arrL[17] = reserved.get("LTC").toString();
		arrL[18] = reserved.get("DOGE").toString();
		arrL[19] = reserved.get("DASH").toString();
		arrL[20] = reserved.get("ETH").toString();
		arrL[21] = reserved.get("WAVES").toString();

		return arrL;
	}

	public static String[] toJsonOrdCreate(String strJson) {
		String[] arrL = new String[3];

		JSONObject dataJsonObj = new JSONObject(strJson);

		arrL[0] = dataJsonObj.get("result").toString();
		arrL[1] = dataJsonObj.get("error").toString();
		try {
			arrL[2] = dataJsonObj.get("order_id").toString();
		} catch (Exception e) {
			arrL[2] = "-1";
		}
		return arrL;
	}
	
	public static String[] toJsonOrdCancel(String strJson) {
		String[] arrL = new String[2];

		JSONObject dataJsonObj = new JSONObject(strJson);

		arrL[0] = dataJsonObj.get("result").toString();
		arrL[1] = dataJsonObj.get("error").toString();
		return arrL;
	}
	
	public static ArrayList<String[]> toJsonOpenOrders(String strJson, Pairs pair) {
		ArrayList<String[]> arrL = new ArrayList<String[]>();

		JSONObject dataJsonObj = new JSONObject(strJson);
		JSONArray array = dataJsonObj.getJSONArray(pair.toString());

		for (int i = 0; i < array.length(); i++) {
			arrL.add(new String[7]);
			arrL.get(arrL.size() - 1)[0] = array.getJSONObject(i).get("order_id").toString();
			arrL.get(arrL.size() - 1)[1] = array.getJSONObject(i).get("created").toString();
			arrL.get(arrL.size() - 1)[2] = array.getJSONObject(i).get("type").toString();
			arrL.get(arrL.size() - 1)[3] = array.getJSONObject(i).get("pair").toString();
			arrL.get(arrL.size() - 1)[4] = array.getJSONObject(i).get("price").toString();
			arrL.get(arrL.size() - 1)[5] = array.getJSONObject(i).get("quantity").toString();
			arrL.get(arrL.size() - 1)[6] = array.getJSONObject(i).get("amount").toString();
		}
		return arrL;
	}
	
	public static ArrayList<String[]> toJsonUserTrades(String strJson, Pairs pair) {
		ArrayList<String[]> arrL = new ArrayList<String[]>();

		JSONObject dataJsonObj = new JSONObject(strJson);
		JSONArray array = dataJsonObj.getJSONArray(pair.toString());

		for (int i = 0; i < array.length(); i++) {
			arrL.add(new String[8]);
			arrL.get(arrL.size() - 1)[0] = array.getJSONObject(i).get("trade_id").toString();
			arrL.get(arrL.size() - 1)[1] = array.getJSONObject(i).get("date").toString();
			arrL.get(arrL.size() - 1)[2] = array.getJSONObject(i).get("type").toString();
			arrL.get(arrL.size() - 1)[3] = array.getJSONObject(i).get("pair").toString();
			arrL.get(arrL.size() - 1)[4] = array.getJSONObject(i).get("order_id").toString();
			arrL.get(arrL.size() - 1)[5] = array.getJSONObject(i).get("quantity").toString();
			arrL.get(arrL.size() - 1)[6] = array.getJSONObject(i).get("price").toString();
			arrL.get(arrL.size() - 1)[7] = array.getJSONObject(i).get("amount").toString();
		}
		return arrL;
	}
	
	public static ArrayList<String[]> toJsonOrdTradesById(String strJson) {
		ArrayList<String[]> arrL = new ArrayList<String[]>();

		JSONObject dataJsonObj = new JSONObject(strJson);
		
		arrL.add(new String[5]);
		arrL.get(arrL.size() - 1)[0] = dataJsonObj.get("type").toString();
		arrL.get(arrL.size() - 1)[1] = dataJsonObj.get("in_currency").toString();
		arrL.get(arrL.size() - 1)[2] = dataJsonObj.get("in_amount").toString();
		arrL.get(arrL.size() - 1)[3] = dataJsonObj.get("out_currency").toString();
		arrL.get(arrL.size() - 1)[4] = dataJsonObj.get("out_amount").toString();
		
		JSONArray array = dataJsonObj.getJSONArray("trades");

		for (int i = 0; i < array.length(); i++) {
			arrL.add(new String[8]);
			arrL.get(arrL.size() - 1)[0] = array.getJSONObject(i).get("trade_id").toString();
			arrL.get(arrL.size() - 1)[1] = array.getJSONObject(i).get("date").toString();
			arrL.get(arrL.size() - 1)[2] = array.getJSONObject(i).get("type").toString();
			arrL.get(arrL.size() - 1)[3] = array.getJSONObject(i).get("pair").toString();
			arrL.get(arrL.size() - 1)[4] = array.getJSONObject(i).get("order_id").toString();
			arrL.get(arrL.size() - 1)[5] = array.getJSONObject(i).get("quantity").toString();
			arrL.get(arrL.size() - 1)[6] = array.getJSONObject(i).get("price").toString();
			arrL.get(arrL.size() - 1)[7] = array.getJSONObject(i).get("amount").toString();
		}
		return arrL;
	}

}
