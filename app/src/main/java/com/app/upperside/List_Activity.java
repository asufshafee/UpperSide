package com.app.upperside;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

public class List_Activity extends AppCompatActivity {


    private ExpandableHeightListView listview;
    private ArrayList<Bean> Bean;
    private ListBaseAdapter baseAdapter;
    private AdView mAdView;


    private int[] IMAGE2 = {R.drawable.img1, R.drawable.img1, R.drawable.img1};
    private String[] TITLE = {"1 day ago", "1 day ago", "1 day ago"};
    private String[] NEWS = {"Trump’s Plan for AmericanMade iPhonew Wold Be Disastrous. Trump’s Plan for AmericanMade iPhonew Wold Be Disastrous",
            "Trump’s Plan for AmericanMade iPhonew Wold Be Disastrous. Trump’s Plan for AmericanMade iPhonew Wold Be Disastrous",
            "Trump’s Plan for AmericanMade iPhonew Wold Be Disastrous. Trump’s Plan for AmericanMade iPhonew Wold Be Disastrous"};
    private String[] NEWSSUB = {"Why even a President Trump couldn’t make Apple manufacture iPhone in the state.","Why even a President Trump couldn’t make Apple manufacture iPhone in the state.",
            "Why even a President Trump couldn’t make Apple manufacture iPhone in the state."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_);
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);

        adView.setAdUnitId("ca-app-pub-3940256099942544/5224354917");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        if (getIntent().getExtras().getString("type").equals("online"))
        getSupportActionBar().setTitle("Online Business Ideas");
        if (getIntent().getExtras().getString("type").equals("offline"))
            getSupportActionBar().setTitle("Offline Business Ideas");
        if (getIntent().getExtras().getString("type").equals("money"))
            getSupportActionBar().setTitle("Saving Money Ideas");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listview = (ExpandableHeightListView)findViewById(R.id.listview);

        Bean = new ArrayList<Bean>();

        for (int i= 0; i< IMAGE2.length; i++){

            Bean bean = new Bean( IMAGE2[i], TITLE[i], NEWS[i], NEWSSUB[i]);
            Bean.add(bean);

        }

        baseAdapter = new ListBaseAdapter(List_Activity.this, Bean) {
        };

        listview.setAdapter(baseAdapter);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.about:
                //about
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
