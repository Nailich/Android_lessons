package ru.stonefist.lesson7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by ntairov on 14.06.2016.
 */
public class FourthActivity extends AppCompatActivity {

    private final String F_NAME = "D_A_T_E";
    File file;
    EditText edName;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_layout);

        edName = (EditText)findViewById(R.id.edName);
        textView = (TextView) findViewById(R.id.textView);

        file = new File(getFilesDir(), F_NAME);

    }

    public void onBtnClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:    //save file on Click
                try {
                    FileOutputStream outputStream = new FileOutputStream(file);
                    outputStream.write(edName.getText().toString().getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnLoad:      //load File on Click
                int length = (int)file.length();  //зунали длину файла
                byte[] bytes = new byte[length];  // создали массив с длинной файла

                try {
                    FileInputStream inputStream = new FileInputStream(file);
                    inputStream.read(bytes);
                    inputStream.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                textView.setText(new String(bytes));
                break;
            case R.id.btnDelete:    //Delete File
                file.delete();
        }
    }


}
