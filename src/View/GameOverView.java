package src.View;
import javax.swing.*;
import java.awt.*;
public class GameOverView  extends JFrame {

    private JFrame GameOver;
    private JTextArea gameovertext;
    public GameOverView(){
        GameOver =new JFrame ("The game is over ");
        GameOver.setSize(800,800);
        GameOver.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameovertext= new JTextArea(80,80);
        gameovertext.setEditable(false );
        gameovertext.setText("The game is over.If you click exit" +
                "the game will be close");

        GameOver.add(gameovertext);
        GameOver.setVisible(true);




    }

}
