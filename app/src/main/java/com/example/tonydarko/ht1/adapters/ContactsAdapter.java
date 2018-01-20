package com.example.tonydarko.ht1.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tonydarko.ht1.R;
import com.example.tonydarko.ht1.items.ContactItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    ArrayList<ContactItem> items;
    Context context;
    OnItemClick onItemClick;

    public ContactsAdapter(ArrayList<ContactItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context)
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(item);
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.bind(items.get(position));
    }

   public interface OnItemClick {
        void onItemClick(int position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView name;
        @BindView(R.id.tv_email)
        TextView email;
        @BindView(R.id.image_view)
        ImageView image;
        @BindView(R.id.card)
        View root;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(ContactItem item) {
            name.setText(item.getName());
            email.setText(item.getEmail());
            image.setImageResource(item.getImage());
        }


        @OnClick(R.id.card)
        void onItemClick() {
            if (onItemClick != null) {
                onItemClick.onItemClick(getAdapterPosition());
            }

        }

    }

}
