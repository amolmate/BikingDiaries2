package rider.bikingdiaries.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.viewpagerindicator.IconPagerAdapter;

import rider.bikingdiaries.R;
import rider.bikingdiaries.fragments.PageIndicatorFragment;


public class PageIndicatorAdapter extends FragmentPagerAdapter implements
		IconPagerAdapter {

	private int mCount = 3;

	public PageIndicatorAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		if (position == 0)
			return PageIndicatorFragment.newInstance(R.mipmap.new_rupee,false);
		else if (position == 1)
			return PageIndicatorFragment.newInstance(R.mipmap.payment_pickup,false);
		else if (position == 2)
			return PageIndicatorFragment.newInstance(R.mipmap.new_rupee,true);

		else
			return null;

	}

	@Override
	public int getCount() {
		return mCount;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "";
	}

	public void setCount(int count) {
		if (count > 0 && count <= 10) {
			mCount = count;
			notifyDataSetChanged();
		}
	}

	@Override
	public int getIconResId(int index) {
		// TODO Auto-generated method stub
		return 0;
	}
}