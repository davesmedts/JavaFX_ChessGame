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
        // creating Random boolean that can be used to randomly define who plays black or white
        Random rd = new Random();
        boolean playerOneIsBlack = rd.nextBoolean();
        if(playerOneIsBlack){
            blackPlayer = playerOne;
            whitePlayer = playerTwo;
        } else {
            blackPlayer = playerTwo;
            whitePlayer = playerOne;
        }
//        we create a new gameBoard and assign the board to the Player object as well.
        gameBoard = new Board();
        whitePlayer.setGameBoard(gameBoard);
        blackPlayer.setGameBoard(gameBoard);

        // Create the movesValidator and assign it to the board and the players
        MovesValidator movesValidator= gameBoard.createMovesValidator();
        whitePlayer.setMovesValidator(movesValidator);
        blackPlayer.setMovesValidator(movesValidator);


//        player who plays white always has the first turn.
        turn = Color.WHITE;
        startTime = LocalDateTime.now();

//        we call the initializePieces method to create all pieces and place them onto our board.
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
