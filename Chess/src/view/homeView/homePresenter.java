package view.homeView;

import model.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.LoadGameView.LoadGamePresenter;
import view.LoadGameView.loadGameView;
import view.newGameView.newGamePresenter;
import view.newGameView.newGameView;
import view.rankingView.RankingPresenter;
import view.rankingView.RankingView;


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
                newGameView newGameView = new newGameView();
                newGamePresenter newGamePresenter = new newGamePresenter(model, newGameView);
                view.getScene().setRoot(newGameView);
                newGameView.getScene().getWindow().sizeToScene();
            }
        });

        // blijven op dezelfde Stage, rangschikking opvragen
        view.getRangschikkingBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RankingView RankingView = new RankingView();
                RankingPresenter loadGamePresenter = new RankingPresenter(model, RankingView);
                view.getScene().setRoot(RankingView);
                RankingView.getScene().getWindow().sizeToScene();
            }
        });

        // blijven op dezelfde Stage, spel hervatten
        view.getOpenenBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadGameView RankingView = new loadGameView();
                LoadGamePresenter LoadGamePresenter = new LoadGamePresenter(model, RankingView);
                view.getScene().setRoot(RankingView);
                RankingView.getScene().getWindow().sizeToScene();
            }
        });

    }

    private void updateView() {
    }
}
