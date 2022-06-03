package uz.namangan.rest.service;

import javafx.concurrent.Service;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import uz.namangan.rest.model.Language;

public interface LanguageService extends IBaseService<Language> {

    Service<Language>changeDefaultLanguage(Language newDefaultLanguage, EventHandler<WorkerStateEvent>onSuccess,EventHandler<WorkerStateEvent> beforeStart);
    Service<Language> findDefaultLanguage(EventHandler<WorkerStateEvent> onSucess, EventHandler<WorkerStateEvent> beforeStart);
    Language findDefaultLanguage();

    Service<Void> cleanLanguageDefault(EventHandler<WorkerStateEvent> onSucess, EventHandler<WorkerStateEvent> beforeStart);

    Service<Void> setLanguageAsDefault(String language, String country, EventHandler<WorkerStateEvent> onSucess, EventHandler<WorkerStateEvent> beforeStart);
}
