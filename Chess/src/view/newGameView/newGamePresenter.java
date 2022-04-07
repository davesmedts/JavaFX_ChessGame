package view.newGameView;

import Model.Model;

public class newGamePresenter {

    private Model model;
    private newGameView view;

    public newGamePresenter(Model model,
                            newGameView view) {
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
