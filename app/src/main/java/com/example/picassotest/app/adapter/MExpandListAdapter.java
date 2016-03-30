package com.example.picassotest.app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.picassotest.app.ExpandListViewActivity;
import com.example.picassotest.app.R;

import java.util.List;

/**
 * Created by shangzhaohui on 16/3/25.
 */
public class MExpandListAdapter extends BaseAdapter {
    ExpandListViewActivity mContext;
    public  MExpandListAdapter(ExpandListViewActivity activity) {
        mContext = activity;
    }
    List<String> mData;
    @Override
    public int getCount() {
        if (mData ==null) {
            return  0;
        }
        return mData.size();
    }

    @Override
    public String getItem(int i) {
        if (mData == null || i <0 || i> mData.size()-1) {
            return null;
        }
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_string,viewGroup,false);
            TextView tv = (TextView)view.findViewById(R.id.textview);
            viewHolder = new ViewHolder();
            viewHolder.tv = tv;

            view.setTag(viewHolder);
        }else {
             viewHolder = (ViewHolder)view.getTag();
        }

        viewHolder.tv.setText(getItem(i));
        return view;
    }

    public void setmData(List list) {
        mData = list;
    }

    public static class ViewHolder{
        TextView tv;
    }
}
