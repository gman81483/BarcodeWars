package com.dev.BarcodeWars;

import java.util.HashMap;
import java.util.Map;

import com.dev.BarcodeWars.R;
import android.app.Activity; 
import android.content.*;
import android.os.Bundle;
import android.util.Log;
import android.view.View; 
import android.widget.*;
import android.widget.SeekBar.OnSeekBarChangeListener;

/**Class BarcodeWars is the driver class behind the BarcodeWars application
 * 
 * @author Greg Charette
 * @author Steve Aquillano
 *
 */
public class BarcodeWars extends Activity 
{
	//Declares all attributes
	private Button scanButton;
	private Button attackButton;
	private TextView scanResultText;
	private TextView textViewHealthValue;
	private TextView textViewSkillValue;
	private TextView textViewWinsValue;
	private TextView textViewLossesValue;
	private TextView textViewInfantryQuantity;
	private TextView textViewInfantrySelected;
	private TextView textViewHumveeQuantity;
	private TextView textViewHumveeSelected;
	private TextView textViewTankQuantity;
	private TextView textViewTankSelected;
	private TextView textViewHeliQuantity;
	private TextView textViewHeliSelected;
	private TextView textViewJetQuantity;
	private TextView textViewJetSelected;
	private SeekBar seekBarInfantry;
	private SeekBar seekBarHumvee;
	private SeekBar seekBarTank;
	private SeekBar seekBarHeli;
	private SeekBar seekBarJet;
	private String increasedAttribute = null;
	private DataStore dataStore;
	private FightEngine fight;
	private final int WINS_ATTRIBUTE = 0;
	private final int LOSSES_ATTRIBUTE = 1;
	private final int HEALTH_ATTRIBUTE = 2;
	private final int INFANTRY_ATTRIBUTE = 3;
	private final int SKILL_ATTRIBUTE = 4;
	private final int HUMVEE_ATTRIBUTE = 5;
	private final int TANK_ATTRIBUTE = 6;
	private final int HELI_ATTRIBUTE = 7;
	private final int JET_ATTRIBUTE = 8;
	private String scannedResult;
	
	/**onCreate instantiates the initial program objects and sets up layout when program
	 * is opened
	*/
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{ 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.main);
		
		//Sets up buttons for use in GUI
		scanButton = (Button) this.findViewById(R.id.scanButton);
		findViewById(R.id.scanButton).setOnClickListener(mScan);
		attackButton = (Button) this.findViewById(R.id.attackButton);
		findViewById(R.id.attackButton).setOnClickListener(ocl);
		
		//Instantiates scroll bars to adjust how many of each item to use during a fight
		seekBarInfantry = (SeekBar) findViewById(R.id.SeekBarInfantry);
		seekBarInfantry.setOnSeekBarChangeListener(oscl);
		seekBarHumvee = (SeekBar) findViewById(R.id.SeekBarHumvee);
		seekBarHumvee.setOnSeekBarChangeListener(oscl);
		seekBarTank = (SeekBar) findViewById(R.id.SeekBarTank);
		seekBarTank.setOnSeekBarChangeListener(oscl);
		seekBarHeli = (SeekBar) findViewById(R.id.SeekBarHeli);
		seekBarHeli.setOnSeekBarChangeListener(oscl);
		seekBarJet = (SeekBar) findViewById(R.id.SeekBarJet);
		seekBarJet.setOnSeekBarChangeListener(oscl); 

		//Instantiates all the text boxes for use in the GUI
		scanResultText = (TextView) this.findViewById(R.id.scanResultText);
		textViewHealthValue = (TextView) this.findViewById(R.id.TextViewHealthValue);
		textViewSkillValue = (TextView) this.findViewById(R.id.TextViewSkillValue);
		textViewWinsValue = (TextView) this.findViewById(R.id.TextViewWinsValue);
		textViewLossesValue = (TextView) this.findViewById(R.id.TextViewLossesValue);
		textViewInfantryQuantity = (TextView) this.findViewById(R.id.TextViewInfantryQuantity);
		textViewInfantrySelected = (TextView) this.findViewById(R.id.TextViewInfantrySelected);
		textViewHumveeQuantity = (TextView) this.findViewById(R.id.TextViewHumveeQuantity);
		textViewHumveeSelected = (TextView) this.findViewById(R.id.TextViewHumveeSelected);
		textViewTankSelected = (TextView) this.findViewById(R.id.TextViewTankSelected);
		textViewTankQuantity = (TextView) this.findViewById(R.id.TextViewTankQuantity);
		textViewHeliSelected = (TextView) this.findViewById(R.id.TextViewHeliSelected);
		textViewHeliQuantity = (TextView) this.findViewById(R.id.TextViewHeliQuantity);
		textViewJetSelected = (TextView) this.findViewById(R.id.TextViewJetSelected);
		textViewJetQuantity = (TextView) this.findViewById(R.id.TextViewJetQuantity);
		
		//Instantiates application context to enable passing objects through classes
		Context appContext = getApplicationContext();
		
		//Instantiates DataStore class for storing the player data
		dataStore = new DataStore(appContext);
		
		//Instantiates the fighting class containing the logic for an attack
		fight = new FightEngine(appContext);
		
		//Initializes all the attributes in the DataStore
		dataStore.setAttributes();
		
		//Initializes all the text boxes to the correct values from the DataStore
		textViewHealthValue.setText(Integer.toString(dataStore.getHealth()));
		textViewWinsValue.setText(Integer.toString(dataStore.getWins()));
		textViewLossesValue.setText(Integer.toString(dataStore.getLosses()));
		textViewInfantryQuantity.setText(Integer.toString(dataStore.getInfantry()));
		textViewSkillValue.setText(Integer.toString(dataStore.getSkill()));
		textViewHumveeQuantity.setText(Integer.toString(dataStore.getHumvee()));
		textViewTankQuantity.setText(Integer.toString(dataStore.getTank()));
		textViewHeliQuantity.setText(Integer.toString(dataStore.getHeli()));
		textViewJetQuantity.setText(Integer.toString(dataStore.getJet()));
		
	}
	
	/**Method listens for the buttons to be clicked.  When this happens,
	 * a new intent is created that opens the scanning class
	 * to start performing the desired operation
	*/
	public Button.OnClickListener mScan = new Button.OnClickListener() { 
	    public void onClick(View v) { 
	        Intent intent = new Intent("com.google.zxing.client.android.SCAN"); 
	        startActivityForResult(intent, 0);
	    } 
	};
	
	  /**
	   * Method is used to test application. Button listener above and the
	   * method onActivityResult must be commented out before uncommenting
	   * this code and running the application
	   */
	  /*public Button.OnClickListener mScan = new Button.OnClickListener() { 
	    public void onClick(View v) { 
	    	    		
    		String scanResult = calcScanPoints("A785H981T07B3");
	        
  	        //Sets Health text on GUI to correct value
  	    	if(increasedAttribute.equals("Health"))
  	    	{
  	    		scanResultText.setText("Excellent! This scan increased your " + increasedAttribute + " by " + scanResult + "!");
  	    		textViewHealthValue.setText(Integer.toString(dataStore.getHealth()));
  	    	}
  	    	
  	    	//Sets Skill text on GUI to correct value
  	    	if(increasedAttribute.equals("Skill"))
  	    	{
  	    		scanResultText.setText("Excellent! This scan increased your " + increasedAttribute + " by " + scanResult + "!");
  	    		textViewSkillValue.setText(Integer.toString(dataStore.getSkill()));
  	    	}
  	    	
  	    	//Sets Infantry text on GUI to correct value
  	    	if(increasedAttribute.equals("Infantry"))
  	    	{
  	    		scanResultText.setText("Excellent! This scan increased your " + increasedAttribute + " by " + scanResult + "!");
  	    		textViewInfantryQuantity.setText(Integer.toString(dataStore.getInfantry()));
  	    	}
  	    	
  	    	//Sets Humvee text on GUI to correct value
  	    	if(increasedAttribute.equals("Humvee"))
  	    	{
  	    		scanResultText.setText("Excellent! This scan increased your " + increasedAttribute + " by " + 1 + "!");
  	    		textViewHumveeQuantity.setText(Integer.toString(dataStore.getHumvee()));
  	    	}
  	    	
  	    	//Sets Tank text on GUI to correct value
  	    	if(increasedAttribute.equals("Tank"))
  	    	{
  	    		scanResultText.setText("Excellent! This scan increased your " + increasedAttribute + " by " + 1 + "!");
  	    		textViewTankQuantity.setText(Integer.toString(dataStore.getTank()));
  	    	}
  	    	
  	    	//Sets Helicopter text on GUI to correct value
  	    	if(increasedAttribute.equals("Heli"))
  	    	{
  	    		scanResultText.setText("Excellent! This scan increased your " + increasedAttribute + " by " + 1 + "!");
  	    		textViewHeliQuantity.setText(Integer.toString(dataStore.getHeli()));
  	    	}
  	    	
  	    	//Sets Jet Fighter text on GUI to correct value
  	    	if(increasedAttribute.equals("Jet"))
  	    	{
  	    		scanResultText.setText("Excellent! This scan increased your " + increasedAttribute + " by " + 1 + "!");
  	    		textViewJetQuantity.setText(Integer.toString(dataStore.getJet()));
  	    	}
	    } 
	};*/
	
	public final Button.OnClickListener ocl = new Button.OnClickListener() {
	    public void onClick(View v) {
	    		    	
		//Initiates fight using the FightEngine
		fight.initiateFight(Integer.parseInt((String)textViewInfantrySelected.getText()), Integer.parseInt((String)textViewSkillValue.getText()), Integer.parseInt((String)textViewHumveeSelected.getText()), Integer.parseInt((String)textViewTankSelected.getText()), Integer.parseInt((String)textViewHeliSelected.getText()), Integer.parseInt((String)textViewJetSelected.getText()));
		
		//Executes if user wins the fight and sets GUI texts to correct values using the DataStore
		if(fight.getFightWinLose())
		{
			scanResultText.setText("Excellent, you won the fight, causing " + fight.getFightResult() + " damage and increasing your skill by " + fight.getFightResult() + "!!");
			dataStore.increaseAttribute(WINS_ATTRIBUTE, 1);
			dataStore.increaseAttribute(SKILL_ATTRIBUTE, fight.getFightResult());
			textViewWinsValue.setText(Integer.toString(dataStore.getWins()));
			textViewSkillValue.setText(Integer.toString(dataStore.getSkill()));
		}
		
		//Executes if user loses the fight and sets GUI texts to correct values using the DataStore
		if(!fight.getFightWinLose())
		{
			scanResultText.setText("You lose, taking " + fight.getFightResult() + " damage!!");
			dataStore.increaseAttribute(LOSSES_ATTRIBUTE, 1);
			dataStore.decreaseAttribute(HEALTH_ATTRIBUTE, fight.getFightResult());
			textViewLossesValue.setText(Integer.toString(dataStore.getLosses()));
			textViewHealthValue.setText(Integer.toString(dataStore.getHealth()));
		}
	  }
	};
	
	  /**Method listens for any scroll bars to change.
	   */
	  public final OnSeekBarChangeListener oscl = new OnSeekBarChangeListener() { 
    	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){ 
           
    	   //Executes if Infantry bar is moved and sets the selected Infantry amount text to the correct value
    	   if(seekBar.getId() == seekBarInfantry.getId())
           { 	
        	   textViewInfantrySelected.setText(Integer.toString((progress * dataStore.getInfantry()) / 100));
           }
           
    	   //Executes if Humvee bar is moved and sets the selected Humvee amount text to the correct value
           if(seekBar.getId() == seekBarHumvee.getId())
           { 	
        	   textViewHumveeSelected.setText(Integer.toString((progress * dataStore.getHumvee()) / 100));
           }
           
           //Executes if Tank bar is moved and sets the selected Tank amount text to the correct value
           if(seekBar.getId() == seekBarTank.getId())
           { 	
        	   textViewTankSelected.setText(Integer.toString((progress * dataStore.getTank()) / 100));
           }
           
           //Executes if Helicopter bar is moved and sets the selected Helicopter amount text to the correct value
           if(seekBar.getId() == seekBarHeli.getId())
           { 	
        	   textViewHeliSelected.setText(Integer.toString((progress * dataStore.getHeli()) / 100));
           }
           
           //Executes if Fighter Jet bar is moved and sets the selected Fighter Jet amount text to the correct value
           if(seekBar.getId() == seekBarJet.getId())
           { 	
        	   textViewJetSelected.setText(Integer.toString((progress * dataStore.getJet()) / 100));
           }
           
        } 

           public void onStartTrackingTouch(SeekBar seekBar) {} 
           public void onStopTrackingTouch(SeekBar seekBar) {} 
            
      };

	/**onActivityResult initiates scanner activity, passing the barcode into the method, which calls
	 * the method @calcScanPoints to calculate the total points the player receives from
	 * the object that was scanned
	*/
	public void onActivityResult(int requestCode, int resultCode, Intent intent) 
	{
	    if (requestCode == 0) 
	    {
	    	if (resultCode == RESULT_OK) 
	    	{
	    		scannedResult = intent.getStringExtra("SCAN_RESULT");
	    		
	    		String scanResult = calcScanPoints(scannedResult);
		        
	  	      //Sets Health text on GUI to correct value
	  	    	if(increasedAttribute.equals("Health"))
	  	    	{
	  	    		scanResultText.setText("Excellent! This scan increased your " + increasedAttribute + " by " + scanResult + "!");
	  	    		textViewHealthValue.setText(Integer.toString(dataStore.getHealth()));
	  	    	}
	  	    	
	  	    	//Sets Infantry text on GUI to correct value
	  	    	if(increasedAttribute.equals("Infantry"))
	  	    	{
	  	    		scanResultText.setText("Excellent! This scan increased your " + increasedAttribute + " by " + scanResult + "!");
	  	    		textViewInfantryQuantity.setText(Integer.toString(dataStore.getInfantry()));
	  	    	}
	  	    	
	  	    	//Sets Humvee text on GUI to correct value
	  	    	if(increasedAttribute.equals("Humvee"))
	  	    	{
	  	    		scanResultText.setText("Excellent! This scan increased your " + increasedAttribute + " by " + 1 + "!");
	  	    		textViewHumveeQuantity.setText(Integer.toString(dataStore.getHumvee()));
	  	    	}
	  	    	
	  	    	//Sets Tank text on GUI to correct value
	  	    	if(increasedAttribute.equals("Tank"))
	  	    	{
	  	    		scanResultText.setText("Excellent! This scan increased your " + increasedAttribute + " by " + 1 + "!");
	  	    		textViewTankQuantity.setText(Integer.toString(dataStore.getTank()));
	  	    	}
	  	    	
	  	    	//Sets Helicopter text on GUI to correct value
	  	    	if(increasedAttribute.equals("Heli"))
	  	    	{
	  	    		scanResultText.setText("Excellent! This scan increased your " + increasedAttribute + " by " + 1 + "!");
	  	    		textViewHeliQuantity.setText(Integer.toString(dataStore.getHeli()));
	  	    	}
	  	    	
	  	    	//Sets Jet Fighter text on GUI to correct value
	  	    	if(increasedAttribute.equals("Jet"))
	  	    	{
	  	    		scanResultText.setText("Excellent! This scan increased your " + increasedAttribute + " by " + 1 + "!");
	  	    		textViewJetQuantity.setText(Integer.toString(dataStore.getJet()));
	  	    	}
	    	}
	    }
	}
      
	/**calcScanPoints takes in the result of the barcode scan, calculates the total number of points for the scan,
	 * and assigns the points to the appropriate player attribute
	 * @param scanResult
	 * @return - String calcScanPoints - Total points gained from the object scanned
	 * @throws NullPointerException
	 */
	public String calcScanPoints(String scanResult) throws NullPointerException
	{
		//Variable for points after calculations are performed
		int finalScannedPoints = 0;
		//Map to hold the key/value pairs for potential scanned values to convert to numbers
		Map<String, String> hm = new HashMap<String, String>();
		
		//Instantiates keys array holding potential values
		String[] keys = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		
		//Instantiates values array to hold converted values
		String[] values = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36"};
		
		//Adds array values to the hash map
		for(int i = 0; i < keys.length; i++)
		{
			hm.put(keys[i], values[i]);
		}
		
		//Adds each digit of the scanned number to get result
		for(int i = 0; i < scanResult.length(); i++)
		{
			if(!scanResult.equals(null))
			{	
				finalScannedPoints += Integer.parseInt((String)hm.get(scanResult.substring(i,i+1).toUpperCase()));
			}
		}
		
		//Divides points by 10
		finalScannedPoints /= 10;
		
		//Instantiates a random number to randomly select attribute to be updated
		int randomNum = (int)Math.round(Math.random() * 5);
		
		//Switch statement selects appropriate attribute based on generated random number above and
		//sets the value in the DataStore
		switch(randomNum)
		{
			case 0:
				increasedAttribute = "Health";
				dataStore.increaseAttribute(HEALTH_ATTRIBUTE, finalScannedPoints);
				break;
			case 1:
				increasedAttribute = "Infantry";
				dataStore.increaseAttribute(INFANTRY_ATTRIBUTE, finalScannedPoints);
				break;
			case 2:
				increasedAttribute = "Humvee";
				dataStore.increaseAttribute(HUMVEE_ATTRIBUTE, finalScannedPoints);
				break;
			case 3:
				increasedAttribute = "Tank";
				dataStore.increaseAttribute(TANK_ATTRIBUTE, finalScannedPoints);
				break;
			case 4:
				increasedAttribute = "Heli";
				dataStore.increaseAttribute(HELI_ATTRIBUTE, finalScannedPoints);
				break;
			case 5:
				increasedAttribute = "Jet";
				dataStore.increaseAttribute(JET_ATTRIBUTE, finalScannedPoints);
				break;
			
		}
		
		//Returns the final scanned amount as a String value
		return Integer.toString(finalScannedPoints);
	} 
}
	