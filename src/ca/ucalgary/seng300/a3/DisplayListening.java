/**
 * Function for delivery chute listener
 * Elodie Boudes 10171818, Grace Ferguson 30004869, 
 * Tae Chyung 10139101, Karndeep Dhami 10031989, 
 * Andrew Garcia-Corley 10015169 & Michael de Grood 10134884
 */

package  ca.ucalgary.seng300.a3;

import java.io.IOException;

import org.lsmr.vending.hardware.AbstractHardware;
import org.lsmr.vending.hardware.AbstractHardwareListener;
import org.lsmr.vending.hardware.Display;
import org.lsmr.vending.hardware.DisplayListener;

/**
* Listener class to implement functions for the vending machine's display.
*/
public class DisplayListening implements DisplayListener {
	private boolean isOn;
	private String prevMessage = "";
	private String currMessage = "";
	
	public DisplayListening() {
		isOn = true;
	
	}

	/**
	* Method to enable the display.
	*/
	@Override
	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		isOn = true;
		
	}

	/**
	* Method to disable the display.
	*/
	@Override
	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		isOn = false;
		
	}

	/**
	* Method to change the message on the display.
	* @param display - the display object whose message will be changed
	* @param oldMessage - the previous message on the display
	* @param newMessage - the new message to be displayed
	*/
	@Override
	public void messageChange(Display display, String oldMessage, String newMessage) {
		prevMessage = oldMessage;
		currMessage = newMessage;
		try {
			LogFile.writeLog(LogFile.df.format(LogFile.dateobj) + "\t" + this.getClass().getName() + "\t" + currMessage);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	/**
	 * Returns current status of display
	 * @return isOn
	 */ 
	public boolean isOn() {
		return isOn;
		
	}
	
	/**
	 * For testing purposes
	 * @return prevMessage - returns the previous message
	 */
	public String getPrevMessage() {
		return prevMessage;
		
	}
	
	/**
	 * For testing purposes
	 * @return currMessage - returns the current message
	 */
	public String getCurrMessage() {
		return currMessage;
		
	}
	
	/**
	 * For testing purposes
	 * Sets the current message field.
	 * @param msg - the message to be set as the current message
	 */
	public void setCurrMessage(String msg) {
		currMessage = msg;
		
	}
	
	/**
	 * for testing purposes
	 * Sets the previous message field.
	 * @param msg - the message to be set as the previous message
	 */
	public void setPrevMessage(String msg) {
		prevMessage = msg;
		
	}



}
