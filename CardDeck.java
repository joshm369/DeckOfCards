import javax.swing.*;
import java.awt.*;
import java.util.*;

public class CardDeck
{
    private static final int NUMCARDS = 52;

    private ArrayList<Card> deck;
    private Iterator<Card> deal;

    public CardDeck()
    {
        deck = new ArrayList<Card>(NUMCARDS);
        for (Card.Suit suit : Card.Suit.values())
            for (Card.Rank rank: Card.Rank.values())
            {
                deck.add(new Card(rank, suit));
            }
        deal = deck.iterator();
    }

    public void shuffle()
    {
        Random random = new Random();
        int randomLocation;
        Card card;

        for (int i = (NUMCARDS - 1); i > 0; i--)
        {
            randomLocation = random.nextInt(i);
            card = deck.get(randomLocation);
            deck.set(randomLocation, deck.get(i));
            deck.set(i, card);
        }
        deal = deck.iterator();
    }

    public String dealOneCard()
    {
        String nextCard = "";
        if(deal.hasNext()) {
           Card card = deal.next();
           nextCard = card.toString();
        }
        return nextCard;
    }

    public static void main(String[] args){
        CardDeck cards = new CardDeck();
        cards.shuffle();                                  //Create a deck of cards and shuffle it
        for(int i = 0; i < 5; i++) {                      //Deal 5 cards in windows side by side
           String card = cards.dealOneCard();
           JFrame frame = new JFrame("Deck Of Cards");
           JPanel panel = new JPanel();
           JLabel label = new JLabel(card);
           JLabel label2 = new JLabel(card);
           Font font = new Font("Sarif", Font.PLAIN, 35);
           label.setFont(font);
           label2.setFont(font);
           Dimension size = label.getPreferredSize();
           label.setBounds(115, 50, size.width, size.height);
           label2.setBounds(115, 350, size.width, size.height);
           panel.setLayout(null);
           panel.add(label);
           panel.add(label2);
           panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
           frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
           frame.add(panel);
           frame.setSize(300, 500);
           frame.setLocation(new Point(i * 300, 100));
           frame.setVisible(true);
       }
    }

}
 