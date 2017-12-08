/**
*SENG 300 Group 3
*/
package ca.ucalgary.seng300.a3;

import org.lsmr.vending.hardware.AbstractHardwareListener;


/**
* Class which would listen to the swipe of a credit/debit card
* if given the appropriate hardware.
*/
public interface SwipeListener extends AbstractHardwareListener {
	/**
     * An event that announces that partial payment has been selected
     * indicated receptacle.
     * 
     * @param amount
     * 			amount of covered payment 
     * 
     */
    void partialPayment(double amount);

    /**
     * An event that announces if exact payment has been selected
     * indicated receptacle.
     *  
     */
    void exactPayment();

    /**
     * An event that announces that the indicated payment card has been declined
     */
    void paymentDeclined();

    /**
     *  An event that announces that the indicated payment card has been accepted
     */
    void paymentAccepted();
	
	



}
