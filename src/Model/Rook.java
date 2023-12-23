package Model;


public class Rook extends Piece{
    public Rook(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.Rook;
        this.isWhite=isWhite;
        this.order_in_png=4;
    }
}
