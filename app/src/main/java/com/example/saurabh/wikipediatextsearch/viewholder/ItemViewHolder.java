package com.example.saurabh.wikipediatextsearch.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.saurabh.wikipediatextsearch.R;

/**
 * Created by danilolemes on 13/10/2017.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private final TextView itemTitle;
    private final TextView itemSnippet;
    private Context context;


    public ItemViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        itemTitle = (TextView) itemView.findViewById(R.id.item_title);
        itemSnippet = (TextView) itemView.findViewById(R.id.item_snippet);
    }

    public TextView getItemTitle() {
        return itemTitle;
    }

    public TextView getItemSnippet() {
        return itemSnippet;
    }
}
