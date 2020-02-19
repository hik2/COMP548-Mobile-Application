package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ViveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vive);
    }

    //Called when user presses the 'Description' or 'Specs' button
    public void selectFragment(View view)
    {
        //Create Fragment object
        Fragment fr;

        //Initialize/assign fr to FragmentDescription
        if (view == findViewById(R.id.buttonDescription))
        {
            fr = new FragmentViveDescription();
        }
        //Otherwise 'Specs' button
        else
        {
            fr = new FragmentViveSpecs();
        }

        //Fragment manager and transaction
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment, fr);
        transaction.commit();
    }

    //Called when the user presses the 'Gallery' button
    public void sendGallery(View view)
    {
        Intent intent = new Intent(this, ViveGalleryActivity.class);
        startActivity(intent);
    }
}
