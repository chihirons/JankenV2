package janken.abs.co.jp.janken_ver2i_wamoto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

@SuppressLint("Registered")
public class ResultActivity extends AppCompatActivity {

    //紐づけ
    ImageView image;
    ImageView my;
    ImageView cp;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_janken);

        Intent intent = getIntent();
        int User = intent.getIntExtra("User",0);

        image = findViewById(R.id.result_image);
        my = findViewById(R.id.my);
        cp = findViewById(R.id.cp);
        text = findViewById(R.id.result);

        //ランダム生成(0.1.2)の3つの数を生成
        long seed = System.currentTimeMillis();
        Random rnd = new Random(seed);
        int Cp = rnd.nextInt(3);



        Log.d(String.valueOf(User),"MyHand_DATA");

        if (Cp == 0 && User == 0) {
            //CP_G,USER_G...Draw
            image.setImageResource(R.drawable.draw);
            cp.setImageResource(R.drawable.j_gu02);
            text.setText("引き分け");
            my.setImageResource(R.drawable.j_gu02);
        }else if (Cp == 1 && User == 1) {
            //CP_T,USER_T...Draw
            image.setImageResource(R.drawable.draw);
            cp.setImageResource(R.drawable.j_ch02);
            text.setText("引き分け");
            my.setImageResource(R.drawable.j_ch02);
        }else if (Cp == 2 && User == 2) {
            //CP_P,USER_P...Draw
            image.setImageResource(R.drawable.draw);
            cp.setImageResource(R.drawable.j_pa02);
            text.setText("引き分け");
            my.setImageResource(R.drawable.j_pa02);
        }else if (Cp == 0 && User == 1) {
            //CP_G,USER_T...CPWin
            image.setImageResource(R.drawable.lose);
            cp.setImageResource(R.drawable.j_gu02);
            text.setText("あなたの負け..");
            my.setImageResource(R.drawable.j_ch02);
        }else if (Cp == 0 && User == 2) {
            //CP_G,USER_P...CPLoss
            image.setImageResource(R.drawable.win);
            cp.setImageResource(R.drawable.j_gu02);
            text.setText("あなたの勝ち!!");
            my.setImageResource(R.drawable.j_pa02);
        }else if (Cp == 1 && User == 2) {
            //CP_T,USER_P...CPWin
            image.setImageResource(R.drawable.lose);
            cp.setImageResource(R.drawable.j_ch02);
            text.setText("あなたの負け..");
            my.setImageResource(R.drawable.j_pa02);
        }else if (Cp == 1 && User == 0) {
            //CP_T,USER_G...CPLoss
            image.setImageResource(R.drawable.win);
            cp.setImageResource(R.drawable.j_ch02);
            text.setText("あなたの勝ち!!");
            my.setImageResource(R.drawable.j_gu02);
        }else if (Cp == 2 && User == 1) {
            //CP_P,USER_T...CPLoss
            image.setImageResource(R.drawable.win);
            cp.setImageResource(R.drawable.j_pa02);
            text.setText("あなたの勝ち!!");
            my.setImageResource(R.drawable.j_ch02);
        }else if (Cp == 2 && User == 0) {
            //CP_P,USER_G...CPWin
            image.setImageResource(R.drawable.lose);
            cp.setImageResource(R.drawable.j_pa02);
            text.setText("あなたの負け..");
            my.setImageResource(R.drawable.j_gu02);
        }else{
            Log.d(String.valueOf(User),"E");
        }
    }
}
