package Model;

public class Move {
    int oldRow; //Move objects can include these, but this might be unnecessary...
    int oldColumn;
    int newRow;
    int newColumn;

    Move(int newRow, int newColumn){
        this.newRow = newRow;
        this.newColumn = newColumn;
    }

}
