package Model;

/**
 * @author Dave Smedts
 * @version 1.0 9/02/2022 22:37
 */
public class Square implements Comparable<Square>{
    private int rowNumber;
    private char columnLetter;

    public Square(int rowNumber, char columnLetter) {
        this.rowNumber = rowNumber;
        this.columnLetter = columnLetter;
    }

    @Override
    public int compareTo(Square o) {
        if (columnLetter == o.columnLetter){
            return Integer.compare(rowNumber, o.rowNumber);
        } else {
            return Character.compare(columnLetter, o.columnLetter);
        }
    }

    public String toString(){
        return "X";
    }
}
