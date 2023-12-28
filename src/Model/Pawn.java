package src.Model;


public class Pawn extends Piece{
    public Pawn(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.Pawn;
        this.isWhite=isWhite;
        this.order_in_png=5;
    }

    /*
    //@Override
    public boolean isMoveValid1(Move move) {


        if(isWhite){
            //if(Math.abs(move.newColumn - move.oldColumn) == 1)
                //Piece toBeCapturedRight = move.board.getPiece(move.newColumn, move.newRow);


        }


        if(move.newColumn != move.oldColumn) //a pawn cannot change its column, EVER.
            return false;
        if(isWhite && move.newRow>move.oldRow) //I know that this seems inverted. It actually is, but it must be so because of legacy code.
            return false;
        if(!isWhite && move.newRow<move.oldRow)
            return false;
        boolean firstMove;
        if(isWhite){firstMove= move.oldRow == 6;}
        else{firstMove = move.oldRow == 1;}

        System.out.println(Math.abs(move.newRow-move.oldRow));
        if(!firstMove){
            return Math.abs(move.newRow-move.oldRow) == 1;}
        else
            return Math.abs(move.newRow-move.oldRow) ==2 || Math.abs(move.newRow-move.oldRow) ==1;

    }*/
    /**
     * Bunu parça parça ve çirkin yazdım fakat çalışıyor.
     * @param move
     * @return
     */
    public boolean isMoveValid(Move move){
        System.out.println("çağırdım");
        if(isWhite && move.newRow>move.oldRow) return false; //pawn cannot return. Full stop.
        if(!isWhite && move.newRow<move.oldRow) return false; //this looks inverted, but is really not.


        if(Math.abs(move.newColumn - move.oldColumn)==1 && Math.abs(move.newRow - move.oldRow)==1){ //yani ki çaprazsa
            System.out.println("çapraz");
            if(move.captured_piece == null)
                return false;
            else
                return isWhite ^ move.captured_piece.isWhite;
        }
        else{
            System.out.println("doğru");
            boolean firstMove;
            if(isWhite){firstMove= move.oldRow == 6;}
            else{firstMove = move.oldRow == 1;}

            if(!firstMove){return Math.abs(move.newRow-move.oldRow) == 1 && (move.captured_piece == null);}
            else return Math.abs(move.newRow-move.oldRow) ==2 || Math.abs(move.newRow-move.oldRow) ==1 && (move.captured_piece == null);
        }

    }

}
