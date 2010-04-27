package com.dev.BarcodeWars;

import java.util.HashMap;
import java.util.Map;

import com.dev.BarcodeWars.R;
import android.app.Activity; 
import android.content.*;
import android.os.Bundle;
import android.util.Log;
import android.view.View; 
import android.view.View.OnLongClickListener;
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
	private Button scanButton;
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
	private DataStoreText dataStore;
	private final int WINS_ATTRIBUTE = 0;
	private final int LOSSES_ATTRIBUTE = 1;
	private final int HEALTH_ATTRIBUTE = 2;
	private final int INFANTRY_ATTRIBUTE = 3;
	private final int SKILL_ATTRIBUTE = 4;	
	
	/**onCreate instantiates the initial program objects and sets up layout when program
	 * is opened
	*/
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{ 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.main);

		scanButton = (Button) this.findViewById(R.id.scanButton);
		findViewById(R.id.scanButton).setOnClickListener(ocl);
		
		seekBarInfantry = (SeekBar) findViewById(R.id.SeekBarInfantry);
		seekBarInfantry.setOnSeekBarChangeListener(oscl); 

		
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
		
		Context appContext = getApplicationContext();
		dataStore = new DataStoreText(appContext);
		
		dataStore.setWins();
		dataStore.setLosses();
		dataStore.setHealth();
		dataStore.setInfantry();
		dataStore.setSkill();
		textViewHealthValue.setText(Integer.toString(dataStore.getHealth()));
		textViewWinsValue.setText(Integer.toString(dataStore.getWins()));
		textViewLossesValue.setText(Integer.toString(dataStore.getLosses()));
		textViewInfantryQuantity.setText(Integer.toString(dataStore.getInfantry()));
		textViewSkillValue.setText(Integer.toString(dataStore.getSkill()));
		
	}
	
	/**Method listens for the scanning button to be clicked.  When this happens,
	 * a new intent is created that opens the scanning class and calls @startActivityForResult
	 * to start performing the desired operation
	*/
	public final Button.OnClickListener ocl = new Button.OnClickListener() {
	    public void onClick(View v) {
	    	
	    	String scanResult = calcScanPoints("A19N25L567");
	    	scanResultText.setText("Excellent! This scan increased your " + increasedAttribute + " by " + scanResult + "!");
	    	
	    	if(increasedAttribute.equals("Health"))
	    	{
	    		textViewHealthValue.setText(Integer.toString(dataStore.getHealth()));
	    	}
	    	
	    	if(increasedAttribute.equals("Skill"))
	    	{
	    		textViewSkillValue.setText(Integer.toString(dataStore.getSkill()));
	    	}
	    	
	    	if(increasedAttribute.equals("Infantry"))
	    	{
	    		textViewInfantryQuantity.setText(Integer.toString(dataStore.getInfantry()));
	    	}
	    	
	    	/*Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		    startActivityForResult(intent, 0);*/
	    }
	  };
	    
    public final OnSeekBarChangeListener oscl = new OnSeekBarChangeListener() { 
    	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){ 
                textViewInfantrySelected.setText(Integer.toString((progress * dataStore.getInfantry()) / 100)); 
           } 

           public void onStartTrackingTouch(SeekBar seekBar) {} 
           public void onStopTrackingTouch(SeekBar seekBar) {} 
            
      }; 




	/**onActivityResult initiates scanner activity, passing the barcode into the method, which calls
	 * the method @calcScanPoints to calculate the total points the player receives from
	 * the object that was scanned
	*/
	/*public void onActivityResult(int requestCode, int resultCode, Intent intent) 
	{
	    if (requestCode == 0) 
	    {
	    	if (resultCode == RESULT_OK) 
	    	{
	    		
	    		//String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
	    		scanResultText.setText("Excellent! This scan increased your " + increasedAttribute + " by " + scanResult + "!\n\nYour current stats are:\nHealth: " + health + "\nInfantry: " + infantry + "\nSkill: " + skill);

	    		/*if(format.equals("ISBN"))
	    		{
	    			skill += Integer.parseInt(scanResult);
	    		}
	    	} 
	    	
	    	else if (resultCode == RESULT_CANCELED) 
	    	{
	    		//showDialog(R.string.result_failed, getString(R.string.result_failed_why));
	    	}
	    }
	}*/
	/**calcScanPoints takes in the result of the barcode scan, calculates the total number of points for the scan,
	 * and assigns the points to the appropriate player attribute
	 * @param scanResult
	 * @return - String calcScanPoints - Total points gained from the object scanned
	 * @throws NullPointerException
	 */
	public String calcScanPoints(String scanResult) throws NullPointerException
	{
		int finalScannedPoints = 0;
		Map<String, String> hm = new HashMap<String, String>();
		
		String[] keys = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String[] values = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36"};
		
		for(int i = 0; i < keys.length; i++)
		{
			hm.put(keys[i], values[i]);
		}
		
		for(int i = 0; i < scanResult.length(); i++)
		{
			if(!scanResult.equals(null))
			{	
				finalScannedPoints += (Integer.parseInt((String)hm.get(scanResult.substring(i,i+1).toUpperCase()))) / 10;
				
			}
		}
		
		int randomNum = (int)Math.round(Math.random() * 2);
		
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
				increasedAttribute = "Skill";
				dataStore.increaseAttribute(SKILL_ATTRIBUTE, finalScannedPoints);
				break;
		}
		
		Log.v("randomNumber: ", Integer.toString(randomNum));
		
		return Integer.toString(finalScannedPoints);
	} 
}
	