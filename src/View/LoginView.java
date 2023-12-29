package src.View;
import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField t_username1;
    private JTextField t_username2 ;
    String username1 = "user1";
    String username2 = "user2";
    private JPanel panel;
    private JPanel cardPanel;
    
    public LoginView(){
        JFrame CheT= new JFrame("CheT");
        CheT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CheT.setSize(800,800);
        panel = new JPanel();
        panel.setBackground(new Color(40,45,60));
        panel.setLayout(null);

        JLabel loginLabel =new JLabel ("Welcome the CheT application");
        t_username1= new JTextField(username1,20);
        t_username1.setBounds(100,150,200,30);
        t_username2 = new JTextField(username2,20);
        t_username2.setBounds(500,150,200,30);

        CardLayout cardLayout = new CardLayout();
        cardPanel= new JPanel (cardLayout);

        JButton ok1= new JButton("Start Game");
        ok1.setBounds(250,500,300,100);
        ok1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                username1 = t_username1.getText();
                username2 = t_username2.getText();
                src.View.chess.showAFrame(username1, username2);
                CheT.dispose();
            }
        });

        JButton rules = new JButton("RULES");
        rules.setBounds(350,625,100,50);
        rules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Rules();
            }
        });



        panel.add(loginLabel);
        panel.add(t_username1);
        panel.add(ok1);
        panel.add(t_username2);
        panel.add(rules);
        CheT.add(panel);
        CheT.setVisible(true);
}
}

