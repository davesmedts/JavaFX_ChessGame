package Model;

import java.time.LocalDateTime;
import java.util.Random;

public class Game {
    private Player blackPlayer;
    private Player whitePlayer;
    private Board gameBoard;
    private Color turn;
    private LocalDateTime startTime;
    private LocalDateTime stopTime;
    private Player winner;

    //constructor
    public Game(Player playerOne, Player playerTwo) {
        Random rd = new Random();
        boolean playerOneIsBlack = rd.nextBoolean(); // creating Random boolean
        if(playerOneIsBlack){
            blackPlayer = playerOne;
            whitePlayer = playerTwo;
        } else {
            blackPlayer = playerTwo;
            whitePlayer = playerOne;
        }
        gameBoard = new Board();
        blackPlayer.setGameBoard(gameBoard);
        blackPlayer.setGameBoard(gameBoard);
        turn = Color.WHITE;
        startTime = LocalDateTime.now();

        whitePlayer.setColor(Color.WHITE);
        whitePlayer.initializePieces();
        blackPlayer.setColor(Color.BLACK);
        blackPlayer.initializePieces();
    }

    public void setStopTime(LocalDateTime stopTime) {
        this.stopTime = stopTime;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Board getGameBoard() {
        return gameBoard;
    }
}
