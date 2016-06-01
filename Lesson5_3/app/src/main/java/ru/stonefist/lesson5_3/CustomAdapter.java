package ru.stonefist.lesson5_3;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ntairov on 01.06.2016.
 */
public class CustomAdapter extends BaseAdapter {

    List<Profile> profiles;

    public CustomAdapter(List<Profile> profiles){
    this.profiles = profiles;
    }

    @Override
    public int getCount() {
        return profiles.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Log.d(".......", "getView рсботал");

        View v = convertView;
        if (v==null) v = View.inflate(parent.getContext(), R.layout.item_view, null);

        ImageView photo = (ImageView)v.findViewById(R.id.photo);
        photo.setImageResource(profiles.get(position).getPhoto());

        TextView fName = (TextView) v.findViewById(R.id.fName);
        fName.setText(profiles.get(position).getfName());

        TextView sName = (TextView) v.findViewById(R.id.sName);
        sName.setText(profiles.get(position).getsName());

        return v;
    }
}
