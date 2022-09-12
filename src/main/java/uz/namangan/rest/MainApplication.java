package uz.namangan.rest;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import uz.namangan.rest.controllers.LoginController;
import uz.namangan.rest.controllers.RootController;
import uz.namangan.rest.model.Language;
import uz.namangan.rest.model.User;
import uz.namangan.rest.service.LanguageService;
import uz.namangan.rest.service.UserService;
import uz.namangan.rest.util.I18N;
import uz.namangan.rest.util.WindowsUtils;

import java.util.Locale;

@SpringBootApplication
public class MainApplication extends Application {

    public static ConfigurableApplicationContext springContext;
    private LanguageService languageService;
    public static I18N i18n;

    public static HostServices hostServices;


    private UserService userService;

    public static void main(String[] args) {
        System.setProperty("spring.application.admin.enabled", "true");

        SpringApplication.run(MainApplication.class, args);
        launch(args);
    }


    @Override
    public void init() throws Exception {
//        springContext=SpringApplication.run(MainApplication.class);
//        userService=springContext.getBean(UserService.class);

    }



    private void initI18N() {
        Language languageDefault = languageService.findDefaultLanguage();

        if (languageDefault != null) {
            i18n = new I18N(new Locale(languageDefault.getLanguageCode(), languageDefault.getCountryCode()));
        } else {
            i18n = new I18N(I18N.PORTUGUESE_BRAZILLIAN);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        hostServices = this.getHostServices();
//
//        userService.finUserSignIn(e -> {
//            try {
//                User user = (User) e.getSource().getValue();
//
//                if (user == null) {
                   // WindowsUtils.openNewWindow(primaryStage, LoginController.PATH_FXML, i18n.getString(LoginController.LOGIN_TITLE_KEY), LoginController.PATH_ICON, null);
//                } else {
//                    WindowsUtils.openNewWindow(primaryStage, RootController.PATH_FXML, i18n.getString(RootController.ROOT_TITLE_KEY), RootController.PATH_ICON, null);
//                }
//            } catch(Exception ex) {
//                ex.printStackTrace();
//            }

//        }, null);

    }
}
