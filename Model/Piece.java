package Model;


enum Type{
    King, Queen, Bishop, Knight, Rook, Pawn
}
public class Piece {
    private int row;
    private int column;
    protected Type type;

    Piece(int row, int column){
        this.row = row;
        this.column = column;
    }

    public Type getType(){
        return type;
    }
}
