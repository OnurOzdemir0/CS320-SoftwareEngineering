package src.View;
import javax.swing.*;
import java.awt.*;
public class Rules extends JFrame {
    private JFrame rules;
    private JTextArea rulesText;

    public Rules(){
        rules= new JFrame("Rules of Chess");
        rules.setSize(800,800);
        rules.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        rulesText= new JTextArea(80,80);
        rulesText.setEditable(false);
        rulesText.setFont(new Font("Ariel",Font.PLAIN,17));
        rulesText.setText("Chess is a game played on a board with 64 squares. There are two players, each with 16 pieces. \n" +
                "One player has white pieces and the other has black pieces.\n"+
                "Each player has eight pawns ♙, two knights ♘ , two bishops ♗ \n" +
                ",two rooks ♖ , a queen ♕, and a king. ♔\n"+
                "The goal of the game is to capture the other player's king. This is called checkmate.\n" +
                "Each piece moves in a different way. \n" +
                "The pawns ♙ can move one or two squares. \n" +
                "Forward on their first move and then one square forward after that.\n " +
                "They capture diagonally.\n" +
                "\n" +
                "The ♘ move in an L-shape,\n" +
                "\n" +
                "The ♗ move diagonally,\n" +
                "\n" +
                "The rooks ♖ move horizontally or vertically,\n" +
                "\n" +
                "The queen ♕ can move in any direction,.\n" +
                "\n" +
                "The king ♔ can move one square in any direction.\n" +
                "\n" +
                "Players take turns moving their pieces.\n " +
                "If a player's piece is in a position to capture the other player's king, \n" +
                "they must say \"check\" to let the other player know.\n"

        );
        rules.add(rulesText);
        rules.setVisible(true);


    }
}
