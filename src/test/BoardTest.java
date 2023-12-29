package src.test;
import org.junit.Assert;
import org.junit.Test;
import src.View.Board;
import java.util.ArrayList;
import src.Model.*;
import src.View.*;
public class BoardTest {

    public boolean testPiecesNumber (ArrayList<Piece>pieceList){
        if(pieceList.size()==32){
            return true ;
        }
        return false ;
    }

}
