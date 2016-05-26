package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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

    public void bonus() {
        int number = random.nextInt(7777);
        int x = random.nextInt(windowWidth - 20);
        int y = random.nextInt(windowHeight - 10);
        if (number < 96) {
            Image image = new Image("sample/resources/images/fungus.png");
            ImageView fungus = new ImageView();
            fungus.setImage(image);
            fungus.setX(x);
            fungus.setY(y);
            bonuses.add(fungus);
            root.getChildren().addAll(fungus);
        }
    }

    public void createBorders() {
        top = new Rectangle(510, 1, Color.RED);
        top.setX(root.getLayoutX());
        top.setY(root.getLayoutY());
        root.getChildren().addAll(top);

        left = new Rectangle(1, 510, Color.RED);
        left.setX(root.getLayoutX());
        left.setY(root.getLayoutY());
        root.getChildren().addAll(left);

        right = new Rectangle(1, 510, Color.RED);
        right.setX(root.getLayoutX() + 509);
        right.setY(root.getLayoutY());
        root.getChildren().addAll(right);

        bottom = new Rectangle(510, 1, Color.RED);
        bottom.setX(root.getLayoutX());
        bottom.setY(root.getLayoutY() + 509);
        root.getChildren().addAll(bottom);
    }

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
        } else if (isPressed(KeyCode.RIGHT)) {
            hero.animation.play();
            hero.animation.setY(96);
            hero.moveByHorizontal(2);
        } else if (isPressed(KeyCode.LEFT)) {
            hero.animation.play();
            hero.animation.setY(48);
            hero.moveByHorizontal(-2);
        } else {
            hero.animation.stop();
        }
    }

    public boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        root.getChildren().addAll(hero);
        Image fon = new Image("sample/resources/images/field.png");

        Scene scene = new Scene(root, windowWidth, windowHeight);
        scene.setOnKeyPressed(event -> keys.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> {
            keys.put(event.getCode(), false);
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                createBorders();
                update();
                bonus();
            }
        };
        timer.start();
        primaryStage.setTitle("ForesterGirl");
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}