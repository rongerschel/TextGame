
/**
 * Write a description of class MoveAction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoveAction extends Action 
{
       //************************************
    // instance fields
    private Place prevPlace, nextPlace;
    private Item [] required, forbidden;
    private int rcount  = 0;
    private int fcount  = 0;

    //contructors******
    public MoveAction(String label, String description, Place lastPlace, Place nextPlace) {
        super(label, description);
        try                {setLast(lastPlace);}
        catch (Exception e){System.out.println(e.getMessage());}
        try                {setNext(nextPlace);}
        catch (Exception e){System.out.println(e.getMessage());}
    }

    /**
     * Gets next place and returns nextPlace
     */
    public Place getNext() { return this.nextPlace; }

    /**
     * Sets next possible place
     */
    public void setNext(Place newNext) throws Exception{
        //return false if newnext place is null
        if (null == newNext){
            throw new Exception("No next place given");}
        else{nextPlace = newNext;}
    }

    /**
     * Gets prevPlace string and 
     * returns prevPlace.
     */
    public Place getLast()  { return this.prevPlace; }

    /**
     * Takes newPrev and prevPlace becomes newPrev
     */
    public void setLast(Place newPrev) throws Exception{  
        //return false is null is newprev place
        if (null == newPrev){
            throw new Exception ("No previous place given");}
        else{prevPlace = newPrev;}
    }
    
    public void addReqItem(Item item) {
        addItem(required, rcount, item);
    }
    
    public void addForItem(Item item) {
        addItem(forbidden, fcount, item);
    }
} // end class

/**
 * moveAction(Sring label,String description, Place lastPlace, Place nextPlace)
 * moveAction(String label, String description, Place lastPlace, Place nextPlace, Item [] req, Item [] forb)
 * add ReqItem(Item i, [] req, count)
 * add ForbItem(Item i)
 * 
 * ItemAction (String label, String description)
 * ItemAction(String label, String description, Place placebef, Place placeAft, playerBef, playerAft)
 * add(Place/Player)(Before/After)(Item i)
 * 
 * 
 */
