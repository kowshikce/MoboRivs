package com.example.moborivs;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.moborivs.persiststorage.Account;
import com.example.moborivs.persiststorage.AccountRepository;
import com.example.moborivs.ui.sharePreference.SessionManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.SearchView;

import com.example.moborivs.ui.main.SectionsPagerAdapter;

import java.util.List;


public class MainActivity extends BaseActivity{

    DrawerLayout dl;
    ActionBarDrawerToggle t;
    NavigationView nv;
    Toolbar toolbar;
    SearchView searchView;
    View HeaderView;
    SessionManager sessionManager;
    Context mContext;
    TextView T_username, T_userEmail;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mContext = getApplicationContext();

        dl = findViewById(R.id.drawer_main_id);
        nv = findViewById(R.id.drawer_navigation_id);
        nv.setNavigationItemSelectedListener(listener);
        t = new ActionBarDrawerToggle(this, dl, toolbar,R.string.Open, R.string.Close);
        dl.addDrawerListener(t);
        t.syncState();


        sessionManager = SessionManager.getInstance(getApplicationContext());
        HeaderView = nv.getHeaderView(0);
        T_username = HeaderView.findViewById(R.id.nav_header_username_id);
        T_userEmail = HeaderView.findViewById(R.id.nav_header_user_email_id);

        if(sessionManager.isLogin()){
            T_userEmail.setText(sessionManager.getAccount().getUsername());
            T_username.setText(sessionManager.getAccount().getEmail());
        }




        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);
        searchView = (SearchView)menu.findItem(R.id.menu_search_id).getActionView();
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(onQueryTextListener);
        return super.onCreateOptionsMenu(menu);
    }

    private SearchView.OnQueryTextListener onQueryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_search_id:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_logout_id:
                if(sessionManager.isLogin()){
                    if(sessionManager.logout()){
                        Intent restartIntent = new Intent(mContext, MainActivity.class);
                        int pendingIntentId = 1243434;
                        PendingIntent mPendingIntent = PendingIntent.getActivity(mContext, pendingIntentId, restartIntent, PendingIntent.FLAG_CANCEL_CURRENT);
                        AlarmManager alrm = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
                        alrm.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
                        System.exit(0);
                    }else{
                        Toast.makeText(mContext, "CAN NOT LOGOUT RIGHT NOW.", Toast.LENGTH_SHORT).show();
                    }

                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    NavigationView.OnNavigationItemSelectedListener listener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.account_nav_menu_id:
                    Toast.makeText(MainActivity.this, "Account", Toast.LENGTH_SHORT).show();
                    dl.closeDrawers();
                    return true;
                default:
                    return false;
            }


        }
    };

    @Override
    public void onBackPressed() {
        if(dl.isDrawerOpen(GravityCompat.START)){
            dl.closeDrawer(GravityCompat.START);
        }else{
            finish();
        }

    }

}