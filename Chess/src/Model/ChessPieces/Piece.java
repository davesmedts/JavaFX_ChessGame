package Model.ChessPieces;

import Model.Color;
import Model.Square;

import java.util.*;

public class Piece {
    private Color color;
    private Square position;
    private List<Square> moves;
    private boolean isCaptured;



    public Piece(Color color, Square startPosition) {
        this.color = color;
        this.position = startPosition;
        moves = new ArrayList<>();
        isCaptured = false;
    }

    public List<Square> getMoves() {
        return moves;
    }

    public Map<String, List<Square>> getValidMoves() {
        return new HashMap<>();
    }

    public Map<String, List<Square>> getValidMovesPawn(List<Square> squares){
        return new HashMap<>();
    }

    public Square getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public void setMoves(Square square) {
        moves.add(square);
    }

    public void setPosition(Square position) {
        this.position = position;
    }

    public void capturePiece(){
        isCaptured = true;
        position = null; // value for captured pieces
    }
}
