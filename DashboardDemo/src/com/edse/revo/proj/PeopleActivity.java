

package com.edse.revo.proj;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * This is the activity for feature 3 in the dashboard application.
 * It displays some text and provides a way to get back to the home activity.
 *
 */

public class PeopleActivity extends DashboardActivity 
{

	private ListView listViewCountries;
	private int selectedCountry = 0;
/**
 * onCreate
 *
 * Called when the activity is first created. 
 * This is where you should do all of your normal static set up: create views, bind data to lists, etc. 
 * This method also provides you with a Bundle containing the activity's previously frozen state, if there was one.
 * 
 * Always followed by onStart().
 *
 * @param savedInstanceState Bundle
 */

protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView (R.layout.activity_people);
    setTitleFromActivityLabel (R.id.title_text);
    
  listViewCountries = (ListView) findViewById(R.id.listView1);
  
  String sides[] = {"American", "British", "French"};
  
  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sides);
  
  listViewCountries.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
  listViewCountries.setAdapter(adapter);
  
  listViewCountries.setOnItemClickListener(new OnItemClickListener()
  {
	 
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
	{
		selectedCountry = listViewCountries.getSelectedItemPosition();
		
		
			 //go to specific people activity
			 Intent goToPeople = new Intent(PeopleActivity.this.getApplicationContext(), PeopleSpecific.class);
			 goToPeople.putExtra("country", selectedCountry);
				
			
		 
	}
  });
  
    
}
    
} // end class
