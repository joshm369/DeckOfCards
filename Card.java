public class Card {

    private final Rank rank;
    private final Suit suit;

    public enum Rank {Ace("A"), Two("2"), Three("3"), Four("4"), Five("5"), Six("6"),
        Seven("7"), Eight("8"), Nine("9"), Ten("10"), Jack("J"), Queen("Q"), King("K");

        private String value;

        Rank(String value) {
            this.value = value;
        }
    }

    public enum Suit {Club("♣"), Diamond("♦"), Heart("♥"), Spade("♠");

        private String value;

        Suit(String value) {
            this.value = value;
        }
    }

    Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() { return rank.value + suit.value; }
}


 