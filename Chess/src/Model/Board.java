package Model;

import java.util.Set;
public class Board {
    private final int numberOfRows = 8;
    private final int numberOfColumns = 8;

    Set<Square> squareSet;

    public Board() {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                char columnLetter = (char) (65 + i); //ASCII code gebruiken om int naar char om te zetten
                int rowNumber = i + 1;
                squareSet.add(new Square(rowNumber, columnLetter));
            }
        }
    }


}
