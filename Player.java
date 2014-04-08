/**
 * Player in the text game
 * 
 * @author  Ron Gerschel
 * @version 2014-04-13
 */
public class Player extends Parent{

    //************************************************************
    // instance fields

    public static final int ITEM_COUNT_MAX = 15;
    public Item [] itemList = new Item [ ITEM_COUNT_MAX ];
    int numItems = 0;

    //************************************************************
    // constructors
    
    /**
     * Creates new Place with given label & description
     * @param label
     * @param description
     */
    public Player(String label, String description) {
        super(label,description);
    }
    
    public void addItem(Item item) {
        itemList[numItems] = item;
        System.out.println("You now have: " + item.getDescription());
        numItems = numItems + 1;
    }
    
    public void removeItem(Item item) {
        int i;
        String itemLabel;
        for (i = 0; i < numItems ; i++) {
            itemLabel = itemList[i].getLabel();
            if (item.getLabel().equals(itemLabel)) {
                itemList[i] = null;
                int p;
                for (p = i; p < numItems - 1; p++) {
                    itemList[p] = itemList [p+1];
                }
                itemList[numItems - 1] = null;
                System.out.println("You drop " + item.getDescription());
                numItems = numItems - 1;
            }
        }
    }
}