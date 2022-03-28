import Model.Square;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Square> validSquares = new ArrayList<>();
//        vertical moves
        for (int i = 1; i <= 8; i++) {
            char column = 'A';
            int row = i;
            validSquares.add(new Square(row, column));
        }
//        Because we added the piece his current positions as well we need to delete this from the validsquares list
//        validSquares.remove(super.getPosition());
//        horizontal moves
        for (int i = 1; i <= 65+8; i++) {
            char column = (char) (65 + i);
            int row = 1;
            validSquares.add(new Square(row, column));
        }
//        Because we added the piece his current positions as well we need to delete this from the validsquares list
//        validSquares.remove(super.getPosition());

    }

}
