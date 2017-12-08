/**
*SENG 300 Group 3
*/
package ca.ucalgary.seng300.a3;


import java.io.IOException;

import org.lsmr.vending.Coin;
import org.lsmr.vending.hardware.AbstractHardware;
import org.lsmr.vending.hardware.AbstractHardwareListener;
import org.lsmr.vending.hardware.CoinReceptacle;




/** this class has been made so Vending Machine can receive messages from with Swipe module 
 * @author lambda
 *
 */

public class SwipeListening implements SwipeListener {

	private boolean declined = false;

	private boolean accepted = false;
	

	private String prevMessage = "";
	private String currMessage = "";
	private boolean partial = false;
	private boolean full = false;
	private double amountCovered=0;

	
	/**
	 * this method is only for testing purposes and would not be needed when hooked up to a Swipe module
	 */
	public void resetAmount() {
		amountCovered = 0.0;
	}
	
	/**
	 * Gets the amount of the payment, or the card's limit.
	 */
	public double getAmountCovered() {
		return amountCovered;
	}
	
	/**
	 * Gets the partial payment amount.
	 */
	public boolean getPartial() {
		return partial;
	
	}
	/**
	 * Gets the full payment amount.
	 */
	public boolean getFull() {
		return full;
	
	}
	
	/**
	* Returns whether the card was accepted.
	*/
	public boolean getAccepted() {
		return accepted;
	}
	
	/**
	* Returns whether the card was declined.
	*/
	public boolean getDeclined() {
		return declined;
	}

	/** this class writes to the log file for later use
	 * @param oldMessage
	 * 			message from before event
	 * @param newMessage
	 * 			message after new event
	 */
	 private void messageChange(String oldMessage, String newMessage) {
		// call event log here 
		String currentTime = LogFile.df.format(LogFile.dateobj) ;
		String classType  = this.getClass().getName();
		newMessage = classType + "\t" + newMessage;
		try {
			LogFile.writeLog( currentTime +"\t" + newMessage);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	@Override
	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		
	
		
	}
	
	
	@Override
	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		// TODO Auto-generated method stub
		
		
	}
	
	/**
	* Method to take partial payment
	* @param amount - the partial payment amount
	*/
	@Override
	public void partialPayment(double amount) {
		// TODO Auto-generated method stub
		amountCovered = amount;
		prevMessage  = "Partial Payment has been selected an will cover " + amountCovered;
		partial = true;
		full = false;
		currMessage = "Partial Payment has been selected an will cover " + amountCovered;
		messageChange(prevMessage,currMessage);
		
	}

	/**
	* Method to take full payment
	*/
	@Override
	public void exactPayment() {
		prevMessage  = "Full Payment has been selected full variable was "+ full;
		amountCovered = -1;
		full = true;
		partial = false;
		currMessage = "Full Payment has been selected partial variable is "+ full;
		messageChange(prevMessage,currMessage);
				
	}


	/**
	* Method to decline any payment
	*/
	@Override
	public void paymentDeclined() {
			prevMessage  = "Payment was Declined = " + declined;
			declined = true;
			accepted = false;
			amountCovered = 0;
			currMessage = "Payment is now Declined = " + declined; 
			messageChange(prevMessage,currMessage);
	}

	/**
	* Method to accept any payment
	*/
	@Override
	public void paymentAccepted() {
		prevMessage  = "Payment was accepted = " + accepted;
		accepted = true;
		declined = false;
		currMessage = "Payment is now accepted = " + accepted; 
		messageChange(prevMessage,currMessage);
		
	}



}
