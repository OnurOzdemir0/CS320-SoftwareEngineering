import javax.swing.*;
import.java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField username1;
    private JTextField username2 ;
    private JPanel panel;
    private JPanel cardPanel ;
    private JPanel = panel;


    public LoginView(){
        JFrame CheT= new JFrame("CheT");
        CheT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CheT.setSize(800,800);
        panel = new JPanel();

        JLabel loginLabel =new JLabel ("Welcome the CheT application");
        JTextField username1= new JTextField("Default ",20);
        username1.setBounds(50,50,50,50);

        JTextField username2 = new JTextField("Default",20);
        username2.setBounds(750,750,50,50);



        cardLayout = new CardLayout();
        cardPanel= new JPanel (cardLayout);

        JButton ok1= new JButton("Select name");
        ok1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String username11= username1.getText();
            }
        }

        JButton ok2= new JButton ("START A NEW GAME");
        StartButton.setBounds(300,300,200,50);

        Start Button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                cardLayout.show(cardPanel, String.valueOf(panel))
            }
        });

    }


        panel.add(loginLabel);
        panel.add(username1);
        panel.add(ok1);
        panel.add(username2);
        panel.add(ok2);
        panel.add(StartButton);
        CheT.add(panel);
        CheT.setVisible(true);
}
