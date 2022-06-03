package uz.namangan.rest.service;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseService {

    private List<Service<?>> services;

    public BaseService(){
        this.services=new ArrayList<>();
    }

    protected <D> Service<D> createService(Task<D> task, EventHandler<WorkerStateEvent> onSuccess,EventHandler<WorkerStateEvent>beforeStart){
        Service<D> service=new Service<D>() {
            @Override
            protected Task<D> createTask() {
                return task;
            }
        };
        if (onSuccess!=null){
            service.setOnSucceeded(onSuccess);
        }

        if (beforeStart!=null){
            service.setOnScheduled(beforeStart);
        }
        service.setOnFailed(e->{
            System.out.println("Failed:"+ e.getSource().getMessage());
        });
        service.start();
        services.add(service);
        return service;
    }

    public void onClose(){
        for(Service<?> service:services){
            service.cancel();
        }
    }
}
