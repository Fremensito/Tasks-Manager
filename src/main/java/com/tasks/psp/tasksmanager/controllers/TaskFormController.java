package com.tasks.psp.tasksmanager.controllers;

import com.google.gson.Gson;
import com.tasks.psp.tasksmanager.models.BaseResponse;
import com.tasks.psp.tasksmanager.models.JobTask;
import com.tasks.psp.tasksmanager.services.ServiceUtils;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.concurrent.CompletableFuture;

public class TaskFormController extends NavBar {

    @FXML
    public ChoiceBox categories;
    public TextArea description;
    public Button create;
    public DatePicker date;
    public Label result;

    public void initialize(){
        categories.setItems(FXCollections.observableArrayList("Maintenance", "Cleaning"));
        categories.setValue("Maintenance");
    }

    public void createTask(ActionEvent actionEvent) {
        JobTask jbTask = new JobTask(
                categories.getValue().toString(),
                description.getText(),
                date.getValue().toString());

        Gson gson = new Gson();
        result.setText("Creating...");
        String json = gson.toJson(jbTask, JobTask.class);

        ServiceUtils.getResponseAsync("/trabajos", json, "POST")
        .thenAccept((response) -> Platform.runLater(()-> {
            System.out.println(response);
            BaseResponse bs = gson.fromJson(response, BaseResponse.class);
            if(bs != null)
                result.setText("Task Created");
            else
                result.setText("Error While Creating");
        }));
    }
}
