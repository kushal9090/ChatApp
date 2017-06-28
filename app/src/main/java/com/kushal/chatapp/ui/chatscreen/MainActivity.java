package com.kushal.chatapp.ui.chatscreen;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.kushal.chatapp.R;
import com.kushal.chatapp.ui.chatscreen.commonadapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private  void initView() {

        initToolbar();
        initNewMessageFloatingButton();
        initViewPager();
        initTabLayout();


    }
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

      private void initNewMessageFloatingButton(){

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private ViewPager mVpager;
    private void initViewPager(){

     mVpager = (ViewPager) findViewById(R.id.vpager);
        List<String> tabNames = new ArrayList<String>();
        tabNames.add("CHATS");
        tabNames.add("STATUS");
        tabNames.add("CALLLS");

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager() , getFragments(), tabNames);
        mVpager.setOffscreenPageLimit(2);
        mVpager.setAdapter(viewPagerAdapter);
    }

   private  void initTabLayout(){
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mVpager);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));

    }

   private List<Fragment> mfragments;
    private List<Fragment> getFragments(){

        mfragments = new ArrayList<Fragment>();
        mfragments.add(ChatsFragment.newInstance(" "));
        mfragments.add(StatusFragment.newInstance( ));
        mfragments.add(CallsFragment.newInstance( ));
       return mfragments;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The       action bar will
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
