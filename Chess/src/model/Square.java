package model;

import model.chessPieces.*;

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
        return String.format("%s%d", columnLetter, rowNumber);
    }

    public String getBoardView() {
//        depending on the type of Piece a different output must show.
//        if empty a dash is shown on the console
        String value;
        if (squareContent instanceof King && squareContent.getColor() == Color.WHITE) {
            value = "K";
        } else if (squareContent instanceof Pawn && squareContent.getColor() == Color.WHITE) {
            value = "P";
        } else if (squareContent instanceof Rook && squareContent.getColor() == Color.WHITE) {
            value = "R";
        } else if (squareContent instanceof Queen && squareContent.getColor() == Color.WHITE) {
            value = "Q";
        } else if (squareContent instanceof Bishop && squareContent.getColor() == Color.WHITE) {
            value = "B";
        } else if (squareContent instanceof Knight && squareContent.getColor() == Color.WHITE) {
            value = "H";
        } else if (squareContent instanceof King && squareContent.getColor() == Color.BLACK) {
            value = "k";
        } else if (squareContent instanceof Pawn && squareContent.getColor() == Color.BLACK) {
            value = "p";
        } else if (squareContent instanceof Rook && squareContent.getColor() == Color.BLACK) {
            value = "r";
        } else if (squareContent instanceof Queen && squareContent.getColor() == Color.BLACK) {
            value = "q";
        } else if (squareContent instanceof Bishop && squareContent.getColor() == Color.BLACK) {
            value = "b";
        } else if (squareContent instanceof Knight && squareContent.getColor() == Color.BLACK) {
            value = "h";
        } else {
            value = "-";
        }
        return value;

    }

    public String log() {
        StringBuilder builder = new StringBuilder();
        if (squareContent != null) {

            builder.append(String.format("%s: %s", this, this.squareContent.log()));
        } else {
            builder.append(String.format("%s: %s", this, null));

        }
        return builder.toString();
    }
}
