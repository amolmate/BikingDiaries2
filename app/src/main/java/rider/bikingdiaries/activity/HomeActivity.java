package rider.bikingdiaries.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import rider.bikingdiaries.R;

/**
 * Created by Sandip on 4/29/2016.
 */
public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        set_up_drawer();
    }
}
