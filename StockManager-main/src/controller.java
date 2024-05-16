import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.opencsv.CSVWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class controller implements Initializable {

    @FXML
    private CheckBox login_checkBox;

    @FXML
    private AnchorPane login_form;

    @FXML
    private Button login_login;

    @FXML
    private PasswordField login_password;

    @FXML
    private Hyperlink login_registerhere;

    @FXML
    private TextField login_showpassword;

    @FXML
    private TextField login_username;

    @FXML
    private AnchorPane main_form;

    @FXML
    private CheckBox register_checkBox;

    @FXML
    private TextField register_email;

    @FXML
    private AnchorPane register_form;

    @FXML
    private Hyperlink register_loginhere;

    @FXML
    private PasswordField register_password;

    @FXML
    private TextField register_showpassword;

    @FXML
    private Button register_signup;

    @FXML
    private TextField register_username;
    private Stage stage;
    private Parent root;
    private boolean userFound;
    private Alertmessage alert = new Alertmessage();

    // login button action
    public void registerAccount() {

        if (register_email.getText().isEmpty() || register_username.getText().isEmpty()
                || register_password.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {

            alert.confirmationMessage("successful register");
        }

    }


    // sign up button action
    public void LoginAccount() {

        if (login_username.getText().isEmpty()
                || login_password.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {

            alert.confirmationMessage("successful login");
        }

    }

    // show password of Register form
    public void registershowpassword() {
        if (register_checkBox.isSelected()) {
            register_showpassword.setText(register_password.getText());
            register_showpassword.setVisible(true);
            register_password.setVisible(false);
        } else {
            register_showpassword.setText(register_password.getText());
            register_showpassword.setVisible(false);
            register_password.setVisible(true);
        }
    }

    // show password of login form
    public void login_showpassword() {
        if (login_checkBox.isSelected()) {
            login_showpassword.setText(login_password.getText());
            login_showpassword.setVisible(true);
            login_password.setVisible(false);
        } else {
            login_showpassword.setText(login_password.getText());
            login_showpassword.setVisible(false);
            login_password.setVisible(true);
        }
    }


    public void switchform(ActionEvent event) {
        if (event.getSource() == login_registerhere) {
            login_form.setVisible((false));
            register_form.setVisible(true);
        } else if (event.getSource() == register_loginhere) {
            login_form.setVisible((true));
            register_form.setVisible(false);
        }
    }
    public void onlogin(ActionEvent event) throws IOException {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(Main.file))) {
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row.length >= 3) { // Ensure there are at least three values in the row
                    String usernameFromFile = row[0];
                    String passwordFromFile = row[2];
                    String usernameInput = login_username.getText();
                    String passwordInput = login_password.getText();
                    String showedpasswordInput = login_showpassword.getText();
                    if ((usernameFromFile.equals(usernameInput)
                            && (passwordFromFile.equals(passwordInput) || passwordFromFile.equals(showedpasswordInput))) ||
                            (usernameFromFile.equals("\"" + usernameInput + "\"")
                                    && ((passwordFromFile.equals("\"" + passwordInput + "\""))
                                    || (passwordFromFile.equals("\"" + showedpasswordInput + "\""))))) {
                        userFound = true;
                        break;
                    }
                } else {
                    // Handle invalid or malformed lines in the CSV file
                    System.err.println("Invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rest of your code for handling user login...



        if (userFound) {

            root = FXMLLoader.load(getClass().getResource("stockscreen.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
//        else if(login_username.getText() == "zi" && login_password.getText() == "ad") {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("stockManege.fxml"));
//            Parent root = loader.load();
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        }


        else  {
            root = FXMLLoader.load(getClass().getResource("adminscreen.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            //System.out.println("Invalid username or password");
        }
    }






    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
       
//        userList();

    }
    @FXML
    void registerAccount(ActionEvent event) throws IOException {
        String emailInput = register_email.getText();
        String passwordInput = register_password.getText();
        String usernameInput = register_username.getText();
        File csvFile = new File(Main.file);
        try (FileWriter fileWriter = new FileWriter(csvFile, true);
             CSVWriter csvWriter = new CSVWriter(fileWriter)) {
            String[] newUser = { emailInput, usernameInput, passwordInput };
            if (!emailInput.isEmpty() && !usernameInput.isEmpty() && !passwordInput.isEmpty()) {
                csvWriter.writeNext(newUser);
                System.out.println("New user added successfully.");
                login_form.setVisible((true));
                register_form.setVisible(false);
            } else {
                System.out.println("Please fill in all fields.");
            }
        }
    }

}
