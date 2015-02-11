package com.example.amado.tabs;

import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;


public class Display extends ActionBarActivity {


    private ArrayList<Person> mPersonsOne;
    private ArrayList<Person> mPersonsTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TabHost tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
        TabHostSet(tabHost);



        ListView personsListOne = (ListView)findViewById(R.id.persons_one);
        ListView personsListTwo = (ListView)findViewById(R.id.persons_two);
        CreatePersonsList();
        personsListOne.setAdapter(new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, mPersonsOne));
        personsListTwo.setAdapter(new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, mPersonsTwo));




    }

    private void TabHostSet(TabHost tabHost) {
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("personsOne");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("", getResources().getDrawable(R.drawable.ic_person_one));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("personsTwo");
        tabSpec.setContent(R.id.tab2);

        tabSpec.setIndicator("", getResources().getDrawable(R.drawable.ic_person));
        tabHost.addTab(tabSpec);
    }

    private void CreatePersonsList() {
        mPersonsOne = new ArrayList<Person>();
        mPersonsTwo = new ArrayList<Person>();
        for (int i = 1; i < 10; i++) {
            mPersonsOne.add(new Person("person One"));
            mPersonsTwo.add(new Person("person Two"));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display, menu);
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
