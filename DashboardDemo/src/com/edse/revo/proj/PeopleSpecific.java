package com.edse.revo.proj;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * This activity displays a list of prominent Americans that played a vital
 * role in the Revolutionary war. Once a person is chosen from the list
 * the user is taken to the next screen to read about the individual.
 *
 */

public class PeopleSpecific extends DashboardActivity 
{
    private static final int AMERICAN = 0;
    private static final int BRITISH = 1;
    private static final int FRENCH = 2;

    
	private ListView listPeople;
	private int selectedCountry = 0;
	private String selectedPerson = null;
	private int selectedInteger = 0;
	private String homeCountry = null;
    private ArrayAdapter<String> adaptPeople;
    private String peopleArray[];
  protected void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate(savedInstanceState);
    setContentView (R.layout.activity_peoplespec);
    setTitleFromActivityLabel (R.id.title_text);
    
    
    selectedCountry = getIntent().getIntExtra("country",0);
    
    switch(selectedCountry)
    {
      case AMERICAN:
      {
    	  peopleArray = getResources().getStringArray(R.array.amerArray); 
    	  homeCountry = "American";
    	  break;
      }
      case BRITISH:
      {
    	  peopleArray = getResources().getStringArray(R.array.britArray); 
    	  homeCountry = "British";
    	  break;
      }
      case FRENCH:
      {
    	  peopleArray = getResources().getStringArray(R.array.frenchArray);
    	  homeCountry = "French";
    	  break;
      }
     
     
      default:
      {
    	  break;
      }
    }
    
   
    adaptPeople = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, peopleArray);
    listPeople.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    listPeople.setAdapter(adaptPeople);
    
    listPeople.setOnItemClickListener(new OnItemClickListener()
    {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3)
		{
			selectedPerson = listPeople.getSelectedItem().toString();
			selectedInteger = listPeople.getSelectedItemPosition();
			Intent goToDescription = new Intent(PeopleSpecific.this.getApplicationContext(), PeopleSpecific.class);
			goToDescription.putExtra("person", selectedPerson);
			goToDescription.putExtra("origin", homeCountry);
			goToDescription.putExtra("integer", selectedInteger);
			startActivity(goToDescription);
				
			
			
		}
    	
    });

  }
}
  