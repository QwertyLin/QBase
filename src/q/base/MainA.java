package q.base;

import java.util.ArrayList;
import java.util.List;

import q.util.AdapterBase;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class MainA extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base);
        
        ListView lv = (ListView)findViewById(R.id.listview);
        
        ArrayList<String> datas = new ArrayList<String>();
        datas.add("a"); datas.add("a"); datas.add("a"); datas.add("a"); datas.add("a"); datas.add("a"); datas.add("a");
        datas.add("a"); datas.add("a"); datas.add("a"); datas.add("a"); datas.add("a"); datas.add("a"); datas.add("a");
        
        lv.setAdapter(new Adapter(this, datas));
        
        Dialog d= new DialogBase(this);
        d.setContentView(R.layout.tui_dialog);
        d.show();
    }
    
    
    
}

class Adapter extends AdapterBase<String, Adapter.Holder> {
	
	public Adapter(Context ctx, List<String> datas) {
		super(ctx, datas);
		// TODO Auto-generated constructor stub
	}

	class Holder {
		
	}

	@Override
	protected int getLayoutId() {
		return R.layout.base_list_item_arrow;
	}

	@Override
	protected Holder getHolder(View v) {
		return new Holder();
	}

	@Override
	protected void initItem(int position, String data, Holder holder) {
		// TODO Auto-generated method stub
		
	}
	
}
