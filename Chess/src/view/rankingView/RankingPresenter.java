package view.rankingView;


import Model.Model;

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
    }

    private void updateView() {
    }

}
