import java.util.ArrayList;

/**
 * Place in the text game
 * 
 * @author  Clif Kussmaul & Ron Gerschel
 * @version 2014-03-14
 */
public class Place extends Parent {

    //************************************************************
    // instance fields

    //Item Instance Fields//
    private String label, description;
    public ArrayList <Item>     itemList = new ArrayList<Item>();
    int numItems = 0;

    //Other Instance Fields//

    //************************************************************
    // constructors

    /**
     * Creates new Place with given label & description
     * @param label
     * @param description
     */
    public Place(String label, String description) {
        super(label, description);
    }

    
    // Item methods
    /**
     * 
     */
    public void addItem(Item item) {
        itemList.add(item);
        numItems = numItems + 1;
    } 

    public void removeItem(Item item) {
        int i;
        String itemLabel;
        for (i = 0; i < numItems; i++) {
            itemLabel = itemList.get(i).getLabel();
            if (item.getLabel().equals(itemLabel)) {
                itemList[i] = null;
                int p;
                for (p = i; p < numItems - 1; p++) {
                    itemList[p] = itemList[p+1];
                }
                itemList[numItems - 1] = null;
                numItems = numItems - 1;
            }
        }
    }
    //************************************************************
    // accessor methods

} // end class
