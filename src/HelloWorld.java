import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        GameScene gameScene = new GameScene(root, 600, 400, true);
        stage.setScene(gameScene);
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
