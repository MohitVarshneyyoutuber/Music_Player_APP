package com.example.mohit;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MusicPlayer extends AppCompatActivity {

    Button btn_next,btn_pause,btn_previous;
    TextView songTextLable;
    SeekBar sb;

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

        sb=findViewById(R.id.seekBar);

        songTextLable=findViewById(R.id.songLable);







    }
}
