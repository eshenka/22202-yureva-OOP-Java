package Game;

import junit.framework.TestCase;

public class BullsAndCowsTest extends TestCase {
    BullsAndCows game = new BullsAndCows(1234);


    public void testSuccessful() {
        assertTrue(game.successful(1234));
        assertFalse(game.successful(1235));
    }

    public void testGetBulls() {
        game.successful(1256);
        assertEquals(2, game.getBulls());

        game.successful(4321);
        assertEquals(0, game.getBulls());

        game.successful(1234);
        assertEquals(4, game.getBulls());
    }

    public void testGetCows() {
        game.successful(1256);
        assertEquals(0, game.getCows());

        game.successful(4321);
        assertEquals(4, game.getCows());

        game.successful(1234);
        assertEquals(0, game.getCows());
    }
}