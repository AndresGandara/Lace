package com.example.lace;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class MainActivity extends FragmentActivity{
	
	String[] actions = new String[] {
		    "Todo",
		    "Pendientes"
		};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar a_bar = getActionBar();
				
		/* Create an array adapter to populate dropdownlist */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, actions);
 
        /* Enabling dropdown list navigation for the action bar */
        a_bar.setDisplayShowTitleEnabled(false);
        //a_bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
 
        /* Defining Navigation listener 
        ActionBar.OnNavigationListener navigationListener = new OnNavigationListener() {
 
            @Override
            public boolean onNavigationItemSelected(int itemPosition, long itemId) {
                Toast.makeText(getBaseContext(), "You selected : " + actions[itemPosition]  , Toast.LENGTH_SHORT).show();
                return false;
            }
        };*/
 
        /* Setting dropdown items and item navigation listener for the actionbar */
        //a_bar.setListNavigationCallbacks(adapter, navigationListener);
        
        a_bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab tab1 = a_bar.newTab().setText("Pendientes");
        ActionBar.Tab tab2 = a_bar.newTab().setText("Todo");
        
        Fragment tab1frag = new Fragment();
        Fragment tab2frag = new Fragment();
        
        tab1.setTabListener(new TabsListener(tab1frag));
        tab2.setTabListener(new TabsListener(tab2frag));
        
        a_bar.addTab(tab1);
        a_bar.addTab(tab2);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
	    return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_places:
	            //openPlaces();
	            return true;
	        case R.id.action_settings:
	            //openSettings();
	            return true;
	    }
		return false;
	}
}
