package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    public static Motives motiveActual;

    //Stage and Scene
    private Stage primaryStage = new Stage();
    private Scene sceneMainMenu;
    private Scene sceneMemory;

    //Audio
    final URL resourceLOTR = getClass().getResource("LOTR_Rohan.mp3");
    final Media mediaLOTR = new Media(resourceLOTR.toString());
    final MediaPlayer mediaPlayerLordOfTheRings = new MediaPlayer(mediaLOTR);
    final URL resourceAriel = getClass().getResource("ArielleUntenImMeer.mp3");
    final Media mediaAriel = new Media(resourceAriel.toString());
    final MediaPlayer mediaPlayerAriel = new MediaPlayer(mediaAriel);
    final URL resourceMerida = getClass().getResource("Merida.mp3");
    final Media mediaMerida = new Media(resourceMerida.toString());
    final MediaPlayer mediaPlayerMerida = new MediaPlayer(mediaMerida);
    final URL resourceMinion = getClass().getResource("Minion.mp3");
    final Media mediaMinion = new Media(resourceMinion.toString());
    final MediaPlayer mediaPlayerMinion = new MediaPlayer(mediaMinion);


    //MainPane
    private GridPane gridPane;
    private Image backgroundImage;
    private Label labelAmountPlayer;
    private ComboBox<Integer> comboBoxAmountPlayer;
    private Label labelLevel;
    private ComboBox<String> comboBoxLevel;
    private Label labelName1;
    private Label labelName2;
    private TextField textFieldName1;
    private TextField textFieldName2;
    private Label labelChoice;
    private ScrollPane scrollPane;
    private HBox hBoxMotive1;
    private ImageView imageViewMotive0;
    private ImageView imageViewMotive1;
    private ImageView imageViewMotive2;
    private ImageView imageViewMotive3;
    private ImageView imageViewMotive4;
    private Button buttonPlay;
    private Label labelMotiveCheck;
    private Label labelName1Check;
    private Label labelName2Check;
    private String namePlayer1;
    private String namePlayer2;
    private int amountPlayer = 1;
    private int delayTime;
    private CardShuffler cardShuffler;
    private Card cardFirst;
    private Card cardSecond;
    private double guessCounter = 0.0d;
    private int openCardCounter = 0;
    private int imageViewPointer = -1;
    private int amountTips = 0;

    //MemoryPane
    private SplitPane splitPane;
    private FlowPane flowPane;
    private Image imageBack;
    private ImageView imageView0;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;
    private ImageView imageView9;
    private ImageView imageView10;
    private ImageView imageView11;
    private ImageView imageView12;
    private ImageView imageView13;
    private ImageView imageView14;
    private ImageView imageView15;
    private ImageView imageViewPrevious;

    private ImageView imageViewBackSide = new ImageView(new Image("sample/Backside.jpg"));


    //MemoryResultNodes
    private GridPane gridPaneMemoryResult;
    private Label labelWhoTurn;
    private Label labelWhoTurnName;
    private ImageView imageViewCorrect;
    private FlowPane flowPaneWonCardsPlayer1;
    private FlowPane flowPaneWonCardsPlayer2;
    private Label labelWonCardsPlayer1 = new Label();
    private Label labelWonCardsPlayer2 = new Label();
    private Label tipLabel;
    private Button buttonBackToMain;
    private Button buttonPlayAgain;
    private FlowPane flowPaneButtons;


    @Override
    public void start(Stage primaryStage) {

        //MainPane
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 30));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        backgroundImage = new Image(getClass().getResourceAsStream("Schmetterling.png"));
        gridPane.setBackground(new Background(new BackgroundImage(backgroundImage,
                null, null, null,
                new BackgroundSize(900, 650, false, false, false, false))));
        labelAmountPlayer = new Label("Wähle die Anzahl der Spieler:  ");
        comboBoxAmountPlayer = new ComboBox<>();
        comboBoxAmountPlayer.getItems().addAll(1, 2);
        comboBoxAmountPlayer.getSelectionModel().selectFirst();
        labelLevel = new Label("Wähle ein Level aus:");
        comboBoxLevel = new ComboBox<>();
        comboBoxLevel.getItems().addAll(Level.EASY.getText(), Level.INTERMEDIATE.getText(), Level.DIFFICULT.getText());
        comboBoxLevel.getSelectionModel().selectFirst();
        labelName1 = new Label("Name Spieler1:");
        labelName2 = new Label("Name Spieler2:");
        labelName2.setVisible(false);
        labelName2.setManaged(false);
        textFieldName1 = new TextField();
        textFieldName1.setPromptText("Gib deinen Namen ein");
        textFieldName2 = new TextField();
        textFieldName2.setPromptText("Gib deinen Namen ein");
        textFieldName2.setVisible(false);
        textFieldName2.setManaged(false);
        labelChoice = new Label("Wähle dein Motiv:");
        scrollPane = new ScrollPane();
        scrollPane.setPrefViewportHeight(160);
        scrollPane.setPrefViewportWidth(470);
        hBoxMotive1 = new HBox();
        hBoxMotive1.setPadding(new Insets(0, 10, 0, 10));
        hBoxMotive1.setSpacing(10);
        imageViewMotive0 = new ImageView(new Image(getClass().getResourceAsStream("LordOfTheRings.png")));
        imageViewMotive0.setFitHeight(110);
        imageViewMotive0.setFitWidth(110);
        imageViewMotive1 = new ImageView(new Image(getClass().getResourceAsStream("Arielle.png")));
        imageViewMotive1.setFitHeight(110);
        imageViewMotive1.setFitWidth(110);
        imageViewMotive2 = new ImageView(new Image(getClass().getResourceAsStream("MotiveMerida.png")));
        imageViewMotive2.setFitHeight(110);
        imageViewMotive2.setFitWidth(110);
        imageViewMotive3 = new ImageView(new Image(getClass().getResourceAsStream("PinguMotive.png")));
        imageViewMotive3.setFitHeight(110);
        imageViewMotive3.setFitWidth(110);
        imageViewMotive4 = new ImageView(new Image(getClass().getResourceAsStream("EuvMotive.png")));
        imageViewMotive4.setFitHeight(110);
        imageViewMotive4.setFitWidth(110);

        buttonPlay = new Button("Let's play!");
        try {
            buttonPlay.setFont(Font.loadFont(new FileInputStream("src/sample/Amadeus.ttf"), 30));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        buttonPlay.setPrefSize(490, 40);
        labelMotiveCheck = new Label();
        labelName1Check = new Label();
        labelName2Check = new Label();

        sceneMainMenu = new Scene(gridPane, 800, 650);
        //sceneMainMenu.getStylesheets().add("/sample/StyleSheet.css");

        scrollPane.setContent(hBoxMotive1);
        hBoxMotive1.getChildren().addAll(imageViewMotive0, imageViewMotive1, imageViewMotive2, imageViewMotive3, imageViewMotive4);

        comboBoxAmountPlayer.setOnAction(event -> {
            amountPlayer = comboBoxAmountPlayer.getValue();
            if (amountPlayer == 1) {
                labelName2.setVisible(false);
                labelName2.setManaged(false);
                textFieldName2.setVisible(false);
                textFieldName2.setManaged(false);
            } else {
                labelName2.setVisible(true);
                labelName2.setManaged(true);
                textFieldName2.setVisible(true);
                textFieldName2.setManaged(true);
            }
        });

        imageViewMotive0.setOnMouseClicked(mouseEvent -> {
            motiveActual = Motives.LORD_OF_THE_RINGS;
            resizeNotChosenMotives();
            imageViewMotive0.setFitWidth(150);
            imageViewMotive0.setFitHeight(150);
            System.out.println("Motive: " + motiveActual);
            cardShuffler = new CardShuffler();
        });
        imageViewMotive0.setOnMouseEntered(mouseEvent -> imageViewMotive0.setEffect(new DropShadow()));
        imageViewMotive0.setOnMouseExited(mouseEvent -> imageViewMotive0.setEffect(null));

        imageViewMotive1.setOnMouseClicked(mouseEvent -> {
            motiveActual = Motives.ARIELLE;
            resizeNotChosenMotives();
            imageViewMotive1.setFitWidth(150);
            imageViewMotive1.setFitHeight(150);
            System.out.println("Motive: " + motiveActual);
            cardShuffler = new CardShuffler();
        });
        imageViewMotive1.setOnMouseEntered(mouseEvent -> imageViewMotive1.setEffect(new DropShadow()));
        imageViewMotive1.setOnMouseExited(mouseEvent -> imageViewMotive1.setEffect(null));

        imageViewMotive2.setOnMouseClicked(mouseEvent -> {
            motiveActual = Motives.MERIDA;
            resizeNotChosenMotives();
            imageViewMotive2.setFitWidth(150);
            imageViewMotive2.setFitHeight(150);
            System.out.println("Motive: " + motiveActual);
            cardShuffler = new CardShuffler();
        });
        imageViewMotive2.setOnMouseEntered(mouseEvent -> imageViewMotive2.setEffect(new DropShadow()));
        imageViewMotive2.setOnMouseExited(mouseEvent -> imageViewMotive2.setEffect(null));


        imageViewMotive3.setOnMouseClicked(mouseEvent -> {
            motiveActual = Motives.PINGU;
            resizeNotChosenMotives();
            imageViewMotive3.setFitWidth(150);
            imageViewMotive3.setFitHeight(150);
            System.out.println("Motive: " + motiveActual);
            cardShuffler = new CardShuffler();
        });
        imageViewMotive3.setOnMouseEntered(mouseEvent -> imageViewMotive3.setEffect(new DropShadow()));
        imageViewMotive3.setOnMouseExited(mouseEvent -> imageViewMotive3.setEffect(null));

        imageViewMotive4.setOnMouseClicked(mouseEvent -> {
            motiveActual = Motives.MINION;
            resizeNotChosenMotives();
            imageViewMotive4.setFitWidth(150);
            imageViewMotive4.setFitHeight(150);
            System.out.println("Motive: " + motiveActual);
            cardShuffler = new CardShuffler();
        });
        imageViewMotive4.setOnMouseEntered(mouseEvent -> imageViewMotive4.setEffect(new DropShadow()));
        imageViewMotive4.setOnMouseExited(mouseEvent -> imageViewMotive4.setEffect(null));

        GridPane.setConstraints(labelAmountPlayer, 0, 0);
        GridPane.setConstraints(comboBoxAmountPlayer, 1, 0);
        GridPane.setConstraints(labelLevel, 0, 1);
        GridPane.setConstraints(comboBoxLevel, 1, 1);
        GridPane.setConstraints(labelName1, 0, 2);
        GridPane.setConstraints(textFieldName1, 1, 2);
//        GridPane.setColumnSpan(textFieldName1, 4);
        GridPane.setConstraints(labelName2, 0, 3);
        GridPane.setConstraints(textFieldName2, 1, 3);
//        GridPane.setColumnSpan(textFieldName2, 3);
        GridPane.setConstraints(labelChoice, 0, 4);
        GridPane.setConstraints(scrollPane, 1, 4);
        GridPane.setConstraints(buttonPlay, 1, 5);
        GridPane.setConstraints(labelName1Check, 1, 6);
//        GridPane.setColumnSpan(labelName1Check, 2);
        GridPane.setConstraints(labelName2Check, 1, 7);
//        GridPane.setColumnSpan(labelName2Check, 2);
        GridPane.setConstraints(labelMotiveCheck, 1, 8);
//        GridPane.setColumnSpan(labelMotiveCheck, 2);

        gridPane.getChildren().addAll(labelAmountPlayer, comboBoxAmountPlayer, labelLevel, comboBoxLevel, labelName1, textFieldName1,
                labelName2, textFieldName2, labelChoice, scrollPane, buttonPlay, labelName1Check,
                labelName2Check, labelMotiveCheck);

        //MemoryPane
        splitPane = new SplitPane();
        splitPane.setDividerPosition(0, 0.66); //0.66 teilt splitPane nach zweitem Drittel
        flowPane = new FlowPane();
        flowPane.setPadding(new Insets(10, 10, 10, 10));
        flowPane.setHgap(10);
        flowPane.setVgap(10);

        //Memory Result Nodes
        gridPaneMemoryResult = new GridPane();
        gridPaneMemoryResult.setPadding(new Insets(10, 10, 10, 10));
        gridPaneMemoryResult.setVgap(10);
        gridPaneMemoryResult.setHgap(10);
        labelWhoTurn = new Label("Du bist an der Reihe:");
        labelWhoTurnName = new Label();
        labelWhoTurnName.setFont(new Font(20));
        labelWonCardsPlayer1 = new Label();
        labelWonCardsPlayer2 = new Label();
        flowPaneWonCardsPlayer1 = new FlowPane();
        flowPaneWonCardsPlayer1.setHgap(10);
        flowPaneWonCardsPlayer1.setVgap(10);
        flowPaneWonCardsPlayer2 = new FlowPane();
        flowPaneWonCardsPlayer2.setHgap(10);
        flowPaneWonCardsPlayer2.setVgap(10);
        tipLabel = new Label("Anzahl Tipps: " + amountTips);
        buttonBackToMain = new Button("Zurück zum Hauptmenü");
        buttonPlayAgain = new Button("Nochmals spielen");
        flowPaneButtons = new FlowPane(buttonBackToMain, buttonPlayAgain);
        flowPaneButtons.setHgap(10);
        GridPane.setConstraints(labelWhoTurn, 0, 0);
        GridPane.setConstraints(labelWhoTurnName, 0, 1);
        GridPane.setConstraints(labelWonCardsPlayer1, 0, 4);
        GridPane.setConstraints(flowPaneWonCardsPlayer1, 0, 5);
        GridPane.setConstraints(labelWonCardsPlayer2, 0, 8);
        GridPane.setConstraints(flowPaneWonCardsPlayer2, 0, 9);
        GridPane.setConstraints(tipLabel, 0, 11);
        GridPane.setConstraints(flowPaneButtons, 0, 13);

        gridPaneMemoryResult.getChildren().addAll(labelWhoTurn, labelWhoTurnName, labelWonCardsPlayer1,
                flowPaneWonCardsPlayer1, labelWonCardsPlayer2, flowPaneWonCardsPlayer2, tipLabel, flowPaneButtons);

        //Memory Nodes
        imageBack = new Image(getClass().getResourceAsStream("Backside.jpg"));
        imageView0 = new ImageView(imageBack);
        imageView1 = new ImageView(imageBack);
        imageView2 = new ImageView(imageBack);
        imageView3 = new ImageView(imageBack);
        imageView4 = new ImageView(imageBack);
        imageView5 = new ImageView(imageBack);
        imageView6 = new ImageView(imageBack);
        imageView7 = new ImageView(imageBack);
        imageView8 = new ImageView(imageBack);
        imageView9 = new ImageView(imageBack);
        imageView10 = new ImageView(imageBack);
        imageView11 = new ImageView(imageBack);
        imageView12 = new ImageView(imageBack);
        imageView13 = new ImageView(imageBack);
        imageView14 = new ImageView(imageBack);
        imageView15 = new ImageView(imageBack);

        imageView0.setFitWidth(150);
        imageView0.setFitHeight(150);
        imageView1.setFitWidth(150);
        imageView1.setFitHeight(150);
        imageView2.setFitWidth(150);
        imageView2.setFitHeight(150);
        imageView3.setFitWidth(150);
        imageView3.setFitHeight(150);
        imageView4.setFitWidth(150);
        imageView4.setFitHeight(150);
        imageView5.setFitWidth(150);
        imageView5.setFitHeight(150);
        imageView6.setFitWidth(150);
        imageView6.setFitHeight(150);
        imageView7.setFitWidth(150);
        imageView7.setFitHeight(150);
        imageView8.setFitWidth(150);
        imageView8.setFitHeight(150);
        imageView9.setFitWidth(150);
        imageView9.setFitHeight(150);
        imageView10.setFitWidth(150);
        imageView10.setFitHeight(150);
        imageView11.setFitWidth(150);
        imageView11.setFitHeight(150);
        imageView12.setFitWidth(150);
        imageView12.setFitHeight(150);
        imageView13.setFitWidth(150);
        imageView13.setFitHeight(150);
        imageView14.setFitWidth(150);
        imageView14.setFitHeight(150);
        imageView15.setFitWidth(150);
        imageView15.setFitHeight(150);

        imageViewBackSide.setFitHeight(150);
        imageViewBackSide.setFitWidth(150);

        flowPane.getChildren().addAll(imageView0, imageView1, imageView2, imageView3, imageView4, imageView5, imageView6,
                imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, imageView13, imageView14,
                imageView15);
        splitPane.getItems().addAll(flowPane, gridPaneMemoryResult);
        sceneMemory = new Scene(splitPane, 1000, 650);


        buttonBackToMain.setOnAction(event -> {
            motiveActual = null;
            resizeNotChosenMotives();
            reset();
            fadeOut(mediaPlayerLordOfTheRings);
            mediaPlayerAriel.stop();
            mediaPlayerMerida.stop();
            mediaPlayerMinion.stop();
            primaryStage.setScene(sceneMainMenu);

        });

        buttonPlayAgain.setOnAction(event -> {
            reset();
            primaryStage.setScene(sceneMemory);
        });

        //Play-Button
        buttonPlay.setOnAction(event -> {
            play();
            //Finaler Check & Set Configuration
            if (!(labelName1Check.isVisible() || labelName2Check.isVisible() ||
                    labelMotiveCheck.isVisible())) {
                labelWhoTurnName.setText(getTurn());
                labelWonCardsPlayer1.setText(namePlayer1 + "'s gewonnene Karten:");
                labelWonCardsPlayer2.setText(namePlayer2 + "'s gewonnene Karten:");
                System.out.println(comboBoxLevel.getValue());
                if (comboBoxLevel.getValue().equals("Leicht")) {
                    delayTime = Level.EASY.getMilliSec();
                } else if (comboBoxLevel.getValue().equals("Mittel")) {
                    delayTime = Level.INTERMEDIATE.getMilliSec();
                } else { // Level Schwer
                    delayTime = Level.DIFFICULT.getMilliSec();
                }
                playAudio();
                primaryStage.setScene(sceneMemory);
            }
        });


        imageView0.setOnMouseEntered(mouseEvent -> {

            if (compareImage(imageView0, imageViewBackSide)) {
                imageView0.setEffect(new Glow());
            }
        });
        imageView0.setOnMouseExited(mouseEvent -> imageView0.setEffect(null));
        imageView0.setOnMousePressed(mouseEvent -> {
            imageView0.setEffect(new DropShadow());
        });
        imageView0.setOnMouseReleased(mouseEvent -> {
            imageView0.setEffect(null);
            uncover(mouseEvent, 0);
        });

        imageView1.setOnMouseEntered(mouseEvent -> {
            if (compareImage(imageView1, imageViewBackSide)) {
                imageView1.setEffect(new Glow());
            }
        });
        imageView1.setOnMouseExited(mouseEvent -> imageView1.setEffect(null));
        imageView1.setOnMousePressed(mouseEvent -> {
            imageView1.setEffect(new DropShadow());
        });
        imageView1.setOnMouseReleased(mouseEvent -> {
            imageView1.setEffect(null);
            uncover(mouseEvent, 1);
        });

        imageView2.setOnMouseEntered(mouseEvent -> {
            if (compareImage(imageView2, imageViewBackSide)) {
                imageView2.setEffect(new Glow());
            }
        });
        imageView2.setOnMouseExited(mouseEvent -> imageView2.setEffect(null));
        imageView2.setOnMousePressed(mouseEvent -> {
            imageView2.setEffect(new DropShadow());
        });
        imageView2.setOnMouseReleased(mouseEvent -> {
            imageView2.setEffect(null);
            uncover(mouseEvent, 2);
        });

        imageView3.setOnMouseEntered(mouseEvent -> {
            if (compareImage(imageView3, imageViewBackSide)) {
                imageView3.setEffect(new Glow());
            }
        });
        imageView3.setOnMouseExited(mouseEvent -> imageView3.setEffect(null));
        imageView3.setOnMousePressed(mouseEvent -> {
            imageView3.setEffect(new DropShadow());
        });
        imageView3.setOnMouseReleased(mouseEvent -> {
            imageView3.setEffect(null);
            uncover(mouseEvent, 3);
        });

        imageView4.setOnMouseEntered(mouseEvent -> {
            if (compareImage(imageView4, imageViewBackSide)) {
                imageView4.setEffect(new Glow());
            }
        });
        imageView4.setOnMouseExited(mouseEvent -> imageView4.setEffect(null));
        imageView4.setOnMousePressed(mouseEvent -> {
            imageView4.setEffect(new DropShadow());
        });
        imageView4.setOnMouseReleased(mouseEvent -> {
            imageView4.setEffect(null);
            uncover(mouseEvent, 4);
        });

        imageView5.setOnMouseEntered(mouseEvent -> {
            if (compareImage(imageView5, imageViewBackSide)) {
                imageView5.setEffect(new Glow());
            }
        });
        imageView5.setOnMouseExited(mouseEvent -> imageView5.setEffect(null));
        imageView5.setOnMousePressed(mouseEvent -> {
            imageView5.setEffect(new DropShadow());
        });
        imageView5.setOnMouseReleased(mouseEvent -> {
            imageView5.setEffect(null);
            uncover(mouseEvent, 5);
        });

        imageView6.setOnMouseEntered(mouseEvent -> {
            if (compareImage(imageView6, imageViewBackSide)) {
                imageView6.setEffect(new Glow());
            }
        });
        imageView6.setOnMouseExited(mouseEvent -> imageView6.setEffect(null));
        imageView6.setOnMousePressed(mouseEvent -> {
            imageView6.setEffect(new DropShadow());
        });
        imageView6.setOnMouseReleased(mouseEvent -> {
            imageView6.setEffect(null);
            uncover(mouseEvent, 6);
        });

        imageView7.setOnMouseEntered(mouseEvent -> {
            if (compareImage(imageView7, imageViewBackSide)) {
                imageView7.setEffect(new Glow());
            }
        });
        imageView7.setOnMouseExited(mouseEvent -> imageView7.setEffect(null));
        imageView7.setOnMousePressed(mouseEvent -> {
            imageView7.setEffect(new DropShadow());
        });
        imageView7.setOnMouseReleased(mouseEvent -> {
            imageView7.setEffect(null);
            uncover(mouseEvent, 7);
        });

        imageView8.setOnMouseEntered(mouseEvent -> {
            if (compareImage(imageView8, imageViewBackSide)) {
                imageView8.setEffect(new Glow());
            }
        });
        imageView8.setOnMouseExited(mouseEvent -> imageView8.setEffect(null));
        imageView8.setOnMousePressed(mouseEvent -> {
            imageView8.setEffect(new DropShadow());
        });
        imageView8.setOnMouseReleased(mouseEvent -> {
            imageView8.setEffect(null);
            uncover(mouseEvent, 8);
        });

        imageView9.setOnMouseEntered(mouseEvent -> {
            if (compareImage(imageView9, imageViewBackSide)) {
                imageView9.setEffect(new Glow());
            }
        });
        imageView9.setOnMouseExited(mouseEvent -> imageView9.setEffect(null));
        imageView9.setOnMousePressed(mouseEvent -> {
            imageView9.setEffect(new DropShadow());
        });
        imageView9.setOnMouseReleased(mouseEvent -> {
            imageView9.setEffect(null);
            uncover(mouseEvent, 9);
        });

        imageView10.setOnMouseEntered(mouseEvent -> {
            if (compareImage(imageView10, imageViewBackSide)) {
                imageView10.setEffect(new Glow());
            }
        });
        imageView10.setOnMouseExited(mouseEvent -> imageView10.setEffect(null));
        imageView10.setOnMousePressed(mouseEvent -> {
            imageView10.setEffect(new DropShadow());
        });
        imageView10.setOnMouseReleased(mouseEvent -> {
            imageView10.setEffect(null);
            uncover(mouseEvent, 10);
        });

        imageView11.setOnMouseEntered(mouseEvent -> {
            if (compareImage(imageView11, imageViewBackSide)) {
                imageView11.setEffect(new Glow());
            }
        });
        imageView11.setOnMouseExited(mouseEvent -> imageView11.setEffect(null));
        imageView11.setOnMousePressed(mouseEvent -> {
            imageView11.setEffect(new DropShadow());
        });
        imageView11.setOnMouseReleased(mouseEvent -> {
            imageView11.setEffect(null);
            uncover(mouseEvent, 11);
        });

        imageView12.setOnMouseEntered(mouseEvent -> {
            if (compareImage(imageView12, imageViewBackSide)) {
                imageView12.setEffect(new Glow());
            }
        });
        imageView12.setOnMouseExited(mouseEvent -> imageView12.setEffect(null));
        imageView12.setOnMousePressed(mouseEvent -> {
            imageView12.setEffect(new DropShadow());
        });
        imageView12.setOnMouseReleased(mouseEvent -> {
            imageView12.setEffect(null);
            uncover(mouseEvent, 12);
        });

        imageView13.setOnMouseEntered(mouseEvent -> {
            if (compareImage(imageView13, imageViewBackSide)) {
                imageView13.setEffect(new Glow());
            }
        });
        imageView13.setOnMouseExited(mouseEvent -> imageView13.setEffect(null));
        imageView13.setOnMousePressed(mouseEvent -> {
            imageView13.setEffect(new DropShadow());
        });
        imageView13.setOnMouseReleased(mouseEvent -> {
            imageView13.setEffect(null);
            uncover(mouseEvent, 13);
        });

        imageView14.setOnMouseEntered(mouseEvent -> {
            if (compareImage(imageView14, imageViewBackSide)) {
                imageView14.setEffect(new Glow());
            }
        });
        imageView14.setOnMouseExited(mouseEvent -> imageView14.setEffect(null));
        imageView14.setOnMousePressed(mouseEvent -> {
            imageView14.setEffect(new DropShadow());
        });
        imageView14.setOnMouseReleased(mouseEvent -> {
            imageView14.setEffect(null);
            uncover(mouseEvent, 14);
        });

        imageView15.setOnMouseEntered(mouseEvent -> {
            if (compareImage(imageView15, imageViewBackSide)) {
                imageView15.setEffect(new Glow());
            }
        });
        imageView15.setOnMouseExited(mouseEvent -> imageView15.setEffect(null));
        imageView15.setOnMousePressed(mouseEvent -> {
            imageView15.setEffect(new DropShadow());
        });
        imageView15.setOnMouseReleased(mouseEvent -> {
            imageView15.setEffect(null);
            uncover(mouseEvent, 15);
        });

        primaryStage.setScene(sceneMainMenu);
        primaryStage.setTitle("Joana's grosse Memory-Sammlung");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public String getTurn() {
        if (comboBoxAmountPlayer.getValue() == 2) {
            if (guessCounter % 2 == 0 || guessCounter % 2 == 0.5) {
                return namePlayer1;
            } else return namePlayer2;
        } else {
            return namePlayer1;
        }
    }

    public void play() {
        //Initialisierung
        amountPlayer = comboBoxAmountPlayer.getValue();
        namePlayer1 = textFieldName1.getText();
        namePlayer2 = textFieldName2.getText();

        //Motiv-Check
        if (motiveActual != null) {
            labelMotiveCheck.setVisible(false);
            labelMotiveCheck.setManaged(false);
        } else {
            System.out.println("Wähle ein Motiv, das dir gefällt");
            labelMotiveCheck.setText("Wähle ein Motiv, das dir gefällt");
            labelMotiveCheck.setTextFill(Color.PURPLE);
            labelMotiveCheck.setVisible(true);
            labelMotiveCheck.setManaged(true);
        }
        // Name Check
        if (namePlayer1.isEmpty()) {
            System.out.println("Spieler1 gib deinen Namen ein");
            labelName1Check.setText("Spieler1 gib deinen Namen ein");
            labelName1Check.setTextFill(Color.PURPLE);
        } else {
            labelName1Check.setVisible(false);
            labelName1Check.setManaged(false);
        }
        if (amountPlayer >= 2) { //2-Spieler-Modus
            if (namePlayer2.isEmpty()) {
                System.out.println("Spieler2 gib deinen Namen ein");
                labelName2Check.setText("Spieler2 gib deinen Namen ein");
                labelName2Check.setTextFill(Color.PURPLE);
                labelName2Check.setVisible(true);
                labelName2Check.setManaged(true);
            } else {
                labelName2Check.setVisible(false);
                labelName2Check.setManaged(false);
            }
            labelWonCardsPlayer2.setVisible(true);
            labelWonCardsPlayer2.setManaged(true);

        } else { //1-Spieler-Modus
            labelName2Check.setVisible(false);
            labelName2Check.setManaged(false);
            labelWonCardsPlayer2.setVisible(false);
            labelWonCardsPlayer2.setManaged(false);
        }
    }

    public void showWonCards(Image image) {
        imageViewCorrect = new ImageView(image);
        imageViewCorrect.setFitWidth(60);
        imageViewCorrect.setFitHeight(60);
        ImageView imageViewCorrectDouble = new ImageView(image);
        imageViewCorrectDouble.setFitWidth(60);
        imageViewCorrectDouble.setFitHeight(60);
        if (comboBoxAmountPlayer.getValue() == 2) {
            if (labelWhoTurnName.getText().equals(namePlayer1)) {
                flowPaneWonCardsPlayer2.getChildren().addAll(imageViewCorrect, imageViewCorrectDouble); //gerade umgekehrt, da Turn zuvor wechselt
            } else {
                flowPaneWonCardsPlayer1.getChildren().addAll(imageViewCorrect, imageViewCorrectDouble); //gerade umgekehrt, da Turn zuvor wechselt
            }
        } else {
            flowPaneWonCardsPlayer1.getChildren().addAll(imageViewCorrect, imageViewCorrectDouble);
        }
    }

    public void reset() {
        amountTips = 0;
        guessCounter = 0.0d;
        openCardCounter = 0;
        labelMotiveCheck.setVisible(false);
        cardShuffler = new CardShuffler();
        imageView0.setImage(imageBack);
        imageView1.setImage(imageBack);
        imageView9.setImage(imageBack);
        imageView3.setImage(imageBack);
        imageView4.setImage(imageBack);
        imageView5.setImage(imageBack);
        imageView6.setImage(imageBack);
        imageView7.setImage(imageBack);
        imageView8.setImage(imageBack);
        imageView9.setImage(imageBack);
        imageView10.setImage(imageBack);
        imageView11.setImage(imageBack);
        imageView12.setImage(imageBack);
        imageView13.setImage(imageBack);
        imageView14.setImage(imageBack);
        imageView15.setImage(imageBack);
        tipLabel.setText("Anzahl Tipps: " + amountTips);
        labelWhoTurnName.setText(namePlayer1);
        flowPaneWonCardsPlayer1.getChildren().clear();
        flowPaneWonCardsPlayer2.getChildren().clear();
    }

    public void playAudio() {
        switch (motiveActual) {
            case LORD_OF_THE_RINGS:
                mediaPlayerLordOfTheRings.play();
                break;
            case ARIELLE:
                mediaPlayerAriel.play();
                break;
            case MERIDA:
                mediaPlayerMerida.play();
                break;
            case MINION:
                mediaPlayerMinion.play();
                break;
        }
    }

    public void fadeOut(MediaPlayer mediaPlayer) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 20; i > 0; i--) {
                    mediaPlayer.setVolume(i);
                }
                mediaPlayer.stop();
            }
        };
        timer.schedule(timerTask, 100);
    }

    public void uncover(MouseEvent mouseEvent, int cardNumber) {
        ImageView imageViewSource = (ImageView) mouseEvent.getSource();
        if (openCardCounter <= 1 && imageViewSource.getImage().equals(imageBack)) {
            guessCounter += 0.5d;
            labelWhoTurnName.setText(getTurn());
            System.out.println("geklickt");
            Card card = cardShuffler.getList().get(cardNumber);
            Image image = card.getImage();
            imageViewSource.setImage(image);
            System.out.println("Karte umgedreht");
            openCardCounter++;
            if (guessCounter % 1 == 0.5) { //erstes Wenden
                System.out.println("Erstes Wenden " + imageViewSource.toString());
                cardFirst = card;
                imageViewPrevious = imageViewSource;
            } else { //zweites Wenden
                System.out.println("Zweites Wenden " + imageViewSource);
                cardSecond = card;
                if (!cardFirst.equals(cardSecond)) {
                    System.out.println("falsch");
                    Timer timer = new Timer();
                    TimerTask timerTaskSetBack = new TimerTask() {
                        @Override
                        public void run() {
                            imageViewSource.setImage(imageBack);
                            imageViewPrevious.setImage(imageBack);
                            openCardCounter = openCardCounter - 2;
//                            imageViewSource.setEffect(new Glow());
                        }
                    };
                    timer.schedule(timerTaskSetBack, delayTime);
                } else if (imageViewPrevious == mouseEvent.getSource()) {
                    System.out.println("Nicht zweimal dieselbe Karte öffnen");
                    guessCounter -= 0.5;
                    openCardCounter--;
                    amountTips--;
                } else {
                    System.out.println("richtig");
                    showWonCards(card.getImage());
                    openCardCounter = openCardCounter - 2;
                    guessCounter = guessCounter - 1;
                    labelWhoTurnName.setText(getTurn());
                }
            }
        } else {
            System.out.println("Es sind bereits zwei Karten offen");
            amountTips--;
        }
        amountTips++;
        tipLabel.setText("Anzahl Tipps: " + amountTips);
    }

    private boolean compareImage(ImageView imageView, ImageView other) {
        return (imageView.getImage().getPixelReader().getColor(100, 100).equals(other.getImage().
                getPixelReader().getColor(100, 100))
                && imageView.getImage().getPixelReader().getColor(10, 10).equals(other.getImage().
                getPixelReader().getColor(10, 10)))
                && imageView.getImage().getPixelReader().getColor(50, 50).equals(other.getImage().
                getPixelReader().getColor(50, 50))
                && imageView.getImage().getPixelReader().getColor(40, 40).equals(other.getImage().
                getPixelReader().getColor(40, 40));
    }

    private void resizeNotChosenMotives() {
        imageViewMotive0.setFitHeight(110);
        imageViewMotive0.setFitWidth(110);
        imageViewMotive1.setFitHeight(110);
        imageViewMotive1.setFitWidth(110);
        imageViewMotive2.setFitHeight(110);
        imageViewMotive2.setFitWidth(110);
        imageViewMotive3.setFitHeight(110);
        imageViewMotive3.setFitWidth(110);
        imageViewMotive4.setFitHeight(110);
        imageViewMotive4.setFitWidth(110);


    }
}

