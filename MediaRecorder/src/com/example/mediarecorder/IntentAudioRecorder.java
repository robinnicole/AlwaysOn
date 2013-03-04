package com.example.mediarecorder;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntentAudioRecorder extends Activity implements OnClickListener, OnCompletionListener{
	
	public static int RECORD_REQUEST = 0;
	
	Button createRecording, playRecording;
	
	Uri audioFileUri;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		createRecording = (Button) this.findViewById(R.id.RecordButton);
		createRecording.setOnClickListener(this);
		Log.v("IntentAudioRecorder", "I'm recording");
		
		
		playRecording = (Button) this.findViewById(R.id.PlayButton);
		playRecording.setOnClickListener(this);
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.activity_main, menu);
//		return true;
//	}
//
//
//
//
//
//
//
//	@Override
//	public void onClick(View arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//
//
//
//
//	@Override
//	public void onCompletion(MediaPlayer arg0) {
//		// TODO Auto-generated method stub
//		
//	}

}
