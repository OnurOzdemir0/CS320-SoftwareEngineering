package Model;

public class King extends Piece{
    public King(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.King;
        this.isWhite=isWhite;
        this.order_in_png=0;
    }
}
