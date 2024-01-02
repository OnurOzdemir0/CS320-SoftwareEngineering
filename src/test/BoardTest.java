package src.test;
import org.junit.Test;
import org.junit.*;
import src.View.LoginView;
import src.View.notationPanel;
import src.View.Board;

import static java.lang.ClassLoader.getSystemResourceAsStream;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

import src.Controller.Input;
import src.Model.*;
import org.junit.Assert;

public class BoardTest {

    private Board board_real = new Board(null, null, null);
    ArrayList<Piece> initialSetup = new ArrayList<>();
    private BufferedImage image = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);


    @Test
    public void testInitialSetup() { //GEÇTİ GÖZÜKÜYO

        initialSetup.add(new Rook(0, 0, false));
        initialSetup.add(new Knight(0, 1, false));
        initialSetup.add(new Bishop(0, 2, false));
        initialSetup.add(new Queen(0, 3, false));
        initialSetup.add(new King(0, 4, false));
        initialSetup.add(new Bishop(0, 5, false));
        initialSetup.add(new Knight(0, 6, false));
        initialSetup.add(new Rook(0, 7, false));

        for (int i = 0; i < 8; i++) {
            initialSetup.add(new Pawn(1, i, false));
        }

        initialSetup.add(new Rook(7, 0, true));
        initialSetup.add(new Knight(7, 1, true));
        initialSetup.add(new Bishop(7, 2, true));
        initialSetup.add(new Queen(7, 3, true));
        initialSetup.add(new King(7, 4, true));
        initialSetup.add(new Bishop(7, 5, true));
        initialSetup.add(new Knight(7, 6, true));
        initialSetup.add(new Rook(7, 7, true));

        for (int i = 0; i < 8; i++) {
            initialSetup.add(new Pawn(6, i, true));
        }

        Assert.assertEquals(board_real.pieceList.size(), initialSetup.size());

    }

    @Test
    public void testGetPiece() {
        Piece piece = board_real.getPiece(0, 0);
        Assert.assertNotNull(piece);
        Assert.assertTrue(piece instanceof Rook);
        Assert.assertEquals(0, piece.getColumn());
        Assert.assertEquals(0, piece.getRow());
    }

    @Test
    public void testGetTileSizeByPixel (){
        int tilesizebypixel=83;
        int truetilesizebypixel= Board.getTilesizebypixel();
        Assert.assertEquals(tilesizebypixel,truetilesizebypixel);

    }

    @Test
    public void testPiecesNumber() {
        Assert.assertEquals(board_real.pieceList.size(), 32);

    }

    /*@BeforeEach
    void setUp() {
        System.setProperty("key", "value");

        board = new Board(new notationPanel(), "Player1", "Player2");
    }*/


    @Test
    public void testPaintBoard() { //GEÇTİ

        BufferedImage image = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        board_real.paintBoard(g2d);
        Color color = new Color(image.getRGB(0, 0));

        Assert.assertEquals(new Color(247, 213, 168), color);// Assert that the color matches the expected color for the first cell

    }

    //test çalışıyor ama false döndürüyor ?? resimler birbirinin aynısı
    @Test
    public void testDrawPieces() {

        Board board = new Board(null, null, null);
        board.initializePieces();
        BufferedImage boardImage = new BufferedImage(
                Board.columnNumber * Board.getTilesizebypixel(),
                Board.rowNumber * Board.getTilesizebypixel(),
                BufferedImage.TYPE_INT_ARGB);

        Graphics g = boardImage.getGraphics();
        board.paintComponent(g);
        g.dispose();

        BufferedImage paintedBoardImage = boardImage.getSubimage(0, 0, Board.getTilesizebypixel(), Board.getTilesizebypixel());

        try {
            BufferedImage allPiecesImage = ImageIO.read(getSystemResourceAsStream("src/View/pieces.png"));
            int pieceWidth = allPiecesImage.getWidth() / 6; // There are 6 pieces in a row
            int pieceHeight = allPiecesImage.getHeight() / 2; // There are 2 rows for each color
            Image scaledInstance = allPiecesImage.getSubimage(0, 0, pieceWidth, pieceHeight)
                    .getScaledInstance(Board.getTilesizebypixel(), Board.getTilesizebypixel(), Image.SCALE_SMOOTH);

            BufferedImage expectedRookImage = new BufferedImage(Board.getTilesizebypixel(), Board.getTilesizebypixel(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = expectedRookImage.createGraphics();
            g2d.drawImage(scaledInstance, 0, 0, null);
            g2d.dispose();

            //BufferedImage expectedRookImage = (BufferedImage) allPiecesImage.getSubimage(0, 0, pieceWidth, pieceHeight).getScaledInstance(Board.getTilesizebypixel(), Board.getTilesizebypixel(), Image.SCALE_SMOOTH);
            Assert.assertEquals(true,imagesAreEqual(expectedRookImage, paintedBoardImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean imagesAreEqual(BufferedImage img1, BufferedImage img2) {
        // Check if the dimensions are the same
        if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
            return false;
        }

        // Check pixel by pixel if the RGB values are the same
        for (int x = 0; x < img1.getWidth(); x++) {
            for (int y = 0; y < img1.getHeight(); y++) {
                if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                    return false;
                }
            }
        }

        return true;
    }
//    private boolean imagesAreEqual(BufferedImage img1, BufferedImage img2) {
//        // Check if the dimensions are the same
//        if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
//            return false;
//        } else {
//            long difference = 0;
//            // Check pixel by pixel if the RGB values are the same
//            for (int y = 0; y < img1.getHeight(); y++) {
//                for (int x = 0; x < img1.getWidth(); x++) {
//                    int rgbA = img1.getRGB(x, y);
//                    int rgbB = img2.getRGB(x, y);
//                    int redA = (rgbA >> 16) & 0xff;
//                    int greenA = (rgbA >> 8) & 0xff;
//                    int blueA = (rgbA) & 0xff;
//                    int redB = (rgbB >> 16) & 0xff;
//                    int greenB = (rgbB >> 8) & 0xff;
//                    int blueB = (rgbB) & 0xff;
//                    difference += Math.abs(redA - redB);
//                    difference += Math.abs(greenA - greenB);
//                    difference += Math.abs(blueA - blueB);
//                }
//            }
//            double total_pixels = img1.getWidth() * img2.getHeight() * 3;
//            double avg_different_pixels = difference / total_pixels;
//            double percentage= (avg_different_pixels / 255) * 100;
    //         return percentage <= 1;



    @Test
    public void testAddManyMoveNotations() {
        notationPanel notationPanel = new notationPanel("Player1", "Player2");

        for (int i = 0; i < 100; i++) {
            notationPanel.addMoveNotation("Move" + i);
        }

        String actualText = notationPanel.getNotationTextArea().getText();

        String expectedLastMove = "Player2: Move99\n";
        Assert.assertTrue(actualText.contains(expectedLastMove));
    //T-SRS-CheT-004
    }
    
    @Test
    public void testHighlightValidPositions() {

        Piece pawn = board_real.getPiece(1, 1);
        Assert.assertNotNull(pawn);
        
        Input input = new Input(board_real);

        MouseEvent mousePressedEvent = new MouseEvent(board_real, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0,
        			Board.getTilesizebypixel(), Board.getTilesizebypixel(), 0, false);
        
        input.mousePressed(mousePressedEvent);
        
        Color highlightedSquareColor = board_real.getSquareColor(2 * Board.getTilesizebypixel(), 1 * Board.getTilesizebypixel());
        
        Assert.assertEquals(new Color(82, 252, 3, 80), highlightedSquareColor);

    }


    @Test
    public void testManual(){
        Board b = new Board(null,null,null);
        Assert.assertTrue(b.isVisible());
    }



    
}




