package sample;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class Animation extends Transition {

    private final ImageView imageView;
    private final int column;
    private final int frame;
    private int coordX;
    private int coordY;
    private int width;
    private int height;

    public Animation(ImageView imageView, Duration duration, int column, int frame, int coordX, int coordY,
                     int width, int height) {
        this.imageView = imageView;
        this.column = column;
        this.frame = frame;
        this.coordX = coordX;
        this.coordY = coordY;
        this.width = width;
        this.height = height;
        setCycleDuration(duration);
        setCycleCount(Animation.INDEFINITE);
        setInterpolator(Interpolator.LINEAR);
        this.imageView.setViewport(new Rectangle2D(coordX, coordY, width, height));
    }

    public void setX(int x) {
        this.coordX = x;
    }

    public void setY(int y) {
        this.coordY = y;
    }

    @Override
    protected void interpolate(double frac) {
        final int index = Math.min((int) Math.floor(frame * frac), frame - 1);
        final int x = (index % column) * width + coordX;
        final int y = (index / column) * height + coordY;
        imageView.setViewport(new Rectangle2D(x, y, width, height));
    }

}
