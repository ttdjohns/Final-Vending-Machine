/**
 * SENG 300 Group Assignment 3
 * Group 3
 * 
 * Class to handle mouse clicks of the GUI button that allows the technician
 * to unload all pops
 */

package ca.ucalgary.seng300.a3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnloadPopButtonActionListener implements ActionListener {

	private LoadUnloadGUI gui;
	private int buttonIndex;
	
	public UnloadPopButtonActionListener(LoadUnloadGUI mygui, int i) {
		gui = mygui;
		buttonIndex = i;
	}
	
	/**
	 * Unloads pops from correct rack when button is pushed
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		gui.unloadPops(buttonIndex);
	}

}
