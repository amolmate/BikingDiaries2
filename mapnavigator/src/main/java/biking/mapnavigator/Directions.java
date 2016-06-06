package biking.mapnavigator;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Directions {
	
	private ArrayList<Route> routes = new ArrayList<Route>();
	private String directions;
	
	public enum DrivingMode{
		DRIVING,MASS_TRANSIT,BYCICLE,WALKING
	}
	
	public enum Avoid{
		TOLLS,HIGHWAYS,NONE
	}
	
	public Directions(String directions){
		this.directions = directions;
		
		if(directions != null){
			parseDirections();
		}

	}
	
	private void parseDirections(){
		try {
			JSONObject json = new JSONObject(directions);

			
			if(!json.isNull("routes")){
				JSONArray route = json.getJSONArray("routes");
				
				for(int k=0;k<route.length(); k++){
					
					JSONObject obj3 = route.getJSONObject(k);
					routes.add(new Route(obj3));
				}
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Route> getRoutes(){
		return routes;
	}

	public String getDistance(){
		String distance = null;
		for(int i=0;i<routes.size();i++){
			distance=routes.get(i).getDistance();
		}
		return distance;
	}
	
	public String getDuration(){
		String duration = null;
		for(int i=0;i<routes.size();i++){
			duration=routes.get(i).getDuration();
		}
		return duration;
	}
}
