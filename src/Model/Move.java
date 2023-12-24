package Model;

import View.Board;

public class Move {
    int oldRow; //Move objects can include these, but this might be unnecessary...
    int oldColumn;
    int newRow;
    int newColumn;
    
    Piece playing_piece;
	Piece captured_piece;

    Move(Board board,Piece piece,int newRow, int newColumn){
    	this.oldColumn=playing_piece.getColumn();
    	this.oldRow=playing_piece.getRow();
        this.newRow = newRow;
        this.newColumn = newColumn;
        this.playing_piece=piece;
        this.captured_piece=board.getPiece(newColumn, newRow);
    }

}
