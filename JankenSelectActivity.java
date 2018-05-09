package janken.abs.co.jp.janken_ver2i_wamoto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

@SuppressLint("Registered")
public class JankenSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.knaken_select);
    }

    int G_Check = 0;
    int T_Check = 1;
    int P_Check = 2;

    public void onClick(View v){
        int User = 0;
        switch(v.getId()){
            case R.id.gu:
                Log.d(String.valueOf(G_Check),"Test");
                User = 0;
                break;
            case R.id.tyoki:
                Log.d(String.valueOf(T_Check),"Test");
                User = 1;
                break;
            case R.id.pa:
                User = 2;
                Log.d(String.valueOf(P_Check),"Test");
                break;
        }
//        intent.putExtra("MyHand",0);
//        intent.putExtra("MyHand",1);
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("User",User);
        Log.d(String.valueOf(User),"Go");
        startActivity(intent);

    }
}
