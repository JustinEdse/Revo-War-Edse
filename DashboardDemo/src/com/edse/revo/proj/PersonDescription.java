package com.edse.revo.proj;




import java.lang.reflect.Field;


import adapters.people.AbutAdapter;
import adapters.people.AmherstAdapter;
import adapters.people.ArnoldAdapter;
import adapters.people.BourbonAdapter;
import adapters.people.BoydAdapter;
import adapters.people.BurgAdapter;
import adapters.people.ClintonAdapter;
import adapters.people.ConwayAdapter;
import adapters.people.CornAdapter;
import adapters.people.FawcettAdapter;
import adapters.people.GageAdapter;
import adapters.people.GatesAdapter;
import adapters.people.GeorgeAdapter;
import adapters.people.GrasseAdapter;
import adapters.people.GravesAdapter;
import adapters.people.GravierAdapter;
import adapters.people.GreenAdapter;
import adapters.people.GreeneAdapter;
import adapters.people.HClintonAdapter;
import adapters.people.HaldAdapter;
import adapters.people.HectorAdapter;
import adapters.people.HoweRAdapter;
import adapters.people.KingLouisAdapter;
import adapters.people.KnoxAdapter;
import adapters.people.LafyAdapter;
import adapters.people.LeeAdapter;
import adapters.people.LincolnAdapter;
import adapters.people.MarionAdapter;
import adapters.people.MontyAdapter;
import adapters.people.PhilipsAdapter;
import adapters.people.RIHoweAdapter;
import adapters.people.RevereAdapter;
import adapters.people.SartineAdapter;
import adapters.people.ShuAdapter;
import adapters.people.SullivanAdapter;
import adapters.people.SumterAdapter;
import adapters.people.ThomasAdapter;
import adapters.people.VimAdapter;
import adapters.people.WHoweAdapter;
import adapters.people.WarrenAdapter;
import adapters.people.WashingtonAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;


/**
 * This activity displays a list of prominent Americans that played a vital
 * role in the Revolutionary war. Once a person is chosen from the list
 * the user is taken to the next screen to read about the individual.
 *
 */

public class PersonDescription extends DashboardActivity 
{
    
    
	
	private String person = null;
	private String home = null;
	private String loadPerson = null;
	private String notables[] = null;
	private int selectedInt = 0;
	
	////////////////////////////////////////////////////////////////////////////////////
	//CUSTOM ADAPTERS FOR HISTORICAL FIGURES
	////////////////////////////////////////////////////////////////////////////////////
	
	
	//assign only once during all selections.
	ViewPager myPager = (ViewPager) findViewById(R.id.myfivepanelpager);
	
	
    
  protected void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate(savedInstanceState);
    setContentView (R.layout.activity_peoplespec);
    setTitleFromActivityLabel (R.id.title_text);
    
    
    person = getIntent().getStringExtra("person");
    home = getIntent().getStringExtra("origin");
    selectedInt = getIntent().getIntExtra("integer", 0);
    // forget all of this below, just have names to load in relation to .xml layouts.
    //washington1, washington2, washington3.
   
    
   //send to the page viewer class. page viewer class should look through 
    //a text file with entries separated by # per entry.
   //one file for all people. if title = loadPerson. display page text until at next #.
    //JUST TEXT FROM .STRINGS.XML BOOK ACTIVITY.CLASS
    //.xml activities for pages, strings.xml file.
   //class red id,    R.
    if(home.equals("American"))
    {
    	switch(selectedInt)
    	{
    	case 0:
    	{
    		    		
    		WashingtonAdapter washAdapt = new WashingtonAdapter();
    		myPager.setAdapter(washAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 1:
    	{
    		//Gates
    		GatesAdapter gatesAdapt = new GatesAdapter();
    		myPager.setAdapter(gatesAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 2:
    	{
    		//Greene
    		GreeneAdapter greeneAdapt = new GreeneAdapter();
    		myPager.setAdapter(greeneAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	
    	case 3:
    	{
    		//Knox
    		KnoxAdapter knoxAdapt = new KnoxAdapter();
    		myPager.setAdapter(knoxAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 4:
    	{
    		//Lee
    		LeeAdapter leeAdapt = new LeeAdapter();
    		myPager.setAdapter(leeAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 5:
    	{
    		//Lincoln
    		LincolnAdapter lincAdapt = new LincolnAdapter();
    		myPager.setAdapter(lincAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 6:
    	{
    		//Clinton
    		ClintonAdapter clintonAdapt = new ClintonAdapter();
    		myPager.setAdapter(clintonAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 7:
    	{
    		//Monty
    		MontyAdapter montyAdapt = new MontyAdapter();
    		myPager.setAdapter(montyAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 8:
    	{
    		//Schuyler
    		ShuAdapter shuAdapt = new ShuAdapter();
    		myPager.setAdapter(shuAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 9:
    	{
    		//Howe
    		HoweRAdapter howeRAdapt = new HoweRAdapter();
    		myPager.setAdapter(howeRAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	
    	case 10:
    	{
    		//Sullivan
    		SullivanAdapter sullAdapt = new SullivanAdapter();
    		myPager.setAdapter(sullAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	
    	case 11:
    	{
    		//Thomas
    		ThomasAdapter thomasAdapt = new ThomasAdapter();
    		myPager.setAdapter(thomasAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 12:
    	{
    		//Warren
    		WarrenAdapter warrenAdapt = new WarrenAdapter();
    		myPager.setAdapter(warrenAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 13:
    	{
    		//Revere
    		RevereAdapter revereAdapt = new RevereAdapter();
    		myPager.setAdapter(revereAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 14:
    	{
    		//Sumter
    		SumterAdapter sumtAdapt = new SumterAdapter();
    		myPager.setAdapter(sumtAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 15:
    	{
    		//Marion
    		MarionAdapter marAdapt = new MarionAdapter();
    		myPager.setAdapter(marAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 16:
    	{
    		//Arnold
    		ArnoldAdapter arnoldAdapt = new ArnoldAdapter();
    		myPager.setAdapter(arnoldAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	default:
    	{
    		break;
    	}
    	
    	}
    	//myPager.setCurrentItem(0);
    	
    }
    else if(home.equals("British"))
    {
    	switch(selectedInt)
    	{
    	case 0:
    	{
    		//George III
    		//Monty
    		GeorgeAdapter georgeAdapt = new GeorgeAdapter();
    		myPager.setAdapter(georgeAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 1:
    	{
    		//Amherst
    		//Monty
    		AmherstAdapter amAdapt = new AmherstAdapter();
    		myPager.setAdapter(amAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 2:
    	{
    		//Conway
    		//Monty
    		ConwayAdapter conAdapt = new ConwayAdapter();
    		myPager.setAdapter(conAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 3:
    	{
    		//gage
    		//Monty
    		GageAdapter gageAdapt = new GageAdapter();
    		myPager.setAdapter(gageAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 4:
    	{
    		//clinton
    		//Monty
    		HClintonAdapter hClintonAdapt = new HClintonAdapter();
    		myPager.setAdapter(hClintonAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	
    	case 5:
    	{
    		//howe
    		
    		WHoweAdapter wHoweAdapt = new WHoweAdapter();
    		myPager.setAdapter(wHoweAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 6:
    	{
    		//boyd
    		
    		BoydAdapter boydAdapt = new BoydAdapter();
    		myPager.setAdapter(boydAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 7:
    	{
    		//arbuthnot
    	
    		AbutAdapter abutAdapt = new AbutAdapter();
    		myPager.setAdapter(abutAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 8:
    	{
    		//Burgoyne
    		
    		BurgAdapter burgAdapt = new BurgAdapter();
    		myPager.setAdapter(burgAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	
    	case 9:
    	{
    		//cornwallis
    	
    		CornAdapter cornAdapt = new CornAdapter();
    		myPager.setAdapter(cornAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 10:
    	{
    		//graves
    	
    		GravesAdapter gravesAdapt = new GravesAdapter();
    		myPager.setAdapter(gravesAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 11:
    	{
    		//fawcett
    		
    		FawcettAdapter fawAdapt = new FawcettAdapter();
    		myPager.setAdapter(fawAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	
    	case 12:
    	{
    		//green
    		
    		GreenAdapter greenAdapt = new GreenAdapter();
    		myPager.setAdapter(greenAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 13:
    	{
    		//halimand
    		
    		HaldAdapter haldAdapt = new HaldAdapter();
    		myPager.setAdapter(haldAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 14:
    	{
    		//phillips
    		
    		PhilipsAdapter philAdapt = new PhilipsAdapter();
    		myPager.setAdapter(philAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 15:
    	{
    		//rihowe
    		
    		RIHoweAdapter riHAdapt = new RIHoweAdapter();
    		myPager.setAdapter(riHAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	default:
    	{
    		break;
    	}
    	
    	}
    	
    }
    else if(home.equals("French"))
    {
    	switch(selectedInt)
    	{
    	case 0:
    	{
    		//king louis XVI
    	
    		KingLouisAdapter louisAdapt = new KingLouisAdapter();
    		myPager.setAdapter(louisAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 1:
    	{
    		//gravier
    		
    		GravierAdapter gravierAdapt = new GravierAdapter();
    		myPager.setAdapter(gravierAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 2:
    	{
    		//sartine
    	
    		SartineAdapter sartAdapt = new SartineAdapter();
    		myPager.setAdapter(sartAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 3:
    	{
    		//lafyette
    	
    		LafyAdapter lafyAdapt = new LafyAdapter();
    		myPager.setAdapter(lafyAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 4:
    	{
    		//bourbon
    	
    		BourbonAdapter brAdapt = new BourbonAdapter();
    		myPager.setAdapter(brAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 5:
    	{
    		//hector/comte
    		
    		HectorAdapter hectAdapt = new HectorAdapter();
    		myPager.setAdapter(hectAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 6:
    	{
    		//grasse
    		
    		GrasseAdapter grasseAdapt = new GrasseAdapter();
    		myPager.setAdapter(grasseAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	case 7:
    	{
    		//vim
    	
    		VimAdapter vimAdapt = new VimAdapter();
    		myPager.setAdapter(vimAdapt);
    		myPager.setCurrentItem(0);
    		break;
    	}
    	default:
    	{
    		break;
    	}
    	
    	}
    	
    }
   
  }
}
  