package homework.实验6;

public class Card {
    public static void main(String[] args) {
        Card card = new Card("梅花", 5);
        card.displayInfo();
    }

    private String suit;
    private int value;

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public void displayInfo() {
        System.out.println(suit + value);
    }
}
