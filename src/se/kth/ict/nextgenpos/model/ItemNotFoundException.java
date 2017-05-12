package se.kth.ict.nextgenpos.model;

/**
 * Created by ocean on 2017-05-12.
 */
public class ItemNotFoundException extends Exception {
    int notFoundItemId;

    /**
     * Creates new instance with message specifying which item could not be found.
     *
     * @param ItemId ID of the item that could not be found.
     */
    public ItemNotFoundException(int ItemId) {
        super("The item with ID "+ ItemId +" could not be found.");
        this.notFoundItemId = ItemId;
    }

    public int getNotFoundItemId() {
        return notFoundItemId;
    }
}
