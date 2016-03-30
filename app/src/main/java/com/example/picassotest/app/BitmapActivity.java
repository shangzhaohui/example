package com.example.picassotest.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.picassotest.app.view.MyImageView;

/**
 * Created by shangzhaohui on 16/3/27.
 */
public class BitmapActivity extends  MainBaseActivity {
    MyImageView mImageViewSrc;
    ImageView mImageViewDst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bitmap_actvity_layout);
        Button btn = (Button)findViewById(R.id.btn);
        mImageViewSrc = (MyImageView)findViewById(R.id.image_src);
        mImageViewDst=(ImageView) findViewById(R.id.image_des);
        mImageViewSrc.setBackgroundResource(R.drawable.a);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bitmap bitmap = BitmapUtil.ReadBitmapById(BitmapActivity.this,R.drawable.a);
//
//                mImageViewSrc.setBackground(new BitmapDrawable(BitmapUtil.ImageCrop(bitmap,true)));
                mImageViewSrc.setBitmap();
            }
        });


        Button btnReset = (Button) findViewById(R.id.reset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageViewSrc.setBackgroundResource(R.drawable.a);
            }
        });

        final Button btnChangeStyle = (Button) findViewById(R.id.change_style);
        btnChangeStyle.setText(mImageViewSrc.getStyleStr());
        btnChangeStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mImageViewSrc.changeStyle();
                btnChangeStyle.setText(mImageViewSrc.getStyleStr());
            }
        });

        Button saveBtn = (Button)findViewById(R.id.save);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitmapUtil.saveBitmap(mImageViewSrc.getBitmap());
            }
        });
    }




}
