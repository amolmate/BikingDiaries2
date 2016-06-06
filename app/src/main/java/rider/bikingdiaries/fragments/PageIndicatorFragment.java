package rider.bikingdiaries.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


import dd.processbutton.iml.ActionProcessButton;
import rider.bikingdiaries.R;
import rider.bikingdiaries.activity.LoginActivity;
import rider.bikingdiaries.utils.AppUtility;


public class PageIndicatorFragment extends Fragment {
	private static final String KEY_CONTENT = "TestFragment:Content";
	ImageView iv_content;
	LinearLayout ll_show_button;

	int resource;
	String title, desc;
	boolean is_show_buttons;
	ActionProcessButton btn_login,btn_register;
	public static PageIndicatorFragment newInstance(int resource, boolean is_show_buttons) {
		PageIndicatorFragment fragment = new PageIndicatorFragment();
		fragment.resource = resource;
		fragment.is_show_buttons=is_show_buttons;

		return fragment;
	}

	private String mContent = "???";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if ((savedInstanceState != null)
				&& savedInstanceState.containsKey(KEY_CONTENT)) {
			mContent = savedInstanceState.getString(KEY_CONTENT);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_showcase, container,
				false);
		iv_content = (ImageView) view.findViewById(R.id.iv_content);
		iv_content.setImageResource(resource);
		ll_show_button= (LinearLayout) view.findViewById(R.id.ll_btn);
		btn_login= (ActionProcessButton) view.findViewById(R.id.btn_Login);
		btn_register= (ActionProcessButton) view.findViewById(R.id.btn_register);
		if(is_show_buttons){
			ll_show_button.setVisibility(View.VISIBLE);
		}
		else{
			ll_show_button.setVisibility(View.GONE);
		}


		btn_login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pass_intent(0);
			}
		});

		btn_register.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				pass_intent(1);
			}
		});
		return view;
		}


	public void pass_intent(int i){
		getActivity().finish();
		Intent login_intent=new Intent(getActivity(), LoginActivity.class);
		login_intent.putExtra(AppUtility.TAB_POSITION,i);
		startActivity(login_intent);
	}

@Override
public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString(KEY_CONTENT, mContent);
		}

		}
