package Model;


public class Bishop extends Piece{
    public Bishop(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.Bishop;
        this.isWhite=isWhite;
        this.order_in_png=2;
    }
}
