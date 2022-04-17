package view.homeView;

import Model.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.newGameView.LoadGamePresenter;
import view.newGameView.LoadGameView;


public class homePresenter {

    private Model model;
    private homeView view;

    public homePresenter(Model model,
                         homeView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }


    private void addEventHandlers() {
        // blijven op dezelfde Stage, new Game starten
        view.getNewGameBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoadGameView loadGameView = new LoadGameView();
                LoadGamePresenter loadGamePresenter = new LoadGamePresenter(model, loadGameView);
                view.getScene().setRoot(loadGameView);
                loadGameView.getScene().getWindow().sizeToScene();
            }
        });
    }

    private void updateView() {
    }

}
