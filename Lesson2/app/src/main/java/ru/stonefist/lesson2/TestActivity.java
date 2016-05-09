package ru.stonefist.lesson2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by Наиль on 09.05.2016.
 */
public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contacts);
    }
    public void onClickFio(View view) {

        Intent intent=new Intent(this, MainActivity.class);
        //intent.setClass(this, ArrayActivity.class);
       // Log.d(".........", "Doshli");
        startActivity(intent);
        finish();
    }
}
