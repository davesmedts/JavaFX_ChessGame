package view.SplashScreenView;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class SplashScreenView extends BorderPane {
    private VBox mainContainer;
    private VBox leftContainer;

    private Button homeBtn;

    private MenuItem afsluiten;
    private MenuItem spelregels;
    private MenuItem info;

    private ImageView chessLogo;
    private ImageView splashScreenImage;


    public SplashScreenView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
//        mainContainerNodes
        this.mainContainer = new VBox();
        this.splashScreenImage = new ImageView("/splashScreenImage.jpg");
//        menuNodes
        this.afsluiten = new MenuItem("afsluiten");
        this.spelregels = new MenuItem("spelregels");
        this.info = new MenuItem("info");

//        left area nodes
        this.leftContainer = new VBox();
        this.chessLogo = new ImageView("/applicationLogoSmall.png");
        this.homeBtn = new Button("Home page");

    }

    private void layoutNodes() {

//        menu
        final Menu bestandMenu = new Menu("Bestand",null, this.afsluiten);
        final Menu helpMenu = new Menu("Help",null, this.spelregels, this.info);
        final MenuBar menuBar = new MenuBar(bestandMenu, helpMenu);
        this.setTop(menuBar);

//        MainContainerContent
        mainContainer.getChildren().add(splashScreenImage);
        this.setCenter(mainContainer);

//        leftArea
        leftContainer.getChildren().addAll(chessLogo, homeBtn);
        this.setLeft(leftContainer);
    }
}
