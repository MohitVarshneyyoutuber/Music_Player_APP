package com.example.mohit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MusicPlayer extends AppCompatActivity {

    Button btn_next,btn_pause,btn_previous;
    TextView songTextLable;
    SeekBar songSeekbar;
   String sname;
    static MediaPlayer myMediaPlayer;
    int position;
    ArrayList<File> mySongs;
    Thread updateseekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        btn_next=findViewById(R.id.next);
        btn_pause=findViewById(R.id.pause);
        btn_previous=findViewById(R.id.previous);

        songSeekbar=findViewById(R.id.seekBar);

        songTextLable=findViewById(R.id.songLable);

        updateseekBar=new Thread()
        {

            @Override
            public void run() {

          int totalDuration=myMediaPlayer.getDuration();
          int currentPosition=0;

          while(currentPosition<totalDuration)
          {
              try {
                  sleep(500);
                  currentPosition=myMediaPlayer.getCurrentPosition();
                  songSeekbar.setProgress(currentPosition);

              }
              catch (InterruptedException e)
              {
                  e.printStackTrace();
              }

          }

            }
        };

     if(myMediaPlayer!=null)
     {

         myMediaPlayer.stop();
         myMediaPlayer.release();
     }

        Intent i=getIntent();
     Bundle bundle=i.getExtras();
     mySongs=(ArrayList) bundle.getParcelableArrayList("songs");
sname=mySongs.get(position).getName().toString();

String songName=i.getStringExtra("songnsme");
songTextLable.setText(songName);
songTextLable.setSelected(true);

position= bundle.getInt("pos",0);
        Uri u=Uri.parse(mySongs.get(position).toString());

        myMediaPlayer=MediaPlayer.create(getApplicationContext(),u);
        myMediaPlayer.start();
        songSeekbar.setMax(myMediaPlayer.getDuration());

        songSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                myMediaPlayer.seekTo(seekBar.getProgress());
            }
        });
    }
}
