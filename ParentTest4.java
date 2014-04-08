import static org.junit.Assert.*;
import org.junit.*;

/**
 * GameTest (JUnit 4)
 * @author  Ron Gerschel (with assistance)
 * @version 2014-4-13
 */
public class ParentTest4
{

    private static final String DEFAULT_LABEL = "game label";
    private static final String DEFAULT_DESCRIPTION = "description";

    private Game game;

    /**
     * Sets up the test fixture before each test method.
     */
    @Before public void setUp()
    {
        this.game = new Game(DEFAULT_LABEL, DEFAULT_DESCRIPTION);
    }

    /**
     * Tears down the test fixture after each test method.
     */
    @After public void tearDown()
    {
        this.game = null;
    }

    // test for description

    @Test public void setDescriptionNull() {
        try { 
            this.game.setDescription(null); 
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals(DEFAULT_DESCRIPTION, this.game.getDescription());
        }
    }

    @Test public void setDescriptionEmpty() {
        try {
            this.game.setDescription("");
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals(DEFAULT_DESCRIPTION, this.game.getDescription());
        }
    }

    @Test public void setDescriptionBlank() {
        try {
            this.game.setDescription("  ");
            fail();
        }
        catch (IllegalArgumentException e){    
            assertEquals(DEFAULT_DESCRIPTION, this.game.getDescription());
        }
    }
    
    @Test public void setDescriptionTrim() {
        try {
            this.game.setDescription(" " + DEFAULT_DESCRIPTION + " ");
            assertEquals(DEFAULT_DESCRIPTION, this.game.getDescription());
        }
        catch (IllegalArgumentException e){
            fail();
        }
    }
        // tests for label

    @Test public void setLabelNull() {
        try {
            this.game.setLabel(null);
            fail();
        }    
        catch (IllegalArgumentException e){
            assertEquals(DEFAULT_LABEL, this.game.getLabel());
        }
        
    }
        @Test public void setLabelEmpty() {
        try {
            this.game.setLabel("");
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals(DEFAULT_LABEL, this.game.getLabel());
        }
    }
        @Test public void setLabelBlank(){
        try {
            this.game.setLabel("  ");
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals(DEFAULT_LABEL, this.game.getLabel());
        }
    }
        @Test public void setLabelTrim() {
        try {
            this.game.setLabel(" " + DEFAULT_LABEL + " ");
        }
        catch (IllegalArgumentException e){
            assertEquals(DEFAULT_LABEL, this.game.getLabel());
        }

    }
}
        