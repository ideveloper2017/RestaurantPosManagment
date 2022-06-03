package uz.namangan.rest.service;

import javafx.concurrent.Service;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

import java.util.List;

public interface IBaseService<T> {
    public Service<T> save(T obj, EventHandler<WorkerStateEvent> onSuccess,EventHandler<WorkerStateEvent> beforeStart) throws  Exception;
    public Service<List<T>> findAll(EventHandler<WorkerStateEvent> onSucess, EventHandler<WorkerStateEvent> beforeStart);

    public Service<Void> delete(long id, EventHandler<WorkerStateEvent> onSucess, EventHandler<WorkerStateEvent> beforeStart) throws Exception;
    public Service<T> find(long id, EventHandler<WorkerStateEvent> onSucess, EventHandler<WorkerStateEvent> beforeStart) throws Exception;

    public void onClose();
}
