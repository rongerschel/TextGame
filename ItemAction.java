import java.util.*;

/**
 * Write a description of class ItemAction here.
 * 
 * @author 
 * @version 
 */
public class ItemAction extends Action
{
    /**
     * Constructor for objects of class ItemAction
     */
    public ItemAction(String label, String description, Item[] playerBefore, Item[]playerAfter, Item[] placeBefore, Item[] placeAfter)
    {
        super(label, description);
        //         set playerBefore[];
        //         set playerAfter[]; 
        //         set placeBefore[];
        //         set placeAfter[];
    }
    
    /** 
     * checks that item is in place or before, removes it from before, adds it to after
     */
    
    public boolean Arrays(Item[] before, Item[] has){
        int items = 0;
        int i;
        int j;
        for(i=0; i< before.length; i++){
           for(j=0; j< has.length; j++){
               if (before[i].equals(has[j])){items = items +1;}}
        }
        if (items == before.length){return true;}
        else{return false;}
    }
    
    public static Place getItemAction(String label, Place place, Player player0, int numItems){
        if (label.startsWith("pick ")){
            pickupItem(label, player0, place, numItems);}
        if (label.startsWith("put ")){
            putdownItem(label, player0, place, numItems);}
        return place;
    }
    
    public static void pickupItem(String text, Player player0, Place place, int numItems){
        String itemLabel = text.substring(5);
        int j;
        for(j=0; j<numItems; j++){
            pickup(itemLabel, player0, place, j);
        }
    }

    public static void pickup(String itemLabel, Player player0, Place place, int j){
        if (itemLabel.equals(Game.itemList[j].getLabel())){
            Item item = Game.itemList[j];
            player0.addItem(item);
            place.removeItem(item);
        }
    }

    public static void putdownItem(String text, Player player0, Place place, int numItems){
        String itemLabel = text.substring(5);
        int k;
        for(k=0; k<numItems; k++){
            putdown(itemLabel, player0, place, k);
        }
    }

    public static void putdown(String itemLabel, Player player0, Place place, int k){
        if (itemLabel.equals(Game.itemList[k].getLabel())){
            Item item = Game.itemList[k];
            place.addItem(item);
            player0.removeItem(item);
        }
    }
    
    //ItemAction takeCoffee = new ItemAction ("take coffee", "takes coffee", ["coffee"], [], [], ["coffee"]);
}
