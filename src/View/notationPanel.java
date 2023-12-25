package src.View;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class notationPanel extends JPanel{
	
	private JTextArea notationTextArea;

    public notationPanel() {
        setLayout(new BorderLayout());
        notationTextArea = new JTextArea();
        notationTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(notationTextArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addMoveNotation(String notation) {
        notationTextArea.append(notation + "\n");
    }

}
