package Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int NUMBER_OF_ROWS = 8;
    private final int NUMBER_OF_COLUMNS = 8;

    List<Square> squares;

    public Board() {
        squares = new ArrayList<Square>();
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                char columnLetter = (char) (65 + j); //ASCII code gebruiken om int naar char om te zetten
                int rowNumber = i + 1;
                squares.add(new Square(rowNumber, columnLetter));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int rowNumber = 1;
        for (int i = 0; i < squares.size(); i++) {
            if (i % 8 == 0) {
                builder.append("\n");
                builder.append(rowNumber).append(String.format("%3s", squares.get(i)));
                rowNumber++;
            } else {
                builder.append(String.format("%3s", squares.get(i)));
            }
        }
        builder.append("\n   ");
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            char columnLetter = (char) (65 + i);
            builder.append(columnLetter + "  ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Board gameBoard = new Board();
        System.out.println(gameBoard);
    }
}