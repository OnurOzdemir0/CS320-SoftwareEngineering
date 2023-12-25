package src.test;

import org.junit.Assert;
import org.junit.Test;
import src.View.Board;

import src.Model.*;

public class MoveTest {
    static Board board = new Board();
    @Test
    public void testMoveCollidesQueen(){
        Queen queen = new Queen(5,5,true);
        Move move = new Move(board, queen, 6,6);
        System.out.println(queen.isMoveValid(move));
        System.out.println(move.moveCollides());

    }
    @Test
    public void testMoveCollidesPawn(){
       //work in progress.

    }
}
