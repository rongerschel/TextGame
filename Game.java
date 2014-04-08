import java.util.Scanner;
import java.util.ArrayList;
/**
 * Game in the text game
 *
 * @author  Clif Kussmaul & Ron Gerschel (DemoB)
 * @version 2014-2-26
 */
public class Game extends Parent {

    //************************************************************
    //*** instance fields

    private String      label, description;
    private ItemAction      []   itemActionList      = new ItemAction[ACTION_COUNT_MAX];
    private MoveAction      []   moveActionList      = new MoveAction[ACTION_COUNT_MAX];
    private Place           []   placeList       = new Place [PLACE_COUNT_MAX];
    public static Item      []   itemList        = new Item  [ITEM_COUNT_MAX];
    private Item            []   gameItem;
    private 
    int         itemActionCount     = 0;
    int         moveActionCount     = 0;
    int         placeCount          = 0;
    int         itemCount           = 1;
    int         playeritemcount     = 0;
    int         numItems            = 0;

    //************************************************************
    //*** constructors

    /**
     * Create new Game with given label and description.
     * @param label         must not be null or blank
     * @param description   must not be null, may be blank
     */
    public Game(String label, String description) {
        super (label,description);
    }

    //************************************************************
    //*** accessor methods

    public void addItem(Item newItem) {
        try {
            if (null == newItem)  
                throw new IllegalArgumentException();
            // FUTURE: auto-expand itemList when full; prevent duplicate
            if (this.itemList.length == numItems)  
                throw new IllegalArgumentException(); 
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.itemList[numItems++] = newItem; 
    }  

    /**
     * Adds given Action to current Game.
     * @param newAction     must not be null
     * @return              true if successful, false otherwise
     */
    public void addMoveAction(MoveAction newAction) throws IllegalArgumentException{
        try{ 
            if (null == newAction) {
                throw new IllegalArgumentException("Can't add null action");
            }
            // FUTURE: auto-expand actionList when full, prevent duplicates
            if (this.moveActionList.length == moveActionCount){
                throw new IllegalArgumentException();
            }
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.moveActionList[moveActionCount++] = newAction;
    }

    // FUTURE: public Action makeAction(label, desc, prevPlace, nextPlace) { }
    // FUTURE: public Action makeAction(label, desc, prevLabel, nextLabel) { }

    /**
     * Gets Action with given label & previous Place.
     * @param label         must not be null or blank
     * @return              requested Action, null on error
     */
    public MoveAction getMoveAction(String label, Place place) {
        MoveAction action = null;
        if (null != label || null != place) { 
            label = label.trim();
            String actionLabel;
            for (int i=0; i<moveActionCount; i++) {
                action = this.moveActionList[i];
                actionLabel = action.getLabel();
                if ( label.equals(actionLabel)) {
                    if( place.equals(action.getLast ()) ) {
                        return action;
                    }
                }
            }
        }
        return null;
    }

    public Place actionSelection(String label, Place place, Player player){
        MoveAction action = getMoveAction(label, place);
        if (action != null){
            System.out.println(action.getDescription());
            place = action.getNext();
        }
        return place;
    }

    /**
     * Gets count of Actions in Game.
     * @return      count of actions
     */
    public int getMoveActionCount() { 
        return this.moveActionCount; 
    }

    /**
     * Adds given Place to current Game.
     * @param newPlace     must not be null
     * @return              true if successful, false otherwise
     */
    public void addPlace(Place newPlace) {
        try { 
            if (null == newPlace) 
                throw new IllegalArgumentException();
            // FUTURE: auto-expand placeList when full; prevent duplicate
            if (this.placeList.length == placeCount) 
                throw new IllegalArgumentException(); }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }  
        this.placeList[placeCount++] = newPlace;
    }

    // FUTURE: public Action makePlace(label, desc) { }
    /**
     * Gets Place at given index.
     * @param index         0 <= index < placeCount
     * @return              requested Place, null on error
     */
    public Place getPlace(int i) {
        try{
            if (i < 0 || i >= this.placeCount) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return this.placeList[i];
    }

    /**
     * Gets Place with given label.
     * @param label         must not be null or blank
     * @return              requested Place, null on error
     */
    public Place getPlace(String label) {
        if (null == label) { 
            return null; 
        }
        label = label.trim();
        for (int i=0; i<placeCount; i++) {
            if (label.equals(this.placeList[i].getLabel())) {
                return this.placeList[i];
            }
        }
        return null;
    }

    /**
     * Gets count of Places in Game.
     * @return      count of places
     */
    public int getItemActionCount() { 
        return this.itemActionCount; 
    }

    public Item getItem(String label) {
        if (null == label) { return null; }
        label = label.trim();
        for (int i=0; i<itemCount; i++) {
            if (label.equals(this.gameItem[i].getLabel())) {
                return this.gameItem[i];
            }
        }
        return null;
    }
    
    public void addItemAction(ItemAction newAction){
        try{
            if (null == newAction) 
                throw new IllegalArgumentException ();
            if (this.itemActionList.length == itemActionCount)
                throw new IllegalArgumentException();
        }

        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        this.itemActionList[itemActionCount++] = newAction;
    }

    public Place actionPicker(String label, Place place, Player player){
        MoveAction action = getMoveAction(label, place);
        if(action != null){
            System.out.println(action.getDescription());
            place = action.getNext();}
        if (action.equals(null)){
            place = ItemAction.getItemAction(label, place, player, numItems);}
        return place;
    }

    public int getPlaceCount(){
        return this.placeCount;
    }
    //************************************************************
    //*** other methods

    public void play() {
        Place   place   = getPlace(0);
        Player player0  = new Player ("Player ", "One");
        Scanner scanner = new Scanner(System.in);
        String  text;

        System.out.println(getDescription());
        while (null != place) {
            System.out.println(place.getDescription());

            int i;
            for (i = 0; i < place.numItems; i++) {
                System.out.println("You see " + place.itemList[i].getDescription());
            }

            // Pick up item
            text    = scanner.nextLine();
            
            if  (text.startsWith("Pick Up ")){
                String itemLabel = text.substring(8);

                int j;
                for (j = 0; j < numItems; j ++) {
                    if (itemLabel.equals(itemList[j].getLabel())) {
                        Item item = place.itemList[j];
                        player0.addItem(item);
                        place.removeItem(item);
                    }
                }
            }

            // Put down item
            if (text.startsWith("Put Down ")) {
                String itemLabel = text.substring(9);

                int k;
                for (k = 0; k < numItems; k ++) {
                    if (itemLabel.equals(itemList[k].getLabel())) {
                        Item item = itemList[k];
                        place.addItem(item);
                        player0.removeItem(item);
                    }
                }
            }

            // Quit and help
            if (text.equals("quit")) {
                System.out.println("Thanks for playing!!");
                return;
            }
            else if (text.equals("help")) {
                System.out.println("Type ALL lower case");
            }
            else if (text.equals("Player List")){
                int r;
                for (r = 0; r < player0.numItems; r ++) {
                    System.out.println("You have: "+ player0.itemList[r].getLabel());
                }
            }

            MoveAction action  = getMoveAction(text, place);
            if (null != action) {
                System.out.println(action.getDescription());
                place   = action.getNext();
            }

        }      
    }

    public static void demoA() {
        Game    game    = new Game("Trumbower", "This is the Trumbower Demo Game.");
        // create & add Places
        Place   outside = new Place("outside",
                "You are outside. There is a door to the north.");
        Place   foyer   = new Place("foyer",
                "You are in the foyer. There are stairs up and down, and a door south.");
        Place   hall0   = new Place("hall0",
                "You are in a hallway leading east and west, and there are stairs up.");
        /**
         * Place   rm48    = new Place("rm48",
                "You are in a room full of computers and tables. There is a door to the south.");
         */

        game.addPlace(outside);
        game.addPlace(foyer);
        game.addPlace(hall0);
        //game.addPlace(rm48);

        // create and add Actions

        game.addMoveAction(new MoveAction("north",  "You enter the building.",  outside,    foyer   ));
        game.addMoveAction(new MoveAction("south",  "You leave the building.",  foyer,      outside ));
        game.addMoveAction(new MoveAction("down",   "You descend the stairs.",  foyer,      hall0   ));
        game.addMoveAction(new MoveAction("up",     "You ascend the stairs.",   hall0,      foyer   ));
        //game.addMoveAction(new MoveAction("east",   "You walk down the hall.",  hall0,      rm48    ));
        //game.addMoveAction(new MoveAction("south",  "You leave the room.",      rm48,       hall0   ));


        //Add Items and Descriptions
        Item   pencil = new Item("pencil", "a pencil");
        Item   key    = new Item("key", " a key");        
        Item   paper  = new Item("paper", " a piece of printer paper");
        Item   computers = new Item("computers", " twelve computers connected to the internet");
        Item   flashlight = new Item("flashlight", " on the door knob a flashlight");

        //Add Items to game and places
        game.addItem(key);
        outside.addItem(key);

        game.addItem(pencil);
        //rm48.addItem(pencil);

        game.addItem(paper);
        //rm48.addItem(paper);

        game.addItem(flashlight);
        hall0.addItem(flashlight);

        game.addItem(computers);
        //rm48.addItem(computers);

        game.play();
    }
}

/**public static void demoB() {
Game    game    = new Game("Airport", "This is the Airport Demo Game.");
// create & add Places
Place   curb = new Place("Curb Side",
"You were just dropped off. You are outside. There is a door to the north.");
Place   mainterminal   = new Place("Main Terminal",
"You are in the main terminal. There are check-in stations straight ahead, security is up");
Place   security   = new Place("Security",
"You are in security. The terminal/gates are straight ahead.");
Place   checkin    = new Place("Checkin",
"You are at checkin. Security is up the stairs.");    
Place   gates    = new Place("Gates",
"You are at the gates");
game.addPlace(curb);
game.addPlace(checkin);
game.addPlace(security);
game.addPlace(gates);
game.addPlace(mainterminal);
// create and add Actions
game.addAction(new Action("north",  "You enter the main terminal.",  curb,    mainterminal ));
game.addAction(new Action("straight",  "You move to check-in",  mainterminal,      checkin ));
game.addAction(new Action("up",   "You ascend to security.",  mainterminal,      security  ));
game.addAction(new Action("up",     "You ascend the stairs.",   checkin,      security   ));
game.addAction(new Action("straight",   "You walk to the gates",  security,      gates    ));
game.play();

game.addItem(sword);
outside.addItem(sword);
}*/
// end class
