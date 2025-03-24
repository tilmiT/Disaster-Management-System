//////package com.example.disastermanagement;
//////
//////import javafx.collections.FXCollections;
//////import javafx.collections.ObservableList;
//////import javafx.fxml.FXML;
//////import javafx.fxml.FXMLLoader;
//////import javafx.fxml.Initializable;
//////import javafx.scene.Parent;
//////import javafx.scene.Scene;
//////import javafx.scene.chart.PieChart;
//////import javafx.scene.control.Alert;
//////import javafx.scene.input.MouseEvent;
//////import javafx.scene.layout.Pane;
//////import javafx.stage.Stage;
//////
//////import java.net.URL;
//////import java.sql.Connection;
//////import java.sql.PreparedStatement;
//////import java.sql.ResultSet;
//////import java.sql.SQLException;
//////import java.util.HashMap;
//////import java.util.Map;
//////import java.util.ResourceBundle;
//////
//////public class DashboardController implements Initializable {
//////
//////    @FXML
//////    private PieChart disasterPieChart;
//////
//////    @FXML
//////    private Pane adminSection;
//////
//////    @FXML
//////    private Pane reportDisaster;
//////
//////    @FXML
//////    private Pane dashboard;
//////
//////    @Override
//////    public void initialize(URL url, ResourceBundle resourceBundle) {
//////        loadDisasterStatistics();
//////        setupNavigationHandlers();
//////    }
//////
//////    private void loadDisasterStatistics() {
//////        try {
//////            // Get disaster type counts from database
//////            Map<String, Integer> disasterCounts = getDisasterTypeCounts();
//////
//////            // Convert to pie chart data
//////            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
//////            int total = disasterCounts.values().stream().mapToInt(Integer::intValue).sum();
//////
//////            for (Map.Entry<String, Integer> entry : disasterCounts.entrySet()) {
//////                double percentage = (entry.getValue() * 100.0) / total;
//////                String label = String.format("%s (%.1f%%)", entry.getKey(), percentage);
//////                pieChartData.add(new PieChart.Data(label, entry.getValue()));
//////            }
//////
//////            disasterPieChart.setData(pieChartData);
//////            disasterPieChart.setTitle("Disaster Type Distribution");
//////
//////            // Add hover labels showing exact count
//////            pieChartData.forEach(data ->
//////                    data.getNode().setOnMouseEntered(e ->
//////                            data.getNode().setStyle("-fx-pie-color: derive(" + data.getNode().getStyle() + ", 20%);")
//////                    )
//////            );
//////
//////        } catch (SQLException e) {
//////            showAlert(Alert.AlertType.ERROR, "Database Error",
//////                    "Error loading disaster statistics: " + e.getMessage());
//////        }
//////    }
//////
//////    private Map<String, Integer> getDisasterTypeCounts() throws SQLException {
//////        Map<String, Integer> counts = new HashMap<>();
//////        String query = "SELECT type_of_disaster, COUNT(*) as count FROM disaster_reports GROUP BY type_of_disaster";
//////
//////        try (Connection conn = DatabaseUtil.getConnection();
//////             PreparedStatement stmt = conn.prepareStatement(query);
//////             ResultSet rs = stmt.executeQuery()) {
//////
//////            while (rs.next()) {
//////                counts.put(rs.getString("type_of_disaster"), rs.getInt("count"));
//////            }
//////        }
//////
//////        return counts;
//////    }
//////
//////    private void setupNavigationHandlers() {
//////        if (adminSection != null) {
//////            adminSection.setOnMouseClicked(this::handleAdminSectionClick);
//////        }
//////        if (reportDisaster != null) {
//////            reportDisaster.setOnMouseClicked(this::handleReportDisasterClick);
//////        }
//////        if (dashboard != null) {
//////            dashboard.setOnMouseClicked(this::handleDashboardClick);
//////        }
//////    }
//////
//////    @FXML
//////    private void handleAdminSectionClick(MouseEvent event) {
//////        navigateToView("Admin.fxml");
//////    }
//////
//////    @FXML
//////    private void handleReportDisasterClick(MouseEvent event) {
//////        navigateToView("complain.fxml");
//////    }
//////
//////    @FXML
//////    private void handleDashboardClick(MouseEvent event) {
//////        navigateToView("Dashboard.fxml");
//////    }
//////
//////    private void navigateToView(String fxmlFile) {
//////        try {
//////            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/disastermanagement/" + fxmlFile));
//////            Parent root = loader.load();
//////            Stage stage = (Stage) dashboard.getScene().getWindow();
//////            Scene scene = new Scene(root);
//////            stage.setScene(scene);
//////            stage.show();
//////        } catch (Exception e) {
//////            showAlert(Alert.AlertType.ERROR, "Navigation Error",
//////                    "Could not load " + fxmlFile + ": " + e.getMessage());
//////        }
//////    }
//////
//////    private void showAlert(Alert.AlertType alertType, String title, String message) {
//////        Alert alert = new Alert(alertType);
//////        alert.setTitle(title);
//////        alert.setHeaderText(null);
//////        alert.setContentText(message);
//////        alert.showAndWait();
//////    }
//////}
////package com.example.disastermanagement;
////
////import javafx.fxml.FXML;
////import javafx.fxml.FXMLLoader;
////import javafx.fxml.Initializable;
////import javafx.scene.Parent;
////import javafx.scene.Scene;
////import javafx.scene.chart.PieChart;
////import javafx.scene.control.TextField;
////import javafx.scene.layout.Pane;
////import javafx.stage.Stage;
////import javafx.scene.input.MouseEvent;
////import javafx.scene.control.Alert;
////import javafx.collections.FXCollections;
////import javafx.collections.ObservableList;
////
////import java.net.URL;
////import java.sql.Connection;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.util.ResourceBundle;
////import java.util.HashMap;
////import java.util.Map;
////
////public class DashboardController implements Initializable {
////    @FXML
////    private PieChart disasterPieChart;
////
////    @FXML
////    private TextField totalDisasterField;
////
////    @FXML
////    private Pane adminSection;
////
////    @FXML
////    private Pane reportDisaster;
////
////    @FXML
////    private Pane dashboard;
////
////    @Override
////    public void initialize(URL url, ResourceBundle rb) {
////        loadDisasterData();
////
////        if (adminSection != null) {
////            adminSection.setOnMouseClicked(this::handleAdminSectionClick);
////        }
////        if (reportDisaster != null) {
////            reportDisaster.setOnMouseClicked(this::handleReportDisasterClick);
////        }
////        if (dashboard != null) {
////            dashboard.setOnMouseClicked(this::handleDashboardClick);
////        }
////    }
////
////    @FXML
////    private void handleAdminSectionClick(MouseEvent event) {
////        try {
////            FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
////            Parent root = loader.load();
////            Stage stage = (Stage) adminSection.getScene().getWindow();
////            Scene scene = new Scene(root);
////            stage.setScene(scene);
////            stage.show();
////        } catch (Exception e) {
////            e.printStackTrace();
////            showAlert(Alert.AlertType.ERROR, "Navigation Error",
////                    "Could not load admin view: " + e.getMessage());
////        }
////    }
////
////    @FXML
////    private void handleReportDisasterClick(MouseEvent event) {
////        try {
////            FXMLLoader loader = new FXMLLoader(getClass().getResource("complain.fxml"));
////            Parent root = loader.load();
////            Stage stage = (Stage) reportDisaster.getScene().getWindow();
////            Scene scene = new Scene(root);
////            stage.setScene(scene);
////            stage.show();
////        } catch (Exception e) {
////            e.printStackTrace();
////            showAlert(Alert.AlertType.ERROR, "Navigation Error",
////                    "Could not load complaint form: " + e.getMessage());
////        }
////    }
////
////    @FXML
////    private void handleDashboardClick(MouseEvent event) {
////        try {
////            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
////            Parent root = loader.load();
////            Stage stage = (Stage) dashboard.getScene().getWindow();
////            Scene scene = new Scene(root);
////            stage.setScene(scene);
////            stage.show();
////        } catch (Exception e) {
////            e.printStackTrace();
////            showAlert(Alert.AlertType.ERROR, "Navigation Error",
////                    "Could not load dashboard: " + e.getMessage());
////        }
////    }
////
////    private void loadDisasterData() {
////        try (Connection conn = DatabaseUtil.getConnection()) {
////            // Get total number of disasters
////            String countQuery = "SELECT COUNT(*) as total FROM disaster_reports";
////            try (PreparedStatement pstmt = conn.prepareStatement(countQuery)) {
////                ResultSet rs = pstmt.executeQuery();
////                if (rs.next()) {
////                    int totalDisasters = rs.getInt("total");
////                    totalDisasterField.setText(String.valueOf(totalDisasters));
////                }
////            }
////
////            // Get disaster type distribution
////            String distributionQuery = """
////                SELECT type_of_disaster, COUNT(*) as count,
////                (COUNT(*) * 100.0 / (SELECT COUNT(*) FROM disaster_reports)) as percentage
////                FROM disaster_reports
////                GROUP BY type_of_disaster
////            """;
////
////            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
////
////            // Define color mapping for disaster types
////            Map<String, String> disasterColors = new HashMap<>();
////            disasterColors.put("Flood", "#1E88E5");       // Blue
////            disasterColors.put("Landslide", "#8B4513");   // Brown
////            disasterColors.put("Cyclone", "#7E57C2");     // Purple
////            disasterColors.put("Earthquake", "#D32F2F");   // Red
////            disasterColors.put("Tsunami", "#0097A7");      // Cyan
////            disasterColors.put("Drought", "#FFA000");      // Orange
////            disasterColors.put("Wildfire", "#FF5722");     // Deep Orange
////
////            try (PreparedStatement pstmt = conn.prepareStatement(distributionQuery)) {
////                ResultSet rs = pstmt.executeQuery();
////
////                while (rs.next()) {
////                    String disasterType = rs.getString("type_of_disaster");
////                    double percentage = rs.getDouble("percentage");
////                    PieChart.Data slice = new PieChart.Data(
////                            String.format("%s (%.1f%%)", disasterType, percentage),
////                            percentage
////                    );
////                    pieChartData.add(slice);
////
////                    // Apply color if defined for this disaster type
////                    final String color = disasterColors.getOrDefault(disasterType, "#757575");
////                    slice.getNode().setStyle("-fx-pie-color: " + color + ";");
////                }
////            }
////
////            disasterPieChart.setData(pieChartData);
////            disasterPieChart.setTitle("Disaster Type Distribution");
////
////            // Add hover effects and click handlers for pie chart segments
////            pieChartData.forEach(data -> {
////                String color = data.getNode().getStyle().replace("-fx-pie-color: ", "").replace(";", "");
////
////                data.getNode().setOnMouseEntered(event -> {
////                    data.getNode().setStyle("-fx-pie-color: derive(" + color + ", 20%);");
////                });
////
////                data.getNode().setOnMouseExited(event -> {
////                    data.getNode().setStyle("-fx-pie-color: " + color + ";");
////                });
////
////                // Add click handler to show detailed information
////                data.getNode().setOnMouseClicked(event -> {
////                    String disasterType = data.getName().split(" ")[0];
////                    showDisasterDetails(disasterType);
////                });
////            });
////
////        } catch (Exception e) {
////            e.printStackTrace();
////            showAlert(Alert.AlertType.ERROR, "Data Loading Error",
////                    "Error loading disaster data: " + e.getMessage());
////        }
////    }
////
////    private void showDisasterDetails(String disasterType) {
////        try (Connection conn = DatabaseUtil.getConnection()) {
////            String query = """
////                SELECT COUNT(*) as count,
////                       SUM(affected_individuals) as total_affected,
////                       AVG(affected_individuals) as avg_affected
////                FROM disaster_reports
////                WHERE type_of_disaster = ?
////            """;
////
////            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
////                pstmt.setString(1, disasterType);
////                ResultSet rs = pstmt.executeQuery();
////
////                if (rs.next()) {
////                    int count = rs.getInt("count");
////                    int totalAffected = rs.getInt("total_affected");
////                    double avgAffected = rs.getDouble("avg_affected");
////
////                    String details = String.format("""
////                        Disaster Type: %s
////                        Total Incidents: %d
////                        Total Affected Individuals: %d
////                        Average Affected per Incident: %.2f
////                        """,
////                            disasterType, count, totalAffected, avgAffected);
////
////                    showAlert(Alert.AlertType.INFORMATION,
////                            "Disaster Details",
////                            details);
////                }
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////            showAlert(Alert.AlertType.ERROR, "Error",
////                    "Could not load disaster details: " + e.getMessage());
////        }
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
//import javafx.application.Platform;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.chart.PieChart;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.control.Alert;
//
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ResourceBundle;
//
//public class DashboardController implements Initializable {
//    @FXML
//    private PieChart disasterPieChart;
//
//    @FXML
//    private TextField totalDisasterField;
//
//    @FXML
//    private Pane adminSection;
//
//    @FXML
//    private Pane reportDisaster;
//
//    @FXML
//    private Pane dashboard;
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        loadDisasterData();
//
//        if (adminSection != null) {
//            adminSection.setOnMouseClicked(this::handleAdminSectionClick);
//        }
//        if (reportDisaster != null) {
//            reportDisaster.setOnMouseClicked(this::handleReportDisasterClick);
//        }
//        if (dashboard != null) {
//            dashboard.setOnMouseClicked(this::handleDashboardClick);
//        }
//    }
//
//    @FXML
//    private void handleAdminSectionClick(MouseEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
//            Parent root = loader.load();
//            Stage stage = (Stage) adminSection.getScene().getWindow();
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//            showAlert(Alert.AlertType.ERROR, "Navigation Error",
//                    "Could not load admin view: " + e.getMessage());
//        }
//    }
//
//    @FXML
//    private void handleReportDisasterClick(MouseEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("complain.fxml"));
//            Parent root = loader.load();
//            Stage stage = (Stage) reportDisaster.getScene().getWindow();
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//            showAlert(Alert.AlertType.ERROR, "Navigation Error",
//                    "Could not load complaint form: " + e.getMessage());
//        }
//    }
//
//    @FXML
//    private void handleDashboardClick(MouseEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
//            Parent root = loader.load();
//            Stage stage = (Stage) dashboard.getScene().getWindow();
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//            showAlert(Alert.AlertType.ERROR, "Navigation Error",
//                    "Could not load dashboard: " + e.getMessage());
//        }
//    }
//
//    private void loadDisasterData() {
//        try (Connection conn = DatabaseUtil.getConnection()) {
//            // Get total number of disasters
//            String countQuery = "SELECT COUNT(*) as total FROM disaster_reports";
//            try (PreparedStatement pstmt = conn.prepareStatement(countQuery)) {
//                ResultSet rs = pstmt.executeQuery();
//                if (rs.next()) {
//                    int totalDisasters = rs.getInt("total");
//                    totalDisasterField.setText(String.valueOf(totalDisasters));
//                }
//            }
//
//            // Get disaster type distribution
//            String distributionQuery = """
//                SELECT type_of_disaster, COUNT(*) as count,
//                (COUNT(*) * 100.0 / (SELECT COUNT(*) FROM disaster_reports)) as percentage
//                FROM disaster_reports
//                GROUP BY type_of_disaster
//            """;
//
//            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
//
//            try (PreparedStatement pstmt = conn.prepareStatement(distributionQuery)) {
//                ResultSet rs = pstmt.executeQuery();
//
//                while (rs.next()) {
//                    String disasterType = rs.getString("type_of_disaster");
//                    double percentage = rs.getDouble("percentage");
//                    pieChartData.add(new PieChart.Data(
//                            String.format("%s (%.1f%%)", disasterType, percentage),
//                            percentage
//                    ));
//                }
//            }
//
//            disasterPieChart.setData(pieChartData);
//            disasterPieChart.setTitle("Disaster Type Distribution");
//
//            // Add hover effect after the pie chart has been rendered
//            Platform.runLater(() -> {
//                for (PieChart.Data data : pieChartData) {
//                    if (data.getNode() != null) {
//                        data.getNode().setOnMouseEntered(event -> {
//                            data.getNode().setStyle("-fx-pie-color: derive(" + data.getNode().getStyle() + ", 20%);");
//                        });
//
//                        data.getNode().setOnMouseExited(event -> {
//                            data.getNode().setStyle("");
//                        });
//                    }
//                }
//            });
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            showAlert(Alert.AlertType.ERROR, "Data Loading Error",
//                    "Error loading disaster data: " + e.getMessage());
//        }
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

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.Node;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private PieChart disasterPieChart;

    @FXML
    private TextField totalDisasterField;

    @FXML
    private Pane adminSection;

    @FXML
    private Pane reportDisaster;

    @FXML
    private Pane dashboard;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDisasterData();

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) adminSection.getScene().getWindow();
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

    private void loadDisasterData() {
        try (Connection conn = DatabaseUtil.getConnection()) {
            // Get total number of disasters
            String countQuery = "SELECT COUNT(*) as total FROM disaster_reports";
            try (PreparedStatement pstmt = conn.prepareStatement(countQuery)) {
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    int totalDisasters = rs.getInt("total");
                    totalDisasterField.setText(String.valueOf(totalDisasters));
                }
            }

            // Get disaster type distribution
            String distributionQuery = """
                SELECT type_of_disaster, COUNT(*) as count,
                (COUNT(*) * 100.0 / (SELECT COUNT(*) FROM disaster_reports)) as percentage
                FROM disaster_reports
                GROUP BY type_of_disaster
            """;

            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

            try (PreparedStatement pstmt = conn.prepareStatement(distributionQuery)) {
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    String disasterType = rs.getString("type_of_disaster");
                    double percentage = rs.getDouble("percentage");
                    pieChartData.add(new PieChart.Data(
                            String.format("%s (%.1f%%)", disasterType, percentage),
                            percentage
                    ));
                }
            }

            disasterPieChart.setData(pieChartData);
            disasterPieChart.setTitle("Disaster Type Distribution");

            // Add hover effects after the chart has been rendered
            Platform.runLater(() -> {
                pieChartData.forEach(data -> {
                    Node node = data.getNode();
                    if (node != null) {
                        // Store the original opacity
                        double originalOpacity = node.getOpacity();

                        node.setOnMouseEntered(event -> {
                            node.setOpacity(0.8); // Slightly reduce opacity on hover
                        });

                        node.setOnMouseExited(event -> {
                            node.setOpacity(originalOpacity); // Restore original opacity
                        });
                    }
                });
            });

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Data Loading Error",
                    "Error loading disaster data: " + e.getMessage());
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