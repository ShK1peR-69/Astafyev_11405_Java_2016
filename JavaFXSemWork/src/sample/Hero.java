package sample;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class Hero extends Pane {

    private int windowWidth = 500;
    private int windowHeight = 500;
    ImageView imageView;
    int frame = 3;
    int columns = 3;
    int coordX = 0;
    int coordY = 0;
    int width = 30;
    int height = 45;
    int score = 0;
    ImageView deletingFungus = null;
    Animation animation;

    public Hero(ImageView imageView) {
        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(coordX, coordY, width, height));
        animation = new Animation(imageView, Duration.millis(200), frame, columns, coordX, coordY, width, height);
        getChildren().addAll(imageView);
    }

    public void createBorders(){
        Main.top = new Rectangle(510, 1, Color.RED);
        Main.top.setX(Main.root.getLayoutX());
        Main.top.setY(Main.root.getLayoutY());
        Main.root.getChildren().addAll(Main.top);

        Main.left = new Rectangle(1, 510, Color.RED);
        Main.left.setX(Main.root.getLayoutX());
        Main.left.setY(Main.root.getLayoutY());
        Main.root.getChildren().addAll(Main.left);

        Main.right = new Rectangle(1, 510, Color.RED);
        Main.right.setX(Main.root.getLayoutX() + 509);
        Main.right.setY(Main.root.getLayoutY());
        Main.root.getChildren().addAll(Main.right);

        Main.bottom = new Rectangle(510, 1, Color.RED);
        Main.bottom.setX(Main.root.getLayoutX());
        Main.bottom.setY(Main.root.getLayoutY() + 509);
        Main.root.getChildren().addAll(Main.bottom);
    }

    public void moveByHorizontal(int x) {
        boolean horizontal = true;
        if (x < 0) {
            horizontal = false;
        }
        for (int i = 0; i < Math.abs(x); i++) {
            if (horizontal) {
                this.setTranslateX(this.getTranslateX() + 1);
            } else {
                this.setTranslateX(this.getTranslateX() - 1);
            }
            isBonusEat();
        }
    }

    public void moveByVertical(int y) {
        boolean vertical = true;
        if (y < 0) {
            vertical = false;
        }
        for (int i = 0; i < Math.abs(y); i++) {
            if (vertical) {
                this.setTranslateY(this.getTranslateY() + 1);
            } else {
                this.setTranslateY(this.getTranslateY() - 1);
            }
            isBonusEat();
        }
    }

    public void isBonusEat() {
        for (ImageView fungus : Main.bonuses) {
            if (this.getBoundsInParent().intersects(fungus.getBoundsInParent())) {
                deletingFungus = fungus;
                score++;
                System.out.println(score);
            }
        }
        Main.bonuses.remove(deletingFungus);
        Main.root.getChildren().remove(deletingFungus);
    }
}
