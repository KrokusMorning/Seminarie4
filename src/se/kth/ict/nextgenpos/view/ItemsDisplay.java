package se.kth.ict.nextgenpos.view;

import se.kth.ict.nextgenpos.model.ProductSpecification;
import se.kth.ict.nextgenpos.model.RegisteredItemsObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ocean on 2017-05-15.
 */
public class ItemsDisplay implements RegisteredItemsObserver {
    private Map<ProductSpecification, Integer> products =
            new HashMap<>();

    public ItemsDisplay() {
    }

    @Override
    public void newItem(ProductSpecification product) {
        addNewItem(product);
        printItemsList();
    }

    private void addNewItem(ProductSpecification product) {
        products.put(product, product.getProductId());
    }


    private void printItemsList() {
        System.out.println(products + "\n");
    }


}
