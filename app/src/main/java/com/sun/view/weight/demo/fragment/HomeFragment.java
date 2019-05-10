package com.sun.view.weight.demo.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sun.lib.photo.select.EasyPhotos;
import com.sun.lib.photo.watcher.ImageWatcherHelper;
import com.sun.view.weight.demo.CustomDotIndexProvider;
import com.sun.view.weight.demo.CustomLoadingUIProvider;
import com.sun.view.weight.demo.GlideEngine;
import com.sun.view.weight.demo.GlideLoader;
import com.sun.view.weight.demo.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.app.Activity.RESULT_OK;

/**
 * @author Administrator
 */
public class HomeFragment extends Fragment {
    private ImageView img;

    private ImageWatcherHelper helper;
    private List<Uri> dataList = new ArrayList<>();
    private boolean isTranslucentStatus = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, null);
        TextView text = view.findViewById(R.id.fragment_text);
        img = view.findViewById(R.id.fragment_img);
        text.setText("FRAGMENT_A");

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EasyPhotos.createAlbum(HomeFragment.this, true, GlideEngine.getInstance())
                        .setFileProviderAuthority("com.sun.view.weight.demo.provider")
                        .start(101);
            }
        });

        /**
         * // 一般来讲， ImageWatcher 需要占据全屏的位置
         * // 自定义index
         * // 骰子loading
         */
        helper = ImageWatcherHelper.with(getActivity(), new GlideLoader())
                .setIndexProvider(new CustomDotIndexProvider())
                .setLoadingUIProvider(new CustomLoadingUIProvider());

        final SparseArray<ImageView> mapping = new SparseArray<>();
        mapping.put(0, img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.show(img, mapping, dataList);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
                String path = data.getStringArrayListExtra(EasyPhotos.RESULT_PATHS).get(0);
                Glide.with(this)
                        .load(path)
                        .into(img);
                dataList.add(pathToUri(path));
            }
        }
    }

    private Uri pathToUri(String path){
        File file = new File(path);
        if (file.exists()){
            return Uri.fromFile(file);
        }
        return null;
    }
}
