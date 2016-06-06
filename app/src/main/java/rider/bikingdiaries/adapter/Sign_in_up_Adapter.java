package rider.bikingdiaries.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import rider.bikingdiaries.fragments.Signin_Fragment;
import rider.bikingdiaries.fragments.Signup_Fragment;

/**
 * Created by Sandip on 4/28/2016.
 */
public class Sign_in_up_Adapter extends FragmentPagerAdapter {
    int PAGE_COUNT = 2;
    Context context;
    Signin_Fragment signin_fragment;
    Signup_Fragment signup_fragment;

    private String tabTitles[] = new String[] { "Sign in", "Sign up"  };

    public Sign_in_up_Adapter(FragmentManager fm, Context context){
        super(fm);
        this.context=context;
    }

     @Override
    public Fragment getItem(int position) {

         if(position==0) {
             if (signin_fragment != null) {

             }
             else{
                 signin_fragment=new Signin_Fragment();
             }
             return  signin_fragment;
         }
         else if(position==1){
             if (signup_fragment != null) {

             }
             else{
                signup_fragment=new Signup_Fragment();
             }
             return  signup_fragment;
         }
         else{
             return null;
         }


    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
