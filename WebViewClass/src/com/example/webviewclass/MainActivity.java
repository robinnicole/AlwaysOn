package com.example.webviewclass;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends Activity {

		Button myButton;
	
	WebView webview;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myButton = (Button) this.findViewById(R.id.button1);
		
		//webview = new WebView(this);
		//webview.loadUrl("http://itp.nyu.edu/~sve204/alwaysonalwaysconnected_spring13/week3.html");
		//setContentView(webview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void buttonClicked (View clickedview) {
		
		if (clickedview == myButton) {
			

			Intent intent = new Intent(Intent.ACTION_VIEW); 
			Uri uri = Uri.parse("http://cargocollective.com/robinreid"); 
			intent.setData(uri); 
			startActivity(intent);
			
	
		}
		
		
	}

}
