package com.example.savingstate;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText myEditText;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        myEditText = (EditText) this.findViewById(R.id.editText1);
    }
    
    @Override
    protected void onSaveInstanceState (Bundle outState){
    	outState.putString("editText1", myEditText.getText().toString()); 
    	Log.v("MainActivity","editText1" + myEditText.getText().toString());
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
