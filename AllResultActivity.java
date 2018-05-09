package janken.abs.co.jp.janken_ver2i_wamoto;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class AllResultActivity extends AppCompatActivity {

    //紐づけ
    ImageView result_image;
    TextView result_text;
    TextView result_wld;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_result);

        result_image = findViewById(R.id.result_image);
        result_text = findViewById(R.id.result_text);
        result_wld = findViewById(R.id.result_wld);

        //シェアドプリファレンスの変数取得

        //シェアドプリファレンスの仮数値
        int Win = 0, Loss = 0, Draw = 0;

        //総合結果の表示
        if (Win > Loss && Win > Draw){
            result_image.setImageResource(R.drawable.win);
            result_text.setText("あなたの勝ち!!");
            result_wld.setText("");

        }else if (Loss > Win && Loss > Draw){

        }else{

        }
    }
}
