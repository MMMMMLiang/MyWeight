package com.sun.view.weight.demo;

import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sun.lib.photo.watcher.ImageWatcherHelper;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author cool.
 * Date: 2019/5/10
 * Time: 18:02
 * Info:
 */
public class WatcherActivity extends AppCompatActivity {
    private ImageWatcherHelper helper;
    private List<Uri> dataList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watcher);

        ImageView img = findViewById(R.id.watcher_img);

        Glide.with(this)
                .load("http://img.hb.aicdn.com/adf79cb0385bfe98456fea7768b12a5ca4eca0b8c81b-Tp0ywW_fw658")
                .into(img);

        dataList.add(Uri.parse("http://img.hb.aicdn.com/adf79cb0385bfe98456fea7768b12a5ca4eca0b8c81b-Tp0ywW_fw658"));

        helper = ImageWatcherHelper.with(this, new GlideLoader())
                .setIndexProvider(new CustomDotIndexProvider());

        final SparseArray<ImageView> mapping = new SparseArray<>();
        mapping.put(0, img);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.show((ImageView) v, mapping, dataList);
            }
        });
    }
}
