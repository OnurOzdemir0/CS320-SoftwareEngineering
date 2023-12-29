package src.View;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class notationPanel extends JPanel{
	
	private JTextArea notationTextArea;
	String user1;
	String user2;
	int turn=0;

    public notationPanel(String username1, String username2) {
    	this.user1=username1;
    	this.user2=username2;
        setLayout(new BorderLayout());
        notationTextArea = new JTextArea();
        notationTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(notationTextArea);
        add(scrollPane, BorderLayout.CENTER);
    }

	public notationPanel() {

	}

	public void addMoveNotation(String notation) {
    	if(turn%2==0) {
    		notationTextArea.append(user1 + ": " + notation + "\n");
    		this.turn++;
    	}
    	else {
    		notationTextArea.append(user2 + ": " + notation + "\n");
    		this.turn++;
    	}
    }

}
