package se.kth.ict.nextgenpos.model;

/**
 * Thrown when item ID is not found.
 */
public class ItemNotFoundException extends Exception {
    int notFoundItemId;

    /**
     * Creates new instance with message specifying which item could not be found.
     *
     * @param ItemId ID of the item that could not be found.
     */
    public ItemNotFoundException(int ItemId) {
        super("Invalid search, "+ ItemId +" not in system.");
        System.out.println("The item with ID number "+ ItemId +" could not be found.");
        this.notFoundItemId = ItemId;
    }

    /**
     *
     * @return notFoundItemId The item ID that could not be found.
     */
    public int getNotFoundItemId() {
        return notFoundItemId;
    }
}
