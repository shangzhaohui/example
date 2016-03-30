package com.example.picassotest.app;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import com.example.picassotest.app.adapter.MExpandListAdapter;
import com.example.picassotest.app.view.ExpendListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shangzhaohui on 16/3/25.
 */
public class ExpandListViewActivity extends MainBaseActivity {
    ExpendListView mListview;
    MExpandListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expand_listview_activity);
        mListview = (ExpendListView)findViewById(R.id.listview);

        mListview.setExpandView(getImageView());
        mAdapter = new MExpandListAdapter(this);
        mListview.setAdapter(mAdapter);


        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("b");

        mAdapter.setmData(list);
    }

    private  ImageView getImageView () {
        ImageView imageView = new ImageView(this);
        imageView.setBackground(getResources().getDrawable(R.drawable.a));
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup
                .LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(params);
        return  imageView;
    }
}
