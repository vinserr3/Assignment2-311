module com.example.assignmentlab2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignmentlab2 to javafx.fxml;
    exports com.example.assignmentlab2;
}