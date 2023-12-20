package Model;

import View.Board;

public class Bishop extends Piece{
    public Bishop(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.Bishop;
        this.xPos=column*Board.getTilesizebypixel();
		this.yPos=row*Board.getTilesizebypixel();
        this.isWhite=isWhite;
    }
}
