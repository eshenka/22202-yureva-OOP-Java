package Model;

import Controller.GameWonEvent;
import Controller.WrongGuessEvent;
import Observation.Observable;


import java.io.*;
import java.util.ArrayList;

public class Game extends Observable {
    ArrayList<Card> cards;
    ArrayList<Pair> openedCards;
    BufferedReader images;
    String imagesPath;

    public Game(String imagesPath) throws IOException {
        this.imagesPath = imagesPath;

        images = new BufferedReader(new FileReader(imagesPath));
    }

    public void setDifficulty(int difficulty) throws IOException {
        int capacity = difficulty;

        cards = new ArrayList<>(capacity * capacity);
        openedCards = new ArrayList<>();

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

    public String getImage(int index) {
        String image = cards.get(index).getImage();

        openedCards.add(new Pair(image, index));

        return image;
    }

    public void compare() throws InterruptedException, IOException {
        if (openedCards.size() == 2) {
            String firstImage = openedCards.get(0).first();
            Integer firstIndex = openedCards.get(0).second();
            openedCards.remove(0);
            String secondImage = openedCards.get(0).first();
            Integer secondIndex = openedCards.get(0).second();
            openedCards.remove(0);

            if (firstImage.equals(secondImage)) {
                cards.get(firstIndex).setState(Card.State.OPENED);
                cards.get(secondIndex).setState(Card.State.OPENED);

                if (isWon()) {
                    notify(new GameWonEvent("You won!"));
                }
            } else {
                notify(new WrongGuessEvent("Wrong guess", firstIndex, secondIndex));
            }

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

    public void reset() throws FileNotFoundException {
        images = new BufferedReader(new FileReader(imagesPath));

        for (Card card : cards) {
            card.setState(Card.State.CLOSED);
        }
    }
}
