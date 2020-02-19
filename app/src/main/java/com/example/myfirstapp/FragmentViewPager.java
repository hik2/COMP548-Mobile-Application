package com.example.myfirstapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentViewPager extends Fragment {
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    public static final String IMAGE_MESSAGE = "IMAGE_MESSAGE";

    public static final FragmentViewPager newInstance(String message, int img){
        FragmentViewPager fragment = new FragmentViewPager();
        Bundle bd1 = new Bundle();
        bd1.putString(EXTRA_MESSAGE, message);
        bd1.putInt(IMAGE_MESSAGE, img);
        fragment.setArguments(bd1);
        return fragment;
    }

    // Inflate the view for the fragment based on the layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String message = getArguments().getString(EXTRA_MESSAGE);
        View view = inflater.inflate(R.layout.activity_gallery, container, false);
        TextView messageTextView = (TextView)view.findViewById(R.id.textViewImageTitle);
        messageTextView.setText(message);
        int img = getArguments().getInt(IMAGE_MESSAGE);
        ImageView image = (ImageView)view.findViewById(R.id.imageViewGallery);
        image.setImageResource(img);
        return view;
    }
}
