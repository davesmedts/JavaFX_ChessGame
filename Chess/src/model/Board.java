package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int NUMBER_OF_ROWS = 8;
    private final int NUMBER_OF_COLUMNS = 8;
    private MovesValidator movesValidator;

    List<Square> squares;

    public Board() {
        squares = new ArrayList<>();
        for (int i = NUMBER_OF_ROWS; i > 0; i--) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                char columnLetter = (char) (65 + j); //ASCII code gebruiken om int naar char om te zetten
                int rowNumber = i;
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
        int rowNumber = 8;
        for (int i = 0; i < squares.size(); i++) {
            if (i % 8 == 0) {
                builder.append("\n"); // After printing 8 squares we need to start a new line.
                builder.append(rowNumber).append(String.format("%3s", squares.get(i).getBoardView())); // new line start with the specific rowNumber
                rowNumber--; // update on which rowNumber we are printing
            } else {
                builder.append(String.format("%3s", squares.get(i).getBoardView()));
            }
        }
        builder.append("\n   ");
//        print out the column labels on the screen
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            char columnLetter = (char) (65 + i);
            builder.append(columnLetter).append("  ");
        }
        return builder.toString();
    }

    public List<Square> getSquares() {
        return squares;
    }

    public Square lookupSquare(char columnLetter, int rowNumber) {
        Square matchedSquare = null;
        for (Square square : squares) {
            if (columnLetter == square.getColumnLetter() && rowNumber == square.getRowNumber()) {
                matchedSquare = square;
            }
        }
        return matchedSquare;
    }

    public String log(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < squares.size(); i++) {
            builder.append(squares.get(i).log());
            if (i <squares.size()-1){
                builder.append(",");
            }
        }
        return builder.toString();
    }
}