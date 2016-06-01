package ru.stonefist.lesson5_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Profile> profiles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView)findViewById(R.id.lv);

        assert lv != null;
        lv.setAdapter(new CustomAdapter(loadData()));
        final CustomAdapter customAdapter = new CustomAdapter(loadData());
        lv.setAdapter(customAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Нажат пункт: " + position, Toast.LENGTH_SHORT).show();
                profiles.remove(position);
                view.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_in_left));
                customAdapter.notifyDataSetChanged();
            }
        });
    }


    public List<Profile> loadData() {
        for(int i =0; i<50;i++){
            profiles.add(new Profile(R.drawable.foto1, "Nail", "Tairov"));
            profiles.add(new Profile(R.drawable.foto2, "Nail2", "Tairov2"));
        }
        return profiles;
    }
}
