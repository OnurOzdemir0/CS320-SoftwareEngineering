package src.test;

import org.junit.Assert;
import org.junit.Test;
import src.View.Board;

import src.Model.*;

public class MoveTest {

    static Board board = new Board(null,null,null);


    @Test
    public void testMoveCollidesQueen(){
        Queen queen = new Queen(5,5,true);
        Move move = new Move(board, queen, 6,6);
        Assert.assertTrue(queen.isMoveValid(move));
        Assert.assertFalse(move.moveCollides());

    }
    @Test
    public void testMoveCollidesPawn(){
        Pawn pawn = (Pawn)board.getPiece(4,1); //şah piyonu, beyaz
        System.out.println("row: "+pawn.getRow());
        System.out.println("column: "+pawn.getColumn());
        System.out.println(pawn.getType());

        Move move = new Move(board, pawn, 2,4);
        Assert.assertTrue(move.moveCollides());
        //System.out.println(move.moveCollides());

    }
    @Test
    public void testCapture(){
    }

    @Test
    public void test1000Moves() {
        Board board = new Board();
        board.initializePieces();

        for (int i = 0; i < 1000; i++) {
            Piece knight = board.pieceList.get(i % 2 == 0 ? 17 : 1); //
            int newRow = knight.getRow() + (i % 2 == 0 ? 2 : -2);
            int newColumn = knight.getColumn() + (i % 2 == 0 ? 1 : -1);
            Move move = new Move(board, knight, newRow, newColumn);
        }
    }
}
