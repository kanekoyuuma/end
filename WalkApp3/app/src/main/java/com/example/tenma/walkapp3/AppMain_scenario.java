package com.example.tenma.walkapp3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Tenma and yuuma on 2017/1/20.
 */

public class AppMain_scenario extends AppCompatActivity {
    String result_str = "";
    TextView tv;
    MediaPlayer bgm;
    static int number;
    SharedPreferences data;
    SharedPreferences.Editor editor1;
    private SoundPool soundPool, soundPool1;
    private int soundId, soundId1;
    boolean Discrimination;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autivity_main_scenario);
    }

    public void onResume() {
        super.onResume();
        //リソースファイルから再生
        bgm = MediaPlayer.create(this, R.raw.story);
        bgm.setLooping(true);
        bgm.start();
        soundPool = new SoundPool(50, AudioManager.STREAM_MUSIC, 0);
        soundId = soundPool.load(getApplicationContext(), R.raw.osuoto, 1);
        soundPool1 = new SoundPool(50, AudioManager.STREAM_MUSIC, 0);
        soundId1 = soundPool1.load(getApplicationContext(), R.raw.coin01, 1);
        data = getSharedPreferences("ZENKAIDATA", MODE_PRIVATE);
        editor1 = data.edit();
        // SharedPreferencesよりデータを読み込む
        number = data.getInt("ZenkaiData", 1);
        Log.v("ccccc", "numberシナリオ初期 " + number);

    }

    protected void onPause() {
        super.onPause();
        bgm.pause();
        bgm = null;
    }

//    protected void localBgmStop() {
//        bgm.pause();
//        bgm.release();
////        bgm = null;
//    }

    boolean osenai = true;

    public void onClick(View view) {
        ImageView cp_chaege = (ImageView) findViewById(R.id.teki_scenario);
        if (osenai) {

            osenai = false;
            // SharedPreferencesよりデータを読み込む
            number = data.getInt("ZenkaiData", 1);
            Log.v("ccccc", "numberボタン押すとき" + number);
            //ディレクトリの文字列作成
            String dbStr = "data/data/" + getPackageName() + "/Sample.db";
            // 実際にDB作成
            //SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbStr,  null );
            Scenario s = new Scenario(getApplicationContext());
            SQLiteDatabase db = s.getReadableDatabase();


            String query_select = "SELECT name FROM menber WHERE id=" + number;

            Cursor cursor = db.rawQuery(query_select, null);

            while (cursor.moveToNext()) {
                int index_name = cursor.getColumnIndex("name");
                String name = cursor.getString(index_name);
                result_str = name + "\n";}
            if (number >= 2) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.zyuusya);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 19) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.ma);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 23) {
                Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.mb);
                cp_chaege.setImageBitmap(bmp2);
            }
            if (number >= 25) {
                Bitmap bmp3 = BitmapFactory.decodeResource(getResources(), R.drawable.mc);
                cp_chaege.setImageBitmap(bmp3);
            }
            if (number >= 27) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.sonzyo);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 40) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.o1);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 42) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.o2);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 46) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.o1);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 48) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.o1);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 63) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.on);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 89) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.mueaminn);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number == 101 || number >= 104 || number >= 110 || number >= 118) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.maa);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 102 || number >= 112 || number >= 116 || number >= 122) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.maab);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 108 || number >= 114 || number >= 120) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.maac);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number == 125) {
//null
            }
            if (number >= 129 || number >= 155) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.bazi);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 149 || number >= 152 || number >= 158) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.kennosuke);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number == 150) {
//            null
            }
            if (number >= 163) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.sikabane);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 203) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.monnbann);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 214 || number >= 239 || number >= 241 || number >= 243 || number >= 246 || number >= 249) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.ou);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 236 || number >= 238 || number >= 240 || number >= 248 || number >= 253 || number >= 244 || number >= 242 || number >= 253) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.on);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 256) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.syounen);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number == 325 || number == 326) {
//            null
            }
            if (number >= 329 || number >= 340) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.seinen);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 342) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.tyouasu);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number >= 337 || number == 365 || number >= 378) {
//           null
            }
            if (number >= 374 || number >= 376) {
                Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.zyuusya);
                cp_chaege.setImageBitmap(bmp1);
            }
            if (number == 17) {Discrimination =false;}
            if (number == 38) {Discrimination =false;}
            if (number == 61) {Discrimination =false;}
            if (number == 99) {Discrimination =false;}
            if (number == 127) {Discrimination =false;}
            if (number == 161) {Discrimination =false;}
            if (number == 201) {Discrimination =false;}
            if (number == 254) {Discrimination =false;}
            if (number == 327) {Discrimination =false;}
            if (number == 367) {Discrimination =false;}


            if (number == 18 && Discrimination == false) {
                onPause();
                Intent intent = new Intent(this, name.class);
                //遷移先の画面を起動
                startActivity(intent);
                Discrimination =true;
            } else if (number == 39 && Discrimination == false) {
                onPause();
                Intent intent = new Intent(this, name.class);
                //遷移先の画面を起動
                startActivity(intent);
                Discrimination =true;
            } else if (number == 62 && Discrimination == false) {
                onPause();
                Intent intent = new Intent(this, name.class);
                //遷移先の画面を起動
                startActivity(intent);
                Discrimination =true;
            }
            else if (number == 100 && Discrimination == false) {
                onPause();
                Intent intent = new Intent(this, name.class);
                //遷移先の画面を起動
                startActivity(intent);
                Discrimination =true;
            } else if (number == 128 && Discrimination == false) {
                onPause();
                Intent intent = new Intent(this, name.class);
                //遷移先の画面を起動
                startActivity(intent);
                Discrimination =true;
            } else if (number == 162 && Discrimination == false) {
                onPause();
                Intent intent = new Intent(this, name.class);
                //遷移先の画面を起動
                startActivity(intent);
                Discrimination =true;
            } else if (number == 202 && Discrimination == false) {
                onPause();
                Intent intent = new Intent(this, name.class);
                //遷移先の画面を起動
                startActivity(intent);
                Discrimination =true;
            }
            else if (number == 255 && Discrimination == false) {
                onPause();
                Intent intent = new Intent(this, name.class);
                //遷移先の画面を起動
                startActivity(intent);
                Discrimination =true;
            } else if (number == 328 && Discrimination == false) {
                onPause();
                Intent intent = new Intent(this, name.class);
                //遷移先の画面を起動
                startActivity(intent);
                Discrimination =true;
            } else if (number == 368 && Discrimination == false) {
                onPause();
                Intent intent = new Intent(this, name.class);
                //遷移先の画面を起動
                startActivity(intent);
                Discrimination =true;
            }
            else if (number == 31) {
                onPause();
                Intent intent = new Intent(this, Batle_Start.class);
                //遷移先の画面を起動
                startActivity(intent);
            } else if (number == 44) {
                onPause();
                Intent intent = new Intent(this, Batle_Start.class);
                //遷移先の画面を起動
                startActivity(intent);
            } else if (number == 75) {
                onPause();
                Intent intent = new Intent(this, Batle_Start.class);
                //遷移先の画面を起動
                startActivity(intent);
            } else if (number == 90) {
                onPause();
                Intent intent = new Intent(this, Batle_Start.class);
                //遷移先の画面を起動
                startActivity(intent);
            } else if (number == 106) {
                onPause();
                Intent intent = new Intent(this, Batle_Start.class);
                //遷移先の画面を起動
                startActivity(intent);
            } else if (number == 140) {
                onPause();
                Intent intent = new Intent(this, Batle_Start.class);
                //遷移先の画面を起動
                startActivity(intent);
            } else if (number == 176) {
                onPause();
                Intent intent = new Intent(this, Batle_Start.class);
                //遷移先の画面を起動
                startActivity(intent);
            } else if (number == 251) {
                onPause();
                Intent intent = new Intent(this, Batle_Start.class);
                //遷移先の画面を起動
                startActivity(intent);
            } else if (number == 309) {
                onPause();
                Intent intent = new Intent(this, Batle_Start.class);
                //遷移先の画面を起動
                startActivity(intent);
            } else if (number == 352) {
                onPause();
                Intent intent = new Intent(this, Batle_Start.class);
                //遷移先の画面を起動
                startActivity(intent);
            } else if (number == 357) {
                onPause();
                Intent intent = new Intent(this, Batle_Start.class);
                //遷移先の画面を起動
                startActivity(intent);
            } else if (number == 360) {
                onPause();
                Intent intent = new Intent(this, Batle_Start.class);
                //遷移先の画面を起動
                startActivity(intent);
            } else if (number == 363) {
                onPause();
                Intent intent = new Intent(this, Batle_Start.class);
                //遷移先の画面を起動
                startActivity(intent);
            }
            else if (number >= 382) {
                onPause();
                Intent intent = new Intent(this, fin.class);
                //遷移先の画面を起動
                startActivity(intent);
            } else {
                soundPool1.play(soundId1, 1f, 1f, 0, 0, 1);    //音の大きさは0fから1fで調整できる
                tv = (TextView) findViewById(R.id.textView3);
                tv.setTextColor(Color.WHITE);
                findViewById(R.id.textView3).startAnimation(AnimationUtils.loadAnimation(this, R.anim.storry));
                tv.setText("    " + result_str + "\n");
                tv.setTextSize(16.0f);
            }
            // tv.setText(String.valueOf(g));
            number++;
//        保存
            editor1.putInt("ZenkaiData", number);
            editor1.commit();

            cursor.close();
            db.close();

            new Handler().postDelayed(new Runnable() {
                public void run() {
                    osenai = true;
                }
            }, 500L);
        }
    }

    public void onStop() {
        super.onStop();
        Log.v("testtt", "number " + number);

        editor1.putInt("ZenkaiData", number);
        editor1.commit();
        Log.v("ccccc", "number保存 " + number);
    }

    public void StatusStart(View view) {
        soundPool.play(soundId, 1f, 1f, 0, 0, 1);    //音の大きさは0fから1fで調整できる
        Intent intent = new Intent(this, AppStatus.class);
        //遷移先の画面を起動
        startActivity(intent);
    }

    public void LogStart(View view) {
        soundPool.play(soundId, 1f, 1f, 0, 0, 1);    //音の大きさは0fから1fで調整できる
        Intent intent = new Intent(this, AppLog.class);
        //遷移先の画面を起動
        startActivity(intent);
    }
}
