package com.damasofc.tabby.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.damasofc.tabby.Adapters.PagerAdapter;
import com.damasofc.tabby.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    public void initComponents(){
        Toolbar	myToolbar	=	(Toolbar)	findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        TabLayout tabLayout	=	(TabLayout)	findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("List"));
        tabLayout.addTab(tabLayout.newTab().setText("Add Person"));

        final ViewPager viewPager	=	(ViewPager)	findViewById(R.id.viewPager);
        PagerAdapter	adapter	=	new PagerAdapter(getSupportFragmentManager(),	tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int	position	=	tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
