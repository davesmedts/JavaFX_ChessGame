package Model;

import java.util.Objects;

public class Square implements Comparable<Square>{
    private int rowNumber;
    private char columnLetter;
    private SquareContent squareContent;

    public Square(int rowNumber, char columnLetter) {
        this.rowNumber = rowNumber;
        this.columnLetter = columnLetter;
        this.squareContent = SquareContent.EMPTY;
    }

    public enum SquareContent{
        EMPTY, KING, QUEEN, PAWN, BISHOP, KNIGHT, ROOK;
    }

    @Override
    public int compareTo(Square o) {
        if (columnLetter == o.columnLetter){
            return Integer.compare(rowNumber, o.rowNumber);
        } else {
            return Character.compare(columnLetter, o.columnLetter);
        }
    }

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

    public String toString(){
        String value;
        switch (squareContent){
            case KING: value="K"; break;
            case PAWN: value = "P"; break;
            case ROOK: value = "R"; break;
            case QUEEN: value = "Q"; break;
            case BISHOP: value =  "B"; break;
            case KNIGHT: value =  "H"; break;
            default: value = "-"; break;
        }
        return value;
    }
}
