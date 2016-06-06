package rider.bikingdiaries.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.rengwuxian.materialedittext.MaterialAutoCompleteTextView;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import java.util.ArrayList;
import rider.bikingdiaries.R;
import rider.bikingdiaries.utils.JsonHandler;
import rider.bikingdiaries.utils.AppUtility;
import rider.bikingdiaries.utils.ParsedAddress;

/**
 * Created by Sandip on 4/30/2016.
 */
public class AddRideActivity extends BaseActivity {

    MaterialAutoCompleteTextView et_start_location,et_end_location;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ride);
        init_controls();
        set_up_drawer();
    }

    public void init_controls(){
        et_start_location=(MaterialAutoCompleteTextView) findViewById(R.id.et_start_location);
        et_end_location=(MaterialAutoCompleteTextView) findViewById(R.id.et_end_location);

        et_start_location.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length()>3){
                    new GetLocationFromGoogleTask().execute("0",s.toString().replace(" ","%20"));
                }
            }
        });

        et_start_location.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    public ArrayList<String> get_location_from_google(String search_text){

        ArrayList<ParsedAddress> al_locations_parsed= new ArrayList<>();
        ArrayList<String> al_locations= new ArrayList<>();

        String SourceUrl="http://maps.google.com/maps/api/geocode/json?address="+search_text+"&sensor=false";

        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpPost httpPost = new HttpPost(SourceUrl);
            HttpResponse response = httpClient.execute(httpPost, localContext);

            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                AppUtility.l("URL ","is"+SourceUrl);
               String source= EntityUtils.toString(response.getEntity());
                AppUtility.l("Direction","is"+source);
                JsonHandler json= new JsonHandler(source);
                al_locations_parsed=   json.getAddressFromJson();
            }


            for(int i=0;i<al_locations_parsed.size();i++){
                al_locations.add(al_locations_parsed.get(i).getFormatted_address());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return al_locations;
    }

    public class GetLocationFromGoogleTask extends AsyncTask<String,Void,Void>{
        //for start 0 and end 1
        String start_end="";
        String search_text="";
        ArrayList<String> al_location=new ArrayList<>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... params) {

            start_end=params[0].toString();
            search_text=params[1].toString();

            al_location=get_location_from_google(search_text);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(start_end.equalsIgnoreCase("0")){
                et_start_location.setAdapter(new ArrayAdapter<>(AddRideActivity.this,android.R.layout.simple_list_item_1,al_location));
            }
            if(start_end.equalsIgnoreCase("1")){
                et_start_location.setAdapter(new ArrayAdapter<>(AddRideActivity.this,android.R.layout.simple_list_item_1,al_location));
            }
        }
    }
}
