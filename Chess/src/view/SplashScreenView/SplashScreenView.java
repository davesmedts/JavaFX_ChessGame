package view.splashScreenView;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class SplashScreenView extends BorderPane {
    private VBox mainContainer; // waarom gebruiken wij VBox en geen grid?
    private VBox leftContainer;

    private Button homeBtn;

    private MenuItem afsluiten;
    private MenuItem spelregels;
    private MenuItem info;

    private ImageView chessLogo;
    private ImageView splashScreenImage;

    private Label contentCreators;


    public SplashScreenView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
//        mainContainerNodes
        this.mainContainer = new VBox();
//        menuNodes
        this.afsluiten = new MenuItem("afsluiten");
        this.spelregels = new MenuItem("spelregels");
        this.info = new MenuItem("info");

//        left area nodes
        this.leftContainer = new VBox();
        this.chessLogo = new ImageView("/applicationLogoSmall.png");
        this.homeBtn = new Button("Home page");
        this.contentCreators = new Label("Program created by Deef and MattiMagic");

    }

    private void layoutNodes() {

//        menu
        final Menu bestandMenu = new Menu("Bestand",null, this.afsluiten);
        final Menu helpMenu = new Menu("Help",null, this.spelregels, this.info);
        final MenuBar menuBar = new MenuBar(bestandMenu, helpMenu);
        this.setTop(menuBar);

//        MainContainerContent
        mainContainer.getChildren().addAll(chessLogo,contentCreators);
        mainContainer.setSpacing(20);
        mainContainer.setAlignment(Pos.CENTER);
        this.setCenter(mainContainer);

//        leftArea
        leftContainer.getChildren().addAll( homeBtn);
        this.setLeft(leftContainer);
    }
}
