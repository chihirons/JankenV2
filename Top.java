package janken.abs.co.jp.jankenv2iwamoto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class Top extends AppCompatActivity {

    int loop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        //スピナーのアイテムが選択されたときに呼び出されるコールバックリスナーを登録
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //Spinnerのドラップダウンアイテムが選択さてた時
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Spinnerの場所取得の処理
                Spinner spinner = (Spinner) parent;
                String spinnerS =(String)spinner.getSelectedItem();
                loop = Integer.parseInt(spinnerS);
                Log.d(String.valueOf(loop),"Test");

            }

            //Spinnerのドロップダウンアイテムが選択されなかったとき
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

    }

    public void onClick(View view){
        //シェアードプリファレンス使用のためのおまじない
        SharedPreferences pref =
                PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();

        //ループ回数を保存する
        editor.putInt("GAME_COUNT",loop);
        editor.putInt("COUNT", 1);
        editor.putInt("WIN", 0);
        editor.putInt("LOSS", 0);
        editor.putInt("DRAW", 0);

        //ループ数の保存
        editor.apply();

        Intent intent = new Intent(this,Knaken_select.class);
        startActivity(intent);
    }
}
