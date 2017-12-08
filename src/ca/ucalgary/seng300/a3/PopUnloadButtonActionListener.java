/**
 * SENG 300 Group Assignment 3
 * Group 
 * 
 * Class to update GUI pop return value with the pops in the 
 * vending machine pop return
 */

package ca.ucalgary.seng300.a3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.lsmr.vending.hardware.VendingMachine;

public class PopUnloadButtonActionListener implements ActionListener {

	private VendingMachine vend;
	private GUI gui;
	private GUIPopReturnListener l;
	
	public PopUnloadButtonActionListener(VendingMachine vending, GUI mygui, GUIPopReturnListener listener) {
		vend = vending;
		gui = mygui;
		l = listener;
	}
	
	/**
	* Method to remove items from the pop's delivery chute.
	* @param arg0 - argument if the Unload Pop button is pressed.
	*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		vend.getDeliveryChute().removeItems();
		gui.setPopReturnVal("(None)");
		l.clearItemsInChute();
		
	}

}
