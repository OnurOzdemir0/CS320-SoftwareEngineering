package Model;

import View.Board;

public class Knight extends Piece{
    public Knight(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.Knight;
        this.xPos=column*Board.getTilesizebypixel();
		this.yPos=row*Board.getTilesizebypixel();
        this.isWhite=isWhite;
    }
}
