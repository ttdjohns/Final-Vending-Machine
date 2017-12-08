/**
*SENG 300 Group 3
*/

package ca.ucalgary.seng300.a3;

/**
* Listener class for the configuration panel.
*/
public class ConfigPanelLogicListener {
	
	private GUI mygui;
	
	public ConfigPanelLogicListener(GUI g) {
		mygui = g;
		ConfigPanelLogic.getInstance().register(this);
	}
	
	/**
	* Method to update the price of a pop (the only function of the config panel for now).
	* @param buttonIndex - the index of the pop button that was selected
	* @param newPrice - the price the pop will get changed to
	*/
	public void priceUpdate(int buttonIndex, int newPrice) {
		double newPopCost;
		
		newPopCost = (double)newPrice / 100;
		
		mygui.setPopButtonText(buttonIndex, newPopCost);
	}
} //end class
