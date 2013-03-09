package com.example.newrecord;

import java.io.File;
import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaRecorder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NewRecord extends Activity implements OnClickListener, OnCompletionListener{

	TextView statusTextView, amplitudeTextView;
	Button stopRecording, startRecording, playRecording, finishButton;
	MediaRecorder recorder;
	MediaPlayer player;
	RecordAmplitude recordAmplitude;
	boolean isRecording = false;
	
	
	
	File audioFile;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_record);
		
		statusTextView = (TextView) this.findViewById(R.id.StatusTextView);
		statusTextView.setText("Ready");
		
		amplitudeTextView = (TextView) this.findViewById(R.id.AmplitudeTextView);
		amplitudeTextView.setText("0");
		
		stopRecording = (Button) this.findViewById(R.id.StopRecording);
		startRecording = (Button) this.findViewById(R.id.StartRecording);
		playRecording = (Button) this.findViewById(R.id.PlayRecording);
		finishButton = (Button) this.findViewById(R.id.FinishRecording);
		
		startRecording.setOnClickListener(this);
		stopRecording.setOnClickListener(this);
		playRecording.setOnClickListener(this);
		finishButton.setOnClickListener(this);
		
		stopRecording.setEnabled(false);
		playRecording.setEnabled(false);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.activity_new_record, menu);
//		return true;
//		
//
//	}

	@Override
	public void onClick(View v) {
		
		if (v == finishButton)  {
		finish ();	
		}else if (v == stopRecording){
			
			isRecording = false;
			recordAmplitude.cancel(true);
			
			recorder.stop();
			recorder.release();
			
			player = new MediaPlayer();
			player.setOnCompletionListener(this);
			
			try {player.setDataSource(audioFile.getAbsolutePath());
			} catch (IllegalArgumentException e) {
				throw new RuntimeException( "Illegal Arguement to MediaPlayer.setDataSurce", e);
				
			} catch (IllegalStateException e) {
				
				throw new RuntimeException( " Illegal State to MediaPlayer.setDataSurce", e);
			} catch (IOException e) {
				
				throw new RuntimeException( " IOException MediaPlayer.setDataSurce", e);
			}
			
			
			try { 
				
				player.prepare();
			}catch (IllegalStateException e) {	
			throw new RuntimeException( " Illegal State to MediaPlayer.prepare", e);
			} catch (IOException e) {
				
				throw new RuntimeException( " IOException MediaPlayer.prepare", e);
			}
			
			statusTextView.setText("Ready to Play");
			
			playRecording.setEnabled(true);
			stopRecording.setEnabled(false);
			startRecording.setEnabled(true);
		} else if (v == startRecording) {
			

			
			recorder = new MediaRecorder ();
			
			recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
			recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
			recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
			recorder.setMaxDuration(7000);
			
			File path  = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.apress.proandroidmedia.ch07.customrecorder/files/");
			path.mkdirs();
			
			try { 
				audioFile = File.createTempFile("recording", ".3gp", path);
				
				} catch (IOException e) { throw new RuntimeException ("Couldn't create recording audio file", e);
					
					
				} recorder.setOutputFile(audioFile.getAbsolutePath());
				
				
				try { recorder.prepare();
					
					
				} catch (IllegalStateException e) {
					throw new RuntimeException ("IllegalStateException on MediaRecorder.prepare, e");
					
				} catch (IOException e) {
					throw new RuntimeException("IOException on MediaRecorder.prepare", e);
					
				}
			recorder.start();
			
			isRecording = true;
			recordAmplitude = new RecordAmplitude();
			recordAmplitude.execute();
			
			statusTextView.setText("Recording");
			
			playRecording.setEnabled(false);
			stopRecording.setEnabled(true);
			startRecording.setEnabled(false);
			
		} else if (v == playRecording){
			player.start();
			statusTextView.setText("Playing");
			playRecording.setEnabled(false);
			stopRecording.setEnabled(false);
			startRecording.setEnabled(false);		
			
		    }
			
		}


	@Override
	public void onCompletion(MediaPlayer mp) {
	
			playRecording.setEnabled(true);
			stopRecording.setEnabled(false);
			startRecording.setEnabled(true);
			
			statusTextView.setText("Ready");
		
			
	}
	
	private class RecordAmplitude extends AsyncTask<Void, Integer, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			while (isRecording) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e){
					e.printStackTrace();
					
				}
				
				publishProgress(recorder.getMaxAmplitude());
				}
				
				
			return null;
		}
	
		protected void onProgressUpdate(Integer...progress) {
			amplitudeTextView.setText(progress[0].toString());
			
			
		}
	}
	
}


