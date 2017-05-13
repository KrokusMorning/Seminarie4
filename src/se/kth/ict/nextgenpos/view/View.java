package se.kth.ict.nextgenpos.view;

import se.kth.ict.nextgenpos.controller.Controller;
import se.kth.ict.nextgenpos.model.ItemNotFoundException;
import se.kth.ict.nextgenpos.model.logFileHandler;

import java.io.IOException;

/**
 * A placeholder for the view.
 */
public class View {
    private Controller cont;

    /**
     * Creates a new <code>View</code>.
     * @param cont           The controller of the application.
     */
    public View(Controller cont) {
	this.cont = cont;
    }

    /**
     * Simulates a view. Makes some calls to the controller.
     */
    public void test() throws IOException {
	cont.makeNewSale();
	try {
		enterItem(1);
		System.out.println(">>>>> NOTE!!\n" +
				"A null pointer exception will follow since there is no handling" +
				" of non-existing item ids. When you have implemented exception" +
				" handling, there should be some informative printout instead of the" +
				" exception stack trace.");
		enterItem(10);
	}
	catch (Exception ItemNotFoundException) {
		logFileHandler logger = new logFileHandler();
		logger.logException(ItemNotFoundException);
	}
    }

    private void enterItem(int itemId) throws ItemNotFoundException{
			int quantity = 1;
			System.out.println("");
			System.out.println("Result for item " + itemId + ": " + cont.enterItem(itemId, quantity));
			System.out.println("");
    }

}
