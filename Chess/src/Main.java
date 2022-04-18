import Model.Model;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.LoadGameView.LoadGamePresenter;
import view.LoadGameView.loadGameView;
import view.homeView.homePresenter;
import view.homeView.homeView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Model model = new Model();
        loadGameView view = new loadGameView();
        LoadGamePresenter presenter = new LoadGamePresenter (model, view);
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
