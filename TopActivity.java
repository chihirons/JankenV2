package janken.abs.co.jp.janken_ver2i_wamoto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;

public class TopActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_top);

       // Spinner spinner = findViewById(R.id.)
    }

    public void onClick(View view){
        Intent intent = new Intent(this,JankenSelectActivity.class);
        startActivity(intent);
    }
}
