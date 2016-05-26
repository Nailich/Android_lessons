package ru.stonefist.fithelper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import ru.stonefist.fithelper.fragments.FragmentExerciseComplex;
import ru.stonefist.fithelper.fragments.FragmentExerciseStatistic;
import ru.stonefist.fithelper.fragments.FragmentNearestClubs;
import ru.stonefist.fithelper.fragments.FragmentParameterStatistic;
import ru.stonefist.fithelper.fragments.FragmentParameters;
import ru.stonefist.fithelper.fragments.FragmentPeopleCommunication;
import ru.stonefist.fithelper.fragments.FragmentTraningShedule;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentExerciseComplex fExerciseComplex;
    FragmentExerciseStatistic fExerciseStatistic;
    FragmentNearestClubs fNearestClubs;
    FragmentParameters fParameters;
    FragmentParameterStatistic fParameterStatistic;
    FragmentPeopleCommunication fPeopleCommunication;
    FragmentTraningShedule fTraningShedule;
    TextView pWeight;
    TextView pHeight;
    int pImt;
    TextView calcImt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fExerciseComplex = new FragmentExerciseComplex();
        fExerciseStatistic = new FragmentExerciseStatistic();
        fNearestClubs = new FragmentNearestClubs();
        fParameters = new FragmentParameters();
        fParameterStatistic = new FragmentParameterStatistic();
        fPeopleCommunication = new FragmentPeopleCommunication();
        fTraningShedule = new FragmentTraningShedule();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentTransaction fTrans = getFragmentManager().beginTransaction();

        if (id == R.id.pParameters) {
            fTrans.replace(R.id.container, fParameters);
        } else if (id == R.id.traningShedule) {
            fTrans.replace(R.id.container, fTraningShedule);
        } else if (id == R.id.exerciseComplex) {
            fTrans.replace(R.id.container, fExerciseComplex);
        } else if (id == R.id.nearestClubs) {
            fTrans.replace(R.id.container, fNearestClubs);
        } else if (id == R.id.peopleCommunication) {
            fTrans.replace(R.id.container, fPeopleCommunication);
        } else if (id == R.id.parameterStatistic) {
            fTrans.replace(R.id.container, fParameterStatistic);
        } else if (id == R.id.exerciseStatistic) {
            fTrans.replace(R.id.container, fExerciseStatistic);
        }   fTrans.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void imtCalc(View view) {
        pHeight =(TextView) view.findViewById(R.id.eHeight);
        pWeight =(TextView)view.findViewById(R.id.eWeight);
        calcImt = (TextView) view.findViewById(R.id.calcIMT);
        pImt = Integer.parseInt(pWeight.getText().toString())/(Integer.parseInt(pHeight.getText().toString())*2);
        calcImt.setText(pImt);
    }
}
