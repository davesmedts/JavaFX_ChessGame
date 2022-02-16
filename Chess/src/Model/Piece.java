package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Piece {
    private Color color;
    private Square startPosition;
    private Square endPosition;
    private List<Square> moves;
    private boolean isCaptured;


    private List<Piece> blackPieces = new ArrayList<>(); // volgens mij hebben we dit nodig voor onze getPiece
    private List<Piece> whitePieces = new ArrayList<>(); // volgens mij hebben we dit nodig voor onze getPiece

    public Piece(Color color, Square startPosition) {
        this.color = color;
        this.startPosition = startPosition;
    }


    public void addList(Piece piece) {
        if (piece.color == Color.valueOf("white")) {
            whitePieces.add(piece);
        } else {
            blackPieces.add(piece);
        }
    } // Hoe kunnen we die pieces het best toevoegen aan dieje list? Want zonder dieje list kunnen wij die pieces toch niet getten?

    public Color getColor() {
        return color;
    } // getting the color attribute of a Piece, need it for the comparison black-white piece

    public Square[] getValidMoves() {
        return new Square[0];
    }

    public boolean Move(Square targetSquare) {
        List<Square> validMoves = Arrays.asList(getValidMoves());
        if (validMoves.contains(targetSquare)) {
            endPosition = targetSquare;
            moves.add(targetSquare);
            return true;
        }
        return false;
    }


    public Boolean getPiece(Square startPos, Square endPosition, Color color) {
        if (color == Color.valueOf("white")) {
            for (int i = 0; i < whitePieces.size(); i++) {
                Piece piece = whitePieces.get(i);
                if (piece.startPosition == endPosition) {
                    return true;

                } //we will loop and compare first the color of the piece and then the startposition of the piece.
            }
        } else {
            for (int i = 0; i < blackPieces.size(); i++) {
                Piece piece = blackPieces.get(i);
                if (piece.startPosition == endPosition) {
                    return true;
                }
            }
        }

         /* for (int i = 0; i < whitePieces.size(); i++) {
            Piece piece = whitePieces.get(i);
            if (piece.startPosition == ) { //geen flauw idee wat ik moet doen om al de tussenwaardes van een de huidigeMove te bekomen. Ik denk toch dat een move klasse wel handig is. Want een move klassen kan dan in een list al de mogelijke tussenwaardes opslagen en die kan ik hier dan aanroepen
                return true;

            } //we will loop and compare first the color of the piece and then the startposition of the piece.
        } */


        return false;
    }
}
