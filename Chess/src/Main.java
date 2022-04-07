import Model.Model;
import view.SplashScreenView.SplashScreenPresenter;
import view.SplashScreenView.SplashScreenView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.gameView.gamePresenter;
import view.gameView.gameView;
import view.homeView.homePresenter;
import view.homeView.homeView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Model model = new Model();
        SplashScreenView view = new SplashScreenView();
        SplashScreenPresenter presenter = new SplashScreenPresenter(model, view);
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
