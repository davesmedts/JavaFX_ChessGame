package view.newGameView;

import Model.Model;

public class LoadGamePresenter {

    private Model model;
    private LoadGameView view;

    public LoadGamePresenter(Model model,
                             LoadGameView view) {
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
