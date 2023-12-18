package View;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel{ //this is View.Board, so it should be preoccupied with just showing the board.

    final static int tileSizeByPixel = 85;
    final static int columnNumber = 8;
    final static int rowNumber = 8;


    /**
     * This is a JPanel.
     */
    public Board(){
        this.setPreferredSize(new Dimension(columnNumber*tileSizeByPixel, rowNumber*tileSizeByPixel));
        this.setBackground(Color.gray);
        this.setLayout(new GridBagLayout());


        //burada bir şeyler denedim ama muhtemelen silmek lazım. View kısmının nasıl olması gerektiğini şu an bilemiyorum.
        /*for(int i=0; i<1; i++){
            for(int j=0; i<1; j++) {
                JPanel panel = new JPanel();
                panel.setMinimumSize(new Dimension(3,3));
                if(i+j % 2 == 0)
                    panel.setBackground(Color.black);
                else
                    panel.setBackground(Color.white);
                panel.setVisible(true);
                this.add(panel);
            }
        }*/






    }

}
