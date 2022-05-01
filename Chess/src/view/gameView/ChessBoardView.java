package view.gameView;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Mattia Verreydt
 * @version 1.0 27-4-2022 22:39
 */
public class ChessBoardView extends GridPane {


    //backgroundcolor
    // foto in zetten de chesssKnight
    // you can add nex pane object to each column and row and then add color to the pane with chessboard.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));


    public GridPane drawBoard() {
        int count = 0;

        for (int column = 1; column < 9; column++) {
            count++;

            for (int row = 1; row < 9; row++) {

                GridPane gameSquare = new GridPane();

                ColumnConstraints column1 = new ColumnConstraints(75);
                gameSquare.getColumnConstraints().addAll(column1);

                RowConstraints rowHeight = new RowConstraints(75);
                gameSquare.getRowConstraints().addAll(rowHeight);

                char columnLetter = (char) (64 + column); //ASCII code gebruiken om int naar char om te zetten
                int rowNumber = row;

                String squareName = columnLetter + String.valueOf(rowNumber);
                Text SQUARENAME = new Text(squareName);

                ImageView knight = new ImageView("/rsz_1rsz_1chess-knight-solid2.png");



                if (count % 2 == 0) {

                    gameSquare.setStyle("-fx-background-color: Gray;");

                    this.add(gameSquare, row, column);


                } else {

                    gameSquare.setStyle("-fx-background-color: Green;");

                    this.add(gameSquare, row, column);
                }


                if() {

                    this.add(knight, row, column);

                }


                this.add(SQUARENAME,row,column);

                count++;

            }


        }


        return this;

    }
}


