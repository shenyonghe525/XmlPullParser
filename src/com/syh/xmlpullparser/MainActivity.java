package com.syh.xmlpullparser;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author shenyonghe
 * 
 *         2014-10-5
 */
public class MainActivity extends Activity {
    private TextView show;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		show = (TextView)findViewById(R.id.tv_show);
		show.setMovementMethod(ScrollingMovementMethod.getInstance());
	}

	/**
	 * Tile:xmlPullParser Desciption:
	 * 
	 * @param view
	 *            void
	 */
	public void xmlPullParser(View view) {
	   List<SmsInfoBean> smsinfos = new ArrayList<SmsInfoBean>();
       File file = new File(Environment.getExternalStorageDirectory(), "smsino.xml");
       try {
		FileInputStream fis = new FileInputStream(file);
		Xmlpullparser xmlpullparser = new Xmlpullparser();
		smsinfos = xmlpullparser.pullParser(fis);
		StringBuffer sb = new StringBuffer();
		for (SmsInfoBean info : smsinfos) {
			String  temp = info.toString();
			sb.append(temp);
			sb.append("\n");
		}
		show.setText(sb.toString());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
		Toast.makeText(this, "解析数据失败", Toast.LENGTH_SHORT).show();
	}
	}

	
}
