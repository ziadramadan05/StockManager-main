import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    public static String file ="C://Users//Ziiad//Downloads//Sheet1.csv";
    //File file = new File("userdata.csv");

// singiliton ,observable
    @Override
    public void start(Stage primarystage) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("fxmldocument.fxml"));
        primarystage.setTitle("login form");
//        primarystage.setMinWidth(320);
//        primarystage.setMaxWidth(350);
//        primarystage.setMinHeight(520);
//        primarystage.setMaxHeight(580);
        primarystage.setScene(new Scene(root1,330,550));
        //  primarystage.setMaximized(true);
        primarystage.setFullScreen(false);
        primarystage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
