package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    }

    public List<Square> getValidMoves() {
        return new ArrayList<>();
    }

    public Square getPosition() {
        return position;
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
