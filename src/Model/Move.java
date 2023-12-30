package src.Model;

import src.View.Board;

public class Move {
    int oldRow; //Move objects can include these, but this might be unnecessary...
    int oldColumn;
    int newRow;
    int newColumn;
    
    public Piece playing_piece;
	Piece captured_piece;

    Board board; //lazım oluyor.
    
	private String getMoveNotation(Move move) {
		
		final String[] column_to_letter = {"a", "b", "c", "d", "e", "f", "g", "h"};
		String newCol = column_to_letter[move.newColumn];
		int newRow= 8-move.newRow;
		if( move.playing_piece.type.name().equals("Knight")) {
			if(move.captured_piece==null) {
				return "N" + newCol + newRow;
			}
			else {
				return "N" + "x" + newCol + newRow;
			}
		}
		
		else{
			if(move.captured_piece==null) {
				return move.playing_piece.type.name().charAt(0) + newCol +newRow;
			}
			else {
				return move.playing_piece.type.name().charAt(0) + "x" + newCol + newRow;
			}
		}
	}

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
            while(smallColumn != bigColumn-1){
                smallColumn++;
                if(board.getPiece(smallColumn, smallRow) != null)
                    return true;
            }
        }
        else if(smallColumn == bigColumn) { //dikey hareket
            while(smallRow != bigRow-1){
                smallRow++;
                if(board.getPiece(smallColumn, smallRow) != null)
                    return true;
            }
        }
        else{ //çapraz hareket
            int rowStep = (newRow > oldRow) ? 1 : -1;
            int columnStep = (newColumn > oldColumn) ? 1 : -1;
            int currentRow = oldRow;
            int currentColumn = oldColumn;

            while ((currentRow != newRow - rowStep) && (currentColumn != newColumn - columnStep)) {
                currentRow += rowStep;
                currentColumn += columnStep;
                if (board.getPiece(currentColumn, currentRow) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canMove() { //separated this part from makeMove to also use in different places
        if (!this.playing_piece.isMoveValid(this)) {
            return false;
        }

        if (this.moveCollides()) {
            System.out.println("Move path collides");
            return false;
        }

        if (this.captured_piece != null && this.captured_piece.isWhite == this.playing_piece.isWhite) {
            return false;
        }

        // check();

        return true;
    }

    public void makeMove(){
        if (!canMove()) {
            return;
        }

        if (this.captured_piece != null) {
            capturePiece(this);
        }

        this.playing_piece.setRow(this.newRow);
        this.playing_piece.setColumn(this.newColumn);

        board.notationPanel.addMoveNotation(getMoveNotation(this));
        this.board.repaint();
    }


    /**
     *
     * @param move aldığı hamle
     * @return if the move can be executed.
     */
    public boolean capturePiece(Move move){
        if(captured_piece != null){
                if(captured_piece.isWhite ^ move.playing_piece.isWhite && captured_piece.type != Type.King){ //so if their colours are not the same, meaning the one can actually capture the other
                    this.board.pieceList.remove(captured_piece);
                    return true;
                }
                else //eğer renkleri aynıysa kıramaz.
                    return false;

        }
        return true;
    }
    public void capturePiece1(Move move){
        board.pieceList.remove(captured_piece);
    }

}
