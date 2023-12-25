package View;

import javax.swing.*;
import java.awt.*;

import View.*;
import Model.*;
import Controller.*;
public class chess {

    /**
     * denemek için yazdım. Ekrana bir frame ve panel göstermekten başka bir şey yapmıyor
     */
    public static void showAFrame(){
        JFrame frame = new JFrame();
        frame.setTitle("CheT");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setLayout(new GridBagLayout());
        frame.setMinimumSize(new Dimension(800,800));

        Board board = new Board();
        frame.add(board);

        frame.pack();
        frame.setVisible(true);
    }

}