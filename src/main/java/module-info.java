module org.lexiscan {
    requires javafx.controls;
    requires javafx.fxml;

    exports org.lexiscan;
    exports org.lexiscan.controller;

    opens org.lexiscan.controller to javafx.fxml;
}