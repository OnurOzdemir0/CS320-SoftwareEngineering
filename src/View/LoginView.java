package src.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField username1;
    private JTextField username2 ;
    private JPanel panel;
    private JPanel cardPanel ;
    public LoginView(){
        JFrame CheT= new JFrame("CheT");
        CheT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CheT.setSize(800,800);
        panel = new JPanel();
        panel.setLayout(null);

        JLabel loginLabel =new JLabel ("Welcome the CheT application");
         username1= new JTextField("Default ",20);
        username1.setBounds(100,150,200,30);

        username2 = new JTextField("Default",20);
        username2.setBounds(500,150,200,30);



        CardLayout cardLayout = new CardLayout();
        cardPanel= new JPanel (cardLayout);

        JButton ok1= new JButton("Select name");
        ok1.setBounds(100,200,200,30);
        ok1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String username11 = username1.getText();
            }
            });


        JButton ok2= new JButton ("START A NEW GAME");
        ok2.setBounds(500,200,200,30);
         ok2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username22 = username2.getText();
                }
            });

        JButton StartButton = new JButton("START A NEW GAME");
        StartButton.setBounds(250, 300, 300, 100);
        StartButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                cardLayout.show(cardPanel, String.valueOf(panel));
            }
        });
        
        JButton rules = new JButton("RULES");
        rules.setBounds(250,500,300,100);
        rules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new Rules();
            }
        });



        panel.add(loginLabel);
        panel.add(username1);
        panel.add(ok1);
        panel.add(username2);
        panel.add(ok2);
        panel.add(StartButton);
        CheT.add(panel);
        CheT.setVisible(true);
}
}

