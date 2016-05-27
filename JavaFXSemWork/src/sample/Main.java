package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork_2
 */

public class Main extends Application {

    public static Rectangle top;
    public static Rectangle right;
    public static Rectangle bottom;
    public static Rectangle left;

    private int windowWidth = 500;
    private int windowHeight = 500;
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    public static ArrayList<ImageView> bonuses = new ArrayList<>();
    public Image image = new Image(getClass().getResourceAsStream("resources/images/girl.png"));
    public ImageView imageView = new ImageView(image);
    public Hero hero = new Hero(imageView);
    public static Pane root = new Pane();

    Random random = new Random();


    /*
      Метод создания "грибочков"
     */
    public void bonus() {
        int number = random.nextInt(7654);
        int x = random.nextInt(windowWidth - 20);
        int y = random.nextInt(windowHeight - 10);
        if (number < 123) {
            Image image = new Image("sample/resources/images/fungus.png");
            ImageView fungus = new ImageView();
            fungus.setImage(image);
            fungus.setX(x);
            fungus.setY(y);
            bonuses.add(fungus);
            root.getChildren().addAll(fungus);
        }
    }

    /*
      Создание стенок игрового поля
     */
    public void createBorders() {
        top = new Rectangle(511, 1, Color.RED);
        top.setX(root.getLayoutX());
        top.setY(root.getLayoutY() - 1);
        root.getChildren().addAll(top);

        left = new Rectangle(1, 511, Color.RED);
        left.setX(root.getLayoutX() - 1);
        left.setY(root.getLayoutY());
        root.getChildren().addAll(left);

        right = new Rectangle(1, 511, Color.RED);
        right.setX(root.getLayoutX() + 510);
        right.setY(root.getLayoutY());
        root.getChildren().addAll(right);

        bottom = new Rectangle(511, 1, Color.RED);
        bottom.setX(root.getLayoutX());
        bottom.setY(root.getLayoutY() + 510);
        root.getChildren().addAll(bottom);
    }

    /*
      Обработка нажатия кнопок
     */
    public void update() {
        if (isPressed(KeyCode.UP)) {
            hero.animation.play();
            hero.animation.setY(144);
            hero.moveByVertical(-2);
            if (hero.getBoundsInParent().intersects(Main.top.getBoundsInParent())) {
                hero.setTranslateX(hero.getTranslateX());
                hero.setTranslateY(Main.bottom.getY() - 50);
            }
        } else if (isPressed(KeyCode.DOWN)) {
            hero.animation.play();
            hero.animation.setY(0);
            hero.moveByVertical(2);
            if (hero.getBoundsInParent().intersects(Main.bottom.getBoundsInParent())) {
                hero.setTranslateX(hero.getTranslateX());
                hero.setTranslateY(Main.top.getY() + 3);
            }
        } else if (isPressed(KeyCode.RIGHT)) {
            hero.animation.play();
            hero.animation.setY(96);
            hero.moveByHorizontal(2);
            if (hero.getBoundsInParent().intersects(Main.right.getBoundsInParent())) {
                hero.setTranslateX(Main.left.getX() + 5);
                hero.setTranslateY(hero.getTranslateY());
            }
        } else if (isPressed(KeyCode.LEFT)) {
            hero.animation.play();
            hero.animation.setY(48);
            hero.moveByHorizontal(-2);
            if (hero.getBoundsInParent().intersects(Main.left.getBoundsInParent())) {
                hero.setTranslateX(Main.right.getX() - 33);
                hero.setTranslateY(hero.getTranslateY());
            }
        } else {
            hero.animation.stop();
        }
    }

    public boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final int[] t = {60};

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                createBorders();
                update();
                bonus();
            }
        };
        timer.start();

        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(1000),
                        ae -> {
                            if (t[0] > -1) {
                                System.out.println("Осталось: " + t[0] + " сек.");
                                primaryStage.setTitle("ForesterGirl  " + t[0] + " cек.");
                            }
                            t[0]--;
                            if (t[0] < 0) {
                                try {
                                    this.stop();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                timer.stop();
                                if (t[0] == -1) {
                                    hero.animation.stop();
                                    System.out.println("Игра завершена!");
                                    System.out.println("Ваш счет = " + hero.score);

                                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                    alert.setTitle("Game Over");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Игра завершена" + "\n" + "Ваш счет = " + hero.score);
                                    ButtonType endTheGameButton = new ButtonType("Выход", ButtonBar.ButtonData.CANCEL_CLOSE);
                                    alert.getButtonTypes().setAll(endTheGameButton);
                                    alert.showingProperty().addListener((observable, oldValue, newValue) -> {
                                        if (!newValue) {
                                            primaryStage.close();
                                        }
                                    });
                                    alert.show();
                                }
                            }
                        }
                )
        );

        timeline.setCycleCount(61);
        timeline.play();

        root.getChildren().addAll(hero);
        root.setId("pane");
        Scene scene = new Scene(root, windowWidth, windowHeight);
        scene.setFill(Color.AZURE);
        scene.setOnKeyPressed(event -> keys.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> {
            keys.put(event.getCode(), false);
        });

        primaryStage.setResizable(false);
        primaryStage.setFullScreen(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}