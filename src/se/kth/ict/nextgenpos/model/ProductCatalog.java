package se.kth.ict.nextgenpos.model;

import se.kth.ict.nextgenpos.view.ItemDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
/**
 * This class is responsible for all access to the product database.
 */ 
public class ProductCatalog {
    private Map<Integer, ProductSpecification> products = 
	new HashMap<Integer, ProductSpecification>();
    private RegisteredItemsObserver observer;
    int nrOfItemsRegistred = -1;

    /**
     * Fills the catalog with some dummy items.
     */
    public ProductCatalog() {
    }

    public void addItem(ItemDTO item){
        ProductSpecification product = new ProductSpecification(item.getProductId(),
                item.getName(), item.getDescription(), item.getPrice());
        nrOfItemsRegistred++;
        products.put(nrOfItemsRegistred, product);
        notifyObeservers(product);
    }
    private void notifyObeservers(ProductSpecification product){
        observer.newItem(product);

    }
    public void addItemRegistryObserver(RegisteredItemsObserver obs ){
        observer = obs;}

    /**
     * Search for an item in the product catalog.
     *
     * @param    itemId The item to look for
     * @return          The specification for the found item or null if no item was found.
     * @throws   ItemNotFoundException
     */
    public ProductSpecification findSpecification(int itemId) throws ItemNotFoundException {
        boolean exists = false;
        int i;
        for(i = 0; i < nrOfItemsRegistred; i++){
                if (products.get( i ).getProductId() == itemId)
                    exists = true;}
        if (exists == false)
            throw new ItemNotFoundException(itemId);
        return products.get(itemId);

    }

}
