package view.rankingView;


import model.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.homeView.homePresenter;
import view.homeView.homeView;

public class RankingPresenter {

    private Model model;
    private RankingView view;

    public RankingPresenter(Model model,
                            RankingView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }
    private void addEventHandlers() {
        // Terug naar HomeScherm
        view.getHomeBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                homeView homeView = new homeView();
                homePresenter homePresenter = new homePresenter(model, homeView);
                view.getScene().setRoot(homeView);
                homeView.getScene().getWindow().sizeToScene();
            }
        });
    }

    private void updateView() {
    }

}
