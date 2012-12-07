package q.base;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class UiBaseHeader {
	
	public static final void text(final Activity act, String text){
		((TextView)act.findViewById(R.id.base_header_text)).setText(text);
	}
		
	public static final void btnBack(final Activity act, String text){
		text(act, text);
		ImageButton btn = (ImageButton)act.findViewById(R.id.base_header_btn_left);
		btn.setVisibility(View.VISIBLE);
		btn.setImageResource(R.drawable.base_icon_back);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				act.finish();
			}
		});
	}
	
}
