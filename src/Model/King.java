package src.Model;

public class King extends Piece{
    public King(int row, int column, boolean isWhite){
        super(row, column,isWhite);
        this.type = Type.King;
        this.isWhite=isWhite;
        this.order_in_png=0;
    }
    @Override
    public boolean isMoveValid(Move move) {
        if(move.oldRow == move.newRow && move.oldColumn == move.newColumn)
            return false;
        else{
            return (Math.abs(move.newRow-move.oldRow) <= 1) && (Math.abs(move.newColumn-move.oldColumn) <= 1);
        }



        /*
        return
                (move.newColumn == move.oldColumn && move.newRow == move.oldRow+1)|| //ileri
                        (move.newColumn == move.oldColumn && move.newRow == move.oldRow-1)|| //geri
                        (move.newColumn == move.oldColumn+1 && move.newRow == move.oldRow)|| //sağa
                        (move.newColumn == move.oldColumn-1 && move.newRow == move.oldRow)|| //sola
                        (move.newColumn == move.oldColumn+1 && move.newRow == move.oldRow+1)|| //sağ ileri
                        (move.newColumn == move.oldColumn-1 && move.newRow == move.oldRow+1)|| //sol ileri
                        (move.newColumn == move.oldColumn+1 && move.newRow == move.oldRow-1)|| //sağ geri
                        (move.newColumn == move.oldColumn-1 && move.newRow == move.oldRow-1); //sol geri*/

    }
}
