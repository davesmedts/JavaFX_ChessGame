package Model;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dave Smedts
 * @version 1.0 1/02/2022 23:15
 */
public class Piece {
    private Color color;
    private Square startPosition;
    private Square position;
//    private int moveCount; Dit attribuut kan weg volgens mij, als we de lengte van de "List<Square> moves;" gebruiken om te bepalen of bv een koning al verplaatst is of niet.
    private List<Square> moves;
    private boolean isCaptured;


    public Square[] getValidMoves(){

    }

    public boolean Move(Square targetSquare){
        List<Square> validMoves = Arrays.asList(getValidMoves());
        if(validMoves.contains(targetSquare)){
            position = targetSquare;
            moves.add(targetSquare);
            return true;
        } return false;
    }

}
