
/**
 * Creates actions to navigate through the game
 * 
 * @Ron Gerschel
 * @2014-2-26
 */
public abstract class Action extends Parent
{
    private Place prevPlace, nextPlace;
    
    public Action (String label, String description){
        super(label,description);
    }
}
