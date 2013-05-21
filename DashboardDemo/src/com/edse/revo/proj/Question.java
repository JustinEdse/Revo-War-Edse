package com.edse.revo.proj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable
{

	private int timesSeen = 0;
	private String questType = null;
	private String correctAnswer = null;
	private String questionWords = null;
	private String explain = null;
	private String[] answers = new String[5];
	private static final String DATA_FILE_DIR = "questions";
	private static final String DATA_FILE = "questiondata.txt";
	private static final int ITEMS_PER_LINE = 3;
	private static final String SECTION_DELIMITER = ";";
	private static final String ARRAY_DELIMITER = "*";
	
	
	public Question(String questType, String questionWords, String answers[], String correctAnswer,String explain)
	{
		this.questType = questType;
		this.questionWords = questionWords;
		this.answers = answers;
		this.explain = explain;
		this.correctAnswer = correctAnswer;
		timesSeen = 0;
	}
	
	public String getQuestType()
	{
		return questType;
	}
	public void setQuestNum(String type)
	{
		this.questType= type;
	}
	public String getText()
	{
		return questionWords;
	}
	
	public String getExplanation()
	{
		return explain;
	}
	
	public String getCorrectAnswer()
	{
		return correctAnswer;
	}
	public void setAnswers(String readAnswers[])
	{
		answers = readAnswers;
	}
	public String[] getAnswers()
	{
		return answers;
	}
	public int getNumTimesSeen()
	{
		return timesSeen;
	}
	public void setNumTimesSeen(int times)
	{
		timesSeen = times;
	}
	
    public static List<Question> readQuestions(Context context) throws Exception
    {
		// If the current context is null an exception needs to be thrown.
    	if(context == null)
    	{
    		throw new Exception("Error in class Question, mehtod read Questions.");
    	}
    	
    	List<Question> endingResult = new ArrayList<Question>();
    	
    	File directory = context.getDir(DATA_FILE_DIR, Context.MODE_PRIVATE);
    	File file = new File(directory, DATA_FILE);
    	
    	//does this file exist already on the device?
    	if(!file.exists())
    	{
    		//if the file does not exist call loadRawResources to 
    		//move it from the raw directory to the device directory.
    		Question.loadRawResources(context, file);
    		
    	}
    	
    	if(!file.canRead())
    	{
    		throw new IOException("Error in class Question when trying to read file from raw resources.");
    	}
    	
    	//create a reader to read questions in.
    	BufferedReader reader = new BufferedReader(new FileReader(file));
    	
    	String line = "";
    	
    	while((line = reader.readLine()) != null)
    	{
    		//split according to a semi colon for each section of the question data.
    		//the section for the array is split with asterisks.
    		String[] split = line.split(SECTION_DELIMITER);
    		String qtype = "";
    		String questText = "";
    		String arrText = "";
    		String expl = "";
    		String correct = "";
    		String arr[] = new String[5];
    		
    		if(split.length >= ITEMS_PER_LINE)
    		{
    			split[0] = qtype;
    			split[1] = questText;
    			split[2] = arrText;
    			split[3] = expl;
    			
    			String[] splitForArray = arrText.split(ARRAY_DELIMITER);
    			//indexes 0 thru 3 represent A,B,C,D set of answers while index 4 represents the correct answer.
    			//index 4 this is a separate field.
    			splitForArray[0] = arr[0];
    			splitForArray[1] = arr[1];
    			splitForArray[2] = arr[2];
    			splitForArray[3] = arr[3];
    			splitForArray[4] = correct;
    			
    			endingResult.add(new Question(qtype,questText, arr, correct,expl));
    			
    		}
    	}
    	
    	reader.close();
    	
    	return endingResult;
    	
    }
   
    public static void loadRawResources(Context context, File file) throws IOException
    {
    	//grab input stream for default raw resources.
    	InputStream input = context.getResources().openRawResource(R.raw.questiondata);
    	
    	//setup channels for transfer from raw to directory.
    	ReadableByteChannel incoming = Channels.newChannel(input);
    	FileChannel outgoing = new FileOutputStream(file).getChannel();
    	
    	//bytes to transfer, settings.
    	outgoing.transferFrom(incoming, 0, 50000);
    	
    	incoming.close();
    	outgoing.close();
    	
    }
    public @Override String toString()
    {
    
		return this.questType+ " " + this.questionWords + "\n" + this.answers[0] + "\n" + this.answers[1] + "\n" +
          this.answers[2] + this.answers[3];
    	
    }

	@Override
	public int describeContents()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel destination, int flag)
	{
		
		destination.writeString(questType);
		destination.writeString(questionWords);
		destination.writeString(explain);
		destination.writeStringArray(answers);
		destination.writeString(correctAnswer);
		
		
		
	}
	
	@SuppressWarnings({"rawtypes"})
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
	{
		public Question createFromParcel(Parcel in)
		{
			return new Question(in);
		}
		public Question[] newArray(int size)
		{
			return new Question[size];
		}
	};
	
	public Question(Parcel in)
	{
		
		this.questType = in.readString();
		this.questionWords = in.readString();
		this.explain = in.readString();
		in.readStringArray(this.answers);
	}
}
