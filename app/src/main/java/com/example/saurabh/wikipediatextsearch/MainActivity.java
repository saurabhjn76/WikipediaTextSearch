package com.example.saurabh.wikipediatextsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.saurabh.wikipediatextsearch.adapter.RecyclerAdapter;
import com.example.saurabh.wikipediatextsearch.models.WikipediaResponse;
import com.example.saurabh.wikipediatextsearch.models.WikipediaResultItem;
import com.example.saurabh.wikipediatextsearch.services.BaseService;
import com.example.saurabh.wikipediatextsearch.services.WikipediaService;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.edit_query)
    EditText editQuery;

    @BindView(R.id.btn_search)
    Button btnSearch;

    private WikipediaService wikipediaService;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        wikipediaService = BaseService.getInstance().getWikiService();

        setupViews();
        setupRecycler();
    }

    private void setupRecycler() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new RecyclerAdapter(new ArrayList<WikipediaResultItem>(), this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void setupViews() {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = editQuery.getText().toString();

                if (TextUtils.isEmpty(query)) {
                    editQuery.setError("Field cannot be empty");
                } else {
                    doSearch(query.replace(" ", "+"));
                }
            }
        });
    }

    private void doSearch(String query) {
        HashMap<String, String> options = new HashMap<>();
        options.put("srsearch", query);
        options.put("sroffset", "0");
        wikipediaService.search(options).enqueue(new Callback<WikipediaResponse>() {
            @Override
            public void onResponse(Call<WikipediaResponse> call, Response<WikipediaResponse> response) {
                WikipediaResponse wikipediaResponse = response.body();

                if (wikipediaResponse != null) {
                    if (wikipediaResponse.getQuery() != null
                            && wikipediaResponse.getQuery().getSearch() != null
                            && !wikipediaResponse.getQuery().getSearch().isEmpty()) {
                        adapter.addAll(wikipediaResponse.getQuery().getSearch());
                    }
                }
            }

            @Override
            public void onFailure(Call<WikipediaResponse> call, Throwable t) {

            }
        });
    }
}
