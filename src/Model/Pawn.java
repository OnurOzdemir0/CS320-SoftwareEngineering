package Model;


public class Pawn extends Piece{
    public Pawn(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.Pawn;
        this.isWhite=isWhite;
        this.order_in_png=5;
    }
    
}
