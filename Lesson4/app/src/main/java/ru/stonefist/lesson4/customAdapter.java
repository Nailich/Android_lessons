package ru.stonefist.lesson4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class customAdapter extends BaseAdapter {

    List<contact> contacts;

    public customAdapter(List<contact> contacts) {this.contacts = contacts;}

    @Override

    public int getCount() {return contacts.size();}

    @Override
    public Object getItem(int position) {return position;}

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v==null) v = View.inflate(parent.getContext(), R.layout.item_view, null);

        ImageView contactIcon = (ImageView)v.findViewById(R.id.contactIcon);
        contactIcon.setImageResource(contacts.get(position).getContactIcon());

        TextView number = (TextView)v.findViewById(R.id.number);
        number.setText(contacts.get(position).getNumber());

        TextView contactName = (TextView)v.findViewById(R.id.contactName);
        contactName.setText(contacts.get(position).getContactName());

        TextView contact = (TextView)v.findViewById(R.id.contact);
        contact.setText(contacts.get(position).getContact());

        return v;
    }
}
