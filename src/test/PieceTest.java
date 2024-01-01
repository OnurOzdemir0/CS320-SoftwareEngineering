package src.test;

import org.junit.Test;
import src.Model.*;
import src.View.Board;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PieceTest {
    static Board board = new Board(null,null,null);

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
        Pawn kingPawn1 = new Pawn(6,4,true); //beyaz şah piyonu
        Pawn kingPawn2 = new Pawn(5,4,true); //beyaz şah piyonu ama bir oynamış

        Move move11 = new Move(board, kingPawn1, 5, 4);
        Move move12 = new Move(board, kingPawn1, 4, 4);
        Move move21 = new Move(board, kingPawn2, 4, 4);
        Move move22 = new Move(board, kingPawn2, 3, 4);

        assertTrue(kingPawn1.isMoveValid(move11));
        assertTrue(kingPawn1.isMoveValid(move12));
        assertTrue(kingPawn2.isMoveValid(move21));
        assertFalse(kingPawn2.isMoveValid(move22));

        Move changeColumn = new Move(board, kingPawn1, 3, 4);
        assertFalse(kingPawn1.isMoveValid(changeColumn));

    }
    
    @Test
    public void testRook(){ 
        Rook rook_white = new Rook(7,0,true); //beyaz kale 
        
        ArrayList<Move> moves_for_white = new ArrayList<>();
        moves_for_white.add(new Move(board, rook_white, 6, 0));
        moves_for_white.add(new Move(board, rook_white, 0, 0));
        moves_for_white.add(new Move(board, rook_white, 7, 1));
        moves_for_white.add(new Move(board, rook_white, 7, 7));
        
        for(Move move : moves_for_white) 
            assertTrue(rook_white.isMoveValid(move));
        
        Rook rook_black = new Rook(0,0,false); //siyah kale
        ArrayList<Move> moves_for_black = new ArrayList<>();
        
        moves_for_black.add(new Move(board, rook_black, 0, 1));
        moves_for_black.add(new Move(board, rook_black, 0, 7));
        moves_for_black.add(new Move(board, rook_black, 1, 0));
        moves_for_black.add(new Move(board, rook_black, 7, 0));

        for(Move move : moves_for_black) 
            assertTrue(rook_black.isMoveValid(move)); 	
    }
    
    @Test
    public void testQueen(){ 
        Queen black_queen = new Queen(0,3,false); //siyah vezir 
        
        ArrayList<Move> moves = new ArrayList<>(); // geçerli hamleler
        moves.add(new Move(board, black_queen, 0, 4));
        moves.add(new Move(board, black_queen, 0, 7));
        moves.add(new Move(board, black_queen, 3, 0));
        moves.add(new Move(board, black_queen, 4, 7));
        
        for(Move move : moves) 
            assertTrue(black_queen.isMoveValid(move)); 
        
        Queen white_queen = new Queen(7,3,true); //beyaz vezir 
        
        ArrayList<Move> moves2 = new ArrayList<>(); // geçersiz hamleler
        moves2.add(new Move(board, white_queen, 5, 4));
        moves2.add(new Move(board, white_queen, 0, 5));
        moves2.add(new Move(board, white_queen, 2, 6));
        moves2.add(new Move(board, white_queen, 1, 2));
        
        for(Move move : moves2) 
            assertFalse(white_queen.isMoveValid(move));  
    }
}
