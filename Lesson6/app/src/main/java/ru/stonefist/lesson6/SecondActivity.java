package ru.stonefist.lesson6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ntairov on 07.06.2016.
 */
public class SecondActivity extends AppCompatActivity {

    TextView txt1;
    ImageView img1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        txt1 = (TextView)findViewById(R.id.txt1);
        img1 = (ImageView)findViewById(R.id.img1);

        //img1.setImageResource(getIntent().getIntExtra("image", android.R.drawable.ic_delete));

        txt1.setText(getIntent().getStringExtra("string"));

        byte[] bImage = getIntent().getByteArrayExtra("image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(bImage, 0, bImage.length);
        img1.setImageBitmap(bitmap);
    }
}
