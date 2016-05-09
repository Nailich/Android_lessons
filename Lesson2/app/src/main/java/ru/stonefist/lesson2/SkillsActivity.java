package ru.stonefist.lesson2;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Наиль on 09.05.2016.
 */
public class SkillsActivity extends AppCompatActivity{

    String[] skills;
    ListView listSkills;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_skills);

        listSkills = (ListView)findViewById(R.id.listView_skills);

        Resources res = this.getResources();

        skills = res.getStringArray(R.array.skills);
        for (String s: skills){
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, skills);
            listSkills.setAdapter(adapter);
                    }
    }

    public void onClickBack(View view) {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
