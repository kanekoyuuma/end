package com.example.tenma.walkapp3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yuuma on 2017/1/25.
 */

public class name extends AppCompatActivity {
    TextView tv1;
    private SoundPool soundPool;
    private int soundId;
    MediaPlayer bgm;
    Timer timer = null;
    Handler handle = new Handler();
    SharedPreferences muraname;
    SharedPreferences.Editor editor2;
    int banngou ;
    String[] Village = {"あああ"+"あああああ"+"さ゛くそんのむら", "し゛ゅと゛のと゛うくつ", "のあにーのれむら", "しえーのまち", "とっるかのまち", "まんし゛だに", "ちゃいんのもり","ふ゜らんかのしろ","ささ゛んくろす","ありあは゛んのしろ","えんて゛ぃんく゛"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        soundPool = new SoundPool(50, AudioManager.STREAM_MUSIC, 0);
//        soundId = soundPool.load(getApplicationContext(), R.fin.gameover3, 1);

        muraname = getSharedPreferences("MURADATA_NAME", MODE_PRIVATE);
        editor2 = muraname.edit();

        // SharedPreferencesよりデータを読み込む
        banngou = muraname.getInt("BANGOU", 3);
        Log.v("ccccc", "呼び出し" + banngou+"    "+Village[banngou]);

        //リソースファイルから再生
//        bgm = MediaPlayer.create(this, R.raw.child_bully);
//        bgm.start();
//        bgm.setLooping(true);
//        soundPool.play(soundId, 1f, 1f, 0, 0, 1);    //音の大きさは0fから1fで調整できる
        tv1 = (TextView) findViewById(R.id.dainannsyou);
        tv1.setTextColor(Color.WHITE);
        findViewById(R.id.dainannsyou).startAnimation(AnimationUtils.loadAnimation(this, R.anim.die));
        tv1.setTypeface(Typeface.createFromAsset(getAssets(), "DragonQuestFCIntact.ttf"));
        tv1.setText(Village[banngou]);
        Log.v("ccccc", "表示" + banngou+"    "+Village[banngou]);
        tv1.setTextSize(40.0f);
        if (timer == null) {
            timer = new Timer();
            timer.schedule(new MyTimer(), 3000); // ミリ秒でセット
        }
    }

    class MyTimer extends TimerTask {
        @Override
        public void run() {
            handle.post(new Runnable() {
                @Override
                public void run() {
//                    onPause();
                    Intent intent = new Intent(name.this, AppMain_scenario.class);
                    //遷移先の画面を起動
                    startActivity(intent);
                    banngou++;
                    editor2.putInt("BANGOU", banngou);
                    editor2.apply();
                    Log.v("ccccc", "たすく移動：" + banngou+"    "+Village[banngou]);
                }
            });
        }
    }
//    protected void localBgmStop() {
//        bgm.pause();
//        bgm.release();
//        bgm = null;
//    }
//    protected void onPause() {
//        super.onPause();
//        bgm.pause();
//    }
//    public void MainBack(View view){
//        Intent intent = new Intent(this, AppMain_scenario.class);
//        //遷移先の画面を起動
//        startActivity(intent);
//        banngou++;
//        timer.cancel();
//        Log.v("ccccc", "たすく2移動" + banngou+"    "+Village[banngou]);
//    }
}
