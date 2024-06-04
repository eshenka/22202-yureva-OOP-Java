package Model;

import Observation.Observable;

import java.io.*;
import java.util.ArrayList;

public class Game extends Observable {
    public enum Difficulty {
        EASY(4),
        MEDIUM(6),
        HARD(8);
        private final int difficulty;
        Difficulty(int difficulty) {
            this.difficulty = difficulty;
        }
        public int getDifficulty() {
            return difficulty;
        }

    }

    ArrayList<Card> cards;

    public Game(Difficulty difficulty, String imagesPath) throws IOException {
        BufferedReader images = new BufferedReader(new FileReader(imagesPath));

        int capacity = difficulty.getDifficulty();

        cards = new ArrayList<>(capacity * capacity);

        for (int i = 0; i < capacity * capacity / 2; i++) {
            String imagePath = images.readLine();

            cards.add(new Card(imagePath));
            cards.add(new Card(imagePath));
        }

        shuffle(cards);
    }

    static void shuffle(ArrayList<Card> cards) {
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    boolean isWon() {
        for (Card card : cards) {
            if (card.isClosed()) {
                return false;
            }
        }
        return true;
    }
}
