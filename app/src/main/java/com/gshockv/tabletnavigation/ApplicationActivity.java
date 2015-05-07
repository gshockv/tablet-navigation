package com.gshockv.tabletnavigation;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

public class ApplicationActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private DrawerLayout drawerLayout;
    private SlidingPaneLayout slidingPaneLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.slidingpane_layout);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.mainActivityTitle);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            toggleSideMenuVisibility();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleSideMenuVisibility() {
        if (drawerLayout != null) {
            boolean isVisible = drawerLayout.isDrawerVisible(Gravity.START);
            if (isVisible) {
                drawerLayout.closeDrawer(Gravity.START);
            } else {
                drawerLayout.openDrawer(Gravity.START);
            }
        } else if (slidingPaneLayout != null) {
            boolean isVisible = slidingPaneLayout.isOpen();
            if (isVisible) {
                slidingPaneLayout.closePane();
            } else {
                slidingPaneLayout.openPane();
            }
        }
    }
}
