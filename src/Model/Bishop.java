package src.Model;


public class Bishop extends Piece{
    public Bishop(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.Bishop;
        this.isWhite=isWhite;
        this.order_in_png=2;
    }
    
    @Override
    public boolean isMoveValid(Move move) {
    	return isBishopMoveValid(move);
	}
    
 
    public static boolean isBishopMoveValid(Move move){// Created to be able to use in queen
    	return Math.abs(move.newColumn-move.oldColumn) == Math.abs(move.newRow-move.oldRow);
	}
    
    
}
