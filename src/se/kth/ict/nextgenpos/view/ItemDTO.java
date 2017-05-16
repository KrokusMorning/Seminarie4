package se.kth.ict.nextgenpos.view;

/**
 * Created by ocean on 2017-05-15.
 */
public class ItemDTO {
    private int productId;
    private String description;
    private String name;
    private int price;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getProductId() {
        return productId;
    }
    //More properties.

    /**
     * Creates a new instance.
     */
    public ItemDTO(int productId, String name, String descr,
                                int price) {
        this.productId = productId;
        this.description = descr;
        this.name = name;
        this.price = price;

    }
}
