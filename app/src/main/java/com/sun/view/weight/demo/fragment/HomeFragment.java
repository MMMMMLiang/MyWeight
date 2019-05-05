package com.sun.view.weight.demo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sun.lib.photo.select.EasyPhotos;
import com.sun.view.weight.demo.GlideEngine;
import com.sun.view.weight.demo.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.app.Activity.RESULT_OK;

/**
 * @author Administrator
 */
public class HomeFragment extends Fragment {
    private ImageView img;

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
                        .setFileProviderAuthority("com.sun.view.weight.demo.fileprovider")
                        .start(101);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
                Glide.with(this).load(data.getStringArrayListExtra(EasyPhotos.RESULT_PATHS).get(0)).into(img);
            }
        }
    }
}
