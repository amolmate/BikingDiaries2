package rider.bikingdiaries.utils;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JsonHandler {
String json=null;
ArrayList<ParsedAddress> alParsedAddress;
	public JsonHandler(String json){
		this.json= json;
	}
	public ArrayList<ParsedAddress> getAddressFromJson(){
		alParsedAddress= new ArrayList<ParsedAddress>();	
		try {
			JSONObject mainObject= new JSONObject(json);
			if(mainObject!=null){
				JSONArray resultObject=mainObject.getJSONArray("results");
				if(mainObject.getString("status").equalsIgnoreCase("OK")){
				if(resultObject!=null){
					for(int i=0;i<resultObject.length();i++){
						JSONObject firstResult=resultObject.getJSONObject(i);
						String address=firstResult.getString("formatted_address");
						JSONObject geometryObject =firstResult.getJSONObject("geometry");
						JSONObject locationObject=geometryObject.getJSONObject("location");
						String latitude=locationObject.getString("lat");
						String longitude=locationObject.getString("lng");
						ParsedAddress parsedAddress= new ParsedAddress(latitude, longitude, address);
						alParsedAddress.add(parsedAddress);
						Log.d("Check","is"+address+":"+latitude+":"+longitude);
					}
				}
			}	
			}
			ParsedAddress.resultCheck = "END";
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alParsedAddress;
	}
}
