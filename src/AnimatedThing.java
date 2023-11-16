import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    private final ImageView imageView;
    private final int attitude;
    private final int index;
    private final double windowSize;
    private final double frameOffset;

    public AnimatedThing(double x, double y, int attitude, int index, int duration, int maxIndex,
                         double windowSize, double frameOffset, String fileName) {
        this.attitude = attitude;
        this.index = index;
        this.windowSize = windowSize;
        this.frameOffset = frameOffset;

        Image spriteSheet = new Image(fileName);
        imageView = new ImageView(spriteSheet);

        updateViewport();
    }
    protected void updateViewport() {
        double xOffset = index * frameOffset;
        double yOffset = attitude * windowSize;
        imageView.setViewport(new Rectangle2D(xOffset, yOffset, windowSize, windowSize));
    }
}
