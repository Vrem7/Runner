import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import java.util.List;
import java.util.ArrayList;

public class GameScene extends Scene {
    private StaticThing leftBackground;
    private StaticThing rightBackground;
    private int numberOfLives = 3;
    private List<Hero> heroes;
    private int currentHeroIndex;
    private Camera camera;

    public GameScene(Group root, double width, double height, boolean depthBuffer) {
        super(root, width, height, depthBuffer);

        leftBackground = new StaticThing(0, 0, "file:/Users/AskyM/IdeaProjects/Runner/img/bg.png");
        rightBackground = new StaticThing(800, 0, "file:/Users/AskyM/IdeaProjects/Runner/img/bg.png");

        leftBackground.getImageView().setX(0);
        rightBackground.getImageView().setX(width - rightBackground.getImageView().getFitWidth());

        root.getChildren().addAll(leftBackground.getImageView(), rightBackground.getImageView());

        numberOfLives = 3;
        for (int i = 0; i < numberOfLives; i++) {
            StaticThing heart = new StaticThing(20, 20, "file:/Users/AskyM/IdeaProjects/Runner/img/heart.png");
            heart.getImageView().setX((i + 0.5) * 30);
            heart.getImageView().setY(10);
            root.getChildren().add(heart.getImageView());
        }

        Hero naruto = new Hero(100, 250, 3, 2, 70, 6, 90, 90, 1, "file:/Users/AskyM/IdeaProjects/Runner/img/naruto.png");
        Hero sasuke = new Hero(100, 250, 3, 2, 70, 6, 82, 82, 1, "file:/Users/AskyM/IdeaProjects/Runner/img/sasuke.png");
        Hero sakura = new Hero(100, 250, 3, 2, 70, 6, 82, 82, 1, "file:/Users/AskyM/IdeaProjects/Runner/img/sakura.png");
        Hero kakashi = new Hero(100, 250, 3, 2, 70, 6, 90, 90, 1, "file:/Users/AskyM/IdeaProjects/Runner/img/kakashi.png");
        heroes = new ArrayList<>();
        heroes.add(naruto);
        heroes.add(sasuke);
        heroes.add(sakura);
        heroes.add(kakashi);
        currentHeroIndex = 0;

        Camera camera = new Camera(150, 90, heroes.get(currentHeroIndex));

        for (int i = 0; i < heroes.size(); i++) {

            Hero hero = heroes.get(i);
            hero.setCamera(camera);
            hero.getImageView().setX(100);
            root.getChildren().add(hero.getImageView());
            hero.getImageView().setVisible(i == currentHeroIndex);
        }

        this.setOnMouseClicked((event) -> {
            System.out.println("Jump");
            heroes.get(currentHeroIndex).jump();
        });
        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE || e.getCode() == KeyCode.UP || e.getCode() == KeyCode.Z) {
                heroes.forEach(Hero::jump);
            }
            if (e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.D) {
                heroes.forEach(Hero::moveRight);
            }
            if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.Q) {
                heroes.forEach(Hero::moveLeft);
            }
            if (e.getCode() == KeyCode.R) {
                heroes.get(currentHeroIndex).getImageView().setVisible(false);
                currentHeroIndex = (currentHeroIndex + 1) % heroes.size();
                heroes.forEach(hero -> hero.setCamera(camera));
                heroes.get(currentHeroIndex).getImageView().setVisible(true);
            }
            if (e.getCode() == KeyCode.E) {
                heroes.get(currentHeroIndex).getImageView().setVisible(false);
                currentHeroIndex = (currentHeroIndex - 1 + heroes.size()) % heroes.size();
                heroes.forEach(hero -> hero.setCamera(camera));
                heroes.get(currentHeroIndex).getImageView().setVisible(true);
            }
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long time) {
                heroes.forEach(hero -> hero.update(time));
                render(camera);
                update(time);
            }
        };

        timer.start();
    }

    public void render(Camera camera) {
        leftBackground.getImageView().setX((-camera.getX()) % 800);
        rightBackground.getImageView().setX(leftBackground.getImageView().getX() + (leftBackground.getImageView().getX() < 0 ? 800 : -800));
    }

    public void update(long time) {

    }
}
