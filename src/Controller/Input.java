package src.Controller;

import src.Model.Piece;
import src.View.Board;
import src.Model.Move;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input implements MouseListener, MouseMotionListener {
    private boolean turnWhite = true;

    private Board board;
    private Piece selectedPiece;
    private Point draggingPoint;
    private Point originalPoint;

    public Input(Board board) {
        this.board = board;
        this.originalPoint = new Point();
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        int col = e.getX() / Board.getTilesizebypixel();
        int row = e.getY() / Board.getTilesizebypixel();

        selectedPiece = board.getPiece(col, row);
        if (selectedPiece != null && (turnWhite == selectedPiece.isWhite)) {
        	board.selectedPiece = selectedPiece; //yeni
            originalPoint = new Point(col,row);
        } else if (selectedPiece == null) {
            System.out.println("blank space");
        }
        board.repaint();     
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        int col = e.getX() / Board.getTilesizebypixel();
        int row = e.getY() / Board.getTilesizebypixel();

        if (col < 0) col = 0;
        if (col >= board.columnNumber) col = board.columnNumber - 1;
        if (row < 0) row = 0;
        if (row >= board.rowNumber) row = board.rowNumber - 1;

        if (board.selectedPiece != null && board.selectedPiece.isWhite == turnWhite) {
            Move move = new Move(board, board.selectedPiece, row, col);
            if(move.playing_piece.isMoveValid(move)){

                if(move.makeMove()) //if can make move then turn changes. some validations are made in makeMove() some in isMoveValid()
                    turnWhite = !turnWhite;
            }
            board.selectedPiece = null;
            board.repaint();
        }

    }
    public void paint(Graphics g) {
        if (selectedPiece != null) {
            if (draggingPoint != null) {
                g.drawImage(selectedPiece.getPieceImage(), draggingPoint.x, draggingPoint.y, null);
            } else {
                g.drawImage(selectedPiece.getPieceImage(),
                        originalPoint.x * Board.getTilesizebypixel(),
                        originalPoint.y * Board.getTilesizebypixel(), null);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (board.selectedPiece != null) {
            draggingPoint = e.getPoint();
            board.repaint();
        }
    }

        @Override
        public void mouseClicked (MouseEvent e){
        }

        @Override
        public void mouseEntered (MouseEvent e){
        }

        @Override
        public void mouseExited (MouseEvent e){
        }

        //@Override
        // public void mouseMoved(MouseEvent e) { }


        public void mouseMoved(MouseEvent e){

            int col = e.getX() / Board.getTilesizebypixel();
            int row = e.getY() / Board.getTilesizebypixel();


//            System.out.println("Mouse moved to position - Col: " + col + ", Row: " + row);
        }

}
