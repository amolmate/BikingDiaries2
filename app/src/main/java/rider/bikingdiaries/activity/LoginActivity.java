package rider.bikingdiaries.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import rider.bikingdiaries.R;

/**
 * Created by Sandip on 4/28/2016.
 */
public class LoginActivity extends  BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init_controls();

    }

    public void init_controls(){

    }
}
