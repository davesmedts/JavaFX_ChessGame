package view.gameView;

import Model.Model;

public class gamePresenter {

    private Model model;
    private gameView view;

    public gamePresenter(Model model,
                         gameView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }
    private void addEventHandlers() {
    }

    private void updateView() {
    }

}
