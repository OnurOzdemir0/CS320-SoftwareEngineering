package Model;


public class Knight extends Piece{
    public Knight(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.Knight;
        this.isWhite=isWhite;
        this.order_in_png=3;
    }
}
