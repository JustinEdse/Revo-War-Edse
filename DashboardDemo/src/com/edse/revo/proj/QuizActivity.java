
package com.edse.revo.proj;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/**
 * This is the activity for feature 2 in the dashboard application.
 * It displays some text and provides a way to get back to the home activity.
 *
 */

public class QuizActivity extends DashboardActivity 
{

	private List<Question> activeQuestions = null;
	private List<Question> questionBank = null;
	private enum WantedType {Battles, American, British, French, Weapons, Quotes, Mix};
	private String questionsAskedFor = null;
	private ListView choices;

	
	
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
    setContentView (R.layout.activity_quiz);
    setTitleFromActivityLabel (R.id.title_text);
    
    
    
    //setup an alert dialog box to ask the user what category of questions they want.
    //display 15 questions at a time....when end reached.
    //want more from this category???load more! back button.....reload choice screen again for the user
    //if last question answered ask if they want to answer more from this category. if yes, load more,
    //if no take them back to the selections screen.
    
    questionBank = new ArrayList<Question>();
    try 
    {
    	//load certain types of questions from the question bank array list.
    	//have 2 constructors. The default loads all questions in question bank
    	//and the other loads specific types of questions for the user. That we don't 
    	//have to read the questions from the device directory or raw resources
    	//every single time.
		questionBank = Question.readQuestions(this.getApplicationContext());
	} 
    catch (Exception e) 
    {
		Toast.makeText(getApplicationContext(), "A problem occured when reading in questions for the quiz.", Toast.LENGTH_SHORT).show();
		e.printStackTrace();
	}
    
    //somehow randomize questions better and keep tabs on frequency shown
    Collections.shuffle(questionBank);

    String[] stringArray = getResources().getStringArray(R.array.typeArray);
  
    choices = (ListView) findViewById(R.id.listViewQuiz);
    
  
    
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringArray);
    
    choices.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    choices.setAdapter(adapter);
    
    choices.setOnItemClickListener(new OnItemClickListener()
    {
  	 
  	@Override
  	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
  	{
  		int selectedChoice = choices.getSelectedItemPosition();
  		WantedType whichQuestions = WantedType.values()[selectedChoice];
  		
  		switch(whichQuestions)
  		{
  		 case Battles:
  		 {
  			 questionsAskedFor = "Battles";
  		   	break;
  		 }
  		 case American:
  		 {
  			questionsAskedFor = "American";
  			 break;
  		 }
  		 case British:
  		 {
  			questionsAskedFor = "British";
  			 break;
  		 }
  		 case French:
  		 {
  			questionsAskedFor = "French";
  			 break;
  		 }
  		 case Weapons:
  		 {
  			questionsAskedFor = "Weapons";
  			 break;
  		 }
  		 case Quotes:
  		 {
  			questionsAskedFor = "Quotes";
  			 break;
  		 }
  		 case Mix:
  		 {
  			questionsAskedFor = "Mix";
  			 break;
  		 }
  		}
  		
   
  	}
    });
    
	
	
	    ////////////////////////////////////////////////////////////////////////
	    //somehow randomize questions better and keep tabs on frequency shown
    
}
	private static List<Question> specificQuestions(String askedFor)
	{
		List<Question> specQuest = new ArrayList<Question>();
		//copy all types matching askedFor from question bank to temp specQuest.
		//shouldn't be too hard. check for each entry in question bank, copy over....
		return new ArrayList<Question>();
	}
    
} // end class
