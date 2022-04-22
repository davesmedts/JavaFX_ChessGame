package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ChessGameSaver {
    Board gameBoard;

    public ChessGameSaver(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public static void main(String[] args) {
        FileWriter saveGameWriter = null;
        ChessGameSaver gameSaver = new ChessGameSaver(new Board());
        List<Square> boardSquares = gameSaver.getGameBoard().getSquares();
        try {
            saveGameWriter = new FileWriter("boardSquares.txt");
            for (Square boardSquare : boardSquares) {
                saveGameWriter.write(boardSquare + "," + boardSquare.getSquareContent() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                saveGameWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
