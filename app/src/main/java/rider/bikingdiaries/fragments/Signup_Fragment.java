package rider.bikingdiaries.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import rider.bikingdiaries.R;

/**
 * Created by Sandip on 4/28/2016.
 */
public class Signup_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container,
                false);
        return view;
    }
}
