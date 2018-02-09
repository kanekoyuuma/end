package com.example.tenma.walkapp3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yuuma on 2017/12/18.
 */

public class fin extends AppCompatActivity {
    TextView tv;
    TextView tv1;
    Timer timer = null;
    Timer timer1 =null;
    int number;
    Handler handle = new Handler();
    Handler handle1 = new Handler();
    private SoundPool soundPool;
    private int soundId;
    MediaPlayer bgm;
    SharedPreferences data;
    SharedPreferences.Editor editor1;
    //BGM関係
    ////////////////////////////////
    @Override
    // 画面が表示される度に実行
    protected void onResume() {
        super.onResume();
//        soundPool = new SoundPool(50, AudioManager.STREAM_MUSIC, 0);
//        soundId = soundPool.load(getApplicationContext(), R.raw.fin, 1);
//        bgmStart();
        bgm = MediaPlayer.create(this, R.raw.fin);
        bgm.setLooping(true);
        bgm.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        bgm.pause();
        bgm = null;
//        bgmPause();
    }
    /////////////////////////////////


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fin);
        data = getSharedPreferences("ZENKAIDATA", MODE_PRIVATE);
        editor1 = data.edit();
        // SharedPreferencesよりデータを読み込む
        number = data.getInt("ZenkaiData", 1);
        Log.v("ccccc", "number " + number);
        tv = (TextView) findViewById(R.id.epilogue_textView);
        tv1 = (TextView) findViewById(R.id.epilogue_1);
        tv.setTextColor(Color.WHITE);
        tv1.setTextColor(Color.WHITE);
        findViewById(R.id.epilogue_textView).startAnimation(AnimationUtils.loadAnimation(this, R.anim.fin1));
        findViewById(R.id.epilogue_1).startAnimation(AnimationUtils.loadAnimation(this, R.anim.fin));
        ImageView imageView = (ImageView) findViewById(R.id.fin);
                            GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(imageView);
                            Glide.with(this).load(R.raw.fingif).into(target);
        tv.setText(
                "FATADEVIL\n\n" +
                        "リーダー\n\n" +
                        "畠山拓也\n\n" +
                        "キャラクターデザイン\n\n" +
                        "作山静弥\n\n" +
                        "画面レイアウト\n\n" +
                        "熊谷天馬・金子侑真\n\n" +
                        "プログラミング\n\n" +
                        "畠山拓也・金子侑真\n\n" +
                        "サウンド\n\n" +
                        "熊谷天馬・金子侑真・作山静弥\n\n" +
                        "スペシャルサンクス\n\n" +
                        "中村よしき\n\n" +
                        "提供元\n\n" +
                        "イラスト屋・任天堂・スクエアエニックス\n\n" +
                        "ユニバーサルエンターテインメント\n\n" +
                        "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
        );
        tv1.setText("おしまい");
        tv.setTextSize(16.0f);
        tv1.setTextSize(26.0f);
        if (timer == null) {
            timer = new Timer();
            timer.schedule(new MyTimer(), 45000); // ミリ秒でセット
        }
        if (timer1 == null) {
            timer1 = new Timer();
            timer1.schedule(new MyTimer1(), 38000); // ミリ秒でセット
        }
    }
//    public void AppStart(View view){
//        Intent intent = new Intent(this, SccrenTitle.class);
//        //遷移先の画面を起動
//        startActivity(intent);
//        timer.cancel();
//
//
//
//    }
    class MyTimer extends TimerTask {
        @Override
        public void run() {
            handle.post(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(fin.this, SccrenTitle.class);
                    //遷移先の画面を起動
                    startActivity(intent);
                    number=0;
                    Log.v("ccccc", "number2回目 " + number);
//                    保存
                    editor1.putInt("ZenkaiData", number);
                    editor1.commit();
                }
            });
        }
    }
    class MyTimer1 extends TimerTask {
        @Override
        public void run() {
            handle1.post(new Runnable() {
                @Override
                public void run() {
                    ImageView imageView2 = (ImageView) findViewById(R.id.saigo);
                    imageView2.setImageResource(R.drawable.maou);
                }
            });
        }
    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction()==KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    // ダイアログ表示など特定の処理を行いたい場合はここに記述
                    // 親クラスのdispatchKeyEvent()を呼び出さずにtrueを返す
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }
}
