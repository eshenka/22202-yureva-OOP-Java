import java.util.Random;

public class RandNumber {
    int number;

    public RandNumber(int min, int max) {
        Random rand = new Random();
        number = rand.nextInt(max - min) + min;
    }

    public int getNumber() {
        return number;
    }
}
