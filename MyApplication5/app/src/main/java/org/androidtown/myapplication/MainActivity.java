package org.androidtown.myapplication;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri; import android.os.Bundle; import android.support.v7.app.AppCompatActivity; import android.view.View; import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer1;
    RelativeLayout audio1;
    RelativeLayout audio2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audio1 = (RelativeLayout) findViewById(R.id.audio1);
        audio2 = (RelativeLayout) findViewById(R.id.audio2);

    }

    public void play1(View view){

       // mediaPlayer1.start();
        if(mediaPlayer1!=null){
            mediaPlayer1.release();//음악1중지
        }
            mediaPlayer1 = mediaPlayer1.create(audio1.getContext(), R.raw.music1);//음악1과 연결
        mediaPlayer1.start();//음악1시작
        audio2.setBackgroundColor(Color.WHITE);
        audio1.setBackgroundColor(Color.GRAY);

    }

    public void play2(View view){
        if(mediaPlayer1!=null){
            mediaPlayer1.release();//음악2중지
        }
        mediaPlayer1 = mediaPlayer1.create(audio2.getContext(), R.raw.music2);//음악2와 연결
        mediaPlayer1.start();//음악2시작
        audio1.setBackgroundColor(Color.WHITE);
        audio2.setBackgroundColor(Color.GRAY);
    }
    protected void onDestroy(){ super.onDestroy(); killMediaPlayer(); }
    private void killMediaPlayer(){ if(mediaPlayer1!=null){ try{mediaPlayer1.release(); } catch (Exception e){ e.printStackTrace(); } } }//미디어 없애기

}