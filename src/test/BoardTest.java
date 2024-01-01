package src.test;
import org.junit.Test;
import src.View.Board;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import src.Model.*;
import src.View.*;
import org.junit.jupiter.api.BeforeEach;
import src.Model.Piece;
import src.Model.Move;

import org.junit.Assert;



public class BoardTest {

    private Board board;


    @Test
    public void testInitialSetup() {
        ArrayList<Piece> initialSetup = new ArrayList<>();

        initialSetup.add(new King(0, 4, false));
        initialSetup.add(new Queen(0, 3, false));
        initialSetup.add(new Rook(0, 0, false));
        initialSetup.add(new Knight(0, 1, false));
        initialSetup.add(new Bishop(0, 2, false));
        initialSetup.add(new Knight(0, 6, false));
        initialSetup.add(new Bishop(0, 5, false));
        initialSetup.add(new Rook(0, 7, false));


        initialSetup.add(new King(0, 4, true));
        initialSetup.add(new Queen(0, 3, true));
        initialSetup.add(new Rook(0, 0, true));
        initialSetup.add(new Knight(0, 1, true));
        initialSetup.add(new Bishop(0, 2, true));
        initialSetup.add(new Knight(0, 6, true));
        initialSetup.add(new Bishop(0, 5, true));
        initialSetup.add(new Rook(0, 7, true));
        BoardTest boardTest = new BoardTest();
        Assert.assertTrue(boardTest.testGetPiece(initialSetup));
    }
    @Test
    boolean testGetPiece(ArrayList<Piece> initialSetup) {

        Piece piece = board.getPiece(0, 0);
        Assert.assertNotNull(piece);
        Assert.assertTrue(piece instanceof Rook);
        Assert.assertEquals(0, piece.getColumn());
        Assert.assertEquals(0, piece.getRow());
        return false;
    }

    public boolean testPiecesNumber (ArrayList<Piece>pieceList){
        if(pieceList.size()==32){
            return true ;
        }
        return false ;
    }
    

    @Test
    void testPiecesNumber() {

        ArrayList<Piece> pieceList = new ArrayList<Piece>();


        boolean result = testPiecesNumber(pieceList);

        Assert.assertTrue(result);
    }
    @BeforeEach

    void setUp() {
        System.setProperty("key", "value");

        board = new Board(new notationPanel(), "Player1", "Player2");
    }




    @Test
    void testMakeValidMove() {

        Piece pawn = board.getPiece(1, 1);
        Assert.assertNotNull(pawn);

        Move validMove = new Move(board, pawn, 3, 1);
        Assert.assertTrue(pawn.isMoveValid(validMove));


       Assert.assertTrue(validMove.makeMove());
        Assert.assertNull(board.getPiece(1, 1));
        Assert.assertEquals(pawn, board.getPiece(3, 1));
    }
    @Test
    void testMakeInvalidMove() {

        Piece rook = board.getPiece(0, 0);
        Assert.assertNotNull(rook);


        Move invalidMove = new Move(board, rook, 2, 2);
        Assert.assertFalse(rook.isMoveValid(invalidMove));


        Assert.assertEquals(rook, board.getPiece(0, 0));
        Assert.assertNull(board.getPiece(2, 2));
    }

    @Test
    void testHighlightValidPositions() {

        Piece pawn = board.getPiece(1, 1);
        Assert.assertNotNull(pawn);


        board.setSelectedPiece(pawn);


        board.highlight_valid_positions(board.getGraphics());
    }

    @Test
    void testPaintComponent() {
        Board board = new Board(); // Board sınıfını oluşturuyoruz.

        // paintComponent metodunu çağırarak elde edilen renkleri string olarak alıyoruz.
        BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        board.paintComponent(g);
        g.dispose();

        // Beklenen renk kontrolü
        Assert.assertEquals(new Color(247, 213, 168), new Color(image.getRGB(0, 0))); // Örnek bir kontrol noktası
    }

    @Test
    void testPaintBoard() {
        Board board = new Board(); // Board sınıfını oluşturuyoruz.

        // paintBoard metodunu çağırarak elde edilen renkleri string olarak alıyoruz.
        BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        board.paintBoard(g);
        g.dispose();

        // Beklenen renk kontrolü
        Assert.assertEquals(new Color(247, 213, 168), new Color(image.getRGB(0, 0))); // Örnek bir kontrol noktası
    }

    @Test
    void testDrawPieces() {
        Board board = new Board(); // Board sınıfını oluşturuyoruz.

        // drawPieces metodunu çağırarak elde edilen renkleri string olarak alıyoruz.
        BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        board.drawPieces(g);
        g.dispose();

        // Beklenen renk kontrolü
        Assert.assertEquals(new Color(247, 213, 168), new Color(image.getRGB(0, 0))); // Örnek bir kontrol noktası
    }


}
