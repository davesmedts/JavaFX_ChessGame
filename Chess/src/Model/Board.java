package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private final int NUMBER_OF_ROWS = 8;
    private final int NUMBER_OF_COLUMNS = 8;
    private MovesValidator movesValidator;

    List<Square> squares;

    public Board() {
        squares = new ArrayList<Square>();
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = NUMBER_OF_COLUMNS-1; j >= 0; j--) {
                char columnLetter = (char) (65 + j); //ASCII code gebruiken om int naar char om te zetten
                int rowNumber = i + 1;
                squares.add(new Square(rowNumber, columnLetter));
            }
        }

    }

    // create movesValidator object and set this movesValidator attribute
    public MovesValidator createMovesValidator() {
        this.movesValidator = new MovesValidator();
        this.movesValidator.setSquares(squares); // set the squares of the movesValidator object

        return this.movesValidator;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Collections.reverse(squares);
        int rowNumber = 8;
        for (int i = 0; i < squares.size(); i++) {
            if (i % 8 == 0) {
                builder.append("\n"); // After printing 8 squares we need to start a new line.
                builder.append(rowNumber).append(String.format("%3s", squares.get(i))); // new line start with the specific rowNumber
                rowNumber--; // update on which rowNumber we are printing
            } else {
                builder.append(String.format("%3s", squares.get(i)));
            }
        }
        builder.append("\n   ");
//        print out the column labels on the screen
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            char columnLetter = (char) (65 + i);
            builder.append(columnLetter + "  ");
        }
        return builder.toString();
    }

    public List<Square> getSquares() {
        return squares;
    }

    public static void main(String[] args) {
        Board gameBoard = new Board();
        System.out.println(gameBoard);
    }
}