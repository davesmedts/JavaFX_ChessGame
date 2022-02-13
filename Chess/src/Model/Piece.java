package Model;

import java.util.Arrays;
import java.util.List;

public class Piece {
    private Color color;
    private Square startPosition;
    private Square position;
    private List<Square> moves;
    private boolean isCaptured;

    public Piece(Color color, Square startPosition) {
        this.color = color;
        this.startPosition = startPosition;
    }

    public Square[] getValidMoves(){
        return new Square[0];
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
