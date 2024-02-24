package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BullsAndCowsTest {
    BullsAndCows game = new BullsAndCows(1234);

    @Test
    public void testSuccessful() throws Exception {
        assertTrue(game.successful(1234));
        assertFalse(game.successful(1235));
        assertThrows(Exception.class, () -> {game.successful(12345);});
    }

    @Test
    public void testGetBulls() throws Exception {
        game.successful(1256);
        assertEquals(2, game.getBulls());

        game.successful(4321);
        assertEquals(0, game.getBulls());

        game.successful(1234);
        assertEquals(4, game.getBulls());
    }

    @Test
    public void testGetCows() throws Exception {
        game.successful(1256);
        assertEquals(0, game.getCows());

        game.successful(4321);
        assertEquals(4, game.getCows());

        game.successful(1234);
        assertEquals(0, game.getCows());
    }
}
