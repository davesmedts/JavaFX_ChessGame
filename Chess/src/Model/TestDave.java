package Model;

import java.util.Scanner;

public class TestDave {
    public static void main(String[] args) {
        Player dave = new Player("Dave");
        Player mattia = new Player("mattia");

        Game chessGame = new Game(dave, mattia);

        System.out.println(chessGame.getGameBoard());

        dave.selectPiece();

        System.out.println(chessGame.getGameBoard());



    }
}
