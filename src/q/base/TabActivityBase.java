package q.base;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.RadioGroup.OnCheckedChangeListener;

public abstract class TabActivityBase extends TabActivity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.base_tabhost);
		//
		final TabHost tabHost = getTabHost();
		//
		for(int i = 0; i < getCount(); i++){
			tabHost.addTab(tabHost.newTabSpec(String.valueOf(i))
					.setIndicator(String.valueOf(i))
					.setContent(getIntent(i)));
		}
		tabHost.setCurrentTab(0);
		//
		LayoutInflater inflater = getLayoutInflater();
		Resources res = getResources();
		RadioGroup rg = ((RadioGroup)findViewById(R.id.tabhost_btns_layout));
		RadioButton btn;
		RadioGroup.LayoutParams btnLp = new RadioGroup.LayoutParams(0, RadioGroup.LayoutParams.WRAP_CONTENT, 1);
		for(int i = 0; i < getCount(); i++){
			btn = (RadioButton)inflater.inflate(R.layout.base_tabhost_btn, null);
			btn.setId(i);
			btn.setText(getBtnText(i));
			btn.setCompoundDrawablesWithIntrinsicBounds(0, getBtnDrawable(i), 0, 0);
			btn.setLayoutParams(btnLp);
			rg.addView(btn);
		}
		rg.check(0);
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				tabHost.setCurrentTab(checkedId);
			}
		});
	}
	
	protected abstract int getCount();
	protected abstract Intent getIntent(int position);
	protected abstract String getBtnText(int position);
	protected abstract int getBtnDrawable(int position);
	//protected abstract void initBtns(int position, RadioButton rbtn);
	
	private RadioGroup initRadioGroup(int size){
		//
		RadioGroup rg = new RadioGroup(this);
		rg.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		rg.setOrientation(RadioGroup.HORIZONTAL);
		//rg.setOnCheckedChangeListener(this);
		//
		RadioGroup.LayoutParams rglp0w1 = new RadioGroup.LayoutParams(0, RadioGroup.LayoutParams.WRAP_CONTENT, 1);
		Bitmap rbtnBmNull = null;
		BitmapDrawable rbtnDrawableNull = new BitmapDrawable(rbtnBmNull);
		RadioButton rbtn;
		for(int i = 0; i < size; i++){
			rbtn = new RadioButton(this);
			rbtn.setId(i);
			rbtn.setLayoutParams(rglp0w1);
			rbtn.setButtonDrawable(rbtnDrawableNull);
			rbtn.setGravity(Gravity.CENTER_HORIZONTAL);
			rbtn.setPadding(0, 0, 0, 0);
			//initBtns(i, rbtn);
			rg.addView(rbtn);
		}
		rg.check(0);
		return rg;
	}
}
