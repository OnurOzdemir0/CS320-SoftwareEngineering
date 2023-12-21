package Model;


import java.awt.Image;

import View.Board;


enum Type{
    King, Queen, Bishop, Knight, Rook, Pawn
}
public class Piece {
    private int row;
    private int column;
    public int xPos;
    public int yPos;
    protected Type type;
    public boolean isWhite;
    
    Board board;

    Piece(int row, int column, boolean isWhite){
        this.row = row;
        this.setColumn(column);
        this.isWhite=isWhite;
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
		this.row = column;
	}
	
}
