/**
 * SENG 300 Group Assignment 3
 * Group 3
 * 
 * Class to handle mouse clicks of the GUI button that allows the technician
 * to load coins
 */

package ca.ucalgary.seng300.a3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadCoinButtonActionListener implements ActionListener {

	private LoadUnloadGUI gui;
	private int buttonIndex;
	
	public LoadCoinButtonActionListener(LoadUnloadGUI mygui, int i) {
		gui = mygui;
		buttonIndex = i;
	}
	
	/**
	 * Loads coin in correct rack when button is pushed
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		gui.loadCoin(buttonIndex);
	}

}
