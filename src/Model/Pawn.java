package src.Model;


public class Pawn extends Piece{
    public Pawn(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.Pawn;
        this.isWhite=isWhite;
        this.order_in_png=5;
    }

    @Override
    public boolean isMoveValid(Move move) {
        if(move.newColumn != move.oldColumn) //a pawn cannot change its column, EVER.
            return false;

        boolean firstMove;
        if(isWhite){
            firstMove= move.oldRow == 1;
        }
        else{
            firstMove = move.oldRow == 7;
        }

        if(!firstMove)
            return Math.abs(move.newRow-move.oldRow) == 1;
        else
            return Math.abs(move.newRow-move.oldRow) <=2;

    }
}
