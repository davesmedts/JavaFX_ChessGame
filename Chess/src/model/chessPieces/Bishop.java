package model.chessPieces;

import model.Board;
import model.Color;
import model.Player;
import model.Square;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bishop extends Piece {

    public Bishop(Color color, Square startPosition) {
        super(color, startPosition);
    } //Constructor to create a bishop piece, constructor calls the constructor of the superclass Piece

    public List<Square> getValidMoves(Board gameBoard, Player opponent) {
        List<Square> possibleSquares = new ArrayList<>();

        if (super.getPosition() == null) {
            return possibleSquares;
        }

        //        get the current row and column of the piece that has to move
        char column = super.getPosition().getColumnLetter();
        int row = super.getPosition().getRowNumber();

//        north-east
        for (int i = 1; i < 8; i++) {
            int newRow = row + i;
            char newColumn = (char) (column + i);

            if (newRow <= 8 && newColumn < 65 + 8) {
                Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
                Piece moveSquareContent = moveSquare.getSquareContent();
                if (moveSquareContent == null) {
                    possibleSquares.add(moveSquare);
                } else if (moveSquareContent.getColor() != super.getColor()) {
                    possibleSquares.add(moveSquare);
                    break;
                } else {
                    break;
                }
            }
        }
//        north-west
        for (int i = 1; i < 8; i++) {
            int newRow = row + i;
            char newColumn = (char) (column - i);
            if (newRow <= 8 && newColumn >= 65) {
                Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
                Piece moveSquareContent = moveSquare.getSquareContent();
                if (moveSquareContent == null) {
                    possibleSquares.add(moveSquare);
                } else if (moveSquareContent.getColor() != super.getColor()) {
                    possibleSquares.add(moveSquare);
                    break;
                } else {
                    break;
                }
            }
        }
//        south-east
        for (int i = 1; i < 8; i++) {
            int newRow = row - i;
            char newColumn = (char) (column + i);
            if (newRow > 0 && newColumn < 65 + 8) {
                Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
                Piece moveSquareContent = moveSquare.getSquareContent();
                if (moveSquareContent == null) {
                    possibleSquares.add(moveSquare);
                } else if (moveSquareContent.getColor() != super.getColor()) {
                    possibleSquares.add(moveSquare);
                    break;
                } else {
                    break;
                }
            }
        }
//        south-west
        for (int i = 1; i < 8; i++) {
            int newRow = row - i;
            char newColumn = (char) (column - i);
            if (newRow > 0 && newColumn >= 65) {
                Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
                Piece moveSquareContent = moveSquare.getSquareContent();
                if (moveSquareContent == null) {
                    possibleSquares.add(moveSquare);
                } else if (moveSquareContent.getColor() != super.getColor()) {
                    possibleSquares.add(moveSquare);
                    break;
                } else {
                    break;
                }
            }
        }

        return possibleSquares;
    }
}
