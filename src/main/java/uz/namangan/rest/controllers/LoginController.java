package uz.namangan.rest.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uz.namangan.rest.model.User;
import uz.namangan.rest.service.UserService;
import uz.namangan.rest.util.ValidatorUtils;
import uz.namangan.rest.util.WindowsUtils;

import java.util.HashMap;
@Controller
public class LoginController extends BaseController{

    public static final String PATH_FXML = "/view/login.fxml";
    public static final String LOGIN_TITLE_KEY = "login.title";
    public static final String PATH_ICON = WindowsUtils.ICON_APP_PATH;

    @FXML
    private JFXTextField emailTextField;

    @FXML
    private JFXTextField passwordTextField;

    @FXML
    private JFXCheckBox rememberMeCheckBox;

    @FXML
    private JFXButton loginButton;

    @FXML
    private Label errorLabel;

    @Autowired
    private UserService userService;

    public <T> void init(Stage stage, HashMap<String, T> parameters) {
        super.init(stage, parameters);

        validateTextFields();
        watchEvents();
    }


    private void validateTextFields() {

        ValidatorUtils.addRequiredValidator(emailTextField, "E-mail is Required!");
        ValidatorUtils.addRequiredValidator(passwordTextField, "Password is Required!");

        ValidatorUtils.addEmailValidator(emailTextField, "Email does not match");

        WindowsUtils.validateTextField(emailTextField);
        WindowsUtils.validateTextField(passwordTextField);
    }

    private void watchEvents() {
        WindowsUtils.watchEvents(emailTextField, v -> watch());
        WindowsUtils.watchEvents(passwordTextField, v -> watch());
    }


    private void watch() {
        if (isRequiredTextFieldsFilled() && (passwordTextField.validate() && emailTextField.validate())) {
            loginButton.setDisable(false);
        } else {
            loginButton.setDisable(true);
        }

    }


    private boolean isRequiredTextFieldsFilled() {
        return  !(WindowsUtils.isTextFieldEmpty(emailTextField)) &&
                !(WindowsUtils.isTextFieldEmpty(passwordTextField));
    }

    @FXML
    public void onLogin() {

        userService.findByEmailAndPassword(WindowsUtils.getTextFromTextField(emailTextField),
                WindowsUtils.getTextFromTextField(passwordTextField),
                e -> {
                    User user = (User) e.getSource().getValue();

                    if (user != null) {
                        onSucessLogin(user);
                    } else {
                        onErrorLogin();
                    }
                }, null);

    }

    private void onSucessLogin(User user) {
        errorLabel.setVisible(false);

        userService.setUserAsSignin(user.getEmail(),
                user.getPassword(),
                e -> {
                    try {
                        WindowsUtils.openNewWindow(RootController.PATH_FXML, getWindowTitle(RootController.ROOT_TITLE_KEY), RootController.PATH_ICON, null, Modality.WINDOW_MODAL);
                        stage.close();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                }, null);

    }

    private void onErrorLogin() {
        errorLabel.setVisible(true);
    }

    @Override
    protected void onClose() {

    }

}
