package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListImageActivity extends AppCompatActivity {

    int[] vr_images = new int[]{
            R.drawable.oculus_rift_icon, R.drawable.vive_icon, R.drawable.samsung_gear_vr_icon,
            R.drawable.playstation_vr_icon, R.drawable.samsung_odyssey_icon
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_image);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String name = intent.getStringExtra(StartActivity.EXTRA_MESSAGE);

        //Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textViewWelcome);
        textView.setText(getString(R.string.text_welcome) + name + getString(R.string.text_welcome_em));

        final List<HashMap<String, String>> vrList = new ArrayList<HashMap<String, String>>();

        for(int i = 0; i < 5; i++)
        {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("vr_name", getResources().getStringArray(R.array.text_vr_names)[i]);
            hm.put("vr_company", getResources().getStringArray(R.array.text_vr_companies)[i]);
            hm.put("vr_image", Integer.toString(vr_images[i]));
            vrList.add(hm);
        }

        String[] from = {"vr_image", "vr_name", "vr_company"};
        int[] to = {R.id.imageViewVr, R.id.textViewVrName, R.id.textViewVrCompany};

        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), vrList, R.layout.mylist, from, to);
        ListView listView = (ListView) findViewById(R.id.listViewVr);
        listView.setAdapter(adapter);

        // Called when the user taps on one of the ListView items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Oculus Rift
                if( position == 0 )
                {
                    Intent intent = new Intent ( view.getContext(), OculusRiftActivity.class );
                    startActivityForResult( intent, 0 );
                }
                // HTC Vive
                else if( position == 1 )
                {
                    Intent intent = new Intent ( view.getContext(), ViveActivity.class );
                    startActivityForResult( intent, 0 );
                }
                // Samsung Gear VR
                else if( position == 2 )
                {
                    Intent intent = new Intent ( view.getContext(), GearActivity.class );
                    startActivityForResult( intent, 0 );
                }
                // Playstation VR
                else if( position == 3 )
                {
                    Intent intent = new Intent ( view.getContext(), PlaystationActivity.class );
                    startActivityForResult( intent, 0 );
                }
                // Samsung Odyssey
                else if( position == 4 )
                {
                    Intent intent = new Intent ( view.getContext(), OdysseyActivity.class );
                    startActivityForResult( intent, 0 );
                }
            }
        });
    }
}
