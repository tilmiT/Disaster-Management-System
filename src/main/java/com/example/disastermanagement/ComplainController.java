//////////package com.example.disastermanagement;
//////////
//////////import javafx.event.ActionEvent;
//////////import javafx.fxml.FXML;
//////////import javafx.scene.control.Alert;
//////////import javafx.scene.control.TextField;
//////////
//////////public class ComplainController {
//////////
//////////    @FXML
//////////    private TextField fullNameField;
//////////
//////////    @FXML
//////////    private TextField contactNumberField;
//////////
//////////    @FXML
//////////    private TextField emailField;
//////////
//////////    @FXML
//////////    private TextField nationalIdField;
//////////
//////////    @FXML
//////////    private TextField streetAddressField;
//////////
//////////    @FXML
//////////    private TextField gramaNiladhariField;
//////////
//////////    @FXML
//////////    private TextField districtField;
//////////
//////////    @FXML
//////////    private TextField provinceField;
//////////
//////////    @FXML
//////////    void handleNextButton(ActionEvent event) {
//////////        // Validate mandatory fields
//////////        if (fullNameField.getText().isEmpty() || contactNumberField.getText().isEmpty() ||
//////////                nationalIdField.getText().isEmpty() || streetAddressField.getText().isEmpty() ||
//////////                gramaNiladhariField.getText().isEmpty() || districtField.getText().isEmpty() ||
//////////                provinceField.getText().isEmpty()) {
//////////
//////////            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please fill in all mandatory fields.");
//////////            return;
//////////        }
//////////
//////////        // Collect data
//////////        String fullName = fullNameField.getText();
//////////        String contactNumber = contactNumberField.getText();
//////////        String email = emailField.getText(); // Optional field
//////////        String nationalId = nationalIdField.getText();
//////////        String streetAddress = streetAddressField.getText();
//////////        String gramaNiladhari = gramaNiladhariField.getText();
//////////        String district = districtField.getText();
//////////        String province = provinceField.getText();
//////////
//////////        // Simulate saving the data (you can replace this with actual database integration)
//////////        System.out.println("Disaster Report Submitted:");
//////////        System.out.println("Full Name: " + fullName);
//////////        System.out.println("Contact Number: " + contactNumber);
//////////        System.out.println("Email: " + email);
//////////        System.out.println("National ID: " + nationalId);
//////////        System.out.println("Street Address: " + streetAddress);
//////////        System.out.println("Grama Niladhari Division: " + gramaNiladhari);
//////////        System.out.println("District: " + district);
//////////        System.out.println("Province: " + province);
//////////
//////////        // Show success message
//////////        showAlert(Alert.AlertType.INFORMATION, "Success", "Disaster report submitted successfully!");
//////////    }
//////////
//////////
//////////    private void showAlert(Alert.AlertType alertType, String title, String message) {
//////////        Alert alert = new Alert(alertType);
//////////        alert.setTitle(title);
//////////        alert.setHeaderText(null);
//////////        alert.setContentText(message);
//////////        alert.showAndWait();
//////////    }
//////////}
////////
//////////package com.example.disastermanagement;
//////////
//////////import javafx.event.ActionEvent;
//////////import javafx.fxml.FXML;
//////////import javafx.fxml.FXMLLoader;
//////////import javafx.scene.Parent;
//////////import javafx.scene.Scene;
//////////import javafx.scene.control.Alert;
//////////import javafx.scene.control.TextField;
//////////import javafx.stage.Stage;
//////////
//////////public class ComplainController {
//////////
//////////    @FXML
//////////    private TextField fullNameField;
//////////
//////////    @FXML
//////////    private TextField contactNumberField;
//////////
//////////    @FXML
//////////    private TextField emailField;
//////////
//////////    @FXML
//////////    private TextField nationalIdField;
//////////
//////////    @FXML
//////////    private TextField streetAddressField;
//////////
//////////    @FXML
//////////    private TextField gramaNiladhariField;
//////////
//////////    @FXML
//////////    private TextField districtField;
//////////
//////////    @FXML
//////////    private TextField provinceField;
//////////
//////////    @FXML
//////////    void handleNextButton(ActionEvent event) {
//////////        // Validate mandatory fields
//////////        if (fullNameField.getText().isEmpty() || contactNumberField.getText().isEmpty() ||
//////////                nationalIdField.getText().isEmpty() || streetAddressField.getText().isEmpty() ||
//////////                gramaNiladhariField.getText().isEmpty() || districtField.getText().isEmpty() ||
//////////                provinceField.getText().isEmpty()) {
//////////
//////////            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please fill in all mandatory fields.");
//////////            return;
//////////        }
//////////
//////////        try {
//////////            // Load the disaster information form
//////////            FXMLLoader loader = new FXMLLoader(getClass().getResource("disaster_info.fxml"));
//////////            Parent root = loader.load();
//////////
//////////            // Pass data to the next controller if needed
//////////            DisasterInfoController disasterInfoController = loader.getController();
//////////            disasterInfoController.setUserData(
//////////                    fullNameField.getText(),
//////////                    contactNumberField.getText(),
//////////                    emailField.getText(),
//////////                    nationalIdField.getText(),
//////////                    streetAddressField.getText(),
//////////                    gramaNiladhariField.getText(),
//////////                    districtField.getText(),
//////////                    provinceField.getText()
//////////            );
//////////
//////////            // Switch to the disaster information scene
//////////            Stage stage = (Stage) fullNameField.getScene().getWindow();
//////////            stage.setScene(new Scene(root));
//////////        } catch (Exception e) {
//////////            e.printStackTrace();
//////////        }
//////////    }
//////////
//////////    private void showAlert(Alert.AlertType alertType, String title, String message) {
//////////        Alert alert = new Alert(alertType);
//////////        alert.setTitle(title);
//////////        alert.setHeaderText(null);
//////////        alert.setContentText(message);
//////////        alert.showAndWait();
//////////    }
//////////}
////////
//////////package com.example.disastermanagement;
//////////
//////////import javafx.event.ActionEvent;
//////////import javafx.fxml.FXML;
//////////import javafx.fxml.FXMLLoader;
//////////import javafx.scene.Parent;
//////////import javafx.scene.Scene;
//////////import javafx.scene.control.Alert;
//////////import javafx.scene.control.TextField;
//////////import javafx.scene.control.Button;
//////////import javafx.stage.Stage;
//////////
//////////public class ComplainController {
//////////
//////////    @FXML
//////////    private TextField fullNameField;
//////////
//////////    @FXML
//////////    private TextField contactNumberField;
//////////
//////////    @FXML
//////////    private TextField emailField;
//////////
//////////    @FXML
//////////    private TextField nationalIdField;
//////////
//////////    @FXML
//////////    private TextField streetAddressField;
//////////
//////////    @FXML
//////////    private TextField gramaNiladhariField;
//////////
//////////    @FXML
//////////    private TextField districtField;
//////////
//////////    @FXML
//////////    private TextField provinceField;
//////////
//////////    @FXML
//////////    private Button nextButton;
//////////
//////////    @FXML
//////////    void initialize() {
//////////        // Initialize any necessary components
//////////    }
//////////
//////////    @FXML
//////////    void handleNextButton(ActionEvent event) {
//////////        // Validate mandatory fields
//////////        if (fullNameField.getText().isEmpty() || contactNumberField.getText().isEmpty() ||
//////////                nationalIdField.getText().isEmpty() || streetAddressField.getText().isEmpty() ||
//////////                gramaNiladhariField.getText().isEmpty() || districtField.getText().isEmpty() ||
//////////                provinceField.getText().isEmpty()) {
//////////
//////////            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please fill in all mandatory fields.");
//////////            return;
//////////        }
//////////
//////////        try {
//////////            // Load the disaster information form
//////////            FXMLLoader loader = new FXMLLoader(getClass().getResource("DisasterInfo.fxml"));
//////////            Parent root = loader.load();
//////////
//////////            // Pass data to the next controller
//////////            DisasterInfoController disasterInfoController = loader.getController();
//////////            disasterInfoController.setUserData(
//////////                    fullNameField.getText(),
//////////                    contactNumberField.getText(),
//////////                    emailField.getText(),
//////////                    nationalIdField.getText(),
//////////                    streetAddressField.getText(),
//////////                    gramaNiladhariField.getText(),
//////////                    districtField.getText(),
//////////                    provinceField.getText()
//////////            );
//////////
//////////            // Switch to the disaster information scene
//////////            Stage stage = (Stage) fullNameField.getScene().getWindow();
//////////            Scene scene = new Scene(root);
//////////            stage.setScene(scene);
//////////            stage.show();
//////////        } catch (Exception e) {
//////////            e.printStackTrace();
//////////            showAlert(Alert.AlertType.ERROR, "Navigation Error", "Could not load the next form.");
//////////        }
//////////    }
//////////
//////////    private void showAlert(Alert.AlertType alertType, String title, String message) {
//////////        Alert alert = new Alert(alertType);
//////////        alert.setTitle(title);
//////////        alert.setHeaderText(null);
//////////        alert.setContentText(message);
//////////        alert.showAndWait();
//////////    }
//////////}
////////
////////package com.example.disastermanagement;
////////
////////import javafx.event.ActionEvent;
////////import javafx.fxml.FXML;
////////import javafx.fxml.FXMLLoader;
////////import javafx.scene.Node;
////////import javafx.scene.Parent;
////////import javafx.scene.Scene;
////////import javafx.scene.control.Alert;
////////import javafx.scene.control.ComboBox;
////////import javafx.scene.control.TextField;
////////import javafx.stage.Stage;
////////import java.io.IOException;
////////
////////public class ComplainController {
////////
////////    @FXML
////////    private TextField fullNameField, contactNumberField, emailField, nationalIdField;
////////
////////    @FXML
////////    private TextField streetAddressField, gramaNiladhariField, districtField, provinceField;
////////    @FXML
////////    private ComboBox<String> districtComboBox;
////////
////////    @FXML
////////    private ComboBox<String> provinceComboBox;
//////////    @FXML
//////////    void handleNextButton(ActionEvent event) {
//////////        // Validate required fields
//////////        if (fullNameField.getText().isEmpty() || contactNumberField.getText().isEmpty() ||
//////////                nationalIdField.getText().isEmpty() || streetAddressField.getText().isEmpty() ||
//////////                gramaNiladhariField.getText().isEmpty() || districtField.getText().isEmpty() ||
//////////                provinceField.getText().isEmpty()) {
//////////
//////////            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please fill in all mandatory fields.");
//////////            return;
//////////        }
//////////
//////////        try {
//////////            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/disastermanagement/DisasterInfo.fxml"));
//////////            Stage stage = (Stage) fullNameField.getScene().getWindow();
//////////            Scene scene = new Scene(loader.load());
//////////            stage.setScene(scene);
//////////            stage.show();
//////////        } catch (IOException e) {
//////////            showAlert(Alert.AlertType.ERROR, "Loading Error", "Failed to load the next page.");
//////////            e.printStackTrace();
//////////        }
//////////    }
////////@FXML
////////void handleNextButton(ActionEvent event) {
////////    try {
////////        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/disastermanagement/DisasterInfo.fxml"));
////////        Parent root = loader.load();
////////
////////        // Get the controller and pass the data
////////        DisasterInfoController disasterInfoController = loader.getController();
////////        disasterInfoController.setUserData(
////////                fullNameField.getText(),
////////                contactNumberField.getText(),
////////                emailField.getText(),
////////                nationalIdField.getText(),
////////                streetAddressField.getText(),
////////                gramaNiladhariField.getText(),
////////                districtComboBox.getValue(),
////////                provinceComboBox.getValue()
////////        );
////////
////////        // Get the stage and set the new scene
////////        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
////////        Scene scene = new Scene(root);
////////        stage.setScene(scene);
////////        stage.show();
////////
////////    } catch (Exception e) {
////////        e.printStackTrace();
////////        // Add proper error handling here
////////        System.out.println("Error loading DisasterInfo.fxml: " + e.getMessage());
////////    }
////////}
////////    private void showAlert(Alert.AlertType alertType, String title, String message) {
////////        Alert alert = new Alert(alertType);
////////        alert.setTitle(title);
////////        alert.setHeaderText(null);
////////        alert.setContentText(message);
////////        alert.showAndWait();
////////    }
////////}
//////
//////package com.example.disastermanagement;
//////
//////import javafx.collections.FXCollections;
//////import javafx.collections.ObservableList;
//////import javafx.fxml.FXML;
//////import javafx.fxml.FXMLLoader;
//////import javafx.fxml.Initializable;
//////import javafx.scene.Node;
//////import javafx.scene.Parent;
//////import javafx.scene.Scene;
//////import javafx.scene.control.ComboBox;
//////import javafx.scene.control.TextField;
//////import javafx.event.ActionEvent;
//////import javafx.stage.Stage;
//////
//////import java.net.URL;
//////import java.util.HashMap;
//////import java.util.List;
//////import java.util.Map;
//////import java.util.ResourceBundle;
//////
//////public class ComplainController implements Initializable {
//////
//////    @FXML
//////    private TextField fullNameField, contactNumberField, emailField, nationalIdField;
//////    @FXML
//////    private TextField streetAddressField, gramaNiladhariField;
//////    @FXML
//////    private ComboBox<String> districtComboBox;
//////    @FXML
//////    private ComboBox<String> provinceComboBox;
//////
//////    // Mapping provinces to their respective districts
//////    private final Map<String, List<String>> districtsByProvince = new HashMap<>();
//////
//////    @Override
//////    public void initialize(URL location, ResourceBundle resources) {
//////        initializeProvinces();
//////        initializeDistricts();
//////    }
//////
//////    private void initializeProvinces() {
//////        ObservableList<String> provinces = FXCollections.observableArrayList(
//////                "Central Province", "Eastern Province", "North Central Province",
//////                "Northern Province", "North Western Province", "Sabaragamuwa Province",
//////                "Southern Province", "Uva Province", "Western Province"
//////        );
//////        provinceComboBox.setItems(provinces);
//////
//////        // Automatically update districts when province changes
//////        provinceComboBox.setOnAction(event -> updateDistricts());
//////    }
//////
//////    private void initializeDistricts() {
//////        districtsByProvince.put("Central Province", List.of("Kandy", "Matale", "Nuwara Eliya"));
//////        districtsByProvince.put("Eastern Province", List.of("Ampara", "Batticaloa", "Trincomalee"));
//////        districtsByProvince.put("North Central Province", List.of("Anuradhapura", "Polonnaruwa"));
//////        districtsByProvince.put("Northern Province", List.of("Jaffna", "Kilinochchi", "Mannar", "Mullaitivu", "Vavuniya"));
//////        districtsByProvince.put("North Western Province", List.of("Kurunegala", "Puttalam"));
//////        districtsByProvince.put("Sabaragamuwa Province", List.of("Kegalle", "Ratnapura"));
//////        districtsByProvince.put("Southern Province", List.of("Galle", "Matara", "Hambantota"));
//////        districtsByProvince.put("Uva Province", List.of("Badulla", "Monaragala"));
//////        districtsByProvince.put("Western Province", List.of("Colombo", "Gampaha", "Kalutara"));
//////    }
//////
//////    private void updateDistricts() {
//////        String selectedProvince = provinceComboBox.getValue();
//////        if (selectedProvince != null) {
//////            List<String> districts = districtsByProvince.get(selectedProvince);
//////            districtComboBox.setItems(FXCollections.observableArrayList(districts));
//////        }
//////    }
//////
//////    @FXML
//////    void handleNextButton(ActionEvent event) {
//////        try {
//////            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/disastermanagement/DisasterInfo.fxml"));
//////            Parent root = loader.load();
//////
//////            // Get the controller and pass the data
//////            DisasterInfoController disasterInfoController = loader.getController();
//////            disasterInfoController.setUserData(
//////                    fullNameField.getText(),
//////                    contactNumberField.getText(),
//////                    emailField.getText(),
//////                    nationalIdField.getText(),
//////                    streetAddressField.getText(),
//////                    gramaNiladhariField.getText(),
//////                    districtComboBox.getValue(),
//////                    provinceComboBox.getValue()
//////            );
//////
//////            // Get the stage and set the new scene
//////            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//////            Scene scene = new Scene(root);
//////            stage.setScene(scene);
//////            stage.show();
//////
//////        } catch (Exception e) {
//////            e.printStackTrace();
//////            System.out.println("Error loading DisasterInfo.fxml: " + e.getMessage());
//////        }
//////    }
//////}
//////
////
////
////package com.example.disastermanagement;
////
////import javafx.collections.FXCollections;
////import javafx.collections.ObservableList;
////import javafx.fxml.FXML;
////import javafx.fxml.FXMLLoader;
////import javafx.fxml.Initializable;
////import javafx.scene.Node;
////import javafx.scene.Parent;
////import javafx.scene.Scene;
////import javafx.scene.control.Alert;
////import javafx.scene.control.ComboBox;
////import javafx.scene.control.TextField;
////import javafx.event.ActionEvent;
////import javafx.stage.Stage;
////
////import java.net.URL;
////import java.util.HashMap;
////import java.util.List;
////import java.util.Map;
////import java.util.ResourceBundle;
////
////public class ComplainController implements Initializable {
////
////    @FXML
////    private TextField fullNameField, contactNumberField, emailField, nationalIdField;
////    @FXML
////    private TextField streetAddressField, gramaNiladhariField;
////    @FXML
////    private ComboBox<String> districtComboBox;
////    @FXML
////    private ComboBox<String> provinceComboBox;
////
////    // Static fields to store form data
////    private static String savedFullName = "";
////    private static String savedContactNumber = "";
////    private static String savedEmail = "";
////    private static String savedNationalId = "";
////    private static String savedStreetAddress = "";
////    private static String savedGramaNiladhari = "";
////    private static String savedDistrict = "";
////    private static String savedProvince = "";
////
////    private final Map<String, List<String>> districtsByProvince = new HashMap<>();
////
////    @Override
////    public void initialize(URL location, ResourceBundle resources) {
////        initializeDistricts();  // First set up the districts map
////        initializeProvinces();  // Then initialize provinces which will trigger district update
////        restoreFormData();      // Finally restore other form data
////    }
////
////    // Add this method to handle data coming back from DisasterInfoController
////    public void setUserData(String fullName, String contactNumber, String email, String nationalId,
////                            String streetAddress, String gramaNiladhari, String district, String province) {
////        // Update the static saved fields
////        savedFullName = fullName;
////        savedContactNumber = contactNumber;
////        savedEmail = email;
////        savedNationalId = nationalId;
////        savedStreetAddress = streetAddress;
////        savedGramaNiladhari = gramaNiladhari;
////        savedDistrict = district;
////        savedProvince = province;
////
////        if (fullName.isEmpty() && contactNumber.isEmpty() && email.isEmpty() &&
////                nationalId.isEmpty() && streetAddress.isEmpty() && gramaNiladhari.isEmpty() &&
////                district.isEmpty() && province.isEmpty()) {
////
////            // Clear combo box selections
////            if (provinceComboBox != null) {
////                provinceComboBox.setValue(null);
////            }
////            if (districtComboBox != null) {
////                districtComboBox.setValue(null);
////            }
////        }
////        // Update the form fields
////        restoreFormData();
////    }
////
////    private void initializeProvinces() {
////        ObservableList<String> provinces = FXCollections.observableArrayList(
////                "Central Province", "Eastern Province", "North Central Province",
////                "Northern Province", "North Western Province", "Sabaragamuwa Province",
////                "Southern Province", "Uva Province", "Western Province"
////        );
////        provinceComboBox.setItems(provinces);
////
////        // Set up the event handler for province changes
////        provinceComboBox.setOnAction(event -> updateDistricts());
////
////        // Restore province if saved
////        if (!savedProvince.isEmpty()) {
////            provinceComboBox.setValue(savedProvince);
////            // Explicitly update districts after setting the province
////            updateDistricts();
////        }
////    }
////
////    private void initializeDistricts() {
////        districtsByProvince.put("Central Province", List.of("Kandy", "Matale", "Nuwara Eliya"));
////        districtsByProvince.put("Eastern Province", List.of("Ampara", "Batticaloa", "Trincomalee"));
////        districtsByProvince.put("North Central Province", List.of("Anuradhapura", "Polonnaruwa"));
////        districtsByProvince.put("Northern Province", List.of("Jaffna", "Kilinochchi", "Mannar", "Mullaitivu", "Vavuniya"));
////        districtsByProvince.put("North Western Province", List.of("Kurunegala", "Puttalam"));
////        districtsByProvince.put("Sabaragamuwa Province", List.of("Kegalle", "Ratnapura"));
////        districtsByProvince.put("Southern Province", List.of("Galle", "Matara", "Hambantota"));
////        districtsByProvince.put("Uva Province", List.of("Badulla", "Monaragala"));
////        districtsByProvince.put("Western Province", List.of("Colombo", "Gampaha", "Kalutara"));
////    }
////
////    private void updateDistricts() {
////        String selectedProvince = provinceComboBox.getValue();
////        if (selectedProvince != null) {
////            List<String> districts = districtsByProvince.get(selectedProvince);
////            if (districts != null) {
////                districtComboBox.setItems(FXCollections.observableArrayList(districts));
////
////                // Restore district if saved and matches current province
////                if (!savedDistrict.isEmpty() && districts.contains(savedDistrict)) {
////                    districtComboBox.setValue(savedDistrict);
////                } else {
////                    // Clear the selection if the saved district isn't valid for this province
////                    districtComboBox.setValue(null);
////                }
////            }
////        } else {
////            // Clear districts if no province is selected
////            districtComboBox.setItems(FXCollections.observableArrayList());
////            districtComboBox.setValue(null);
////        }
////    }
////
////    private void restoreFormData() {
////        fullNameField.setText(savedFullName);
////        contactNumberField.setText(savedContactNumber);
////        emailField.setText(savedEmail);
////        nationalIdField.setText(savedNationalId);
////        streetAddressField.setText(savedStreetAddress);
////        gramaNiladhariField.setText(savedGramaNiladhari);
////
////        // Restore province and district
////        if (!savedProvince.isEmpty()) {
////            provinceComboBox.setValue(savedProvince);
////            updateDistricts(); // This will handle setting the district
////        }
////    }
////
////    private void saveFormData() {
////        savedFullName = fullNameField.getText();
////        savedContactNumber = contactNumberField.getText();
////        savedEmail = emailField.getText();
////        savedNationalId = nationalIdField.getText();
////        savedStreetAddress = streetAddressField.getText();
////        savedGramaNiladhari = gramaNiladhariField.getText();
////        savedDistrict = districtComboBox.getValue() != null ? districtComboBox.getValue() : "";
////        savedProvince = provinceComboBox.getValue() != null ? provinceComboBox.getValue() : "";
////    }
////
////    @FXML
////    void handleNextButton(ActionEvent event) {
////        try {
////            if (validateFields()) {
////                // Save form data before navigation
////                saveFormData();
////
////                FXMLLoader loader = new FXMLLoader(getClass().getResource("DisasterInfo.fxml"));
////                Parent root = loader.load();
////
////                DisasterInfoController disasterInfoController = loader.getController();
////                if (disasterInfoController == null) {
////                    throw new RuntimeException("Failed to get DisasterInfoController");
////                }
////
////                disasterInfoController.setUserData(
////                        savedFullName,
////                        savedContactNumber,
////                        savedEmail,
////                        savedNationalId,
////                        savedStreetAddress,
////                        savedGramaNiladhari,
////                        savedDistrict,
////                        savedProvince
////                );
////
////                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
////                Scene scene = new Scene(root);
////                stage.setScene(scene);
////                stage.show();
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////            showAlert(Alert.AlertType.ERROR, "Navigation Error",
////                    "Error loading next page: " + e.getMessage());
////        }
////    }
////
////    private boolean validateFields() {
////        if (fullNameField.getText().trim().isEmpty() ||
////                contactNumberField.getText().trim().isEmpty() ||
////                nationalIdField.getText().trim().isEmpty() ||
////                streetAddressField.getText().trim().isEmpty() ||
////                gramaNiladhariField.getText().trim().isEmpty() ||
////                districtComboBox.getValue() == null ||
////                provinceComboBox.getValue() == null) {
////
////            showAlert(Alert.AlertType.ERROR, "Validation Error",
////                    "Please fill in all mandatory fields.");
////            return false;
////        }
////        return true;
////    }
////
////    private void showAlert(Alert.AlertType alertType, String title, String message) {
////        Alert alert = new Alert(alertType);
////        alert.setTitle(title);
////        alert.setHeaderText(null);
////        alert.setContentText(message);
////        alert.showAndWait();
////    }
////}
//
//package com.example.disastermanagement;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TextField;
//import javafx.event.ActionEvent;
//import javafx.stage.Stage;
//
//import java.net.URL;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.ResourceBundle;
//
//public class ComplainController implements Initializable {
//
//    @FXML
//    private TextField fullNameField, contactNumberField, emailField, nationalIdField;
//    @FXML
//    private TextField streetAddressField, gramaNiladhariField;
//    @FXML
//    private ComboBox<String> districtComboBox;
//    @FXML
//    private ComboBox<String> provinceComboBox;
//
//    // Static fields to store form data
//    private static String savedFullName = "";
//    private static String savedContactNumber = "";
//    private static String savedEmail = "";
//    private static String savedNationalId = "";
//    private static String savedStreetAddress = "";
//    private static String savedGramaNiladhari = "";
//    private static String savedDistrict = "";
//    private static String savedProvince = "";
//
//    private final Map<String, List<String>> districtsByProvince = new HashMap<>();
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        initializeDistricts();  // First set up the districts map
//        initializeProvinces();  // Then initialize provinces which will trigger district update
//        restoreFormData();      // Finally restore other form data
//    }
//
//    // Add this method to handle data coming back from DisasterInfoController
//    public void setUserData(String fullName, String contactNumber, String email, String nationalId,
//                            String streetAddress, String gramaNiladhari, String district, String province) {
//        // Update the static saved fields
//        savedFullName = fullName;
//        savedContactNumber = contactNumber;
//        savedEmail = email;
//        savedNationalId = nationalId;
//        savedStreetAddress = streetAddress;
//        savedGramaNiladhari = gramaNiladhari;
//        savedDistrict = district;
//        savedProvince = province;
//
//        if (fullName.isEmpty() && contactNumber.isEmpty() && email.isEmpty() &&
//                nationalId.isEmpty() && streetAddress.isEmpty() && gramaNiladhari.isEmpty() &&
//                district.isEmpty() && province.isEmpty()) {
//
//            // Clear combo box selections
//            if (provinceComboBox != null) {
//                provinceComboBox.setValue(null);
//            }
//            if (districtComboBox != null) {
//                districtComboBox.setValue(null);
//            }
//        }
//        // Update the form fields
//        restoreFormData();
//    }
//
//    private void initializeProvinces() {
//        ObservableList<String> provinces = FXCollections.observableArrayList(
//                "Central Province", "Eastern Province", "North Central Province",
//                "Northern Province", "North Western Province", "Sabaragamuwa Province",
//                "Southern Province", "Uva Province", "Western Province"
//        );
//        provinceComboBox.setItems(provinces);
//
//        // Set up the event handler for province changes
//        provinceComboBox.setOnAction(event -> updateDistricts());
//
//        // Restore province if saved
//        if (!savedProvince.isEmpty()) {
//            provinceComboBox.setValue(savedProvince);
//            // Explicitly update districts after setting the province
//            updateDistricts();
//        }
//    }
//
//    private void initializeDistricts() {
//        districtsByProvince.put("Central Province", List.of("Kandy", "Matale", "Nuwara Eliya"));
//        districtsByProvince.put("Eastern Province", List.of("Ampara", "Batticaloa", "Trincomalee"));
//        districtsByProvince.put("North Central Province", List.of("Anuradhapura", "Polonnaruwa"));
//        districtsByProvince.put("Northern Province", List.of("Jaffna", "Kilinochchi", "Mannar", "Mullaitivu", "Vavuniya"));
//        districtsByProvince.put("North Western Province", List.of("Kurunegala", "Puttalam"));
//        districtsByProvince.put("Sabaragamuwa Province", List.of("Kegalle", "Ratnapura"));
//        districtsByProvince.put("Southern Province", List.of("Galle", "Matara", "Hambantota"));
//        districtsByProvince.put("Uva Province", List.of("Badulla", "Monaragala"));
//        districtsByProvince.put("Western Province", List.of("Colombo", "Gampaha", "Kalutara"));
//    }
//
//    private void updateDistricts() {
//        String selectedProvince = provinceComboBox.getValue();
//        if (selectedProvince != null) {
//            List<String> districts = districtsByProvince.get(selectedProvince);
//            if (districts != null) {
//                districtComboBox.setItems(FXCollections.observableArrayList(districts));
//
//                // Restore district if saved and matches current province
//                if (!savedDistrict.isEmpty() && districts.contains(savedDistrict)) {
//                    districtComboBox.setValue(savedDistrict);
//                } else {
//                    // Clear the selection if the saved district isn't valid for this province
//                    districtComboBox.setValue(null);
//                }
//            }
//        } else {
//            // Clear districts if no province is selected
//            districtComboBox.setItems(FXCollections.observableArrayList());
//            districtComboBox.setValue(null);
//        }
//    }
//
//    private void restoreFormData() {
//        fullNameField.setText(savedFullName);
//        contactNumberField.setText(savedContactNumber);
//        emailField.setText(savedEmail);
//        nationalIdField.setText(savedNationalId);
//        streetAddressField.setText(savedStreetAddress);
//        gramaNiladhariField.setText(savedGramaNiladhari);
//
//        // Restore province and district
//        if (!savedProvince.isEmpty()) {
//            provinceComboBox.setValue(savedProvince);
//            updateDistricts(); // This will handle setting the district
//        }
//    }
//
//    private void saveFormData() {
//        savedFullName = fullNameField.getText();
//        savedContactNumber = contactNumberField.getText();
//        savedEmail = emailField.getText();
//        savedNationalId = nationalIdField.getText();
//        savedStreetAddress = streetAddressField.getText();
//        savedGramaNiladhari = gramaNiladhariField.getText();
//        savedDistrict = districtComboBox.getValue() != null ? districtComboBox.getValue() : "";
//        savedProvince = provinceComboBox.getValue() != null ? provinceComboBox.getValue() : "";
//    }
//
//    @FXML
//    void handleNextButton(ActionEvent event) {
//        try {
//            if (validateFields()) {
//                // Save form data before navigation
//                saveFormData();
//
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("DisasterInfo.fxml"));
//                Parent root = loader.load();
//
//                DisasterInfoController disasterInfoController = loader.getController();
//                if (disasterInfoController == null) {
//                    throw new RuntimeException("Failed to get DisasterInfoController");
//                }
//
//                disasterInfoController.setUserData(
//                        savedFullName,
//                        savedContactNumber,
//                        savedEmail,
//                        savedNationalId,
//                        savedStreetAddress,
//                        savedGramaNiladhari,
//                        savedDistrict,
//                        savedProvince
//                );
//
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            showAlert(Alert.AlertType.ERROR, "Navigation Error",
//                    "Error loading next page: " + e.getMessage());
//        }
//    }
//
//    private boolean validateFields() {
//        if (fullNameField.getText().trim().isEmpty() ||
//                contactNumberField.getText().trim().isEmpty() ||
//                nationalIdField.getText().trim().isEmpty() ||
//                streetAddressField.getText().trim().isEmpty() ||
//                gramaNiladhariField.getText().trim().isEmpty() ||
//                districtComboBox.getValue() == null ||
//                provinceComboBox.getValue() == null) {
//
//            showAlert(Alert.AlertType.ERROR, "Validation Error",
//                    "Please fill in all mandatory fields.");
//            return false;
//        }
//        return true;
//    }
//
//    private void showAlert(Alert.AlertType alertType, String title, String message) {
//        Alert alert = new Alert(alertType);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//}

package com.example.disastermanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class ComplainController implements Initializable {
    @FXML
    private Pane adminSection;

    @FXML
    private Pane reportDisaster; // Add this field

    @FXML
    private Pane dashboard;
    @FXML
    private TextField fullNameField, contactNumberField, emailField, nationalIdField;
    @FXML
    private TextField streetAddressField, gramaNiladhariField;
    @FXML
    private ComboBox<String> districtComboBox;
    @FXML
    private ComboBox<String> provinceComboBox;

    // Static fields to store form data
    private static String savedFullName = "";
    private static String savedContactNumber = "";
    private static String savedEmail = "";
    private static String savedNationalId = "";
    private static String savedStreetAddress = "";
    private static String savedGramaNiladhari = "";
    private static String savedDistrict = "";
    private static String savedProvince = "";

    private final Map<String, List<String>> districtsByProvince = new HashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeDistricts();  // First set up the districts map
        initializeProvinces();  // Then initialize provinces which will trigger district update
        restoreFormData();
        // Finally restore other form data
        if (adminSection != null) {
            adminSection.setOnMouseClicked(this::handleAdminSectionClick);
        }
        if (reportDisaster != null) {
            reportDisaster.setOnMouseClicked(this::handleReportDisasterClick);
        }

        if (dashboard != null) {
            dashboard.setOnMouseClicked(this::handleDashboardClick);
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

    // Add this method to handle data coming back from DisasterInfoController
    public void setUserData(String fullName, String contactNumber, String email, String nationalId,
                            String streetAddress, String gramaNiladhari, String district, String province) {
        // Update the static saved fields
        savedFullName = fullName;
        savedContactNumber = contactNumber;
        savedEmail = email;
        savedNationalId = nationalId;
        savedStreetAddress = streetAddress;
        savedGramaNiladhari = gramaNiladhari;
        savedDistrict = district;
        savedProvince = province;

        if (fullName.isEmpty() && contactNumber.isEmpty() && email.isEmpty() &&
                nationalId.isEmpty() && streetAddress.isEmpty() && gramaNiladhari.isEmpty() &&
                district.isEmpty() && province.isEmpty()) {

            // Clear combo box selections
            if (provinceComboBox != null) {
                provinceComboBox.setValue(null);
            }
            if (districtComboBox != null) {
                districtComboBox.setValue(null);
            }
        }
        // Update the form fields
        restoreFormData();
    }

    private void initializeProvinces() {
        ObservableList<String> provinces = FXCollections.observableArrayList(
                "Central Province", "Eastern Province", "North Central Province",
                "Northern Province", "North Western Province", "Sabaragamuwa Province",
                "Southern Province", "Uva Province", "Western Province"
        );
        provinceComboBox.setItems(provinces);

        // Set up the event handler for province changes
        provinceComboBox.setOnAction(event -> updateDistricts());

        // Restore province if saved
        if (!savedProvince.isEmpty()) {
            provinceComboBox.setValue(savedProvince);
            // Explicitly update districts after setting the province
            updateDistricts();
        }
    }

    private void initializeDistricts() {
        districtsByProvince.put("Central Province", List.of("Kandy", "Matale", "Nuwara Eliya"));
        districtsByProvince.put("Eastern Province", List.of("Ampara", "Batticaloa", "Trincomalee"));
        districtsByProvince.put("North Central Province", List.of("Anuradhapura", "Polonnaruwa"));
        districtsByProvince.put("Northern Province", List.of("Jaffna", "Kilinochchi", "Mannar", "Mullaitivu", "Vavuniya"));
        districtsByProvince.put("North Western Province", List.of("Kurunegala", "Puttalam"));
        districtsByProvince.put("Sabaragamuwa Province", List.of("Kegalle", "Ratnapura"));
        districtsByProvince.put("Southern Province", List.of("Galle", "Matara", "Hambantota"));
        districtsByProvince.put("Uva Province", List.of("Badulla", "Monaragala"));
        districtsByProvince.put("Western Province", List.of("Colombo", "Gampaha", "Kalutara"));
    }

    private void updateDistricts() {
        String selectedProvince = provinceComboBox.getValue();
        if (selectedProvince != null) {
            List<String> districts = districtsByProvince.get(selectedProvince);
            if (districts != null) {
                districtComboBox.setItems(FXCollections.observableArrayList(districts));

                // Restore district if saved and matches current province
                if (!savedDistrict.isEmpty() && districts.contains(savedDistrict)) {
                    districtComboBox.setValue(savedDistrict);
                } else {
                    // Clear the selection if the saved district isn't valid for this province
                    districtComboBox.setValue(null);
                }
            }
        } else {
            // Clear districts if no province is selected
            districtComboBox.setItems(FXCollections.observableArrayList());
            districtComboBox.setValue(null);
        }
    }

    private void restoreFormData() {
        fullNameField.setText(savedFullName);
        contactNumberField.setText(savedContactNumber);
        emailField.setText(savedEmail);
        nationalIdField.setText(savedNationalId);
        streetAddressField.setText(savedStreetAddress);
        gramaNiladhariField.setText(savedGramaNiladhari);

        // Restore province and district
        if (!savedProvince.isEmpty()) {
            provinceComboBox.setValue(savedProvince);
            updateDistricts(); // This will handle setting the district
        }
    }

    private void saveFormData() {
        savedFullName = fullNameField.getText();
        savedContactNumber = contactNumberField.getText();
        savedEmail = emailField.getText();
        savedNationalId = nationalIdField.getText();
        savedStreetAddress = streetAddressField.getText();
        savedGramaNiladhari = gramaNiladhariField.getText();
        savedDistrict = districtComboBox.getValue() != null ? districtComboBox.getValue() : "";
        savedProvince = provinceComboBox.getValue() != null ? provinceComboBox.getValue() : "";
    }

    @FXML
    void handleNextButton(ActionEvent event) {
        try {
            if (validateFields()) {
                // Save form data before navigation
                saveFormData();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("DisasterInfo.fxml"));
                Parent root = loader.load();

                DisasterInfoController disasterInfoController = loader.getController();
                if (disasterInfoController == null) {
                    throw new RuntimeException("Failed to get DisasterInfoController");
                }

                disasterInfoController.setUserData(
                        savedFullName,
                        savedContactNumber,
                        savedEmail,
                        savedNationalId,
                        savedStreetAddress,
                        savedGramaNiladhari,
                        savedDistrict,
                        savedProvince
                );

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Navigation Error",
                    "Error loading next page: " + e.getMessage());
        }
    }

    private boolean validateFields() {
        if (fullNameField.getText().trim().isEmpty() ||
                contactNumberField.getText().trim().isEmpty() ||
                nationalIdField.getText().trim().isEmpty() ||
                streetAddressField.getText().trim().isEmpty() ||
                gramaNiladhariField.getText().trim().isEmpty() ||
                districtComboBox.getValue() == null ||
                provinceComboBox.getValue() == null) {

            showAlert(Alert.AlertType.ERROR, "Validation Error",
                    "Please fill in all mandatory fields.");
            return false;
        }
        return true;
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}