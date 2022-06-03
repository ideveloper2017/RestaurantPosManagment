package uz.namangan.rest.service;

import javafx.concurrent.Service;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.namangan.rest.model.Language;

import java.util.List;

public  class LanguageServiceImpl extends BaseCrudService<Language, JpaRepository<Language,Long>> implements LanguageService{
    @Override
    public Service<Language> save(Language obj, EventHandler<WorkerStateEvent> onSuccess, EventHandler<WorkerStateEvent> beforeStart) throws Exception {
        return null;
    }

    @Override
    public Service<List<Language>> findAll(EventHandler<WorkerStateEvent> onSucess, EventHandler<WorkerStateEvent> beforeStart) {
        return null;
    }

    @Override
    public Service<Void> delete(long id, EventHandler<WorkerStateEvent> onSucess, EventHandler<WorkerStateEvent> beforeStart) throws Exception {
        return null;
    }

    @Override
    public Service<Language> find(long id, EventHandler<WorkerStateEvent> onSucess, EventHandler<WorkerStateEvent> beforeStart) throws Exception {
        return null;
    }

    @Override
    public Service<Language> changeDefaultLanguage(Language newDefaultLanguage, EventHandler<WorkerStateEvent> onSuccess, EventHandler<WorkerStateEvent> beforeStart) {
        return null;
    }

    @Override
    public Service<Language> findDefaultLanguage(EventHandler<WorkerStateEvent> onSucess, EventHandler<WorkerStateEvent> beforeStart) {
        return null;
    }

    @Override
    public Language findDefaultLanguage() {
        return null;
    }

    @Override
    public Service<Void> cleanLanguageDefault(EventHandler<WorkerStateEvent> onSucess, EventHandler<WorkerStateEvent> beforeStart) {
        return null;
    }

    @Override
    public Service<Void> setLanguageAsDefault(String language, String country, EventHandler<WorkerStateEvent> onSucess, EventHandler<WorkerStateEvent> beforeStart) {
        return null;
    }
}
