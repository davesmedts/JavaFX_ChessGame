package model.chessPieces;

import model.Board;
import model.Color;
import model.Player;
import model.Square;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    public Queen(Color color, Square startPosition) {
        super(color, startPosition);
    }

    @Override
    public List<Square> getValidMoves(Board gameBoard, Player opponent) {
        List<Square> possibleSquares = new ArrayList<>();

        if (super.getPosition() == null) {
            return possibleSquares;
        }

        //        get the current row and column of the piece that has to move
        char column = super.getPosition().getColumnLetter();
        int row = super.getPosition().getRowNumber();


//        north
//        south
//        east
//        west

        //        north
        for (int i = 1; i < 8; i++) {
            int newRow = row + i;
            char newColumn = column;
            if (newRow <= 8) {
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
//        south
        for (int i = 1; i < 8; i++) {
            int newRow = row - i;
            char newColumn = column;
            if (newRow > 0) {
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
//        east
        for (int i = 1; i < 8; i++) {
            int newRow = row;
            char newColumn = (char) (column + i);
            if (newColumn < 65 + 8) {
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
//        west
        for (int i = 1; i < 8; i++) {
            int newRow = row;
            char newColumn = (char) (column - i);
            if (newColumn >= 65) {
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

    @Override
    public String log() {
        return "[" + String.format("%s, %s", this.getClass().getSimpleName(), super.getColor()) + "]";
    }

}
