import Model.Model;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.LoadGameView.newGamePresenter;
import view.LoadGameView.newGameView;
import view.SplashScreenView.SplashScreenPresenter;
import view.SplashScreenView.SplashScreenView;
import view.homeView.homePresenter;
import view.homeView.homeView;
import view.newGameView.LoadGamePresenter;
import view.newGameView.LoadGameView;

import java.awt.*;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Model model = new Model();
        homeView view = new homeView();
        homePresenter presenter = new homePresenter (model, view);
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
