package com.example.tonydarko.ht1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tonydarko.ht1.R;
import com.example.tonydarko.ht1.items.ContactItem;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends BaseAdapter {

    Context context;
    ArrayList<ContactItem> list;

    public ContactsAdapter(Context context, ArrayList<ContactItem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        TextView name = root.findViewById(R.id.tv_name);
        TextView email = root.findViewById(R.id.tv_email);
        ImageView image = root.findViewById(R.id.image_view);

        name.setText(list.get(position).getName());
        email.setText(list.get(position).getEmail());
        image.setImageResource(R.mipmap.ic_launcher);

        return root;
    }
}
