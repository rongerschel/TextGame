
/**
 * Parent class
 * 
 * @Ron Gerschel
 * @2014-03-14
 */
public abstract class Parent
{

    private String      label, description;

    public Parent(String label, String description) {
        try {
            setLabel(label);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try {
            setDescription(description);  
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    //** Methods for other classes

    public  String   getDescription() { return this.description; }

    public  void  setDescription(String newDescription) throws IllegalArgumentException{
        if (null == newDescription) {
            throw new IllegalArgumentException();
        }

        if (newDescription.trim().equals("")) {
            throw new IllegalArgumentException();
        }

        newDescription = newDescription.trim();
        this.description = newDescription;
    }

    public  String   getLabel() { return this.label; }
    public  void  setLabel(String newLabel) throws IllegalArgumentException{
        if (null == newLabel)       {
            throw new IllegalArgumentException();
        }
        newLabel = newLabel.trim();
        if (0 == newLabel.length()) {
            throw new IllegalArgumentException();
        }
        this.label = newLabel;
    }

    protected int addItem(Item [] list, int count, Item item) {
        try {
            if (null == item)  
                throw new IllegalArgumentException();
            // FUTURE: auto-expand itemList when full; prevent duplicate
            if (list.length == count)  
                throw new IllegalArgumentException(); 
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        list[count++] = item;
        return count;
    }  
}
