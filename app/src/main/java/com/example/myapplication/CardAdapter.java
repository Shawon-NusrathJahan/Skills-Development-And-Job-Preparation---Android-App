package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends BaseAdapter {
    private Context context;
    private List<CardItem> cardItems;

    public CardAdapter(Context context, List<CardItem> cardItems) {
//        super(context, 0, cardItems);
        this.context = context;
        this.cardItems = cardItems;
    }

    @Override
    public int getCount() {
        return cardItems.size();
    }

    @Override
    public Object getItem(int position) {
        return cardItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item_card, parent, false);
        }

        CardItem currentItem = (CardItem) getItem(position);

        ImageView imageView = convertView.findViewById(R.id.card_image);
        ImageView iconView = convertView.findViewById(R.id.card_icon);
        TextView titleView = convertView.findViewById(R.id.card_title);

        imageView.setImageResource(currentItem.getImageResId());
        iconView.setImageResource(currentItem.getIconResId());
        titleView.setText(currentItem.getTitle());

        return convertView;
    }
}

