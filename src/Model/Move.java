package src.Model;

import src.View.Board;
import src.View.GameOverView;
import src.View.LoginView;

import java.awt.*;

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
        int newRow = 8 - move.newRow;
        if (move.playing_piece.type.name().equals("Knight")) {
            if (move.captured_piece == null) {
                return "N" + newCol + newRow;
            } else {
                return "N" + "x" + newCol + newRow;
            }
        } else {
            if (move.captured_piece == null) {
                return move.playing_piece.type.name().charAt(0) + newCol + newRow;
            } else {
                return move.playing_piece.type.name().charAt(0) + "x" + newCol + newRow;
            }
        }
    }

    public Move(Board board, Piece piece, int newRow, int newColumn) {
        this.playing_piece = piece;
        this.oldColumn = playing_piece.getColumn();
        this.oldRow = playing_piece.getRow();
        this.newRow = newRow;
        this.newColumn = newColumn;
        this.captured_piece = board.getPiece(newColumn, newRow);
        this.board = board;
    }

    public boolean moveCollides() {
        if (this.playing_piece.getType() == Type.Knight) {
            return false;
        }

        int smallRow = Math.min(oldRow, newRow);
        int bigRow = Math.max(oldRow, newRow);
        int smallColumn = Math.min(oldColumn, newColumn);
        int bigColumn = Math.max(oldColumn, newColumn);

        if (smallRow == bigRow) { //yatay harekette
            while (smallColumn != bigColumn - 1) {
                smallColumn++;
                if (board.getPiece(smallColumn, smallRow) != null)
                    return true;
            }
        } else if (smallColumn == bigColumn) { //dikey hareket
            while (smallRow != bigRow - 1) {
                smallRow++;
                if (board.getPiece(smallColumn, smallRow) != null)
                    return true;
            }
        } else { //çapraz hareket
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

    private int[] findKingPosition(boolean isWhite) {
        for (Piece piece : board.pieceList) {
            if (piece instanceof King && piece.isWhite == isWhite) {
                return new int[]{piece.getRow(), piece.getColumn()};
            }
        }
        return null;
    }

    public boolean isCheck(boolean isWhite) {
        int[] kingPosition = findKingPosition(isWhite);
        for (Piece piece : board.pieceList) {
            if (piece.isWhite != isWhite) {
                Move testMove = new Move(board, piece, kingPosition[0], kingPosition[1]);
                if (testMove.moveCollides() == false && piece.isMoveValid(testMove)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCheckmate(boolean isWhite) {
        if (!isCheck(isWhite)) {
            return false;
        }
        return mateCheck(isWhite);
    }

    public boolean isStalemate(boolean isWhite){
        if(isCheck(isWhite)){
            return false;
        }
        return mateCheck(isWhite);
    }

    public boolean mateCheck(boolean isWhite) {
        for (Piece piece : board.pieceList) {
            if (piece.isWhite == isWhite) {
                for (int newRow = 0; newRow < Board.rowNumber; newRow++) {
                    for (int newColumn = 0; newColumn < Board.columnNumber; newColumn++) {
                        if (piece.getRow() == newRow && piece.getColumn() == newColumn) {
                            continue;
                        }

                        Move testMove = new Move(board, piece, newRow, newColumn);
                        if (testMove.canMove()) {
                            int originalRow = piece.getRow();
                            int originalColumn = piece.getColumn();
                            Piece originalCaptured = testMove.captured_piece;

                            piece.setRow(newRow);
                            piece.setColumn(newColumn);
                            if (originalCaptured != null) {
                                board.pieceList.remove(originalCaptured);
                            }

                            boolean stillInCheck = isCheck(isWhite);

                            piece.setRow(originalRow);
                            piece.setColumn(originalColumn);
                            if (originalCaptured != null) {
                                board.pieceList.add(originalCaptured);
                            }

                            if (!stillInCheck) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }




    public boolean canMove() {
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

        Piece tempCaptured = this.captured_piece;
        int tempRow = playing_piece.getRow();
        int tempColumn = playing_piece.getColumn();

        this.playing_piece.setRow(this.newRow);
        this.playing_piece.setColumn(this.newColumn);
        if (tempCaptured != null) {
            board.pieceList.remove(tempCaptured);
        }

        boolean inCheck = isCheck(this.playing_piece.isWhite);

        this.playing_piece.setRow(tempRow);
        this.playing_piece.setColumn(tempColumn);
        if (tempCaptured != null) {
            board.pieceList.add(tempCaptured);
        }

        if (inCheck) {
            System.out.println("Move puts king in check");
            return false;
        }

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

        if (isCheckmate(!this.playing_piece.isWhite)) { // Check if the opponent is in checkmate
            src.View.GameOverView gameOverView = new GameOverView();
        }
        if(isStalemate(!this.playing_piece.isWhite)){
            src.View.GameOverView gameOverView = new GameOverView();
        }
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
