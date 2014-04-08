
import static org.junit.Assert.*;
import org.junit.*;

/**
 * ActionTest (JUnit 4)
 * @author  Clif Kussmaul
 * @version 2012-10
 */
public class MoveActionTest {
    private static final String DEFAULT_LABEL       = "MoveAction label";
    private static final String DEFAULT_DESCRIPTION = "MoveAction description";
    private static final Place  prevPlace = new Place("Prev", "PPPP"),
    nextPlace = new Place("Next", "NNNN");

    private MoveAction  action;

    /**
     * Sets up the test fixture before each test method.
     */
    @Before public void setUp() {
        this.action = new MoveAction(DEFAULT_LABEL, DEFAULT_DESCRIPTION, prevPlace, nextPlace);
    }

    /**
     * Tears down the test fixture after each test method.
     */
    @After public void tearDown() {
        this.action = null;
    }

    //tests for next place

    @Test public void setNextNull() {
        try               {this.action.setNext(null);}
        catch(Exception e){assertTrue(e.getMessage().equals("No next place given"));}
        assertEquals(nextPlace, this.action.getNext());
    }

    @Test public void setNext() {
        Place place = new Place("Test", "tttt");
        try               {this.action.setNext(place);}
        catch(Exception e){assertFalse(e.getMessage().equals("No next place given"));}
        assertEquals(place, this.action.getNext());
    }
    // 
    // tests for prev place

    @Test public void setPrevNull() {
        try               {this.action.setLast(null);}
        catch(Exception e){assertTrue(e.getMessage().equals("No previous place given"));}
        assertEquals(prevPlace, this.action.getLast());
    }

    @Test public void setPrev() {
        Place place = new Place("Test", "tttt");
        try               {this.action.setLast(place);}
        catch(Exception e){assertFalse(e.getMessage().equals("No previous place given"));}
        assertEquals(place, this.action.getLast());
    }
} // end class
