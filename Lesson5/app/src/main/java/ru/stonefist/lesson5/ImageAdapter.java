package ru.stonefist.lesson5;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by ntairov on 30.05.2016.
 */
public class ImageAdapter extends BaseAdapter {

    Context mContext;

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 40;
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        Log.d("....", "getView сработал плозиция " + position);
        ImageView v = new ImageView(mContext);
        v.setImageResource(android.R.drawable.star_big_on);
        return v;
    }
}
