module com.tasks.psp.tasksmanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.tasks.psp.tasksmanager to javafx.fxml;
    exports com.tasks.psp.tasksmanager;
}