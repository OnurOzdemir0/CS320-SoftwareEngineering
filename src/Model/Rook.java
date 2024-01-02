package src.Model;


public class Rook extends Piece{
    public Rook(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.Rook;
        this.isWhite=isWhite;
        this.order_in_png=4;
    }
    
    @Override
    public boolean isMoveValid(Move move) {
    	return isRookMoveValid(move);
	}
    
    public static boolean isRookMoveValid(Move move){ //Created to be able to use in queen
    	return (move.newRow == move.oldRow && move.newColumn != move.oldColumn)
        || (move.oldColumn == move.newColumn && move.newRow != move.oldRow);

	}
}
