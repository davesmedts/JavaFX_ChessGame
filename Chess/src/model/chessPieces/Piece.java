package model.chessPieces;

import model.Board;
import model.Color;
import model.Player;
import model.Square;

import java.util.*;

public abstract class Piece {
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

    public abstract List<Square> getValidMoves(Board gameBoard, Player opponent);

    public Map<String, List<Square>> getValidMovesPawn(List<Square> squares){ //moet vervangen worden door getValidMoves in de subklasse Pawn
        return new HashMap<>();
    }

    public Square getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public void addMove(Square square) {
        moves.add(square);
    }

    public void setPosition(Square position) {
        this.position = position;
    }

    public void capturePiece(){
        isCaptured = true;
        position = null; // value for captured pieces
    }

    public abstract String log();
}
