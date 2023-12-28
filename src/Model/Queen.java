package src.Model;


public class Queen extends Piece{
    public Queen(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.Queen;
        this.isWhite=isWhite;
        this.order_in_png=1;
    }
    
    @Override
    public boolean isMoveValid(Move move){// Valid moves for queen is combination of bishop and rook.
    	return Rook.isRookMoveValid(move) || Bishop.isBishopMoveValid(move);
	}
}
