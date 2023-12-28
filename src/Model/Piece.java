package src.Model;


import java.awt.Image;

import src.View.Board;


enum Type{
    King, Queen, Bishop, Knight, Rook, Pawn
}
public class Piece {
    private int row;
    private int column;
    public int order_in_png;
    protected Type type;
    public boolean isWhite;
    private Image pieceImage;
    
    Board board;

    public Piece(int row, int column, boolean isWhite){
        this.row = row;
        this.setColumn(column);
        this.isWhite=isWhite;
    }
    
    public Image getPieceImage() {
        return pieceImage;
    }

    public void setPieceImage(Image pieceImage) {
        this.pieceImage = pieceImage;
    }
    

    public Type getType(){
        return type;
    }

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
		
	}public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	public boolean isMoveValid(Move move) {
		return true; 
	}
	
}
