package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandNumber {
    int number = 0;
    ArrayList<Integer> digits = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

    public RandNumber() {
        Random rand = new Random();
        int maxNumber = 9;
        for (int i = 0; i < 4; i++) {
            int minNumber = i == 0 ? 1 : 0;
            number *= 10;
            number += digits.remove(rand.nextInt(maxNumber - minNumber) + minNumber);
            maxNumber -= 1;
        }
    }

    public int getNumber() {
        return number;
    }
}
