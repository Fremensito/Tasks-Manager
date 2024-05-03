module com.tasks.psp.tasksmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    requires org.kordamp.bootstrapfx.core;

    opens com.tasks.psp.tasksmanager to javafx.fxml;
    opens com.tasks.psp.tasksmanager.models to com.google.gson;
    exports com.tasks.psp.tasksmanager;
    exports com.tasks.psp.tasksmanager.controllers;
    opens com.tasks.psp.tasksmanager.controllers to javafx.fxml;
}