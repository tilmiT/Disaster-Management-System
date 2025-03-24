package com.example.disastermanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.application.Platform;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML
    private TableView<DisasterReport> reportTable;
    @FXML
    private TableColumn<DisasterReport, Integer> requestIdColumn;
    @FXML
    private TableColumn<DisasterReport, String> reporterNameColumn;
    @FXML
    private TableColumn<DisasterReport, String> contactInfoColumn;
    @FXML
    private TableColumn<DisasterReport, String> locationDetailsColumn;
    @FXML
    private TableColumn<DisasterReport, String> disasterInfoColumn;
    @FXML
    private TableColumn<DisasterReport, String> impactSummaryColumn;
    @FXML
    private TableColumn<DisasterReport, Integer> affectedIndividualsColumn;
    @FXML
    private TableColumn<DisasterReport, String> statusColumn;

    @FXML
    private Pane reportDisaster;
    @FXML
    private Pane dashboard;
    @FXML
    private ComboBox<String> provinceFilter;
    @FXML
    private ComboBox<String> disasterFilter;
    @FXML
    private ComboBox<String> disasterTypeFilter;
    @FXML
    private ComboBox<String> urgencyLevelFilter;

    private ObservableList<DisasterReport> reportList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeColumns();
        initializeFilters();
        setupStatusColumn();
        loadReports();

        if (reportDisaster != null) {
            reportDisaster.setOnMouseClicked(this::handleReportDisasterClick);
        }
        if (dashboard != null) {
            dashboard.setOnMouseClicked(this::handleDashboardClick);
        }
    }

    private void initializeColumns() {
        requestIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        reporterNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        contactInfoColumn.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        locationDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("district"));
        disasterInfoColumn.setCellValueFactory(new PropertyValueFactory<>("typeOfDisaster"));
        impactSummaryColumn.setCellValueFactory(new PropertyValueFactory<>("impactDescription"));
        affectedIndividualsColumn.setCellValueFactory(new PropertyValueFactory<>("affectedIndividuals"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        reportTable.setItems(reportList);
    }

    private void setupStatusColumn() {
        // Create a ComboBox cell factory for the status column
        Callback<TableColumn<DisasterReport, String>, TableCell<DisasterReport, String>> cellFactory =
                (TableColumn<DisasterReport, String> param) -> new TableCell<DisasterReport, String>() {
                    private final ComboBox<String> statusComboBox = new ComboBox<>(
                            FXCollections.observableArrayList("Pending", "In Progress", "Under Review", "Resolved", "Closed")
                    );

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            DisasterReport report = getTableView().getItems().get(getIndex());
                            statusComboBox.setValue(report.getStatus());
                            statusComboBox.setOnAction(event -> updateReportStatus(report, statusComboBox.getValue()));
                            setGraphic(statusComboBox);
                        }
                    }
                };

        statusColumn.setCellFactory(cellFactory);
    }

    private void updateReportStatus(DisasterReport report, String newStatus) {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String updateQuery = "UPDATE disaster_reports SET status = ? WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
                pstmt.setString(1, newStatus);
                pstmt.setLong(2, report.getId());
                pstmt.executeUpdate();

                // Update the report object
                report.setStatus(newStatus);

                // Show success message using Platform.runLater
                Platform.runLater(() -> {
                    showAlert(Alert.AlertType.INFORMATION, "Status Updated",
                            "Report status has been updated successfully.");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            final String errorMessage = e.getMessage();
            Platform.runLater(() -> {
                showAlert(Alert.AlertType.ERROR, "Update Error",
                        "Failed to update status: " + errorMessage);
            });
        }
    }

    private void initializeFilters() {
        // Initialize province filter
        provinceFilter.setItems(FXCollections.observableArrayList(
                "All", "Central Province", "Eastern Province", "North Central Province",
                "Northern Province", "North Western Province", "Sabaragamuwa Province",
                "Southern Province", "Uva Province", "Western Province"
        ));

        // Initialize disaster type filter
        disasterTypeFilter.setItems(FXCollections.observableArrayList(
                "All", "Flood", "Landslide", "Cyclone", "Earthquake",
                "Tsunami", "Drought", "Wildfire"
        ));

        // Initialize urgency level filter
        urgencyLevelFilter.setItems(FXCollections.observableArrayList(
                "All", "Low", "Medium", "Critical"
        ));

        // Initialize status filter
        disasterFilter.setItems(FXCollections.observableArrayList(
                "All", "Pending", "In Progress", "Under Review", "Resolved", "Closed"
        ));

        // Add listeners for filter changes
        provinceFilter.setOnAction(e -> applyFilters());
        disasterTypeFilter.setOnAction(e -> applyFilters());
        urgencyLevelFilter.setOnAction(e -> applyFilters());
        disasterFilter.setOnAction(e -> applyFilters());
    }

    private void applyFilters() {
        StringBuilder sql = new StringBuilder("SELECT * FROM disaster_reports WHERE 1=1");

        String province = provinceFilter.getValue();
        String disasterType = disasterTypeFilter.getValue();
        String urgencyLevel = urgencyLevelFilter.getValue();
        String status = disasterFilter.getValue();

        try (Connection conn = DatabaseUtil.getConnection()) {
            if (province != null && !province.equals("All")) {
                sql.append(" AND province = ?");
            }
            if (disasterType != null && !disasterType.equals("All")) {
                sql.append(" AND type_of_disaster = ?");
            }
            if (urgencyLevel != null && !urgencyLevel.equals("All")) {
                sql.append(" AND urgency_level = ?");
            }
            if (status != null && !status.equals("All")) {
                sql.append(" AND status = ?");
            }

            try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
                int paramIndex = 1;
                if (province != null && !province.equals("All")) {
                    pstmt.setString(paramIndex++, province);
                }
                if (disasterType != null && !disasterType.equals("All")) {
                    pstmt.setString(paramIndex++, disasterType);
                }
                if (urgencyLevel != null && !urgencyLevel.equals("All")) {
                    pstmt.setString(paramIndex++, urgencyLevel);
                }
                if (status != null && !status.equals("All")) {
                    pstmt.setString(paramIndex, status);
                }

                ResultSet rs = pstmt.executeQuery();
                reportList.clear();

                while (rs.next()) {
                    DisasterReport report = new DisasterReport(
                            rs.getString("type_of_disaster"),
                            rs.getDate("date_of_incident").toLocalDate(),
                            rs.getString("time_of_incident"),
                            rs.getString("impact_description"),
                            rs.getInt("affected_individuals"),
                            rs.getString("urgency_level"),
                            rs.getString("full_name"),
                            rs.getString("contact_number"),
                            rs.getString("email"),
                            rs.getString("national_id"),
                            rs.getString("street_address"),
                            rs.getString("grama_niladhari"),
                            rs.getString("district"),
                            rs.getString("province")
                    );
                    report.setId(rs.getLong("id"));
                    report.setStatus(rs.getString("status"));
                    reportList.add(report);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Filter Error",
                    "Error applying filters: " + e.getMessage());
        }
    }

    private void loadReports() {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM disaster_reports");
             ResultSet rs = pstmt.executeQuery()) {

            reportList.clear();
            while (rs.next()) {
                DisasterReport report = new DisasterReport(
                        rs.getString("type_of_disaster"),
                        rs.getDate("date_of_incident").toLocalDate(),
                        rs.getString("time_of_incident"),
                        rs.getString("impact_description"),
                        rs.getInt("affected_individuals"),
                        rs.getString("urgency_level"),
                        rs.getString("full_name"),
                        rs.getString("contact_number"),
                        rs.getString("email"),
                        rs.getString("national_id"),
                        rs.getString("street_address"),
                        rs.getString("grama_niladhari"),
                        rs.getString("district"),
                        rs.getString("province")
                );
                report.setId(rs.getLong("id"));
                report.setStatus(rs.getString("status"));
                reportList.add(report);
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Loading Error",
                    "Error loading reports: " + e.getMessage());
        }
    }

    @FXML
    private void handleReportDisasterClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("complain.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) reportDisaster.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Navigation Error",
                    "Could not load complaint form: " + e.getMessage());
        }
    }

    @FXML
    private void handleDashboardClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) dashboard.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Navigation Error",
                    "Could not load dashboard: " + e.getMessage());
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}