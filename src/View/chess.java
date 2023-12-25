package src.View;

import javax.swing.*;
import java.awt.*;

import src.View.*;
import src.Model.*;
import src.Controller.*;
public class chess {

    /**
     * denemek için yazdım. Ekrana bir frame ve panel göstermekten başka bir şey yapmıyor
     */
    public static void showAFrame(){
    	JFrame frame = new JFrame();
        frame.setTitle("CheT");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.black);
        frame.setBackground(Color.black);

        notationPanel notationPanel = new notationPanel();
        Board board = new Board(notationPanel);

        board.setPreferredSize(new Dimension(900, 700));

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        mainPanel.add(board, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.32; 
        mainPanel.add(notationPanel, gbc);

        frame.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setMinimumSize(new Dimension(900, 700));
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

}