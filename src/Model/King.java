package Model;

import View.Board;

public class King extends Piece{
    public King(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.King;
        this.xPos=column*Board.getTilesizebypixel();
		this.yPos=row*Board.getTilesizebypixel();
        this.isWhite=isWhite;
    }
}
