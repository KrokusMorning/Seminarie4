package se.kth.ict.nextgenpos.model;

import se.kth.ict.nextgenpos.view.ItemDTO;

import java.util.Map;
import java.util.HashMap;
/**
 * This class is responsible for all access to the product database.
 * Reports changes to observer.
 */ 
public class ProductCatalog {
    private Map<Integer, ProductSpecification> products = 
	new HashMap<Integer, ProductSpecification>();
    private RegisteredItemsObserver observer;

    /**
     * Constructor
     */
    public ProductCatalog() {
    }

    /**
     * Adds item to the register. Confirms that an item has been added with printout and notifies observers.
     *
     * @param item DTO with values for item to be registered.
     */
    public void addItem(ItemDTO item){
        ProductSpecification product = new ProductSpecification(item.getProductId(),
                item.getName(), item.getDescription(), item.getPrice());

        products.put(item.getProductId(), product);
        System.out.println("\n *Item no" + item.getProductId() +" registered*\n");
        notifyObeservers(product);
    }

    /**
     * Notifies observers about changes of object.
     *
     * @param product Item that was registered.
     */
    private void notifyObeservers(ProductSpecification product){
        observer.newItem(product);
    }

    /**
     * Adds observer.
     *
     * @param obs Reference to the observing class.
     */
    public void addItemRegistryObserver(RegisteredItemsObserver obs ){
        observer = obs;
    }

    /**
     * Search for an item in the product catalog.
     *
     * @param    itemId The item to look for
     * @return          The specification for the found item
     * @throws   ItemNotFoundException if item not found in register.
     */
    public ProductSpecification findSpecification(int itemId) throws ItemNotFoundException {
        boolean exists = false;
        for(ProductSpecification product : products.values()){
            if (product.getProductId() == itemId)
                    exists = true;}
        if (exists == false)
            throw new ItemNotFoundException(itemId);
        return products.get(itemId);
    }

}
