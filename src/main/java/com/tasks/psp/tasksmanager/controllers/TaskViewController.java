package com.tasks.psp.tasksmanager.controllers;

import com.google.gson.Gson;
import com.tasks.psp.tasksmanager.models.BaseResponse;
import com.tasks.psp.tasksmanager.models.Employee;
import com.tasks.psp.tasksmanager.models.JobTask;
import com.tasks.psp.tasksmanager.services.ServiceUtils;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TaskViewController extends NavBar{

    public TableView tasksTable;
    public ObservableList<JobTask> jobTasks;
    public TableColumn<JobTask, String> categoryColumn;
    public TableColumn<JobTask, String> taskNameColumn;

    private final String URL_TASKS = "/trabajos";
    private final String URL_WORKERS = "";
    public TextField search;

    public ObservableList<Employee> employees;
    public TableView employeeTable;
    public TableColumn<Employee, String> selectEmployeeColumn;
    public TableColumn<Employee, String>selectJobColumn;

    public ObservableList<JobTask> employeeJobTasks;
    public TableView employeeTasksTable;
    public TableColumn<JobTask, String> employeTasksTask;
    public TableColumn<JobTask, String> employeeTasksDescription;
    Gson gson;
    public void initialize(){
        gson = new Gson();
    }

    private void getJobTasks(){
        ServiceUtils.getResponseAsync(URL_TASKS, null, "GET")
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

    private void getEmployees(){
        ServiceUtils.getResponseAsync(URL_WORKERS, null, "GET")
                .thenAccept((response)->{
                    BaseResponse bs = gson.fromJson(response, BaseResponse.class);
                    Platform.runLater(()->{
                        employees = FXCollections.observableList(bs.empleados);
                        employeeTable.setItems(employeeJobTasks);
                        selectEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("dni"));
                        selectJobColumn.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
                    });
                });
    }

    public void makeSearch(ActionEvent actionEvent) {
        System.out.println("Make Search");
    }
}
