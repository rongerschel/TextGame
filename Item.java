
/**
 * Item class
 * 
 * @Ron Gerschel
 * @2014-03-14
 */
public class Item extends Parent
{
    // Instance fields
    private String label, description;
    
    // Constructors refering to Parent class
    public Item(String label, String description){
        super(label, description);
    }
}
