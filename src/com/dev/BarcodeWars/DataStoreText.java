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
	BufferedReader in;
	private PrintWriter out;
	Context appContext;
	
	Vector<Integer> vect = new Vector<Integer>();
	
	public DataStoreText(Context context)
	{
		Log.v("Entering DataStoreText Constructor", "YEAH BABY");
		initAttributes();
		
		appContext = context;
	}
	
	private void initAttributes()
	{
		Log.v("In INITATTRIBUTES", "HELLZ YEAH!!!!");
		//String stores information read from file
		String line;
		
		//Try allows for error catching
		try
		{	
			//Opens a file to read
			FileInputStream fis = appContext.openFileInput("datastore");
			
			in = new BufferedReader(new InputStreamReader(fis));
			
			//Runs while there is still information to read
			while((line = in.readLine()) != null)
			{		
				//If statement runs if employee is a salaried employee
				if(line.substring(0,3).equals("wins"))
				{
					//Try allows for error catching
					try
					{
						wins = Integer.parseInt(line.substring(5,line.length() - 1));
					}
						
					//Catches BadAttributeValueException and lets user know
					catch(Exception e)
					{
						System.out.print("\n" + e);
					}
				}
				
				//If statement runs if employee is a salaried employee
				if(line.substring(0,5).equals("losses"))
				{
					//Try allows for error catching
					try
					{
						losses = Integer.parseInt(line.substring(7,line.length() - 1));
					}
						
					//Catches BadAttributeValueException and lets user know
					catch(Exception e)
					{
						System.out.print("\n" + e);
					}
				}
				
				//If statement runs if employee is a salaried employee
				if(line.substring(0,5).equals("energy"))
				{
					//Try allows for error catching
					try
					{
						energy = Integer.parseInt(line.substring(7,line.length() - 1));
					}
						
					//Catches BadAttributeValueException and lets user know
					catch(Exception e)
					{
						System.out.print("\n" + e);
					}
				}
				
				//If statement runs if employee is a salaried employee
				if(line.substring(0,7).equals("infantry"))
				{
					//Try allows for error catching
					try
					{
						infantry = Integer.parseInt(line.substring(9,line.length() - 1));
					}
						
					//Catches BadAttributeValueException and lets user know
					catch(Exception e)
					{
						System.out.print("\n" + e);
					}
				}
				
				if(line.substring(0,8).equals("knowledge"))
				{
					//Try allows for error catching
					try
					{
						knowledge = Integer.parseInt(line.substring(10,line.length() - 1));
					}
						
					//Catches BadAttributeValueException and lets user know
					catch(Exception e)
					{
						System.out.print("\n" + e);
					}
				}
				
				try
				{
					in.close();
				}
				
				catch(Exception e)
				{
					System.out.print("\n" + e);
				}
			}
		}
		
		//Catches IO Exception and lets user know
		catch(Exception e)
		{
			System.out.print("\n" + e);
		}
		
		vect.add(wins);
		vect.add(losses);
		vect.add(energy);
		vect.add(infantry);
		vect.add(knowledge);
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
	
	public void setWins(int winsIncrease)
	{
		wins += winsIncrease;
		vect.setElementAt(wins, 0);
		int count = 0;
		
		try
		{	
			FileOutputStream fos = appContext.openFileOutput("datastore", 0);
			out = new PrintWriter(new OutputStreamWriter(fos));
		
			Iterator<Integer> iter = vect.iterator();
			
			while(iter.hasNext())
			{
				if(count == 0)
				{
					out.println("wins=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 1)
				{
					out.println("losses=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 2)
				{
					out.println("energy=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 3)
				{
					out.println("infantry=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 4)
				{
					out.println("knowledge=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				count++;
			}
			
			out.flush();
			
			out.close();
		}
		
		catch(Exception e)
		{
			System.out.println("\n" + e);
		}
	}
	
	public void setLosses(int lossesIncrease)
	{
		losses += lossesIncrease;
		vect.setElementAt(losses, 1);
		int count = 0;
		
		try
		{
			FileOutputStream fos = appContext.openFileOutput("datastore", 0);
			out = new PrintWriter(new OutputStreamWriter(fos));
		
			Iterator<Integer> iter = vect.iterator();
			
			while(iter.hasNext())
			{
				if(count == 0)
				{
					out.println("wins=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 1)
				{
					out.println("losses=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 2)
				{
					out.println("energy=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 3)
				{
					out.println("infantry=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 4)
				{
					out.println("knowledge=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				count++;
			}
			
			out.flush();
			
			out.close();
		}
		
		catch(Exception e)
		{
			System.out.println("\n" + e);
		}
	}
	
	public void setEnergy(int energyIncrease)
	{
		energy += energyIncrease;
		vect.setElementAt(energy, 2);
		int count = 0;
		
		try
		{
			FileOutputStream fos = appContext.openFileOutput("datastore", 0);
			out = new PrintWriter(new OutputStreamWriter(fos));
		
			Iterator<Integer> iter = vect.iterator();
			
			while(iter.hasNext())
			{
				if(count == 0)
				{
					out.println("wins=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 1)
				{
					out.println("losses=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 2)
				{
					out.println("energy=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 3)
				{
					out.println("infantry=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 4)
				{
					out.println("knowledge=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				count++;
			}
			
			out.flush();
			
			out.close();
		}
		
		catch(Exception e)
		{
			System.out.println("\n" + e);
		}
	}
	
	public void setInfantry(int infantryIncrease)
	{
		infantry += infantryIncrease;
		vect.setElementAt(infantry, 3);
		int count = 0;
		
		try
		{     
			FileOutputStream fos = appContext.openFileOutput("datastore", 0);
			out = new PrintWriter(new OutputStreamWriter(fos));
		
			Iterator<Integer> iter = vect.iterator();
			
			while(iter.hasNext())
			{
				if(count == 0)
				{
					out.println("wins=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 1)
				{
					out.println("losses=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 2)
				{
					out.println("energy=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 3)
				{
					out.println("infantry=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 4)
				{
					out.println("knowledge=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				count++;
			}
			
			out.flush();
			
			out.close();
		}
			
		catch(Exception e)
		{
			System.out.print("\n" + e);
		}
	}
	
	public void setKnowledge(int knowledgeIncrease)
	{
		knowledge += knowledgeIncrease;
		vect.setElementAt(knowledge, 4);
		int count = 0;
		
		try
		{
			FileOutputStream fos = appContext.openFileOutput("datastore", 0);
			out = new PrintWriter(new OutputStreamWriter(fos));
		
			Iterator<Integer> iter = vect.iterator();
			
			while(iter.hasNext())
			{
				if(count == 0)
				{
					out.println("wins=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 1)
				{
					out.println("losses=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 2)
				{
					out.println("energy=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 3)
				{
					out.println("infantry=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				if(count == 4)
				{
					out.println("knowledge=" + iter.next());
					//Log.v("Iterator value: ", Integer.toString(iter.next()));
				}
				
				count++;
			}
			
			out.flush();
			
			out.close();
		}
		
		catch(Exception e)
		{
			System.out.println("\n" + e);
		}
	}
}