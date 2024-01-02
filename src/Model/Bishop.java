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


    public static boolean isBishopMoveValid(Move move) {
        int rowDiff = move.newRow - move.oldRow;
        int colDiff = move.newColumn - move.oldColumn;

        if (Math.abs(rowDiff) != Math.abs(colDiff) || rowDiff == 0 || colDiff == 0) {
            return false;
        }

        int rowDirection = Integer.signum(rowDiff); 
        int colDirection = Integer.signum(colDiff);
        int currentRow = move.oldRow + rowDirection;
        int currentCol = move.oldColumn + colDirection;

        while (currentRow != move.newRow && currentCol != move.newColumn) {
            if (move.board.getPiece(currentCol, currentRow) != null)
                return false;
            currentRow += rowDirection;
            currentCol += colDirection;
        }

        return true;
    }

    
    
}
