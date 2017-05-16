package se.kth.ict.nextgenpos.view;

import se.kth.ict.nextgenpos.model.ProductSpecification;
import se.kth.ict.nextgenpos.model.RegisteredItemsObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Displays list printout that updates when new items are added to the register/catalog.
 */
public class ItemsDisplay implements RegisteredItemsObserver {
    private Map<ProductSpecification, Integer> products =
            new HashMap<>();


    /**
     * Constructor
     */
    public ItemsDisplay() {
    }

    /**
     * Adds newly registered item to the HashMap <code>products</code> and prints updated HashMap.
     *
     * @param product object that has been changed.
     */
    @Override
    public void newItem(ProductSpecification product) {
        addNewItem(product);
        printItemsList();
    }

    /**
     * Adds item to HashMap.
     * @param product added to HashMap
     */
    private void addNewItem(ProductSpecification product) {
        products.put(product, product.getProductId());
    }


    /**
     * Prints HashMap <code>products</code> with all registered items.
     */
    private void printItemsList() {
        System.out.println("**************Registered items**************\n");
        products.forEach((k,v) -> System.out.println(k + "\n"));
        System.out.println("********************************************\n");
    }


}
