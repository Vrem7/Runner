import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class HelloWorld extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Camera camera = new Camera(100, 150);
        GameScene gameScene = new GameScene(root, 600, 400, true);

        stage.setScene(gameScene);
        stage.show();

        Image spriteSheet = new Image("file:/Users/AskyM/IdeaProjects/Runner/img/heros.png");
        ImageView sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20, 0, 65, 100));

        sprite.setX(camera.getX());
        sprite.setY(camera.getY());

        root.getChildren().add(sprite);

        System.out.println("Coordonnées de la caméra: " + camera.toString());
    }

    public static void main(String[] args){
        launch(args);
    }

}
