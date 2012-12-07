package q.base;

import android.app.Dialog;
import android.content.Context;

public class DialogBase extends Dialog {

	public DialogBase(Context context) {
		super(context);
		getWindow().setBackgroundDrawableResource(R.drawable.base_bg_transparent);
		
	}
	

}
