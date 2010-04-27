package com.dev.BarcodeWars;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import android.content.Context;
import android.util.Log;

/**
 * @author Greg Charette
 * @author Steve Aquillano
 *
 * Writes to a file in the following order:
 * Wins
 * Losses
 * Health
 * Infantry
 * Skill
 */
public class DataStoreText {
	
	private int wins = 0;
	private int losses = 0;
	private int health = 0;
	private int infantry = 0;
	private int skill = 0;
	PrintWriter out;
	Context appContext;
	private final int WINS_ATTRIBUTE = 0;
	private final int LOSSES_ATTRIBUTE = 1;
	private final int HEALTH_ATTRIBUTE = 2;
	private final int INFANTRY_ATTRIBUTE = 3;
	private final int SKILL_ATTRIBUTE = 4;
	
	public DataStoreText(Context context)
	{
		Log.v("Entering DataStoreText Constructor", "YEAH BABY");
		
		appContext = context;
	}
	
	public void setWins()
	{
		String line;
		int count = 0;
		
		try
		{	Log.v("In try: ", "right before opening file for reading");
			//Opens a file to read
			FileInputStream winsFIS = appContext.openFileInput("datastore.txt");
			
			BufferedReader winsIn = new BufferedReader(new InputStreamReader(winsFIS));
			
			Log.v("File for reading: ", "Created");
			//Runs while there is still information to read
			while((line = winsIn.readLine()) != null)
			{	Log.v("In read file loop", "Reading file");	
				//If statement runs if employee is a salaried employee
				if(count == 0)
				{
					//Try allows for error catching
					try
					{
						wins = Integer.parseInt(line);
						Log.v("Begin Wins: ", Integer.toString(wins));
					}
						
					//Catches BadAttributeValueException and lets user know
					catch(Exception e)
					{
						System.out.print("\n" + e);
					}
				}
				
				count++;
			}
		}
		
		catch(Exception e)
		{
			System.out.print("\n" + e);
		}
	}
	
	public void setLosses()
	{
		String line;
		int count = 0;
		
		try
		{	Log.v("In try: ", "right before opening file for reading");
			//Opens a file to read
			FileInputStream lossesFIS = appContext.openFileInput("datastore.txt");
			
			BufferedReader lossesIn = new BufferedReader(new InputStreamReader(lossesFIS));
			
			Log.v("File for reading: ", "Created");
			//Runs while there is still information to read
			while((line = lossesIn.readLine()) != null)
			{	Log.v("In read file loop", "Reading file");	
				//If statement runs if employee is a salaried employee
				if(count == 1)
				{
					//Try allows for error catching
					try
					{
						losses = Integer.parseInt(line);
						Log.v("Begin Losses: ", Integer.toString(losses));
					}
						
					//Catches BadAttributeValueException and lets user know
					catch(Exception e)
					{
						System.out.print("\n" + e);
					}
				}
				
				count++;
			}
		}
		
		catch(Exception e)
		{
			System.out.print("\n" + e);
		}
	}
	
	public void setHealth()
	{
		String line;
		int count = 0;
		
		try
		{	Log.v("In try: ", "right before opening file for reading");
			//Opens a file to read
			FileInputStream healthFIS = appContext.openFileInput("datastore.txt");
			
			BufferedReader healthIn = new BufferedReader(new InputStreamReader(healthFIS));
			
			Log.v("File for reading: ", "Created");
			//Runs while there is still information to read
			while((line = healthIn.readLine()) != null)
			{	Log.v("In read file loop", "Reading file");	
				//If statement runs if health
				if(count == 2)
				{
					//Try allows for error catching
					try
					{
						health = Integer.parseInt(line);
						Log.v("Begin Health: ", Integer.toString(health));
					}
						
					//Catches BadAttributeValueException and lets user know
					catch(Exception e)
					{
						System.out.print("\n" + e);
					}
				}
				
				count++;
			}
		}
		
		catch(Exception e)
		{
			System.out.print("\n" + e);
		}
	}
	
	public void setInfantry()
	{
		String line;
		int count = 0;
		
		try
		{	Log.v("In try: ", "right before opening file for reading");
			//Opens a file to read
			FileInputStream infantryFIS = appContext.openFileInput("datastore.txt");
			
			BufferedReader infantryIn = new BufferedReader(new InputStreamReader(infantryFIS));
			
			Log.v("File for reading: ", "Created");
			//Runs while there is still information to read
			while((line = infantryIn.readLine()) != null)
			{	Log.v("In read file loop", "Reading file");	
				//If statement runs if employee is a salaried employee
				if(count == 3)
				{
					//Try allows for error catching
					try
					{
						infantry = Integer.parseInt(line);
						Log.v("Begin Infantry: ", Integer.toString(infantry));
					}
						
					//Catches BadAttributeValueException and lets user know
					catch(Exception e)
					{
						System.out.print("\n" + e);
					}
				}
				
				count++;
			}
		}
		
		catch(Exception e)
		{
			System.out.print("\n" + e);
		}
	}
	
	public void setSkill()
	{
		String line;
		int count = 0;
		
		try
		{	Log.v("In try: ", "right before opening file for reading");
			//Opens a file to read
			FileInputStream skillFIS = appContext.openFileInput("datastore.txt");
			
			BufferedReader skillIn = new BufferedReader(new InputStreamReader(skillFIS));
			
			Log.v("File for reading: ", "Created");
			//Runs while there is still information to read
			while((line = skillIn.readLine()) != null)
			{	Log.v("In read file loop", "Reading file");	
				//If statement runs if employee is a salaried employee
				if(count == 1)
				{
					//Try allows for error catching
					try
					{
						skill = Integer.parseInt(line);
						Log.v("Begin Skill: ", Integer.toString(skill));
					}
						
					//Catches BadAttributeValueException and lets user know
					catch(Exception e)
					{
						System.out.print("\n" + e);
					}
				}
				
				count++;
			}
		}
		
		catch(Exception e)
		{
			System.out.print("\n" + e);
		}
	}
	
	public int getWins()
	{
		return wins;
	}
	
	public int getLosses()
	{
		return losses;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getInfantry()
	{
		return infantry;
	}
	
	public int getSkill()
	{
		return skill;
	}
	
	
	public void increaseAttribute(int attribute, int increaseAmt)
	{
		switch(attribute)
		{
			case WINS_ATTRIBUTE: wins += increaseAmt;
				break;
			case LOSSES_ATTRIBUTE: losses += increaseAmt;
				break;
			case HEALTH_ATTRIBUTE: health += increaseAmt;
				break;
			case INFANTRY_ATTRIBUTE: infantry += increaseAmt;
				break;
			case SKILL_ATTRIBUTE: skill += increaseAmt;
				break;				  
		}
		
		int count = 0;
		
		try
		{	
			FileOutputStream fos = appContext.openFileOutput("datastore.txt", 0);
			out = new PrintWriter(new OutputStreamWriter(fos));
			
			while( count <= 4)
			{
				if(count == 0)
				{
					out.println(wins);
				}
				
				if(count == 1)
				{
					out.println(losses);
				}
				
				if(count == 2)
				{
					out.println(health);
				}
				
				if(count == 3)
				{
					out.println(infantry);
				}
				
				if(count == 4)
				{
					out.println(skill);
				}
				
				out.flush();
				
				count++;
			}
			
			out.close();
		}
		
		catch(Exception e)
		{
			System.out.println("\n" + e);
		}
	}
}