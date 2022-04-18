package view.rankingView;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class RankingView extends BorderPane {
    private HBox mainContainer;
    private HBox helpIconsContainer;
    private VBox leftContainer;

    private Button homeBtn;
    private Button stopSpelBtn; // waarom zit dat erin? het zijn de rankings?
    private Button opslaanBtn; // waarom zit dat erin? het zijn de rankings?

    private MenuItem afsluiten;
    private MenuItem opslaan;
    private MenuItem openen;
    private MenuItem spelregels;
    private MenuItem info;

    private ImageView chessLogo;

    private ImageView helpIcon;
    private ImageView infoIcon;
    private ImageView settingsIcon;

    private Label statusBarText;
    private Label datum;
    private Label playerWhite;
    private Label playerBlack;
    private Label winnaar;


    public RankingView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
//        mainContainerNodes
        this.mainContainer = new HBox();
        this.chessLogo = new ImageView("/applicationLogoSmall.png");

//        menuNodes
        this.afsluiten = new MenuItem("afsluiten");
        this.openen = new MenuItem("openen");
        this.opslaan = new MenuItem("opslaan");
        this.spelregels = new MenuItem("spelregels");
        this.info = new MenuItem("info");

//        left area nodes
        this.leftContainer = new VBox();
        this.homeBtn = new Button("Home page");
        this.opslaanBtn = new Button("opslaan");
        this.stopSpelBtn = new Button("Stop spel");

//        Icons on the right part of the screen
        this.helpIconsContainer = new HBox();
        this.helpIcon = new ImageView("/questionIcon.png");
        this.settingsIcon = new ImageView("/infoIcon.png");
        this.infoIcon = new ImageView("/settingsIcon.png");

        // labels of the ranking
        this.datum = new Label("datum");
        this.playerWhite = new Label("Player White");
        this.playerBlack = new Label("Player Black");
        this.winnaar = new Label("Winnaar");

        //        statusbar
        this.statusBarText = new Label("designed and build with by Dave Smedts and Mattia Verreydt");


    }

    private void layoutNodes() {

//        menu
        final Menu bestandMenu = new Menu("Bestand",null, this.openen, this.opslaan, this.afsluiten);
        final Menu helpMenu = new Menu("Help",null, this.spelregels, this.info);
        final MenuBar menuBar = new MenuBar(bestandMenu, helpMenu);
        this.setTop(menuBar);

//        MainContainerContent
        mainContainer.getChildren().addAll(datum,playerWhite,playerBlack,winnaar);
        this.setCenter(mainContainer);


//        leftArea
        leftContainer.getChildren().addAll(chessLogo, homeBtn, opslaanBtn, stopSpelBtn);
        this.setLeft(leftContainer);

//      HelpIcons
        helpIconsContainer.getChildren().addAll(settingsIcon, helpIcon, infoIcon);
        this.setRight(helpIconsContainer);

        //        statusbar
        this.setBottom(statusBarText);
    }

    public Button getHomeBtn() {
        return homeBtn;
    }
}
