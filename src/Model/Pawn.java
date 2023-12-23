package Model;

import View.Board;

public class Pawn extends Piece{
    public Pawn(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.Pawn;
        this.xPos=column*Board.getTilesizebypixel();
		this.yPos=row*Board.getTilesizebypixel();
        this.isWhite=isWhite;
    }
}
