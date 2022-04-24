package view.splashScreenView;

import model.Model;

public class SplashScreenPresenter {

    private Model model;
    private SplashScreenView view;

    public SplashScreenPresenter(Model model,
                                 SplashScreenView view) {
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
