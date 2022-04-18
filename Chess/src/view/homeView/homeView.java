package view.homeView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class homeView extends BorderPane {
    private VBox mainContainer;
    private HBox helpIconsContainer;

    private Button newGameBtn;
    private Button openenBtn;
    private Button rangschikkingBtn;

    private MenuItem afsluiten;
    private MenuItem opslaan;
    private MenuItem openen;
    private MenuItem spelregels;
    private MenuItem info;

    private ImageView chessLogo;
    private Label titel;

    private ImageView helpIcon;
    private ImageView infoIcon;
    private ImageView settingsIcon;

    private Label statusBarText;


    public homeView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
//        mainContainerNodes
        this.mainContainer = new VBox();
        this.newGameBtn = new Button("nieuw spel");
        this.openenBtn = new Button("hervat spel");
        this.rangschikkingBtn = new Button("Rangschikking");
        this.chessLogo = new ImageView("/applicationLogo.png");
        this.titel = new Label("Welkom bij Chess");
//        menuNodes
        this.afsluiten = new MenuItem("afsluiten");
        this.openen = new MenuItem("openen");
        this.opslaan = new MenuItem("opslaan");
        this.spelregels = new MenuItem("spelregels");
        this.info = new MenuItem("info");

//        Icons on the right part of the screen
        this.helpIconsContainer = new HBox();
        this.helpIcon = new ImageView("/questionIcon.png");
        this.settingsIcon = new ImageView("/infoIcon.png");
        this.infoIcon = new ImageView("/settingsIcon.png");

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
        this.newGameBtn.setPrefSize(150, 40);
        this.openenBtn.setPrefSize(150, 40);
        this.rangschikkingBtn.setPrefSize(150, 40);
        mainContainer.setSpacing(10);
        mainContainer.setPadding(new Insets(20));
        mainContainer.getChildren().addAll(chessLogo, titel, newGameBtn, openenBtn, rangschikkingBtn);
        mainContainer.setAlignment(Pos.CENTER);
        this.setCenter(mainContainer);

//      HelpIcons
        helpIconsContainer.getChildren().addAll(settingsIcon, helpIcon, infoIcon);
        this.setRight(helpIconsContainer);

//        statusbar
        this.setBottom(statusBarText);
    }

    public Button getNewGameBtn() {
        return newGameBtn;
    }

    public Button getRangschikkingBtn() {
        return rangschikkingBtn;
    }

    public Button getOpenenBtn() {
        return openenBtn;
    }
}
