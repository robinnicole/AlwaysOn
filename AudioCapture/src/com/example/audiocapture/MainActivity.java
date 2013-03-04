package com.example.audiocapture;


import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener, OnCompletionListener{

public static int RECORD_REQUEST = 0;
	
	Button createRecording, playRecording;
	
	Uri audioFileUri;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		createRecording = (Button) this.findViewById(R.id.RecordButton);
		createRecording.setOnClickListener(this);
	
		
		
		playRecording = (Button) this.findViewById(R.id.PlayButton);
		playRecording.setOnClickListener(this);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		if (v == createRecording) {
			Intent intent = new Intent (MediaStore.Audio.Media.RECORD_SOUND_ACTION);
			startActivityForResult(intent, RECORD_REQUEST);
			Log.v("MainActivity", "I'm recording");
		} else if ( v== playRecording) {
			Log.v("MainActivity", "I'm playing");
			MediaPlayer mediaPlayer = MediaPlayer.create(this, audioFileUri);
			mediaPlayer.setOnCompletionListener(this);
			mediaPlayer.start();
			playRecording.setEnabled(false);
			Log.v("MainActivity", "I'm playing");
		}
			
		}
	
	
		protected void onActivityResult(int requestCode, int resultCode, Intent data){
			if (resultCode == RESULT_OK && requestCode == RECORD_REQUEST) {
				audioFileUri = data.getData();
				playRecording.setEnabled(true);
				
			}
			
		}
	

	@Override
	public void onCompletion(MediaPlayer mp) {
		playRecording.setEnabled(true);
	}

}
