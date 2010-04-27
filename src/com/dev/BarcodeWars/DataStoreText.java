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
 */
public class DataStoreText {
	
	private int wins = 0;
	private int losses = 0;
	private int energy = 0;
	private int infantry = 0;
	private int knowledge = 0;
	PrintWriter out;
	Context appContext;
	private final int WINS_ATTRIBUTE = 0;
	private final int LOSSES_ATTRIBUTE = 1;
	private final int ENERGY_ATTRIBUTE = 2;
	private final int INFANTRY_ATTRIBUTE = 3;
	private final int KNOWLEDGE_ATTRIBUTE = 4;
	
	Vector<Integer> vect = new Vector<Integer>();
	
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
	
	public void setEnergy()
	{
		String line;
		int count = 0;
		
		try
		{	Log.v("In try: ", "right before opening file for reading");
			//Opens a file to read
			FileInputStream energyFIS = appContext.openFileInput("datastore.txt");
			
			BufferedReader energyIn = new BufferedReader(new InputStreamReader(energyFIS));
			
			Log.v("File for reading: ", "Created");
			//Runs while there is still information to read
			while((line = energyIn.readLine()) != null)
			{	Log.v("In read file loop", "Reading file");	
				//If statement runs if energy
				if(count == 2)
				{
					//Try allows for error catching
					try
					{
						energy = Integer.parseInt(line);
						Log.v("Begin Energy: ", Integer.toString(energy));
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
						losses = Integer.parseInt(line);
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
	
	public void setKnowledge()
	{
		String line;
		int count = 0;
		
		try
		{	Log.v("In try: ", "right before opening file for reading");
			//Opens a file to read
			FileInputStream knowledgeFIS = appContext.openFileInput("datastore.txt");
			
			BufferedReader knowledgeIn = new BufferedReader(new InputStreamReader(knowledgeFIS));
			
			Log.v("File for reading: ", "Created");
			//Runs while there is still information to read
			while((line = knowledgeIn.readLine()) != null)
			{	Log.v("In read file loop", "Reading file");	
				//If statement runs if employee is a salaried employee
				if(count == 1)
				{
					//Try allows for error catching
					try
					{
						losses = Integer.parseInt(line);
						Log.v("Begin Knowledge: ", Integer.toString(knowledge));
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
	
	public int getEnergy()
	{
		return energy;
	}
	
	public int getInfantry()
	{
		return infantry;
	}
	
	public int getKnowledge()
	{
		return knowledge;
	}
	
	
	public void increaseAttribute(int attribute, int increaseAmt)
	{
		switch(attribute)
		{
			case WINS_ATTRIBUTE: wins += increaseAmt;
				vect.setElementAt(wins, 0);
				break;
			case LOSSES_ATTRIBUTE: losses += increaseAmt;
				vect.setElementAt(losses, 1);
				break;
			case ENERGY_ATTRIBUTE: energy += increaseAmt;
				vect.setElementAt(energy, 2);
				break;
			case INFANTRY_ATTRIBUTE: infantry += increaseAmt;
				vect.setElementAt(infantry, 3);
				break;
			case KNOWLEDGE_ATTRIBUTE: knowledge += increaseAmt;
				vect.setElementAt(knowledge, 4);
				break;				  
		}
		
		int count = 0;
		
		try
		{	
			String line;
			int count2 = 0;
			
			FileInputStream fis = appContext.openFileInput("datastore.txt");
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			
			while((line = in.readLine()) != null)
			{
				if(count2 == 0)
				{
					wins = Integer.parseInt(line);
					Log.v("Output before storage: ", line);
				}
				
				if(count2 == 1)
				{
					losses = Integer.parseInt(line);
					Log.v("Output before storage: ", line);
				}
				
				if(count2 == 2)
				{
					energy = Integer.parseInt(line);
					Log.v("Output before storage: ", line);
				}
				
				if(count2 == 3)
				{
					infantry = Integer.parseInt(line);
					Log.v("Output before storage: ", line);
				}
				
				if(count2 == 0)
				{
					knowledge = Integer.parseInt(line);
					Log.v("Output before storage: ", line);
				}
				
				count++;
			}
			
			FileOutputStream fos = appContext.openFileOutput("datastore.txt", 0);
			out = new PrintWriter(new OutputStreamWriter(fos));
		
			Iterator<Integer> iter = vect.iterator();
			
			while(iter.hasNext())
			{
				if(count == 0)
				{
					out.println(iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 1)
				{
					out.println(iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 2)
				{
					out.println(iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 3)
				{
					out.println(iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 4)
				{
					out.println(iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
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