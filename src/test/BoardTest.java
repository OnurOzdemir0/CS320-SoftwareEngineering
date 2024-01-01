package src.test;
import org.junit.Test;
import src.View.Board;

import static java.lang.ClassLoader.getSystemResourceAsStream;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import src.Controller.Input;
import src.Model.*;
import org.junit.Assert;

public class BoardTest {

    //private Board board;
    private Board board_real=new Board(null,null,null);
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

    	Assert.assertEquals(board_real.pieceList.size(),initialSetup.size()); 

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
    public void testPiecesNumber() {
    	Assert.assertEquals(board_real.pieceList.size(),32); 

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


    @Test
    public void testDrawPieces() throws IOException {
    	
    	 BufferedImage actualRookImage = new BufferedImage(
         Board.columnNumber * Board.getTilesizebypixel(),
         Board.rowNumber * Board.getTilesizebypixel(),
         BufferedImage.TYPE_INT_ARGB);

         Graphics g = actualRookImage.getGraphics();
         board_real.drawPieces(g);
         g.dispose();

     
        Piece black_rook = board_real.getPiece(0, 0);
        
        BufferedImage allPiecesImage = ImageIO.read(getSystemResourceAsStream("src/View/pieces.png"));
		int pieceWidth = allPiecesImage.getWidth() / 6; // There are 6 pieces in a row
		int pieceHeight = allPiecesImage.getHeight() / 2; // There are 2 rows for each color
		
		BufferedImage expectedRookImage = allPiecesImage.getSubimage(0, 0, pieceWidth, pieceHeight);
 

        // Assert that the two images are the same
        Assert.assertTrue(imagesAreEqual(expectedRookImage, actualRookImage));

		BufferedImage pieceImage = allPiecesImage.getSubimage(0, 0, pieceWidth, pieceHeight);
		
        Image black_rook_image = black_rook.getPieceImage().getScaledInstance(Board.getTilesizebypixel(), Board.getTilesizebypixel(), Image.SCALE_SMOOTH);
        

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


}
