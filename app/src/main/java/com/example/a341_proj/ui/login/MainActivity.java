package com.example.a341_proj.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.a341_proj.R;
import com.example.a341_proj.ui.login.ui.MyAdapter;
import com.example.a341_proj.ui.login.ui.send.SendFragment;
import com.example.a341_proj.ui.login.ui.tools.ToolsFragment;
import com.example.a341_proj.ui.login.ui.tools.ToolsViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.provider.CalendarContract;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a341_proj.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends AppCompatActivity {

    //popup?
    PopupWindow popupWindow;
    DrawerLayout DrawLay;
    Button closePopup;
    Button saveEvent;

    //event recycler array
    //ArrayList<String> title = new ArrayList<String>();
        String s1[], s2[];
        //int images[] = {};
    // recycler
    RecyclerView recyclerView;


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //recieve username and put it in the nav header
        Intent in = getIntent();
        String username = in.getStringExtra(LoginActivity.sendUser);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.textViewuserName);
        navUsername.setText(username);



        //popup
        DrawLay = (DrawerLayout) findViewById(R.id.drawer_layout);

        //calendar and event attemps

        FloatingActionButton fabevent = findViewById(R.id.fabevent);
        fabevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.popwindow,null);
                popupWindow = new PopupWindow(customView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
                popupWindow.showAtLocation(DrawLay, Gravity.CENTER, 0, 0);
                closePopup = (Button) customView.findViewById(R.id.cancelEvent);
                saveEvent = (Button) customView.findViewById(R.id.saveEvent);
                closePopup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                saveEvent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Event saved!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}
