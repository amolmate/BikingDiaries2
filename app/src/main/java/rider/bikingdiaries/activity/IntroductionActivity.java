package rider.bikingdiaries.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;

import com.viewpagerindicator.CirclePageIndicator;

import rider.bikingdiaries.R;
import rider.bikingdiaries.adapter.PageIndicatorAdapter;

/**
 * Created by Sandip on 4/27/2016.
 */
public class IntroductionActivity extends BaseActivity {

    private  ViewPager mPager;
    private PageIndicatorAdapter mAdapter;
    private CirclePageIndicator mIndicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        initControls();
        mAdapter = new PageIndicatorAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
        mIndicator.setViewPager(mPager);
        int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20*2,     getResources().getDisplayMetrics());
        mPager.setClipToPadding(false);
        // set padding manually, the more you set the padding the more you see of prev & next page
        mPager.setPadding(40, 0, 40, 0);
        // sets a margin b/w individual pages to ensure that there is a gap b/w them
        mPager.setPageMargin(20);

    }

    public void initControls(){
        mPager = (ViewPager) findViewById(R.id.pager);
        mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
    }
}
