package src.test;

import org.junit.Assert;
import org.junit.Test;
import src.View.Board;

import src.Model.*;
import src.View.notationPanel;

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
        notationPanel np = new notationPanel("user1", "user2");
        Board board = new Board(np, "user1", "user2");
        board.initializePieces();

        for (int i = 0; i < 1000; i++) {
            Piece knight = board.pieceList.get(i % 2 == 0 ? 17 : 1);
            int mod = i%4;
            int r,c;

            if(mod==0){
                r=3;
                c=6;
            } else if (mod == 1) {
                r=7;
                c=4;
            } else if (mod == 2) {
                r=0;
                c=7;
            }else {
                r=8;
                c=7;
            }
            Move move = new Move(board, knight, r, c);
            if (move.canMove())
                move.makeMove();
        }
    }

}
