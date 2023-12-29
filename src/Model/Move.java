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

        if(captured_piece != null && captured_piece.type == Type.King)
            return true;

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

    public boolean makeMove(){  //called from move object: move.MakeMove()
        if(playing_piece.isMoveValid(this)){
            if(moveCollides() && this.captured_piece == null){
                System.out.println("move collides but no capture");
            }
            else if(capturePiece(this)){
                playing_piece.setColumn(this.newColumn);
                playing_piece.setRow(this.newRow);}
//            System.out.println(playing_piece.getType()+" ile "+this.newColumn + " sütununa ve "+this.newRow+" satırına gitmeye çalışıyorsun");
            this.board.repaint();
            return true;
        }
        else {
            System.out.println("move not valid for: " + this.playing_piece.getType());
            return false;
        }
    }

    /**
     *
     * @param move aldığı hamle
     * @return if the move can be executed.
     */
    public boolean capturePiece(Move move){
        if(captured_piece != null){
                if(captured_piece.isWhite ^ move.playing_piece.isWhite){ //so if their colours are not the same, meaning the one can actually capture the other
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
