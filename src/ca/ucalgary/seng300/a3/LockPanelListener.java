/**
* SENG 300 Group 3
*/
package ca.ucalgary.seng300.a3;

import java.io.IOException;

import org.lsmr.vending.hardware.AbstractHardware;
import org.lsmr.vending.hardware.AbstractHardwareListener;
import org.lsmr.vending.hardware.Lock;

/**
* Listener class for the lock panel, which controls if the machine is locked/unlocked for
* configuration and loading.
*/
public class LockPanelListener implements org.lsmr.vending.hardware.LockListener{

	private VendCommunicator communicator;
	
	public LockPanelListener() {
		this.communicator = VendCommunicator.getInstance();
	}
	
	@Override
	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		// TODO Auto-generated method stub
		
	}
	/**
	* Function that disables safety on the vending machine and logs it
	*/
	private void panelLocked() {
	// call event log here 
		
		String currentTime = LogFile.df.format(LogFile.dateobj);
		String classType  = this.getClass().getName();
		String newMessage = classType + "\t" + "control panel locked";
		try {
			LogFile.writeLog( currentTime +"\t" + newMessage);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	/**
	* Function that enables safety on the vending machine and logs it
	*/	
	private void panelUnlocked() {
		String currentTime = LogFile.df.format(LogFile.dateobj);
		String classType  = this.getClass().getName();
		String newMessage = classType + "\t" + "control panel unlocked";
		try {
			LogFile.writeLog( currentTime +"\t" + newMessage);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	/**
	* Method to unlock the machine.
	@param lock - the lock object
	*/
	@Override
	public void locked(Lock lock) {
		// TODO Auto-generated method stub
		communicator.enableSafety();
		panelLocked();
		
	}

	/**
	* Method to lock the machine.
	* @param lcok - the lock object
	*/
	@Override
	public void unlocked(Lock lock) {
		// TODO Auto-generated method stub
		communicator.disableSafety();
		panelUnlocked();
		
	}

}
