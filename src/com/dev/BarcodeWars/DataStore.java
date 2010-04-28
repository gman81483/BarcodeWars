package com.dev.BarcodeWars;

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
 * Writes game attribute values to a file in the following order:
 * Wins
 * Losses
 * Health
 * Infantry
 * Skill
 * Humvee
 * Tank
 * Helicopter
 * Fighter Jet
 */
public class DataStore {
	
	private int wins = 0;
	private int losses = 0;
	private int health = 100;
	private int infantry = 0;
	private int skill = 0;
	private int humvee = 0;
	private int tank = 0;
	private int heli = 0;
	private int jet = 0;
	PrintWriter out;
	Context appContext;
	private final int WINS_ATTRIBUTE = 0;
	private final int LOSSES_ATTRIBUTE = 1;
	private final int HEALTH_ATTRIBUTE = 2;
	private final int INFANTRY_ATTRIBUTE = 3;
	private final int SKILL_ATTRIBUTE = 4;
	private final int HUMVEE_ATTRIBUTE = 5;
	private final int TANK_ATTRIBUTE = 6;
	private final int HELI_ATTRIBUTE = 7;
	private final int JET_ATTRIBUTE = 8;
	
	//Constructor instantiates application context
	public DataStore(Context context)
	{		
		appContext = context;
	}
	
	/**
	 * Method sets the wins from the data storage file
	 */
	public void setWins()
	{
		//String to hold currently read line
		String line;
		//Count to keep track of current line
		int count = 0;
		
		try
		{
			//Opens a file to read
			FileInputStream winsFIS = appContext.openFileInput("datastore.txt");
			
			//Adds file to reader for reading
			BufferedReader winsIn = new BufferedReader(new InputStreamReader(winsFIS));
			
			//Runs while there is still information to read
			while((line = winsIn.readLine()) != null)
			{	
				//Runs if it's the wins value
				if(count == 0)
				{
					//Try allows for error catching
					try
					{
						wins = Integer.parseInt(line);
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
	
	/**
	 * Method sets the losses from the data storage file
	 */
	public void setLosses()
	{
		//String to hold currently read line
		String line;
		//Count to keep track of current line
		int count = 0;
		
		try
		{	
			//Opens a file to read
			FileInputStream lossesFIS = appContext.openFileInput("datastore.txt");
			
			//Adds file to reader for reading
			BufferedReader lossesIn = new BufferedReader(new InputStreamReader(lossesFIS));
			
			//Runs while there is still information to read
			while((line = lossesIn.readLine()) != null)
			{	
				//Runs if it's the losses value
				if(count == 1)
				{
					//Try allows for error catching
					try
					{
						losses = Integer.parseInt(line);
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
	
	/**
	 * Method sets the losses from the data storage file
	 */
	public void setHealth()
	{
		//String to hold currently read line
		String line;
		//Count to keep track of current line
		int count = 0;
		
		try
		{
			//Opens a file to read
			FileInputStream healthFIS = appContext.openFileInput("datastore.txt");
			
			//Adds file to reader for reading
			BufferedReader healthIn = new BufferedReader(new InputStreamReader(healthFIS));
			
			//Runs while there is still information to read
			while((line = healthIn.readLine()) != null)
			{
				//Runs if it's the health value
				if(count == 2)
				{
					//Try allows for error catching
					try
					{
						health = Integer.parseInt(line);
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
	
	/**
	 * Method sets the number of Infantry from the data storage file
	 */
	public void setInfantry()
	{
		//String to hold currently read line
		String line;
		//Count to keep track of current line
		int count = 0;
		
		try
		{
			//Opens a file to read
			FileInputStream infantryFIS = appContext.openFileInput("datastore.txt");
			
			//Adds file to reader for reading
			BufferedReader infantryIn = new BufferedReader(new InputStreamReader(infantryFIS));
			
			//Runs while there is still information to read
			while((line = infantryIn.readLine()) != null)
			{	
				//Runs if it's the infantry value
				if(count == 3)
				{
					//Try allows for error catching
					try
					{
						infantry = Integer.parseInt(line);
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
	
	/**
	 * Method sets the Skill amount from the data storage file
	 */
	public void setSkill()
	{
		//String to hold currently read line
		String line;
		//Count to keep track of current line
		int count = 0;
		
		try
		{
			//Opens a file to read
			FileInputStream skillFIS = appContext.openFileInput("datastore.txt");
			
			//Adds file to reader for reading
			BufferedReader skillIn = new BufferedReader(new InputStreamReader(skillFIS));
			
			//Runs while there is still information to read
			while((line = skillIn.readLine()) != null)
			{
				//Runs if it's the Skill value
				if(count == 4)
				{
					//Try allows for error catching
					try
					{
						skill = Integer.parseInt(line);
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
	
	/**
	 * Method sets the number Humvees from the data storage file
	 */
	public void setHumvee()
	{
		//String to hold currently read line
		String line;
		//Count to keep track of current line
		int count = 0;
		
		try
		{
			//Opens a file to read
			FileInputStream humveeFIS = appContext.openFileInput("datastore.txt");
			
			//Adds file to reader for reading
			BufferedReader humveeIn = new BufferedReader(new InputStreamReader(humveeFIS));
			
			//Runs while there is still information to read
			while((line = humveeIn.readLine()) != null)
			{
				//Runs if it's the Humvee value
				if(count == 5)
				{
					//Try allows for error catching
					try
					{
						humvee = Integer.parseInt(line);
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
	
	/**
	 * Method sets the number of Tanks from the data storage file
	 */
	public void setTank()
	{
		//String to hold currently read line
		String line;
		//Count to keep track of current line
		int count = 0;
		
		try
		{
			//Opens a file to read
			FileInputStream tankFIS = appContext.openFileInput("datastore.txt");
			
			//Adds file to reader for reading
			BufferedReader tankIn = new BufferedReader(new InputStreamReader(tankFIS));
			
			//Runs while there is still information to read
			while((line = tankIn.readLine()) != null)
			{
				//Runs if it's the Tank value
				if(count == 6)
				{
					//Try allows for error catching
					try
					{
						tank = Integer.parseInt(line);
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
	
	/**
	 * Method sets the number Helicopters from the data storage file
	 */
	public void setHeli()
	{
		//String to hold currently read line
		String line;
		//Count to keep track of current line
		int count = 0;
		
		try
		{
			//Opens a file to read
			FileInputStream heliFIS = appContext.openFileInput("datastore.txt");
			
			//Adds file to reader for reading
			BufferedReader heliIn = new BufferedReader(new InputStreamReader(heliFIS));
			
			//Runs while there is still information to read
			while((line = heliIn.readLine()) != null)
			{
				//Runs if it's the Helicopter value
				if(count == 7)
				{
					//Try allows for error catching
					try
					{
						heli = Integer.parseInt(line);
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
	
	/**
	 * Method sets the number of Fighter Jets from the data storage file
	 */
	public void setJet()
	{
		//String to hold currently read line
		String line;
		//Count to keep track of current line
		int count = 0;
		
		try
		{
			//Opens a file to read
			FileInputStream jetFIS = appContext.openFileInput("datastore.txt");
			
			//Adds file to reader for reading
			BufferedReader jetIn = new BufferedReader(new InputStreamReader(jetFIS));
			
			//Runs while there is still information to read
			while((line = jetIn.readLine()) != null)
			{
				//Runs if it's the Fighter Jet value
				if(count == 8)
				{
					//Try allows for error catching
					try
					{
						jet = Integer.parseInt(line);
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
	
	/**
	 * Method returns the wins from the data storage file
	 */
	public int getWins()
	{
		return wins;
	}
	
	/**
	 * Method returns the losses from the data storage file
	 */
	public int getLosses()
	{
		return losses;
	}
	
	/**
	 * Method returns the health amount from the data storage file
	 */
	public int getHealth()
	{
		return health;
	}
	
	/**
	 * Method returns the number of Infantry from the data storage file
	 */
	public int getInfantry()
	{
		return infantry;
	}
	
	/**
	 * Method returns the Skill amount from the data storage file
	 */
	public int getSkill()
	{
		return skill;
	}
	
	/**
	 * Method returns the number of Humvees from the data storage file
	 */
	public int getHumvee()
	{
		return humvee;
	}
	
	/**
	 * Method returns the number of tanks from the data storage file
	 */
	public int getTank()
	{
		return tank;
	}
	
	/**
	 * Method returns the number of Helicopters from the data storage file
	 */
	public int getHeli()
	{
		return heli;
	}
	
	/**
	 * Method returns the number of Fighter Jets from the data storage file
	 */
	public int getJet()
	{
		return jet;
	}
	
	/**
	 * Method increases attribute based on scanned value and randomly selected attribute from @BarcodeWars class
	 * @param attribute
	 * @param increaseAmt
	 */
	public void increaseAttribute(int attribute, int increaseAmt)
	{
		//Switch statement selects attribute to increase and increases it
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
			case HUMVEE_ATTRIBUTE: humvee += 1;
				break;
			case TANK_ATTRIBUTE: tank += 1;
				break;
			case HELI_ATTRIBUTE: heli += 1;
				break;
			case JET_ATTRIBUTE: jet += 1;
				break;
		}
		
		//Instantiates count variable for keeping track of line of file currently writing
		int count = 0;
		
		try
		{	
			//Opens file for writing
			FileOutputStream fos = appContext.openFileOutput("datastore.txt", 0);
			
			//Adds file to writer
			out = new PrintWriter(new OutputStreamWriter(fos));
			
			//Continues until all attribute values have been written to the file
			while( count <= 8)
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
				
				if(count == 5)
				{
					out.println(humvee);
				}
				
				if(count == 6)
				{
					out.println(tank);
				}
				
				if(count == 7)
				{
					out.println(heli);
				}
				
				if(count == 8)
				{
					out.println(jet);
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
	
	/**
	 * Method decrease attribute based on scanned value and randomly selected attribute from @BarcodeWars class
	 * @param attribute
	 * @param decreaseAmt
	 */
	public void decreaseAttribute(int attribute, int decreaseAmt)
	{
		//Switch statement selects attribute to decrease and decreases it
		switch(attribute)
		{
			case WINS_ATTRIBUTE: wins -= decreaseAmt;
				break;
			case LOSSES_ATTRIBUTE: losses -= decreaseAmt;
				break;
			case HEALTH_ATTRIBUTE: health -= decreaseAmt;
				break;
			case INFANTRY_ATTRIBUTE: infantry -= decreaseAmt;
				break;
			case SKILL_ATTRIBUTE: skill -= decreaseAmt;
				break;
			case HUMVEE_ATTRIBUTE: humvee -= 1;
				break;
			case TANK_ATTRIBUTE: tank -= 1;
				break;
			case HELI_ATTRIBUTE: heli -= 1;
				break;
			case JET_ATTRIBUTE: jet -= 1;
				break;
		}
		
		//Instantiates count variable for keeping track of line of file currently writing
		int count = 0;
		
		try
		{	
			//Opens file for writing
			FileOutputStream fos = appContext.openFileOutput("datastore.txt", 0);
			
			//Adds file to writer
			out = new PrintWriter(new OutputStreamWriter(fos));
			
			////Continues until all attribute values have been written to the file
			while( count <= 8)
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
				
				if(count == 5)
				{
					out.println(humvee);
				}
				
				if(count == 6)
				{
					out.println(tank);
				}
				
				if(count == 7)
				{
					out.println(heli);
				}
				
				if(count == 8)
				{
					out.println(jet);
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