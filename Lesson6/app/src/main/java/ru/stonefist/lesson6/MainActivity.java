package ru.stonefist.lesson6;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA = 100;
    private static final int TEXT = 101;
    ImageView imagePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagePhoto = (ImageView)findViewById(R.id.imagePhoto);
    }

    public void OnClickBtn(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn1: startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.btn2:
                intent = new Intent(this, SecondActivity.class);
                intent.putExtra("string", "Я из :" + getLocalClassName());
                startActivity(intent);
                break;
            case R.id.btn3:
                intent = new Intent(this, SecondActivity.class);
                intent.putExtra("String", "Я из " + getLocalClassName()+ " с фото по id");
                intent.putExtra("image", R.drawable.foto3);
                startActivity(intent);
                break;
            case R.id.btn4:
                intent = new Intent(this, SecondActivity.class);
                intent.putExtra("String", "Я из " + getLocalClassName()+ " с фото по байтам");

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.foto3);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);

                byte[] bImage = byteArrayOutputStream.toByteArray();

                intent.putExtra("image", bImage);
                startActivity(intent);
                break;
            // 5ый метод с камерой не получился, не понятно почему не работает CAMERA
            case R.id.btn5:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                startActivityForResult(intent, CAMERA);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA) {
            Bitmap cameraImg = (Bitmap)data.getExtras().get("data");
            imagePhoto.setImageBitmap(cameraImg);
        }
    }
}
