package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandNumberTest {
    public boolean noSame(int number) {
        int[] digits = new int[10];
        while (number != 0) {
            if (digits[number % 10] == 1) {
                return false;
            } else {
                digits[number % 10] = 1;
            }
            number /= 10;
        }
        return true;
    }

    @Test
    public void testNoSameGeneratedNumbers() {
        RandNumber rand1 = new RandNumber();
        RandNumber rand2 = new RandNumber();
        RandNumber rand3 = new RandNumber();

        assertNotSame(rand1, rand2);
        assertNotSame(rand1, rand3);
        assertNotSame(rand2, rand3);
    }

    @Test
    public void testNoRepeatingDigits() {
        RandNumber rand = new RandNumber();
        assertTrue(noSame(rand.getNumber()));

        rand = new RandNumber();
        assertTrue(noSame(rand.getNumber()));

    }
}
