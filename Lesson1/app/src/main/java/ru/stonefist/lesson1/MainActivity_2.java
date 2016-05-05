package ru.stonefist.lesson1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity_2 extends AppCompatActivity {

    TextView txtHello;
    boolean refresher = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        txtHello = (TextView)findViewById(R.id.txtHello);
        Log.d("...", "Сработал onCREATE");

    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d("...", "Сработал onDESTROY");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        txtHello.setText("Are you Back?");
    }

    public void bttHello(View view) {
        if (refresher) {
            txtHello.setText(R.string.button2);}
        else txtHello.setText(R.string.button1);
        refresher = !refresher;

    }
}
