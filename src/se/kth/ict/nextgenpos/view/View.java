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
	ItemsDisplay itemsDisplay = new ItemsDisplay();
	cont.addItemRegistryObserver(itemsDisplay);
    }


    /**
     * Simulates a view. Makes some calls to the controller.
	 * @throws IOException
     */
    public void test() throws IOException {
	cont.makeNewSale();
	ItemDTO item = new ItemDTO(15,"flower",
			    "looks good, smells good.", 37);
	cont.registerItem(item);
	ItemDTO milk = new ItemDTO(1, "almond milk",
				"guilt free milk", 10);
	cont.registerItem(milk);
	ItemDTO butter = new ItemDTO(2, "diary free butter",
				"healthy butter", 10);
	cont.registerItem(butter);
	ItemDTO bread = new ItemDTO(3, "whole grain bread",
				"healthy bread", 10);
	cont.registerItem(bread);

	try {
		enterItem(15);
		enterItem(5);
	}
	catch (Exception ItemNotFoundException) {
		logFileHandler logger = new logFileHandler();
		logger.logException(ItemNotFoundException);
	}
    }

	/*
	 * @param itemId
	 * @throws ItemNotFoundException
	 */
	private void enterItem(int itemId) throws ItemNotFoundException{
			int quantity = 1;
			System.out.println("");
			System.out.println("Result for item " + itemId + ": " + cont.enterItem(itemId, quantity));
			System.out.println("");
    }

}
