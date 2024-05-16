//import java.io.IOException;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.*;
//
//
//public class viewswitch {
//    private static Scene scene;
//    public static void setScene(Scene scene) {
//        viewswitch.scene = scene;
//    }
//
//    public static void switchto(view view) {
//        if (scene == null) {
//           System.out.println("No scene was set");
//            return;
//        }
//        try {
//            var root = FXMLLoader.load(viewswitch.class.getResource(view.getfilename()));
//            scene.setRoot((Parent) root);
//            // Stage stage = new Stage(null);
//            // stage.setScene(new Scene((Parent) root,930,550));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // }
//
//        //     try {
//        //         var root = FXMLLoader.load(viewswitch.class.getResource(view.getfilename()));
//        //         scene.setRoot((Parent) root);
//        //     } catch (IOException e) {
//        //         e.printStackTrace();
//        //     }
//        }
//
//
//    }
//
