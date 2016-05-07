package ru.stonefist.lesson2;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt1;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer button_on = MediaPlayer.create(this,R.raw.button_on);
        final MediaPlayer button_off = MediaPlayer.create(this,R.raw.button_off);

        btn1 = (Button)findViewById(R.id.btn1);

        String name = this.getString(R.string.name);
        Log.d("...", name);

        btn1.setOnTouchListener(new View.OnTouchListener() {
            ;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        button_on.start();
                        Log.d("..........", "DOWN");
                        break;
                    case MotionEvent.ACTION_UP:
                        button_off.start();
                        Log.d("..........", "UP");
                        break;
                }
                return false;
            }
        }
            );
    }
}
