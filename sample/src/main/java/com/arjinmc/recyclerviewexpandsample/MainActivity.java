package com.arjinmc.recyclerviewexpandsample;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arjinmc.expandrecyclerview.adapter.RecyclerViewAdapter;
import com.arjinmc.expandrecyclerview.adapter.RecyclerViewSingleTypeProcessor;
import com.arjinmc.expandrecyclerview.adapter.RecyclerViewViewHolder;
import com.arjinmc.expandrecyclerview.style.RecyclerViewStyleHelper;
import com.arjinmc.recyclerviewdecoration.RecyclerViewItemDecoration;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvList = findViewById(R.id.rv_list);
        rvList.addItemDecoration(new RecyclerViewItemDecoration.Builder(this)
                .color(Color.GRAY)
                .thickness(5)
                .create());
        RecyclerViewStyleHelper.toLinearLayout(rvList, LinearLayout.VERTICAL);
        String[] titles = getResources().getStringArray(R.array.best_practices);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter<>(this, Arrays.asList(titles)
                , R.layout.item_main_list
                , new RecyclerViewSingleTypeProcessor<String>() {
            @Override
            public void onBindViewHolder(RecyclerViewViewHolder holder, final int position, String str) {
                TextView textView = holder.getView(R.id.tv_content);
                textView.setText(str);
//                textView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        clickPosition(position);
//                    }
//                });
            }

        });
        rvList.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                clickPosition(position);
            }
        });

    }

    private void clickPosition(int position) {
        switch (position) {
            case 0:
                jumpToActivity(ListActivity.class);
                break;
            case 1:
                jumpToActivity(ViewPagerDemoActivity.class);
                break;
            case 2:
                jumpToActivity(GroupListActivity.class);
                break;
            case 3:
                jumpToActivity(GroupGridActivity.class);
                break;
            case 4:
                jumpToActivity(GroupStickyActivity.class);
                break;
        }
    }

    private void jumpToActivity(Class clz) {
        startActivity(new Intent(this, clz));
    }

}
