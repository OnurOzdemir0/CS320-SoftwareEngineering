package src.test;

import org.junit.Assert;
import org.junit.Test;
import src.View.Board;

import src.Model.*;

public class MoveTest {
    static Board board = new Board(null);
    @Test
    public void testMoveCollidesQueen(){
        Queen queen = new Queen(5,5,true);
        Move move = new Move(board, queen, 6,6);
        Assert.assertTrue(queen.isMoveValid(move));
        Assert.assertTrue(move.moveCollides());

    }
    @Test
    public void testMoveCollidesPawn(){
        Pawn pawn = (Pawn)board.getPiece(4,1); //şah piyonu, beyaz
        System.out.println("row: "+pawn.getRow());
        System.out.println("column: "+pawn.getColumn());
        System.out.println(pawn.getType());

        Move move = new Move(board, pawn, 2,4);
        Assert.assertFalse(move.moveCollides());
        //System.out.println(move.moveCollides());

    }
}
