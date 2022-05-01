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

    @Override
    public List<Square> getValidMoves(Board gameBoard, Player opponent) {
        List<Square> possibleSquares = new ArrayList<>();

        List<Square> north = new ArrayList<>();
        List<Square> south = new ArrayList<>();
        List<Square> west = new ArrayList<>();
        List<Square> east = new ArrayList<>();
        List<Square> northEast = new ArrayList<>();
        List<Square> northWest = new ArrayList<>();
        List<Square> southEast = new ArrayList<>();
        List<Square> southWest = new ArrayList<>();

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
            if (newRow <= 8 && newColumn < 65 + 8)
                northEast.add(new Square(newRow, newColumn));
        }
//        north-west
        for (int i = 1; i < 8; i++) {
            int newRow = row + i;
            char newColumn = (char) (column - i);
            if (newRow <= 8 && newColumn >= 65)
                northWest.add(new Square(newRow, newColumn));
        }
//        south-east
        for (int i = 1; i < 8; i++) {
            int newRow = row - i;
            char newColumn = (char) (column + i);
            if (newRow > 0 && newColumn < 65 + 8)
                southEast.add(new Square(newRow, newColumn));
        }
//        south-west
        for (int i = 1; i < 8; i++) {
            int newRow = row - i;
            char newColumn = (char) (column - i);
            if (newRow > 0 && newColumn >= 65)
                southWest.add(new Square(newRow, newColumn));
        }

        return possibleSquares;
    }

    @Override
    public String log() {
        return String.format("%s-%s", this.getClass().getSimpleName(), super.getColor());
    }
}
