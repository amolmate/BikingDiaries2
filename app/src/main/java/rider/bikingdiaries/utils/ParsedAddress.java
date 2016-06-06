package rider.bikingdiaries.utils;

public class ParsedAddress {
String latitude;
String longitude;
String formatted_address;
public static String resultCheck="START";
public ParsedAddress(String lat,String longitude,String formatted_address)
{
	this.latitude=lat;
	this.longitude=longitude;
	this.formatted_address=formatted_address;
}

public String getLatitude() {
	return latitude;
}

public void setLatitude(String latitude) {
	this.latitude = latitude;
}

public String getLongitude() {
	return longitude;
}

public void setLongitude(String longitude) {
	this.longitude = longitude;
}

public String getFormatted_address() {
	return formatted_address;
}

public void setFormatted_address(String formatted_address) {
	this.formatted_address = formatted_address;
}
	
}
