package Model;

/**
 * @author Dave Smedts
 * @version 1.0 1/02/2022 23:15
 */
public class Board {
    private char[] columns = new char[8];
    private int[] rows = new int[8];

    private void fillColumnsAndRows() {
        for (int i = 0; i < columns.length; i++) {
            char rowLetter = (char)(65 + i); //ASCII code gebruiken om int naar char om te zetten
            columns[i] = rowLetter;
            rows[i] = i +1;
        }
    }


}
