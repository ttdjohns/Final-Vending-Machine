/**
*SENG 300 Group 3
*/
package ca.ucalgary.seng300.a3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JButton;

import org.lsmr.vending.hardware.VendingMachine;

/**
* Listen class for the button which controls locking/unlocking the vending machine.
*/
public class LockUnlockButtonListener implements ActionListener{

	
	private VendingMachine vend;
	private GUI gui;
	private GUILockPanelListener l;
	private LoadUnloadGUI loadunload;
	
	/**
	* Single constructor for the class.
	*/
	public LockUnlockButtonListener(VendingMachine vending, GUI mygui, GUILockPanelListener listener) {
		vend = vending;
		gui = mygui;
		l = listener;
	}
	
	/**
	* Method to control whether to lock or unlock the machine.
	* @param arg0 - whether the button has been pressed
	*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String text;
		 if (arg0.getSource() instanceof JButton) {
            text = ((JButton) arg0.getSource()).getText();
            if (text.equals("Lock")) {
            		vend.getLock().lock();
            		gui.getGUIConfig().init();
            		loadunload = new LoadUnloadGUI(vend);
            }
            else {
            	vend.getLock().unlock();
            	gui.getGUIConfig().dispose();
            	loadunload.dispose();
            }
         }
	
		
		
	}

}
	
	

