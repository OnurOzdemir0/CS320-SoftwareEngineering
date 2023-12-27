package src.View;

import javax.imageio.ImageIO;
import javax.swing.*;

import src.Model.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static java.lang.ClassLoader.getSystemResourceAsStream;

public class Board extends JPanel{ //this is View.Board, so it should be preoccupied with just showing the board.

	private final static int tileSizeByPixel = 83;
	final static int columnNumber = 8;
	final static int rowNumber = 8;
	
	private notationPanel notationPanel;

	public ArrayList<Piece> pieceList= new ArrayList<>();


	public Piece getPiece(int col, int row) {
		for(Piece piece:pieceList) {
			if(piece.getColumn()==col && piece.getRow()==row){
				return piece;
			}
		}		
		return null;
	}
	
	/*public void makeMove(Move move){ // bu ve burdan sonraki kısımlar daha daha implemente edilmedi notasyonun nasıl kullanılacağını göstermek için ekledim
		move.piece.col=move.newCol;
		move.piece.row=move.newRow;
		move.piece.xPos=move.newCol*squaresize;
		move.piece.yPos=move.newRow*squaresize;
		
		notationPanel.addMoveNotation(getMoveNotation(move));
		
		capture(move);
		
	}
	
	private String getMoveNotation(Move move) {
		
		final String[] row_to_letter = {"a", "b", "c", "d", "e", "f", "g", "h"};
		String newCol = row_to_letter[move.newCol];
		if( move.piece.name.equals("Knight")) {
			if(move.capture==null) {
				return "N" + newCol + move.newRow;
			}
			else {
				return "N" + "x" + newCol + move.newRow;
			}
		}
		
		else{
			if(move.capture==null) {
				return move.piece.name.charAt(0) + newCol + move.newRow;
			}
			else {
				return move.piece.name.charAt(0) + "x" + newCol + move.newRow;
			}
		}
	}
	
	
	public void capture(Move move) {
		pieceList.remove(move.capture);
	}
	
	public boolean isValidMove(Move move) {
		if(sameTeam(move.piece,move.capture)) {
			return false;
		}
		if(!move.piece.isValidMovement(move.newCol, move.newRow)) {
			return false;
		}
		if (move.piece.moveCollidesWithPiece(move.newCol, move.newRow)){
			return false;
		}
		
		return true;
	}
	
	
	public boolean sameTeam(Piece p1, Piece p2){
		if(p1==null || p2==null) {
			return false;
		}
		return p1.isWhite==p2.isWhite;
	}*/


	public static int getTilesizebypixel() {
		return tileSizeByPixel;
	}


	/**
	 * This is a JPanel.
	 */
	public Board(notationPanel notationPanel){
		this.setPreferredSize(new Dimension(columnNumber*getTilesizebypixel(), rowNumber*getTilesizebypixel()));
		this.setBackground(Color.gray);
		this.setLayout(new GridBagLayout());
		initializePieces();
		this.notationPanel = notationPanel;

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintBoard(g);
		drawPieces(g);
	}


	private void initializePieces() {
		
		//create all the pieces and add them list
		pieceList.add(new Rook(0, 0, false));
		pieceList.add(new Knight(0, 1, false));
		pieceList.add(new Bishop(0, 2, false));
		pieceList.add(new Queen(0, 3, false));
		pieceList.add(new King(0, 4, false));
		pieceList.add(new Bishop(0, 5, false));
		pieceList.add(new Knight(0, 6, false));
		pieceList.add(new Rook(0, 7, false));

		for (int i = 0; i < 8; i++) {
			pieceList.add(new Pawn(1, i, false));
		}

		pieceList.add(new Rook(7, 0, true));
		pieceList.add(new Knight(7, 1, true));
		pieceList.add(new Bishop(7, 2, true));
		pieceList.add(new Queen(7, 3, true));
		pieceList.add(new King(7, 4, true));
		pieceList.add(new Bishop(7, 5, true));
		pieceList.add(new Knight(7, 6, true));
		pieceList.add(new Rook(7, 7, true));

		for (int i = 0; i < 8; i++) {
			pieceList.add(new Pawn(6, i, true));
		}


		try {
			BufferedImage allPiecesImage = ImageIO.read(getSystemResourceAsStream("src/View/pieces.png"));
			int pieceWidth = allPiecesImage.getWidth() / 6; // There are 6 pieces in a row
			int pieceHeight = allPiecesImage.getHeight() / 2; // There are 2 rows for each color

			//assign each image to the corresponding Piece objects
			for (Piece piece : pieceList) {
				int x = piece.order_in_png * pieceWidth;
				int y=pieceHeight;

				if(piece.isWhite) {
					y = 0;	
				}

				BufferedImage pieceImage = allPiecesImage.getSubimage(x, y, pieceWidth, pieceHeight);
				piece.setPieceImage(pieceImage);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	private void drawPieces(Graphics g) {
		for (Piece piece : pieceList) {
			if (piece.getPieceImage() != null) {
				int x = piece.getColumn() * tileSizeByPixel;
				int y = piece.getRow() * tileSizeByPixel;

				// We should fix the size of each piece to fit in tiles
				Image scaledImage = piece.getPieceImage().getScaledInstance(tileSizeByPixel, tileSizeByPixel, Image.SCALE_SMOOTH);

				// Draw the image
				g.drawImage(scaledImage, x, y, this);
			}
		}
	}



}


