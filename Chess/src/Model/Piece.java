package Model;

import java.util.Arrays;
import java.util.List;

public class Piece {
    private Color color;
    private Square startPosition;
    private Square endPosition;
    private List<Square> moves;
    private boolean isCaptured;

    public Piece(Color color, Square startPosition) {
        this.color = color;
        this.startPosition = startPosition;
    }

    public Color getColor() {
        return color;
    } // getting the color attribute of a Piece, need it for the comparison black-white piece

    public Square[] getValidMoves(){
        return new Square[0];
    }

    public boolean Move(Square targetSquare){
        List<Square> validMoves = Arrays.asList(getValidMoves());
        if(validMoves.contains(targetSquare)){
            endPosition = targetSquare;
            moves.add(targetSquare);
            return true;
        } return false;
    }

    public boolean getPiece(Square endPosition, Color color){

        if(endPosition ==  )
        return ;
    }

}
