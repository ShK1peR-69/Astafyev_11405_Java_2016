package sample;

import com.sun.javafx.geom.Vec2f;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Random;

import static java.lang.Math.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("RedArm");
        primaryStage.setScene(createScene());
        primaryStage.show();
    }

    private int windowWidth = 700;
    private int windowHeight = 600;

    private Scene createScene() {
        Group root = new Group();
        for (int i = 0; i < 13; i++) {
            root.getChildren().add(createLabel());
        }
        return new Scene(root, windowWidth, windowHeight);
    }

    private Random random = new Random(); // нам нужен рандом!!

    private ImageView createLabel() {
        Image img = new Image("sample/resources/Solder.png");
        ImageView label = new ImageView();    // создание билдера для Label
        label.setImage(img);            // текстовое значение
        label.prefWidth(72);                // возможная ширина
        label.prefHeight(48);                // возможная высота
        label.setLayoutX(random.nextInt(windowWidth - 100)); // задание  коорд. Х
        label.setLayoutY(random.nextInt(windowHeight - 50));  // задание  коорд. Y
        label.setStyle("-fx-background-color: orange;");  // зарисуем фон в оранжевый
        addTranslateListener(label);
        return label;
    }

    private Node node;   // ссылка на объект, который будем перетаскивать
    private Vec2f delta; // координаты указателя мыши относительно элемента
    private ImageView addingView;
    // нужны для того, чтобы не было резкого рывка вначале движения
/*
    private void addTranslateListener(final Node node) {
        node.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                delta = new Vec2f((float) (mouseEvent.getSceneX() - node.getLayoutX()),
                        (float) (mouseEvent.getSceneY() - node.getLayoutY()));
                // вичисление координат относительно элемeнта
                Main.this.node = node;   // сохраняем ссылку на объект
            }
        });
        node.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.this.node = null;  // обнулям ссылку на объект
            }
        });
        node.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (node != null) {
// если есть что перетаскивать, перетаскиваем
                    node.setLayoutX(mouseEvent.getSceneX() - delta.x);
                    node.setLayoutY(mouseEvent.getSceneY() - delta.y);
                }
            }
        });
    }
    */
    boolean isRotate;

    private void addTranslateListener(final Node node) {

        node.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                delta = new Vec2f((float) (mouseEvent.getSceneX() - node.getLayoutX()),
                        (float) (mouseEvent.getSceneY() - node.getLayoutY()));
                node.setLayoutX(random.nextInt(windowWidth - 96));
                node.setLayoutY(random.nextInt(windowHeight - 30));

                double angle = node.getRotate();


                Main.this.node = node;
                if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                    isRotate = true;
                }
            }
        });

        node.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.this.node = null;
                isRotate = false;
            }
        });


        node.setOnMouseDragged(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                if (node != null) {
                    if (isRotate) {
                        // подсчет нового угла основуется на подсчета угла между двома векторами
// это несложная математика, и поэтому тут должно быть все понятно)
                        double dx1 = mouseEvent.getSceneX() - node.getLayoutX();
                        double dy1 = mouseEvent.getSceneY() - node.getLayoutY();
                        double l = Math.sqrt(dx1 * dx1 + dy1 * dy1);
                        dx1 /= l; // нормализация
                        dy1 /= l; // вектора

                        double angle = PI / 2; // за второй вектор было взято
                        double dx2 = sin(angle);      // единичный вектор,
                        double dy2 = cos(angle);      // который повернутый на 90 градусов

                        double cosA = dx1 * dx2 + dy1 * dy2;
                        angle = acos(cosA);

                        if (dy1 < 0) angle = PI - angle;
                        node.setRotate(angle / PI * 180); // из радиан в градусы
                    } else {
                        node.setLayoutX(mouseEvent.getSceneX() - delta.x);
                        node.setLayoutY(mouseEvent.getSceneY() - delta.y);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}