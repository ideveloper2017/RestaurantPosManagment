package uz.namangan.rest;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import uz.namangan.rest.model.Language;
import uz.namangan.rest.service.LanguageService;
import uz.namangan.rest.util.I18N;

import java.util.Locale;

@SpringBootApplication
public class MainApplication extends Application {

    public static ConfigurableApplicationContext springContext;
    private LanguageService languageService;
    public static I18N i18n;

        public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        launch(args);
    }


    @Override
    public void init() throws Exception {
        springContext=SpringApplication.run(MainApplication.class);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    private void initI18N() {
        Language languageDefault = languageService.findDefaultLanguage();

        if (languageDefault != null) {
            i18n = new I18N(new Locale(languageDefault.getLanguageCode(), languageDefault.getCountryCode()));
        } else {
            i18n = new I18N(I18N.PORTUGUESE_BRAZILLIAN);
        }
    }
}
