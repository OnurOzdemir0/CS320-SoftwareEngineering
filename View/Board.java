package View;

import javax.swing.*;

import Model.Piece;

import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel{ //this is View.Board, so it should be preoccupied with just showing the board.

    private final static int tileSizeByPixel = 85;
    final static int columnNumber = 8;
    final static int rowNumber = 8;
    
    ArrayList<Piece> pieceList= new ArrayList<>();
    
    public Piece getPiece(int col, int row) {
		for(Piece piece:pieceList) {
			if(piece.getColumn()==col && piece.getRow()==row){
				return piece;
			}
		}		
		return null;
	}
    

	public static int getTilesizebypixel() {
		return tileSizeByPixel;
	}


    /**
     * This is a JPanel.
     */
    public Board(){
        this.setPreferredSize(new Dimension(columnNumber*getTilesizebypixel(), rowNumber*getTilesizebypixel()));
        this.setBackground(Color.gray);
        this.setLayout(new GridBagLayout());
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintBoard(g);
    }
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

    public void paintBoard(Graphics g2d) {
    	
    	Graphics2D g = (Graphics2D) g2d;
    	for(int row=0; row<8; row++){
    		for(int col=0; col<8; col++) {
    			if((row+col) % 2 == 0){
    				g.setColor(new Color(247, 213, 168));
    				g.fillRect(col*tileSizeByPixel,row*tileSizeByPixel, tileSizeByPixel ,tileSizeByPixel);
    			}    
    			else {
    				g.setColor(new Color(181, 143, 92));
    				g.fillRect(col*tileSizeByPixel,row*tileSizeByPixel, tileSizeByPixel ,tileSizeByPixel);
    			}
    			
    		}
    	}
    }	


}


