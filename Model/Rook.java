package Model;

import View.Board;


public class Rook extends Piece{
    public Rook(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.Rook;
        this.xPos=column*Board.getTilesizebypixel();
		this.yPos=row*Board.getTilesizebypixel();
        this.isWhite=isWhite;
    }
}
