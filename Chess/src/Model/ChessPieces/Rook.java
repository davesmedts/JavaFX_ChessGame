package Model.ChessPieces;


import Model.Color;
import Model.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Rook extends Piece {
    //Constructor to create a rook piece, constructor calls the constructor of the superclass Piece
    public Rook(Color color, Square startPosition) {
        super(color, startPosition);
    }

//    @Override
//    public Map<String, List<Square>> getValidMoves() {
//        List<Square> validSquares = new ArrayList<>();
//
//        List<Square> north = new ArrayList<>();
//        List<Square> south = new ArrayList<>();
//        List<Square> west = new ArrayList<>();
//        List<Square> east = new ArrayList<>();
//        List<Square> ne = new ArrayList<>();
//        List<Square> nw = new ArrayList<>();
//        List<Square> se = new ArrayList<>();
//        List<Square> sw = new ArrayList<>();
//
////        vertical moves
//        for (int i = 1; i <= 8; i++) {
//            char column = super.getPosition().getColumnLetter();
//            int row = i;
//            validSquares.add(new Square(row, column));
//        }
////        Because we added the piece his current positions as well we need to delete this from the validsquares list
//        validSquares.remove(super.getPosition());
////        horizontal moves
//        for (int i = 1; i <= 65+8; i++) {
//            char column = (char) (65 + i);
//            int row = super.getPosition().getRowNumber();
//            validSquares.add(new Square(row, column));
//        }
////        Because we added the piece his current positions as well we need to delete this from the validsquares list
//        validSquares.remove(super.getPosition());
//
//        return validSquares;
//    }
//
}
