package View;

import javax.swing.*;

import Model.Piece;

import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel{ //this is View.Board, so it should be preoccupied with just showing the board.

	private final static int tileSizeByPixel = 85;
	final static int columnNumber = 8;
	final static int rowNumber = 8;

	public ArrayList<Piece> pieceList= new ArrayList<>();

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
		
		// Draw letters on the last row- for notation
	    for (int col = 0; col < 8; col++) {
	        char letter = (char) ('a' + col);
	        g.setColor(Color.BLACK);
	        g.drawString(String.valueOf(letter), col * tileSizeByPixel + tileSizeByPixel / 2 - 5, 8 * tileSizeByPixel - 5);
	    }

	    // Draw numbers on the last column- for notation
	    for (int row = 0; row < 8; row++) {
	        int number = 8 - row;
	        g.setColor(Color.BLACK);
	        g.drawString(String.valueOf(number), 8 * tileSizeByPixel - 15, row * tileSizeByPixel + tileSizeByPixel / 2 + 5);
	    }
		
		
	}
	
	
	



}


