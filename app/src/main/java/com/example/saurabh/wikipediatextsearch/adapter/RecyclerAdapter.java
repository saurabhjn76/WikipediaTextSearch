package com.example.saurabh.wikipediatextsearch.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saurabh.wikipediatextsearch.R;
import com.example.saurabh.wikipediatextsearch.models.WikipediaResultItem;
import com.example.saurabh.wikipediatextsearch.viewholder.ItemViewHolder;

import java.util.List;

/**
 * Created by danilolemes on 13/10/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter {

    private final String TAG = this.getClass().getCanonicalName();

    private List<WikipediaResultItem> list;
    private Context context;

    public RecyclerAdapter(List<WikipediaResultItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.item_search, parent, false);
        return new ItemViewHolder(view, this.context);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        WikipediaResultItem item = list.get(position);

        try {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            viewHolder.getItemTitle().setText(item.getTitle());
            viewHolder.getItemSnippet().setText(Html.fromHtml(item.getSnippet()));
        } catch (Exception e) {
            Log.e(TAG, "[EXCEPTION]", e);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void clear() {
        this.list.clear();
        notifyDataSetChanged();
    }

    public void add(WikipediaResultItem item) {
        this.list.add(item);
        notifyDataSetChanged();
    }

    public void addAll(List<WikipediaResultItem> itens) {
        this.clear();

        this.list.addAll(itens);
        notifyDataSetChanged();
    }
}
