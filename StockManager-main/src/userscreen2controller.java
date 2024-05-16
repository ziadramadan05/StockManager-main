import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class userscreen2controller {
    private Stage stage;
    private Parent root;
    private boolean userFound;
    @FXML
    private Button UserScreen2_orderstocks;
    @FXML
    private Button userscreen2_deposit;

    public void switchtostockscreen(ActionEvent event) {
        if (event.getSource() == UserScreen2_orderstocks) {

            try {
                Parent root = FXMLLoader.load(getClass().getResource("stockscreen.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setTitle("Stock screen section");
                stage.setScene(new Scene(root));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void switchtodepositscreen(ActionEvent event) {
        if (event.getSource() == userscreen2_deposit) {

            try {
                root = FXMLLoader.load(getClass().getResource("depositscreen.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Stock screen section");
                stage.setScene(new Scene(root));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
