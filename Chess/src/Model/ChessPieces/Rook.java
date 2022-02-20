package Model.ChessPieces;


import Model.Color;
import Model.Square;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    //Constructor to create a rook piece, constructor calls the constructor of the superclass Piece
    public Rook(Color color, Square startPosition) {
        super(color, startPosition);
    }

    @Override
    public List<Square> getValidMoves() {
        List<Square> validSquares = new ArrayList<>();

        List<Square> north = new ArrayList<>();
        List<Square> south = new ArrayList<>();
        List<Square> west = new ArrayList<>();
        List<Square> east = new ArrayList<>();
        List<Square> ne = new ArrayList<>();
        List<Square> nw = new ArrayList<>();
        List<Square> se = new ArrayList<>();
        List<Square> sw = new ArrayList<>();

//        vertical moves
        for (int i = 1; i <= 8; i++) {
            char column = super.getPosition().getColumnLetter();
            int row = i;
            validSquares.add(new Square(row, column));
        }
//        Because we added the piece his current positions as well we need to delete this from the validsquares list
        validSquares.remove(super.getPosition());
//        horizontal moves
        for (int i = 1; i <= 65+8; i++) {
            char column = (char) (65 + i);
            int row = super.getPosition().getRowNumber();
            validSquares.add(new Square(row, column));
        }
//        Because we added the piece his current positions as well we need to delete this from the validsquares list
        validSquares.remove(super.getPosition());

        return validSquares;
    }
    //    public Square[] getPossibleMoves(Square endPosition) {
//
//
//        // er mag geen eigen piece op de plek staan waar we heen willen
////        Boolean possiblePiece = getPiece(endPosition);
////        if (possiblePiece) {
////            System.out.println("No valid move, already a piece of your color is on that space"); // kunnen dit mss cleaner oplossen met een exception?
////        } else if (possiblePiece){
////
////            Boolean possiblePieceBetween = getPiece(startPosition,endPosition, piece.getColor());
////
////        }
//        //code schrijven om de rook horizontaal en verticaal te laten bewegen
//        //code schrijven om rook niet over eigen pieces te laten springen
//
//
//        return new Square[0];
//
//    } //We calculate every valid move for the rook, by doing a constructor overload
}
