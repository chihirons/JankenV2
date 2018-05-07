package janken.abs.co.jp.jankenv2iwamoto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Knaken_select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knaken_select);

        //シェア―ドプリファレンス
        SharedPreferences pref =
                PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();

        int count = pref.getInt("COUNT",1);

        TextView count_battl = findViewById(R.id.count_battl);
        count_battl.setText(count +  "回戦目");

    }

    public void onClick(View v) {
        int User = 0;
        switch (v.getId()) {
            case R.id.gu:
                User = 0;
                break;
            case R.id.tyoki:
                User = 1;
                break;
            case R.id.pa:
                User = 2;
                break;
        }

        Intent intent = new Intent(this,Result_janken.class);
        intent.putExtra("User",User);
        startActivity(intent);
        finish();
    }
}
