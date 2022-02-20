package Model;

import Model.ChessPieces.*;

import java.util.Objects;

public class Square implements Comparable<Square> {
    private final int rowNumber;
    private final char columnLetter;
    private Piece squareContent;

    public Square(int rowNumber, char columnLetter) {
        this.rowNumber = rowNumber;
        this.columnLetter = columnLetter;
    }

//    will be used when a Piece is moved in the game, to keep track of which specific piece is on this square.
    public void setSquareContent(Piece squareContent) {
        this.squareContent = squareContent;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public char getColumnLetter() {
        return columnLetter;
    }

    public Piece getSquareContent() {
        return squareContent;
    }

    @Override
    public int compareTo(Square o) {
        if (columnLetter == o.columnLetter) {
            return Character.compare(columnLetter, o.columnLetter);
        } else {
            return Integer.compare(rowNumber, o.rowNumber);
        }
    }

//    a Square is equal to another square when both columnLetter and rowNumber have a match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return rowNumber == square.rowNumber && columnLetter == square.columnLetter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowNumber, columnLetter);
    }

    public String toString() {
////        only for testing, definitive code is to uncommented after testing
//        return String.format("%s%d", columnLetter, rowNumber);

//        depending on the type of Piece a different output must show.
//        if emty a dash is shown on the console
        String value;
        if (squareContent instanceof King) {
            value = "K";
        } else if (squareContent instanceof Pawn) {
            value = "P";
        } else if (squareContent instanceof Rook) {
            value = "R";
        } else if (squareContent instanceof Queen) {
            value = "Q";
        } else if (squareContent instanceof Bishop) {
            value = "B";
        } else if (squareContent instanceof Knight) {
            value = "H";
        } else {
            value = "-";
        }
        return value;

    }
}

