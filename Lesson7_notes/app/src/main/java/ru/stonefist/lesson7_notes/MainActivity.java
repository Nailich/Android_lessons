package ru.stonefist.lesson7_notes;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<note> notes = new ArrayList<>();
    EditText noteNew;
    CustomAdapter customAdapter = new CustomAdapter(loadData());
    ListView lv;
    TextView noteName;
    TextView noteDate;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.lv);

        assert lv != null;
        lv.setAdapter(customAdapter);
        //final CustomAdapter customAdapter = new CustomAdapter(loadData());
        //lv.setAdapter(customAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Заметка: " + (position+1) + " удалена", Toast.LENGTH_SHORT).show();
                notes.remove(position);
                customAdapter.notifyDataSetChanged();
            }
        });


        
    }

    public List<note> loadData() {
        for(int i =0; i<2;i++){
            notes.add(new note("Купить хлеба", "16 Jun 2016"));
        }
        return notes;
    }

    public void btnClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                noteNew = (EditText)findViewById(R.id.noteNew);
                notes.add(new note(noteNew.getText().toString(), DateFormat.getDateInstance().format(new Date())));
                customAdapter.notifyDataSetChanged();
                break;
            case R.id.btnColor:
                noteName = (TextView) findViewById(R.id.noteName);
                noteDate = (TextView) findViewById(R.id.noteDate);
                noteDate.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                noteName.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}
