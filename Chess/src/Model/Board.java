package Model;

import java.util.Set;
import java.util.TreeSet;

public class Board {
    private final int NUMBER_OF_ROWS = 8;
    private final int NUMBER_OF_COLUMNS = 8;

    Set<Square> squareSet;

    public Board() {
        squareSet = new TreeSet<>();
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                char columnLetter = (char) (65 + j); //ASCII code gebruiken om int naar char om te zetten
                int rowNumber = i + 1;
                squareSet.add(new Square(rowNumber, columnLetter));
            }
        }
    }


    public static void main(String[] args) {
        Board gameBoard = new Board();
        for (Square square : gameBoard.squareSet) {
            System.out.println(square);
        }
    }


}
