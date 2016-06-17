package ru.stonefist.lesson7_notes;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ntairov on 15.06.2016.
 */
public class CustomAdapter extends BaseAdapter {

    List<note> notes;

    public CustomAdapter(List<note> notes) {this.notes = notes;}

    @Override
    public int getCount() {return notes.size();}

    @Override
    public Object getItem(int position) {return position;}

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View v = convertView;

        if (v==null) v = View.inflate(viewGroup.getContext(), R.layout.item_view, null);

        TextView noteName = (TextView)v.findViewById(R.id.noteName);
        noteName.setText(notes.get(position).getNoteName());

        TextView noteDate = (TextView)v.findViewById(R.id.noteDate);
        noteDate.setText(notes.get(position).getNoteDate());

        return v;
    }
}
