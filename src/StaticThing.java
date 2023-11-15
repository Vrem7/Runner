import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {
    private final ImageView imageView;
    public StaticThing(double sizeX, double sizeY, String fileName) {

        Image image = new Image(fileName);
        imageView = new ImageView(image);
    }
    public ImageView getImageView() {
        return imageView;
    }
}
