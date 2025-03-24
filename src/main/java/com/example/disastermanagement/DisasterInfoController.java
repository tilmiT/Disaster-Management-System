
package com.example.disastermanagement;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class DisasterInfoController {

    @FXML
    private Pane adminSection;

    @FXML
    private Pane reportDisaster; // Add this field

    @FXML
    private Pane dashboard;

    @FXML
    private ComboBox<String> typeOfDisasterComboBox;
    @FXML
    private DatePicker dateOfIncidentPicker;
    @FXML
    private TextField timeOfIncidentField;
    @FXML
    private TextArea impactDescriptionArea;
    @FXML
    private TextField numberOfAffectedField;
    @FXML
    private ComboBox<String> urgencyLevelComboBox;
    @FXML
    private Button submitButton;
    @FXML
    private Button backButton;

    // Static fields to store form data
    private static String savedDisasterType = "";
    private static LocalDate savedDate = null;
    private static String savedTime = "";
    private static String savedImpactDescription = "";
    private static String savedAffectedNumber = "";
    private static String savedUrgencyLevel = "";

    // User data fields
    private String fullName, contactNumber, email, nationalId, streetAddress, gramaNiladhari, district, province;

    @FXML
    public void initialize() {
        // Initialize disaster types
        if (typeOfDisasterComboBox != null) {
            typeOfDisasterComboBox.getItems().addAll(
                    "Flood", "Landslide", "Cyclone", "Earthquake",
                    "Tsunami", "Drought", "Wildfire"
            );
            typeOfDisasterComboBox.setPromptText("Select disaster type");
            typeOfDisasterComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    savedDisasterType = newValue;
                }
            });
        }

        // Initialize urgency levels
        if (urgencyLevelComboBox != null) {
            urgencyLevelComboBox.setItems(FXCollections.observableArrayList(
                    "Low", "Medium", "Critical"
            ));
            urgencyLevelComboBox.setPromptText("Select urgency level");

            // Add listener to handle selection changes
            urgencyLevelComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    savedUrgencyLevel = newValue;
                }
            });
        }

        // Set default date and prompts
        if (dateOfIncidentPicker != null) {
            dateOfIncidentPicker.setPromptText("Select date");
            // Set default date only if no saved date exists
            dateOfIncidentPicker.setValue(savedDate != null ? savedDate : LocalDate.now());
        }

        if (timeOfIncidentField != null) {
            timeOfIncidentField.setPromptText("Enter time (HH:MM)");
        }

        if (numberOfAffectedField != null) {
            numberOfAffectedField.setPromptText("Enter number");
            // Add number-only validation
            numberOfAffectedField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*")) {
                    numberOfAffectedField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            });
        }

        if (impactDescriptionArea != null) {
            impactDescriptionArea.setPromptText("Describe the impact of the disaster");
        }
// Add click handler for admin section
        if (adminSection != null) {
            adminSection.setOnMouseClicked(this::handleAdminSectionClick);
        }
        if (reportDisaster != null) {
            reportDisaster.setOnMouseClicked(this::handleReportDisasterClick);
        }

        if (dashboard != null) {
            dashboard.setOnMouseClicked(this::handleDashboardClick);
        }
        // Restore saved data
        restoreFormData();
    }
    @FXML
    private void handleReportDisasterClick(MouseEvent event) {
        try {
            // Save current form data before navigating
            saveFormData();

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
    @FXML
    private void handleAdminSectionClick(MouseEvent event) {
        try {
            // Load the admin view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) adminSection.getScene().getWindow();

            // Create and set the new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Navigation Error",
                    "Could not load admin view: " + e.getMessage());
        }
    }

    private void restoreFormData() {
//        if (!savedDisasterType.isEmpty()) {
//            typeOfDisasterComboBox.setValue(savedDisasterType);
//        }
        if (!savedDisasterType.isEmpty() && typeOfDisasterComboBox != null) {
            typeOfDisasterComboBox.setValue(savedDisasterType);
        }
        if (savedDate != null) {
            dateOfIncidentPicker.setValue(savedDate);
        }
        timeOfIncidentField.setText(savedTime);
        impactDescriptionArea.setText(savedImpactDescription);
        numberOfAffectedField.setText(savedAffectedNumber);
//        if (!savedUrgencyLevel.isEmpty()) {
//            urgencyLevelComboBox.setValue(savedUrgencyLevel);
//        }
        if (!savedUrgencyLevel.isEmpty() && urgencyLevelComboBox != null) {
            urgencyLevelComboBox.setValue(savedUrgencyLevel);
        }
    }

    private void saveFormData() {
        savedDisasterType = typeOfDisasterComboBox.getValue() != null ? typeOfDisasterComboBox.getValue() : "";
        savedDate = dateOfIncidentPicker.getValue();
        savedTime = timeOfIncidentField.getText();
        savedImpactDescription = impactDescriptionArea.getText();
        savedAffectedNumber = numberOfAffectedField.getText();
        savedUrgencyLevel = urgencyLevelComboBox.getValue() != null ? urgencyLevelComboBox.getValue() : "";
    }


    //    @FXML
//    void handleSubmitButton(ActionEvent event) {
//        if (!validateInputs()) {
//            return;
//        }
//
//        try {
//            int affectedIndividuals = Integer.parseInt(numberOfAffectedField.getText().trim());
//
//            // Create disaster report
//            DisasterReport report = new DisasterReport(
//                    typeOfDisasterComboBox.getValue(),
//                    dateOfIncidentPicker.getValue(),
//                    timeOfIncidentField.getText(),
//                    impactDescriptionArea.getText(),
//                    affectedIndividuals,
//                    urgencyLevelComboBox.getValue(),
//                    fullName,
//                    contactNumber,
//                    email,
//                    nationalId,
//                    streetAddress,
//                    gramaNiladhari,
//                    district,
//                    province
//            );
//
//            // Log the report details (replace with database storage in production)
//            System.out.println("New Disaster Report Created:");
//            System.out.println(report.toString());
//
//            // Clear saved data after successful submission
//            clearSavedData();
//
//            showAlert(Alert.AlertType.INFORMATION, "Success", "Disaster information submitted successfully!");
//
//            // Navigate back to complain.fxml with blank fields
//            try {
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("complain.fxml"));
//                Parent root = loader.load();
//
//                // Get the controller and reset all fields
//                ComplainController complainController = loader.getController();
//                if (complainController != null) {
//                    // Pass empty strings to clear all fields
//                    complainController.setUserData("", "", "", "", "", "", "", "");
//                }
//
//                Stage stage = (Stage) submitButton.getScene().getWindow();
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                showAlert(Alert.AlertType.ERROR, "Navigation Error",
//                        "Could not return to the complaint form: " + e.getMessage());
//            }
//
//        } catch (NumberFormatException e) {
//            showAlert(Alert.AlertType.ERROR, "Validation Error",
//                    "Number of affected individuals must be a valid number.");
//        } catch (Exception e) {
//            showAlert(Alert.AlertType.ERROR, "Error",
//                    "An error occurred while submitting the report: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//    @FXML
//    void handleBackButton(ActionEvent event) {
//        try {
//            // Save current form data before navigating back
//            saveFormData();
//
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("complain.fxml"));
//            Parent root = loader.load();
//
//            // Get the controller and set the saved user data
//            ComplainController complainController = loader.getController();
//            if (complainController != null) {
//                complainController.setUserData(fullName, contactNumber, email, nationalId,
//                        streetAddress, gramaNiladhari, district, province);
//            }
//
//            Stage stage = (Stage) backButton.getScene().getWindow();
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//            showAlert(Alert.AlertType.ERROR, "Navigation Error", "Could not return to the previous form.");
//        }
//    }
    @FXML
    void handleSubmitButton(ActionEvent event) {
        if (!validateInputs()) {
            return;
        }

        try {
            int affectedIndividuals = Integer.parseInt(numberOfAffectedField.getText().trim());

            String sql = """
            INSERT INTO disaster_reports (
                type_of_disaster, date_of_incident, time_of_incident,
                impact_description, affected_individuals, urgency_level,
                full_name, contact_number, email, national_id,
                street_address, grama_niladhari, district, province
            ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

            try (Connection conn = DatabaseUtil.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, typeOfDisasterComboBox.getValue());
                pstmt.setDate(2, java.sql.Date.valueOf(dateOfIncidentPicker.getValue()));
                pstmt.setString(3, timeOfIncidentField.getText());
                pstmt.setString(4, impactDescriptionArea.getText());
                pstmt.setInt(5, affectedIndividuals);
                pstmt.setString(6, urgencyLevelComboBox.getValue());
                pstmt.setString(7, fullName);
                pstmt.setString(8, contactNumber);
                pstmt.setString(9, email);
                pstmt.setString(10, nationalId);
                pstmt.setString(11, streetAddress);
                pstmt.setString(12, gramaNiladhari);
                pstmt.setString(13, district);
                pstmt.setString(14, province);

                pstmt.executeUpdate();
            }

            // Clear saved data after successful submission
            clearSavedData();

            showAlert(Alert.AlertType.INFORMATION, "Success", "Disaster information submitted successfully!");

            // Navigate back to complain.fxml with blank fields
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("complain.fxml"));
                Parent root = loader.load();

                // Get the controller and reset all fields
                ComplainController complainController = loader.getController();
                if (complainController != null) {
                    complainController.setUserData("", "", "", "", "", "", "", "");
                }

                Stage stage = (Stage) submitButton.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Navigation Error",
                        "Could not return to the complaint form: " + e.getMessage());
            }

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Validation Error",
                    "Number of affected individuals must be a valid number.");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error",
                    "An error occurred while submitting the report: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private void clearSavedData() {
        savedDisasterType = "";
        savedDate = null;
        savedTime = "";
        savedImpactDescription = "";
        savedAffectedNumber = "";
        savedUrgencyLevel = "";
    }

    private boolean validateInputs() {
        StringBuilder errorMessage = new StringBuilder();

        if (typeOfDisasterComboBox.getValue() == null) {
            errorMessage.append("Please select a disaster type.\n");
        }
        if (dateOfIncidentPicker.getValue() == null) {
            errorMessage.append("Please select a date.\n");
        }
        if (timeOfIncidentField.getText().trim().isEmpty()) {
            errorMessage.append("Please enter the time of incident.\n");
        }
        if (impactDescriptionArea.getText().trim().isEmpty()) {
            errorMessage.append("Please provide an impact description.\n");
        }
        if (numberOfAffectedField.getText().trim().isEmpty()) {
            errorMessage.append("Please enter the number of affected individuals.\n");
        }
        if (urgencyLevelComboBox.getValue() == null) {
            errorMessage.append("Please select an urgency level.\n");
        }

        if (errorMessage.length() > 0) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", errorMessage.toString());
            return false;
        }

        return true;
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void clearForm() {
        typeOfDisasterComboBox.setValue(null);
        dateOfIncidentPicker.setValue(LocalDate.now());
        timeOfIncidentField.clear();
        impactDescriptionArea.clear();
        numberOfAffectedField.clear();
        urgencyLevelComboBox.setValue(null);
    }
    @FXML
    void handleBackButton(ActionEvent event) {
        try {
            // Save current form data before navigating back
            saveFormData();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("complain.fxml"));
            Parent root = loader.load();

            // Get the controller and set the saved user data
            ComplainController complainController = loader.getController();
            if (complainController != null) {
                complainController.setUserData(fullName, contactNumber, email, nationalId,
                        streetAddress, gramaNiladhari, district, province);
            }

            Stage stage = (Stage) backButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Navigation Error", "Could not return to the previous form.");
        }
    }
    public void setUserData(String fullName, String contactNumber, String email, String nationalId,
                            String streetAddress, String gramaNiladhari, String district, String province) {
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.nationalId = nationalId;
        this.streetAddress = streetAddress;
        this.gramaNiladhari = gramaNiladhari;
        this.district = district;
        this.province = province;
    }
}