package ru.stonefist.lesson2;

import android.content.Intent;
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
    Button buttonBack;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer button_fio = MediaPlayer.create(this,R.raw.fio);

        btn1 = (Button)findViewById(R.id.btn1);
        buttonBack = (Button)findViewById(R.id.buttonBack);

        btn1.setOnTouchListener(new View.OnTouchListener() {
            ;

           public boolean onTouch(View view, MotionEvent motionEvent) {
              switch (motionEvent.getAction()) {
                  case MotionEvent.ACTION_DOWN:
                        Log.d("..........", "DOWN");
                        break;
                    case MotionEvent.ACTION_UP:
                      //  button_fio.start();
                      Log.d("..........", "UP");
                        break;
                }
               return false;
            }
        }
        );

    }

    public void onClickFio(View view) {
        final MediaPlayer button_fio = MediaPlayer.create(this,R.raw.fio);
        button_fio.start();
        btn1.animate().scaleX(0.75f).scaleY(0.75f).setDuration(500);
        Intent intent=new Intent(this, FioActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClickContacts(View view) {
        final MediaPlayer button_contacts = MediaPlayer.create(this,R.raw.contacts);
        button_contacts.start();
        Intent intent=new Intent(this, ContactsActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClickSkills(View view) {
        final MediaPlayer button_skills = MediaPlayer.create(this,R.raw.skills);
        button_skills.start();
        Intent intent=new Intent(this, SkillsActivity.class);
        startActivity(intent);
        finish();
    }

    public void testLayout(View view) {
        Intent intent=new Intent(this, VideoActivity.class);
        startActivity(intent);
        finish();
    }
}
