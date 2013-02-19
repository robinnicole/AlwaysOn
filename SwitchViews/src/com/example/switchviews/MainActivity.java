package com.example.switchviews;

import org.w3c.dom.Text;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	
	Button myButton;
	TextView myTextView;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        myButton = (Button) this.findViewById(R.id.myButton);
        myButton.setOnClickListener(this);
        myTextView = (TextView) this.findViewById(R.id.my_textview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onClick(View clickedView) {
		
	
		if (myTextView.getVisibility() == View.VISIBLE){
		myTextView.setVisibility(View.INVISIBLE);
		}else { myTextView.setVisibility(View.VISIBLE);}
		
	}
    
}
 