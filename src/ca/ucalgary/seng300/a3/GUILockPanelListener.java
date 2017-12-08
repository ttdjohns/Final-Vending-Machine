/**
*SENG 300 Group 3
*/

package ca.ucalgary.seng300.a3;

import org.lsmr.vending.hardware.AbstractHardware;
import org.lsmr.vending.hardware.AbstractHardwareListener;
import org.lsmr.vending.hardware.Lock;
import org.lsmr.vending.hardware.LockListener;
import org.lsmr.vending.hardware.VendingMachine;

/**
* Listener class to implement functionality for the Lock Panel through the GUI.
*/
public class GUILockPanelListener implements LockListener {
	
	private String text = "Lock";
	private GUI gui;
	private VendingMachine vend;
	private String prevState = "Lock";
	
	/**
	* Single constructor for the class.
	*/
	public GUILockPanelListener(GUI mygui, VendingMachine vending) {
		vend = vending;
		gui = mygui;
		vend.getLock().register(this);
		
	}

	//Does nothing.
	@Override
	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		// TODO Auto-generated method stub
		
	}

	//Does nothing.
	@Override
	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		// TODO Auto-generated method stub
		
	}

	/**
	* Method to change the GUI to be unlocked.
	*/
	@Override
	public void locked(Lock lock) {
		text = "Unlock"; 
		gui.changeTextLock(text);
		
	}

	/**
	* Method to change the GUI to be locked.
	*/
	@Override
	public void unlocked(Lock lock) {
//		if (prevState == "Unlock") {
//			prevState = text;
//			text = "Lock";
//			gui.changeTextLock(text);
//		}else {
//			prevState = text;
			text = "Lock";
			gui.changeTextLock(text);
	
			
//		}
		
		
	}

}
