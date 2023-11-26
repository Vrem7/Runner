import javafx.scene.image.ImageView;
public class Hero extends AnimatedThing{
    private boolean jumping = false;
    private double vy = 0.0;
    private double gravity = 0.1;
    public Hero(double x, double y, int attitude, int index, int duration, int maxIndex, double windowSize, double frameOffset, String fileName) {
        super(x, y, attitude, index, duration, maxIndex, windowSize, frameOffset, fileName);
    }
    public ImageView getImageView() {
        return imageView;
    }
    public void jump() {
        if (getImageView().getY() >= 150) {
            jumping = true;
            vy = -3.0;
            setAll(400, 4, 1, 4);
        }
    }
    @Override
    public void update(long time) {
        super.update(time);
        if (jumping || getImageView().getY() < 150) {
            vy += gravity;
            getImageView().setY(getImageView().getY() + vy);
        }
        if (getImageView().getY() >= 150) {
            getImageView().setY(150);
            vy = 0.0;
            jumping = false;
            setAll(100, 3, 0, 6);
        }
    }
}
