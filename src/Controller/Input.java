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
            originalPoint = new Point(col,row);
        } else if (selectedPiece == null) {
            System.out.println("blank space");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (selectedPiece != null ) {

            System.out.println(selectedPiece.getType());

            int col = e.getX() / Board.getTilesizebypixel();
            int row = e.getY() / Board.getTilesizebypixel();

            if(selectedPiece.isMoveValid(new Move(board, selectedPiece,row,col))) {
                Move move = new Move(board, selectedPiece, row, col);
            }

            selectedPiece = null;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (selectedPiece != null) {
            draggingPoint = e.getPoint();
            board.repaint();
        }
    }

   // public void paint(Graphics g) {
     //   if (selectedPiece != null) {

      //  }
    //}

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


            System.out.println("Mouse moved to position - Col: " + col + ", Row: " + row);
        }

}
