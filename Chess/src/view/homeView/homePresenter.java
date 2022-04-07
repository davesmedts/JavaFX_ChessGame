package view.homeView;

import Model.Model;

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
    }

    private void updateView() {
    }

}
