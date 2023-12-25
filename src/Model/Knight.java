package src.Model;

public class Knight extends Piece{
    public Knight(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.Knight;
        this.isWhite=isWhite;
        this.order_in_png=3;
    }
    
    @Override
    public boolean isMoveValid(Move move) {
    	return
    			(move.newColumn == move.oldColumn-1) && (move.newRow == move.oldRow+2 || move.newRow ==move.oldRow-2)||
    			(move.newColumn == move.oldColumn+1) && (move.newRow == move.oldRow+2 || move.newRow ==move.oldRow-2)||
    			(move.newColumn == move.oldColumn+2) && (move.newRow == move.oldRow+1 || move.newRow ==move.oldRow-1)||
    			(move.newColumn == move.oldColumn-2) && (move.newRow == move.oldRow+1 || move.newRow ==move.oldRow-1);
	}
  
}
