package com.tasks.psp.tasksmanager.controllers;

import com.google.gson.Gson;
import com.tasks.psp.tasksmanager.models.BaseResponse;
import com.tasks.psp.tasksmanager.models.JobTask;
import com.tasks.psp.tasksmanager.services.ServiceUtils;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TaskViewController extends NavBar{

    public TableView tasksTable;
    public ObservableList<JobTask> jobTasks;
    public TableColumn<JobTask, String> categoryColumn;
    public TableColumn<JobTask, String> taskNameColumn;
    Gson gson;
    public void initialize(){
        gson = new Gson();
        ServiceUtils.getResponseAsync("/trabajos", null, "GET")
                .thenAccept((response) -> {
                    BaseResponse bs = gson.fromJson(response, BaseResponse.class);
                    Platform.runLater(()->{
                        jobTasks = FXCollections.observableList(bs.trabajos);
                        tasksTable.setItems(jobTasks);
                        taskNameColumn.setCellValueFactory(new PropertyValueFactory<>("codTrabajo"));
                        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("categoria"));
                    });
                });
    }
}
