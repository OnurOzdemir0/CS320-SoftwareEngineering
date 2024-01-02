package src.test;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.awt.event.MouseEvent;
import src.Controller.Input;
import src.View.Board;

public class InputTest {

    @Test
    public void testMousePressed() {
        Board board = new Board();
        Input input = new Input(board);

        MouseEvent mousePressedEvent = new MouseEvent(board, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0,
                30, 30, 0, false);
        input.mousePressed(mousePressedEvent);

        Assert.assertEquals(0, input.originalPoint.x);
        Assert.assertEquals(0, input.originalPoint.y);
    }

    @Test
    public void testMouseDragged() {
        Board board = new Board();
        Input input = new Input(board);

        MouseEvent mouseDraggedEvent = new MouseEvent(board, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(), 0,
                50, 50, 0, false);
        input.mouseDragged(mouseDraggedEvent);

        Assert.assertEquals(50, input.draggingPoint.x);
        Assert.assertEquals(50, input.draggingPoint.y);
    }

    @Test
    public void testMouseReleased() {
        Board board = new Board();
        Input input = new Input(board);

        MouseEvent mouseReleasedEvent = new MouseEvent(board, MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(), 0,
                10, 10, 0, true);
        input.mouseReleased(mouseReleasedEvent);

        Assert.assertNull(input.selectedPiece);
        Assert.assertEquals(10, 10);
    }

    @Test
    public void testMouseMoved() {
        Board board = new Board();
        Input input = new Input(board);

        MouseEvent mouseMovedEvent = new MouseEvent(board, MouseEvent.MOUSE_MOVED, System.currentTimeMillis(), 0,
                20, 20, 0, false);
        input.mouseMoved(mouseMovedEvent);

        Assert.assertEquals(20, 20);
    }
}