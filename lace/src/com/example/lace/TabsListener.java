package com.example.lace;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.util.Log;

public class TabsListener implements ActionBar.TabListener{
	
	Fragment fragment;
	
	public TabsListener(Fragment fg){
		// TODO Auto-generated constructor stub
		this.fragment = fg;
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Log.i("ActionBar", tab.getText() + "reseleccionada");
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Log.i("ActionBar", tab.getText() + "seleccionada");
		ft.replace(R.id.action_places, fragment);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Log.i("ActionBar", tab.getText() + "deseleccionada");
		ft.remove(fragment);
	}
	
}
