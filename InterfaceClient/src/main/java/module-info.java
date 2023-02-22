module com.thales.interfaceclient {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires lombok;
    requires com.fasterxml.jackson.databind;

    opens com.thales.interfaceclient to javafx.fxml;
    exports com.thales.interfaceclient;
    exports com.thales.interfaceclient.model;
    opens com.thales.interfaceclient.model to javafx.fxml;
    exports com.thales.interfaceclient.controller;
    opens com.thales.interfaceclient.controller to javafx.fxml;
}