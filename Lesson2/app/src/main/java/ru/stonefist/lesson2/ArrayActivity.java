package ru.stonefist.lesson2;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Наиль on 09.05.2016.
 */
public class ArrayActivity extends AppCompatActivity {

    TextView planetTxt;
    ImageView planetImage;

    String[] planets;
    TypedArray planetsImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        planetTxt = (TextView)findViewById(R.id.planetTxt);
        planetImage = (ImageView)findViewById(R.id.planetImage);

        Resources res = this.getResources(); // Получение ресурсов на уровне активности

        planets = res.getStringArray(R.array.planets);
        planetsImg = res.obtainTypedArray(R.array.planets_img);
        for(String p: planets){
            Log.d("......", p);
        }

    }

    public void btnClick(View view) {
        int rnd = new Random().nextInt(planets.length);
        this.planetTxt.setText(planets[rnd]);
        this.planetImage.setImageDrawable(planetsImg.getDrawable(rnd));
    }
}
