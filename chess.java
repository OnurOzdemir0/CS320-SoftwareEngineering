import javax.swing.*;
import java.awt.*;

import View.*;
import Model.*;
import Controller.*;
public class chess {

    /**
     * denemek için yazdım. Ekrana bir frame ve panel göstermekten başka bir şey yapmıyor
     */
    static void showAFrame(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setLayout(new GridBagLayout());
        frame.setMinimumSize(new Dimension(800,800));

        Board board = new Board();
        frame.add(board);

        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        King king = new King(1,5); //mesela yani
        System.out.println(king.getType());


    }
}