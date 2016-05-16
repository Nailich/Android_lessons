package ru.stonefist.lesson2;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by Наиль on 09.05.2016.
 */
public class ContactsActivity extends AppCompatActivity{

    String[] contacts;
    ListView contactsList;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contacts);


        contactsList = (ListView) findViewById(R.id.listView_contacts);

        Resources res = getResources();
        contacts = res.getStringArray(R.array.contacts);

        for (String c : contacts) {

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        contactsList.setAdapter(adapter);
    }
    }

    public void onClickBack(View view) {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
