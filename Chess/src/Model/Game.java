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
        turn = Color.WHITE;
        startTime = LocalDateTime.now();
    }

    public void setStopTime(LocalDateTime stopTime) {
        this.stopTime = stopTime;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
