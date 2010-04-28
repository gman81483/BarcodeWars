package com.dev.BarcodeWars;

import android.content.Context;

/**
 * @author Greg Charette
 * @author Steve Aquillano
 *
 * Contains attack logic for the game
 */
public class FightEngine 
{	
	Context appContext;
	
	//Declares all attributes
	private int infantryAttack = 0;
	private int skillAttack = 0;
	private int humveeAttack = 0;
	private int tankAttack = 0;
	private int heliAttack = 0;
	private int jetAttack = 0;
	private int totalAttack = 0;
	private int computerAttack = 0;
	private int attackResult = 0;
	private boolean win = false;
	
	//Instantiates attack multiplier constants for the vehicles
	private final int HUMVEE_ATTACK = 2;
	private final int TANK_ATTACK = 5;
	private final int HELI_ATTACK = 8;
	private final int JET_ATTACK = 10;
	
	//Constructor instantiates application context for passing between classes
	public FightEngine(Context context)
	{		
		appContext = context;
	}
	
	/**
	 * Method contains logic for attacking
	 * 
	 * @param infantry
	 * @param skill
	 * @param humvee
	 * @param tank
	 * @param heli
	 * @param jet
	 */
	public void initiateFight(int infantry, int skill, int humvee, int tank, int heli, int jet)
	{
		//Initializes all choices from user for attack
		infantryAttack = infantry;
		skillAttack = skill;
		humveeAttack = humvee * HUMVEE_ATTACK;
		tankAttack = tank * TANK_ATTACK;
		heliAttack = heliAttack * HELI_ATTACK;
		jetAttack = jetAttack * JET_ATTACK;
		totalAttack = infantryAttack + skillAttack + humveeAttack + tankAttack + heliAttack + jetAttack;
		
		//Sets computer's attack, which can be from 0 to twice the user's attack, assigned at random
		computerAttack = (int)Math.round(Math.random() * (totalAttack * 2));
		
		//Executes if user wins
		if(totalAttack > computerAttack)
		{
			win = true;
			
			//Calculates how much damage dealt to enemy
			attackResult = totalAttack - computerAttack;
		}
		
		//Executes if user loses
		if(totalAttack < computerAttack)
		{
			win = false;
			
			//Calculates how much damage user sustains
			attackResult = computerAttack - totalAttack;
		}
	}
	
	/**
	 * Returns whether or not user won the fight
	 * 
	 * @return win
	 */
	public boolean getFightWinLose()
	{
		return win;
	}
	
	/**
	 * Returns the amount of damage dealt or received
	 * 
	 * @return attackResult
	 */
	public int getFightResult()
	{
		return attackResult;
	}
}
