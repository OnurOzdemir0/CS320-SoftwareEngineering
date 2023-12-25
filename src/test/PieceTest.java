package src.test;

import org.junit.Test;
import src.Model.*;
import src.View.Board;

import static org.junit.Assert.assertTrue;

public class PieceTest {
    static Board board = new Board();

    @Test
    public void testFreeKingMoves(){
        King king = new King(5,5,true); //a white king, in the centre of the board.
        for(int i = 4; i<=6; i++){
            for(int j = 4; j<=6; j++){ //these constitute every possible move for a king at the centre
                if(!(i==5 && j==5)){
                    Move move = new Move(board, king, i, j);
                    assertTrue(king.isMoveValid(move));}
            }
        }



    }
}
