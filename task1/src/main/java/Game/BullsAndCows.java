package Game;

public class BullsAndCows {
    int number;
    int bulls;
    int cows;
    int[] array = new int[4];

    private boolean contains(int n) {
        for (int i = 0; i < 4; i++) {
            if (this.array[i] == n) {
                return true;
            }
        }
        return false;
    }

    public BullsAndCows(int randNumber) {
        number = randNumber;
        for (int i = 0; i < 4; i++) {
//            assert false;
            array[i] = randNumber % 10;
            randNumber /= 10;
        }
    }

    public boolean successful(int userNumber) throws Exception {
        if (String.valueOf(userNumber).length() != 4) {
            throw new Exception("Bad length, try again!");
        }

        bulls = 0;
        cows = 0;
        int numberCopy = number;

        for (int i = 0; i < 4; i++) {
            int digit = numberCopy % 10;
            int userDigit = userNumber % 10;
            if (userDigit == digit) {
                bulls++;
            } else if (this.contains(userDigit)) {
                cows++;
            }

            userNumber /= 10;
            numberCopy /= 10;
        }

        return bulls == 4;
    }

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }
}
