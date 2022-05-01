package model.chessPieces;

import model.Board;
import model.Color;
import model.Player;
import model.Square;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight(Color color, Square startPosition) {
        super(color, startPosition);
    }

    public List<Square> getValidMoves(Board gameBoard, Player opponent) {
        List<Square> possibleSquares = new ArrayList<>();

        if (super.getPosition() == null) {
            return possibleSquares;
        }

//        get the current row and column of the piece that has to move
        char column = super.getPosition().getColumnLetter();
        int row = super.getPosition().getRowNumber();
//        A knight always first moves 2 squares and the takes a turn of one square. You need to read the comments below as"move <2squares> <1square>"
//        move north-west
        if (row + 2 <= 8 && column - 1 >= 65) { // check if target is whithin the scope of the board.
            int newRow = row + 2;
            char newColumn = (char) (column - 1);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//         move north-east
        if (row + 2 <= 8 && column + 1 < 65 + 8) {
            int newRow = row + 2;
            char newColumn = (char) (column + 1);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//         move southWest
        if (row - 2 >= 1 && column - 1 >= 65) {
            int newRow = row - 2;
            char newColumn = (char) (column - 1);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//         move southEast
        if (row - 2 >= 1 && column + 1 < 65 + 8) {
            int newRow = row - 2;
            char newColumn = (char) (column + 1);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//        move nortEast (left up)
        if (row + 1 <= 8 && column - 2 >= 65) {
            int newRow = row + 1;
            char newColumn = (char) (column - 2);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//        move SouthEast(left down)
        if (row - 1 >= 1 && column - 2 >= 65) {
            int newRow = row - 1;
            char newColumn = (char) (column - 2);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//        move north east (right up)
        if (row + 1 <= 8 && column + 2 < 65 + 8) {
            int newRow = row + 1;
            char newColumn = (char) (column + 2);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//        move southEast(right down)
        if (row - 1 >= 1 && column + 2 < 65 + 8) {
            int newRow = row - 1;
            char newColumn = (char) (column + 2);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
        return possibleSquares;
    }
    @Override
    public String log() {
        return String.format("%s-%s", this.getClass().getSimpleName(), super.getColor());
    }


}
