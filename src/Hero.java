import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class Hero extends AnimatedThing {
    private boolean jumping = false;
    private double x;
    private double y;
    private Camera camera;

    public Hero(double x, double y, int attitude, int index, int duration, int maxIndex, double windowSize, double frameOffset, int mirror, String fileName) {
        super(x, y, attitude, index, duration, maxIndex, windowSize, frameOffset, mirror,fileName);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void jump() {
        if (getImageView().getY() >= 150 && !jumping) {
            jumping = true;
            y = -3.0;
        }
    }

    public void moveLeft() {
        x=-2;
        setMirror(-1);
    }

    public void moveRight() {
        x=2;
        setMirror(1);
    }

    @Override
    public void update(long time) {
        camera.setX(camera.getX() + x);
        super.update(time);
        if (jumping || getImageView().getY() < 150) {
            double gravity = 0.1;
            y += gravity;
            setAll(2, 4, 3, 4);
            updateViewport();
            getImageView().setY(getImageView().getY() + y);
            if (getImageView().getY() < 150 && y < 0) {
                setAll(2, 4, 2, 4);
                updateViewport();
            }
        }
        if (getImageView().getY() >= 150) {
            getImageView().setY(150);
            y = 0.0;
            jumping = false;
            setAll(70, 3, 0, 6);
        }
    }
}
