package Model;


public class Queen extends Piece{
    public Queen(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.Rook;
        this.isWhite=isWhite;
        this.order_in_png=1;
    }
}
