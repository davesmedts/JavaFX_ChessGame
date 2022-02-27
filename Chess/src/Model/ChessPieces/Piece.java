package Model.ChessPieces;

import Model.Color;
import Model.Square;

import java.util.*;

public class Piece {
    private Color color;
    private Square position;
    private List<Square> moves;
    private boolean isCaptured;


//    private List<Piece> blackPieces = new ArrayList<>(); // volgens mij hebben we dit nodig voor onze getPiece --> list
//    private List<Piece> whitePieces = new ArrayList<>(); // volgens mij hebben we dit nodig voor onze getPiece

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

    public Square getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public void setPosition(Square position) {
        this.position = position;
    }

    public void capturePiece(){
        isCaptured = true;
        position = null; // value for captured pieces
    }

    //    public Boolean getPiece(Square startPos, Square endPosition, Color color) {
//        if (color == Color.valueOf("white")) {
//            for (int i = 0; i < whitePieces.size(); i++) {
//                Piece piece = whitePieces.get(i);
//                if (piece.startPosition == endPosition) {
//                    return true;
//
//                } //we will loop and compare first the color of the piece and then the startposition of the piece.
//            }
//        } else {
//            for (int i = 0; i < blackPieces.size(); i++) {
//                Piece piece = blackPieces.get(i);
//                if (piece.startPosition == endPosition) {
//                    return true;
//                }
//            }
//        }
//
//         /* for (int i = 0; i < whitePieces.size(); i++) {
//            Piece piece = whitePieces.get(i);
//            if (piece.startPosition == ) { //geen flauw idee wat ik moet doen om al de tussenwaardes van een de huidigeMove te bekomen. Ik denk toch dat een move klasse wel handig is. Want een move klassen kan dan in een list al de mogelijke tussenwaardes opslagen en die kan ik hier dan aanroepen
//                return true;
//
//            } //we will loop and compare first the color of the piece and then the startposition of the piece.
//        } */
//
//
//        return false;
//    }
}
