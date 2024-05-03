package com.tasks.psp.tasksmanager.controllers;

import com.tasks.psp.tasksmanager.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class NavBar {
    public final String URL = "http://localhost:8080/trabajos";
    @FXML
    protected void goTaskPanel(ActionEvent actionEvent){

        try {
            Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
            Parent root = FXMLLoader.load(
                    Objects.requireNonNull(HelloApplication.class.getResource("task-view.fxml")));
            Scene viewScene = new Scene(root);
            stage.setScene(viewScene);
            stage.show();
            stage.centerOnScreen();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
