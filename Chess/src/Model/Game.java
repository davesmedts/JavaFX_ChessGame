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
    private boolean gameFinished;

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
        gameFinished = false;

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

    public void play(){
        System.out.println(whitePlayer);
        System.out.println(blackPlayer);
        System.out.println(getGameBoard());
        while (!gameFinished){
            if(turn == Color.WHITE){
                whitePlayer.selectPiece();
                turn = Color.BLACK;
                System.out.println(getGameBoard());
            } else {
                blackPlayer.selectPiece();
                turn = Color.WHITE;
                System.out.println(getGameBoard());
            }
//            Hier moet nog een check komen of een stuk op checkmate staat of niet.
//            OF vanuit een andere klasse het spel beëindigen na een checkmate.
        }
    }
}
