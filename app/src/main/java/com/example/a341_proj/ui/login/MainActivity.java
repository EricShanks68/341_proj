package com.example.a341_proj.ui.login;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.a341_proj.DatePickerFragment;
import com.example.a341_proj.R;
import com.example.a341_proj.ui.login.ui.groups.MessageAdapter;
import com.example.a341_proj.ui.login.ui.groups.MessagingActivity;
import com.example.a341_proj.ui.login.ui.home.Event;
import com.example.a341_proj.ui.login.ui.home.EventAdapter;
import com.example.a341_proj.ui.login.ui.home.HomeFragment;
import com.example.a341_proj.ui.login.ui.logout.LogoutFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.DialogFragment;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    //fragment idk if this works
    LogoutFragment fragment = new LogoutFragment();
    FragmentManager manager = getSupportFragmentManager();

    //idk try
    FragmentManager fragmentManager = getSupportFragmentManager();


    //popup?
    PopupWindow popupWindow;
    DrawerLayout DrawLay;
    Button closePopup;
    Button saveEvent;
    View customView;
    EditText eventTitle;
    String saveEventTitle;

    //date picker button
    Button datePick;
    //date picker textview
    TextView eventDate;
    //String to store date value
    String eventDateString;

    //spinner strings
    String startSpinner;
    String endSpinner;




    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_groups, R.id.nav_settings,
                R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //receive username and put it in the nav header
        Intent in = getIntent();
        String username = in.getStringExtra(LoginActivity.sendUser);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.textViewuserName);
        navUsername.setText(username);
        MessagingActivity.username = username;


        //popup
        DrawLay = (DrawerLayout) findViewById(R.id.drawer_layout);

//calendar and event attemps

        FloatingActionButton fabevent = findViewById(R.id.fabevent);
        fabevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                 customView = layoutInflater.inflate(R.layout.popwindow,null);
                popupWindow = new PopupWindow(customView, Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.MATCH_PARENT);
                popupWindow.showAtLocation(DrawLay, Gravity.CENTER, 0, 0);
                closePopup = (Button) customView.findViewById(R.id.cancelEvent);
                saveEvent = (Button) customView.findViewById(R.id.saveEvent);
                popupWindow.setFocusable(true);
                popupWindow.update();
                closePopup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                //edit text title
                eventTitle = (EditText) customView.findViewById(R.id.title);

                //create spinners
                //start spinner
               final Spinner spinner = (Spinner) customView.findViewById(R.id.startTime);
                ArrayAdapter<String> spinnerStartTimeArrayAdapter = new ArrayAdapter<String>(
                        MainActivity.this,
                        android.R.layout.simple_spinner_dropdown_item,
                        getResources().getStringArray(R.array.TimeArray));
                spinner.setAdapter(spinnerStartTimeArrayAdapter);

                //start spinner
           final Spinner spinner2 = (Spinner) customView.findViewById(R.id.endTime);
                ArrayAdapter<String> spinnerEndTimeArrayAdapter = new ArrayAdapter<String>(
                        MainActivity.this,
                        android.R.layout.simple_spinner_dropdown_item,
                        getResources().getStringArray(R.array.TimeArray));
                spinner2.setAdapter(spinnerEndTimeArrayAdapter);

                saveEvent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        saveEventTitle = eventTitle.getText().toString();
                        startSpinner = spinner.getSelectedItem().toString();
                        endSpinner = spinner2.getSelectedItem().toString();
                        eventDateString = eventDate.getText().toString();
                        HomeFragment.events.add(new Event(saveEventTitle, eventDateString, startSpinner + " - " + endSpinner));
                        Toast.makeText(getApplicationContext(), "Event saved!", Toast.LENGTH_LONG).show();
                        popupWindow.dismiss();
                    }
                });

                //add event functionality


                //date picker button
                datePick = (Button) customView.findViewById(R.id.pickDate);
                datePick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogFragment datePicker = new DatePickerFragment();
                        datePicker.show(getSupportFragmentManager(), "date picker");

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

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String eventDateString = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        eventDate = (TextView) customView.findViewById(R.id.eventDate);
        eventDate.setText(eventDateString);
    }

    //send data to HomeFragment?
//    public void sendToFrag(){
//        HomeFragment fragHome = HomeFragment.newInstance(saveEventTitle);
////        Bundle bundle = new Bundle();
////        bundle.putString("saveEventTitle", saveEventTitle);
////        fragHome.setArguments(bundle);
//// set Fragmentclass Arguments
////       HomeFragment fragHome = new HomeFragment();
//     getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragHome).commit();
////        fragHome.setArguments(bundle);
    }

