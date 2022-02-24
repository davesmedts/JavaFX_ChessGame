package Model;

import Model.ChessPieces.Pawn;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestDave {
    public static void main(String[] args) {
//        Player dave = new Player("Dave");
//        Player mattia = new Player("mattia");
//
//        Game chessGame = new Game(dave, mattia);
//
//        System.out.println(chessGame.getGameBoard());
//
//        dave.selectPiece();
//
//        System.out.println(chessGame.getGameBoard());

        Pawn pawn = new Pawn(Color.WHITE, new Square(2, 'A'));
        Map<String, List<Square>> possibleMoves = pawn.getValidMoves();
        for (List<Square> direction : possibleMoves.values()) {
            System.out.println(direction);
        }
    }

}
