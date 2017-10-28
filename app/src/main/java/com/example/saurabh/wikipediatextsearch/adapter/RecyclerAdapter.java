package com.example.saurabh.wikipediatextsearch.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saurabh.wikipediatextsearch.ArticleViewActivity;
import com.example.saurabh.wikipediatextsearch.R;
import com.example.saurabh.wikipediatextsearch.models.WikipediaResultItem;
import com.example.saurabh.wikipediatextsearch.viewholder.ItemViewHolder;

import java.io.Serializable;
import java.util.List;

/**
 * Created by danilolemes on 13/10/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private final String TAG = this.getClass().getCanonicalName();

    private List<WikipediaResultItem> list;
    private Context context;

    public RecyclerAdapter(List<WikipediaResultItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.item_search, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        WikipediaResultItem item = list.get(position);

        try {
            holder.articleTitle.setText(item.getTitle());
            holder.article.setText(Html.fromHtml(item.getSnippet()));
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

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        LinearLayout articleLayout;
        TextView articleTitle;
        TextView article;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            articleLayout = (LinearLayout) itemView.findViewById(R.id.article_layout);
            articleTitle = (TextView) itemView.findViewById(R.id.item_title);
            article = (TextView) itemView.findViewById(R.id.item_snippet);

        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent intent = new Intent(context, ArticleViewActivity.class);
            WikipediaResultItem data = list.get(getLayoutPosition());
            intent.putExtra("data", data);
            context.startActivity(intent);
        }
    }
}
