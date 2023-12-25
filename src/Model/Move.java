package src.Model;

import src.View.Board;

public class Move {
    int oldRow; //Move objects can include these, but this might be unnecessary...
    int oldColumn;
    int newRow;
    int newColumn;
    
    Piece playing_piece;
	Piece captured_piece;

    Board board; //lazım oluyor.

    public Move(Board board, Piece piece, int newRow, int newColumn){
        this.playing_piece=piece;
    	this.oldColumn=playing_piece.getColumn();
    	this.oldRow=playing_piece.getRow();
        this.newRow = newRow;
        this.newColumn = newColumn;
        this.captured_piece=board.getPiece(newColumn, newRow);
        this.board = board;
    }

    public boolean moveCollides(){
        if(this.playing_piece.getType() == Type.Knight) {
            return (board.getPiece(newColumn, newRow) != null); //at yalnızca varağında bir taş varsa "collide" ediyor.
        }
        int smallRow = Math.min(oldRow, newRow);
        int bigRow = Math.max(oldRow, newRow);
        int smallColumn = Math.min(oldColumn, newColumn);
        int bigColumn = Math.max(oldColumn, newColumn);

        if(smallRow == bigRow){ //yatay harekette
            while(smallColumn != bigColumn){
                if(board.getPiece(smallColumn, smallRow) != null)
                    return true;
                smallColumn++;
            }
        }
        else if(smallColumn == bigColumn) { //dikey hareket
            while(smallRow != bigRow){
                if(board.getPiece(smallColumn, smallRow) != null)
                    return true;
                smallRow++;
            }
        }
        else{ //çapraz hareket
            while(smallColumn != bigColumn && smallRow != bigRow) {//the second part should be unnecessary
                if(board.getPiece(smallColumn, smallRow) != null)
                    return true;
                smallRow++;
                smallColumn++;
            }
        }
            return false;


    }

}
