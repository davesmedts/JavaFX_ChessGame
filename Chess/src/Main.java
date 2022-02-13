/**
 * @author Dave Smedts
 * @version 1.0 1/02/2022 23:14
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        System.out.println("Deef is Deef");

    }

    private void fillColumnsAndRows() {
        for (int i = 0; i < columns.length; i++) {
            char rowLetter = (char)(65 + i); //ASCII code gebruiken om int naar char om te zetten
            columns[i] = rowLetter;
            rows[i] = i +1;
        }
    }


}
