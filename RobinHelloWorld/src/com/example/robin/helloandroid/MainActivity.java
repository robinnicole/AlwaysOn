package com.example.robin.helloandroid;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	TextView myTextView;
	Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("MainActivity", "onCreate Started");
        setContentView(R.layout.activity_main);
        
        myTextView = (TextView) findViewById(R.id.my_textview);
        myButton = (Button) findViewById(R.id.my_button);
        myButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
        
    }

	@Override
	public void onClick(View clickedView) {
	myTextView.setText("Clicked");
	Toast t = Toast.makeText(this,"Hi",Toast.LENGTH_SHORT);
	t.show();
		
	}
    
}
