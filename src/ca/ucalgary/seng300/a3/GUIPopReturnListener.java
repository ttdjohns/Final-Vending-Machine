/**
 * SENG 300 Group Assignment 3
 * Group 
 * 
 * Class to update GUI Pop delivery chute with which pops are in the chute
 */

package ca.ucalgary.seng300.a3;

import org.lsmr.vending.hardware.*;

public class GUIPopReturnListener implements DeliveryChuteListener {

	private int itemsInChute;
	private VendingMachine vend;
	private GUI gui;
	
	/**
	* Single constructor for the class.
	*/
	public GUIPopReturnListener(VendingMachine vending, GUI mygui) {
		vend = vending;
		gui = mygui;
		itemsInChute = 0;
		
		vend.getDeliveryChute().register(this);
	}
	
	@Override
	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		// Do nothing		
	}

	@Override
	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		// Do nothing		
	}

	
	/**
	* Method to implement an item being delivered through the chute.
	* @param chute - the delivery chute that is being used
	*/
	@Override
	public void itemDelivered(DeliveryChute chute) {
		//itemsInChute++;
		//gui.setPopReturnVal(itemsInChute);
		/*
		 * Change display for pops in delivery chute with proper formatting
		 */
		String newPop = vend.getPopKindName(gui.getLastButtonPressed());
		String popsInChute = gui.getPopsReturned();
		String updatedPops;
		if (popsInChute.equals("(None)")) {
			updatedPops = newPop;
		}
		else {
			updatedPops = popsInChute + "\n" + newPop;
		}
		gui.setPopReturnVal(updatedPops);
		
		
	}

	@Override
	public void doorOpened(DeliveryChute chute) {
		// Do nothing		
	}

	@Override
	public void doorClosed(DeliveryChute chute) {
		// Do nothing		
	}

	@Override
	public void chuteFull(DeliveryChute chute) {
		// Do nothing		
	}
	
	/**
	* Method to clear out all items from the chute (such as taking pops or coins)
	*/
	public void clearItemsInChute() {
		itemsInChute = 0;
	}

}
