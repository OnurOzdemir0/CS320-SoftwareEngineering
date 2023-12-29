package src.test;
import org.junit.Assert;
import org.junit.Test;
import src.Model.Piece;
import src.View.Board;

import src.Controller.*;

import java.awt.event.MouseEvent;

public class InputTest {
    @Test
    public void testMousePressed() {
        Board board = new Board();
        Input input = new Input(board);

        int mouseX = 100;
        int mouseY = 100;
        int expectedCol = 3;
        int expectedRow = 3;

        input.mousePressed(new MouseEvent(
                null, MouseEvent.MOUSE_PRESSED, 0, 0, mouseX, mouseY, 0, false));

        // Assert the results
        Assert.assertEquals(expectedCol, board.selectedPiece.getCol());
        Assert.assertEquals(expectedRow, board.selectedPiece.getRow());
    }

    @Test
    public void testMouseReleased() {
        Board board = new Board();
        Input input = new Input(board);

        int mouseX = 200;
        int mouseY = 200;
        int expectedCol = 6;
        int expectedRow = 6;


        board.selectedPiece = new Piece(expectedCol, expectedRow, true);


        input.mouseReleased(new MouseEvent(
                null, MouseEvent.MOUSE_RELEASED, 0, 0, mouseX, mouseY, 0, false));

        Assert.assertEquals(null, board.selectedPiece);
    }


}
