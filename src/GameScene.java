import javafx.scene.Group;
import javafx.scene.Scene;

public class GameScene extends Scene {
    private StaticThing leftBackground;
    private StaticThing rightBackground;
    private int numberOfLives = 3;
    public GameScene(Group root, double width, double height, boolean depthBuffer) {
        super(root, width, height, depthBuffer);

        leftBackground = new StaticThing(0, 0, "file:/Users/AskyM/IdeaProjects/Runner/img/desert.png");
        rightBackground = new StaticThing(800, 0, "file:/Users/AskyM/IdeaProjects/Runner/img/desert.png");

        leftBackground.getImageView().setX(0);
        rightBackground.getImageView().setX(width - rightBackground.getImageView().getFitWidth());

        root.getChildren().addAll(leftBackground.getImageView(), rightBackground.getImageView());

        numberOfLives = 3;
        for (int i = 0; i < numberOfLives; i++) {
            StaticThing heart = new StaticThing(20, 20, "file:/Users/AskyM/IdeaProjects/Runner/img/heart.png");
            heart.getImageView().setX((i+0.5) * 30);
            heart.getImageView().setY(10);
            root.getChildren().add(heart.getImageView());
        }
    }
    public void render(Camera camera) {
        leftBackground.getImageView().setX((-camera.getX())%800);
        rightBackground.getImageView().setX(800-camera.getX()%800);
    }
    public StaticThing getLeftBackground() {
        return leftBackground;
    }
    public StaticThing getRightBackground() {
        return rightBackground;
    }

}
