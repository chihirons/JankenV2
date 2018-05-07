package janken.abs.co.jp.jankenv2iwamoto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Result_janken extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_janken);

        //CPの手
        int cp;
        //Userの手の情報　0の場合は グー　1の場合は チョキ　2の場合は パー
        int user;
        //ゲーム回数の取得
        int loop;

        //紐づけ
        ImageView image;
        ImageView my_h;
        ImageView cp_h;
        TextView text;
        Button count;

        //紐づけ
        count = findViewById(R.id.count);
        image = findViewById(R.id.result_image);
        my_h = findViewById(R.id.my);
        cp_h = findViewById(R.id.cp);
        text = findViewById(R.id.result);

        //シェア―ドプリファレンス
        SharedPreferences pref =
                PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();

        //インテント内容を取得するための変数
        Intent intent;

        //インテント内容を取得する
        intent = getIntent();
        //手のSelect画面からの情報　Userの手の情報エラーの場合は0を返す
        user = intent.getIntExtra("User",0);

        //CPのじゃんけん結果を決める
        //ランダム生成(0.1.2)の3つの数を生成
        long seed = System.currentTimeMillis();
        Random rnd = new Random(seed);
        cp = rnd.nextInt(3);

        //BattleResultの格納 Userが 0は負け 1は勝 2は引き分け
        int BattleResult = 0;

            //Userのじゃんけん結果とPCの結果を照合する
            //引き分けの場合の処理
            if (user == cp) {
                switch (user) {
                    case 0: //グーで引き分けの場合
                        //CP_G,USER_G...Draw
                        image.setImageResource(R.drawable.draw);
                        cp_h.setImageResource(R.drawable.j_gu02);
                        text.setText("引き分け");
                        my_h.setImageResource(R.drawable.j_gu02);
                        BattleResult = 2;
                        break;
                    case 1: //チョキで引き分けの場合
                        //CP_T,USER_T...Draw
                        image.setImageResource(R.drawable.draw);
                        cp_h.setImageResource(R.drawable.j_ch02);
                        text.setText("引き分け");
                        my_h.setImageResource(R.drawable.j_ch02);
                        BattleResult = 2;
                        break;
                    case 2: //パーで引き分けの場合
                        //CP_P,USER_P...Draw
                        image.setImageResource(R.drawable.draw);
                        cp_h.setImageResource(R.drawable.j_pa02);
                        text.setText("引き分け");
                        my_h.setImageResource(R.drawable.j_pa02);
                        BattleResult = 2;
                        break;
                }
            }else{
                //引き分け以外の結果だった場合
                switch (user){
                    case 0://Userがグーだった場合
                        if (cp == 1){//CPがチョキの場合
                            //CP_T,USER_G...CPLoss
                            image.setImageResource(R.drawable.win);
                            cp_h.setImageResource(R.drawable.j_ch02);
                            text.setText("あなたの勝ち!!");
                            my_h.setImageResource(R.drawable.j_gu02);
                            BattleResult = 1;
                            break;
                        }else{//CPがパーの場合
                            //CP_P,USER_G...CPWin
                            image.setImageResource(R.drawable.lose);
                            cp_h.setImageResource(R.drawable.j_pa02);
                            text.setText("あなたの負け..");
                            my_h.setImageResource(R.drawable.j_gu02);
                            BattleResult = 0;
                            break;
                        }
                    case 1://Userがチョキだった場合
                        if (cp == 2){//CPがパーだった場合
                            //CP_P,USER_T...CPLoss
                            image.setImageResource(R.drawable.win);
                            cp_h.setImageResource(R.drawable.j_pa02);
                            text.setText("あなたの勝ち!!");
                            my_h.setImageResource(R.drawable.j_ch02);
                            BattleResult = 1;
                            break;
                        }else{//CPがグーだった場合
                            //CP_G,USER_T...CPWin
                            image.setImageResource(R.drawable.lose);
                            cp_h.setImageResource(R.drawable.j_gu02);
                            text.setText("あなたの負け..");
                            my_h.setImageResource(R.drawable.j_ch02);
                            BattleResult = 0;
                            break;
                        }
                    case 2://Userがパーだった場合
                        if (cp == 0){//CPがグーだった場合
                            //CP_G,USER_P...CPLoss
                            image.setImageResource(R.drawable.win);
                            cp_h.setImageResource(R.drawable.j_gu02);
                            text.setText("あなたの勝ち!!");
                            my_h.setImageResource(R.drawable.j_pa02);
                            BattleResult = 1;
                            break;
                        }else {//CPがチョキだった場合
                            //CP_T,USER_P...CPWin
                            image.setImageResource(R.drawable.lose);
                            cp_h.setImageResource(R.drawable.j_ch02);
                            text.setText("あなたの負け..");
                            my_h.setImageResource(R.drawable.j_pa02);
                            BattleResult = 0;
                            break;
                        }
                        default:
                            Log.d(String.valueOf(cp),"ER");
                }///hghghg
            }

            //BattleResultの格納 Userが 0は負け 1は勝 2は引き分け
            switch (BattleResult){
                case 0://負け
                    // 負け結果にシェアードプリファレンスを加算
                    int loos = pref.getInt("LOOS", 0);
                    Log.d(String.valueOf(loos),"LOOSTest");
                    editor.putInt("LOOS", loos + 1);
                    break;
                case 1://勝ち
                    // 勝ち結果にシェアードプリファレンスを加算
                    int win = pref.getInt("WIN", 0);
                    Log.d(String.valueOf(win),"WINTest");
                    editor.putInt("WIN", win + 1);
                    break;
                case 2://引き分け
                    // 引き分け結果にシェアードプリファレンスを加算
                    int draw = pref.getInt("DRAW", 0);
                    Log.d(String.valueOf(draw),"DRAWTest");
                    editor.putInt("DRAW", draw + 1);
                    break;
            }

            loop = pref.getInt("GAME_COUNT", 0);
            Log.d(String.valueOf(loop),"Test2");
            int counts = pref.getInt("COUNT", 0);
            //取得確認用
            Log.d(String.valueOf(loop),"Massage");
            int i;
            for (i = loop; i >= counts; counts++){
                //じゃんけん回数を計測
                editor.putInt("GAME_COUNT", loop);
                editor.putInt("COUNT", counts);
                Log.d(String.valueOf(loop),"Massage");
                Log.d(String.valueOf(counts),"count_set");
            }
            if (loop != counts){
                count.setText("結果画面へ");
                Intent intents = new Intent(this,All_result.class);
                startActivity(intents);
            }else {
                Intent intents = new Intent(this,Knaken_select.class);
                startActivity(intents);
            }
            editor.apply();

       // finish();
    }
}
