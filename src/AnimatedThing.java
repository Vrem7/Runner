import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    private final double x;
    private final double y;
    final ImageView imageView;
    private int attitude;
    private int index;
    private int duration;
    private int maxIndex;
    private final double windowSize;
    private final double frameOffset;
    private int mirror;

    public AnimatedThing(double x, double y, int attitude, int index, int duration, int maxIndex, double windowSize, double frameOffset, int mirror, String fileName) {
        this.x = x;
        this.y = y;
        this.attitude = attitude;
        this.index = index;
        this.duration = duration;
        this.maxIndex = maxIndex;
        this.windowSize = windowSize;
        this.frameOffset = frameOffset;
        this.mirror = mirror;

        Image spriteSheet = new Image(fileName);
        imageView = new ImageView(spriteSheet);

        updateViewport();
    }

    protected void updateViewport() {
        double xOffset = index * frameOffset;
        double yOffset = attitude * windowSize;
        imageView.setViewport(new Rectangle2D(xOffset, yOffset, windowSize, windowSize));
        if (mirror == -1) {
            imageView.setScaleX(-1);
        } else {
            imageView.setScaleX(1);
        }
    }
    public void update(long time) {
        index = (int) ((time / (duration * 1_000_000)) % maxIndex);
        updateViewport();
    }
    public void setAll(int duration, int attitude, int index, int maxIndex) {
        this.duration = duration;
        this.attitude = attitude;
        this.index = index;
        this.maxIndex = maxIndex;
    }
    public void setMirror(int mirror) {
        this.mirror = mirror;
    }
}
