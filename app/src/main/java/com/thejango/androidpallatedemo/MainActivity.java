package com.thejango.androidpallatedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FrameLayout container;
    private ListView swatchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = (FrameLayout) findViewById(R.id.pallateId);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        swatchList = (ListView) findViewById(R.id.swatchList);


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.icon_android);
        Palette.from(bitmap).maximumColorCount(16).generate(listener);

    }

    Palette.PaletteAsyncListener listener = new Palette.PaletteAsyncListener() {
        public void onGenerated(Palette palette) {
            // access palette colors here

            int vibrant = palette.getVibrantColor(0x000000);
            int vibrantLight = palette.getLightVibrantColor(0x000000);
            int vibrantDark = palette.getDarkVibrantColor(0x000000);
            int muted = palette.getMutedColor(0x000000);
            int mutedLight = palette.getLightMutedColor(0x000000);
            int mutedDark = palette.getDarkMutedColor(0x000000);

            Log.d("Jango"," vibrant = " +vibrant+
                    " , vibrantLight = " +vibrantLight+
                    " , vibrantDark = " +vibrantDark+
                    " , muted = " +muted+
                    " , mutedLight = " +mutedLight+
                    " , mutedDark = "+mutedDark);

            int vibrant1 = palette.getVibrantSwatch().getRgb();
            int vibrantLight1 = palette.getLightVibrantSwatch().getRgb();
            int vibrantDark1 = palette.getDarkVibrantSwatch().getRgb();
            int muted1 = palette.getMutedSwatch().getRgb();
            int mutedLight1 = palette.getLightMutedSwatch().getRgb();
            int mutedDark1 = palette.getDarkMutedSwatch().getRgb();

            Log.d("Jango"," vibrant = " +vibrant1+
                    " , vibrantLight = " +vibrantLight1+
                    " , vibrantDark = " +vibrantDark1+
                    " , muted = " +muted1+
                    " , mutedLight = " +mutedLight1+
                    " , mutedDark = "+mutedDark1);

            List<Palette.Swatch> swatches = palette.getSwatches();
            SwatchListAdapter adapter = new SwatchListAdapter(MainActivity.this,getResources(),swatches);
            swatchList.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
