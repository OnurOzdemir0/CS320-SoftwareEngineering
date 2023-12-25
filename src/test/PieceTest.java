package src.test;

import org.junit.Test;
import src.Model.*;
import src.View.Board;

import java.util.ArrayList;

import static org.junit.Assert.*;

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
    @Test
    public void testFreeBishopMoves(){
        Bishop bishop = new Bishop(5,5,true);
        for(int i=2; i<=8; i++){
            Move move = new Move(board, bishop, i, i); //on the same diagonal
            assertTrue(bishop.isMoveValid(move));

            Move move2 = new Move(board, bishop, i, 8+2-i); //this draws the other diagonal for the initial point
            assertTrue(bishop.isMoveValid(move2));
        }
    }
    @Test
    public void testFreeKnight(){
        Knight knight = new Knight(5,5,true);
        ArrayList<Move> moves = new ArrayList<>();
        moves.add(new Move(board, knight, 7, 6));
        moves.add(new Move(board, knight, 7, 4));
        moves.add(new Move(board, knight, 3, 4));
        moves.add(new Move(board, knight, 3, 6));

        for(Move move : moves) //this is not an exhaustive list of possible moves, but that is not necessary...
            assertTrue(knight.isMoveValid(move));
    }

    @Test
    public void testPawn(){ //this is a hideous way of testing this.
        Pawn kingPawn1 = new Pawn(2,5,true); //beyaz şah piyonu
        Pawn kingPawn2 = new Pawn(3,5,true); //beyaz şah piyonu ama bir oynamış

        Move move11 = new Move(board, kingPawn1, 3, 5);
        Move move12 = new Move(board, kingPawn1, 4, 5);
        Move move21 = new Move(board, kingPawn2, 4, 5);
        Move move22 = new Move(board, kingPawn2, 5, 5);

        assertTrue(kingPawn1.isMoveValid(move11));
        assertTrue(kingPawn1.isMoveValid(move12));
        assertTrue(kingPawn2.isMoveValid(move21));
        assertFalse(kingPawn2.isMoveValid(move22));

        Move changeColumn = new Move(board, kingPawn1, 3, 4);
        assertFalse(kingPawn1.isMoveValid(changeColumn));

    }
}
