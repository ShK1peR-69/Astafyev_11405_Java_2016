package sample;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork_2
 */

public class Hero extends Pane {

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

    /*
      Движение по горизонтали
     */
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

    /*
      Движение по вертикали
     */
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

    /*
      Поедание "грибочков"
     */
    public void isBonusEat() {
        for (ImageView fungus : Main.bonuses) {
            if (this.getBoundsInParent().intersects(fungus.getBoundsInParent())) {
                deletingFungus = fungus;
                score++;
            }
        }
        Main.bonuses.remove(deletingFungus);
        Main.root.getChildren().remove(deletingFungus);
    }
}
