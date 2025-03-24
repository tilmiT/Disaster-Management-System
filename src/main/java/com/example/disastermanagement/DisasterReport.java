//package com.example.disastermanagement;
//
//import java.time.LocalDate;
//
//public class DisasterReport {
//    private String typeOfDisaster;
//    private LocalDate dateOfIncident;
//    private String timeOfIncident;
//    private String impactDescription;
//    private int affectedIndividuals;
//    private String urgencyLevel;
//    private String fullName;
//    private String contactNumber;
//    private String email;
//    private String nationalId;
//    private String streetAddress;
//    private String gramaNiladhari;
//    private String district;
//    private String province;
//
//    public DisasterReport(String typeOfDisaster, LocalDate dateOfIncident, String timeOfIncident,
//                          String impactDescription, int affectedIndividuals, String urgencyLevel,
//                          String fullName, String contactNumber, String email, String nationalId,
//                          String streetAddress, String gramaNiladhari, String district, String province) {
//        this.typeOfDisaster = typeOfDisaster;
//        this.dateOfIncident = dateOfIncident;
//        this.timeOfIncident = timeOfIncident;
//        this.impactDescription = impactDescription;
//        this.affectedIndividuals = affectedIndividuals;
//        this.urgencyLevel = urgencyLevel;
//        this.fullName = fullName;
//        this.contactNumber = contactNumber;
//        this.email = email;
//        this.nationalId = nationalId;
//        this.streetAddress = streetAddress;
//        this.gramaNiladhari = gramaNiladhari;
//        this.district = district;
//        this.province = province;
//    }
//
//    // Getters
//    public String getTypeOfDisaster() { return typeOfDisaster; }
//    public LocalDate getDateOfIncident() { return dateOfIncident; }
//    public String getTimeOfIncident() { return timeOfIncident; }
//    public String getImpactDescription() { return impactDescription; }
//    public int getAffectedIndividuals() { return affectedIndividuals; }
//    public String getUrgencyLevel() { return urgencyLevel; }
//    public String getFullName() { return fullName; }
//    public String getContactNumber() { return contactNumber; }
//    public String getEmail() { return email; }
//    public String getNationalId() { return nationalId; }
//    public String getStreetAddress() { return streetAddress; }
//    public String getGramaNiladhari() { return gramaNiladhari; }
//    public String getDistrict() { return district; }
//    public String getProvince() { return province; }
//
//    // Setters
//    public void setTypeOfDisaster(String typeOfDisaster) { this.typeOfDisaster = typeOfDisaster; }
//    public void setDateOfIncident(LocalDate dateOfIncident) { this.dateOfIncident = dateOfIncident; }
//    public void setTimeOfIncident(String timeOfIncident) { this.timeOfIncident = timeOfIncident; }
//    public void setImpactDescription(String impactDescription) { this.impactDescription = impactDescription; }
//    public void setAffectedIndividuals(int affectedIndividuals) { this.affectedIndividuals = affectedIndividuals; }
//    public void setUrgencyLevel(String urgencyLevel) { this.urgencyLevel = urgencyLevel; }
//    public void setFullName(String fullName) { this.fullName = fullName; }
//    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
//    public void setEmail(String email) { this.email = email; }
//    public void setNationalId(String nationalId) { this.nationalId = nationalId; }
//    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
//    public void setGramaNiladhari(String gramaNiladhari) { this.gramaNiladhari = gramaNiladhari; }
//    public void setDistrict(String district) { this.district = district; }
//    public void setProvince(String province) { this.province = province; }
//
//    @Override
//    public String toString() {
//        return "DisasterReport{" +
//                "typeOfDisaster='" + typeOfDisaster + '\'' +
//                ", dateOfIncident=" + dateOfIncident +
//                ", timeOfIncident='" + timeOfIncident + '\'' +
//                ", impactDescription='" + impactDescription + '\'' +
//                ", affectedIndividuals=" + affectedIndividuals +
//                ", urgencyLevel='" + urgencyLevel + '\'' +
//                ", fullName='" + fullName + '\'' +
//                ", contactNumber='" + contactNumber + '\'' +
//                ", email='" + email + '\'' +
//                ", nationalId='" + nationalId + '\'' +
//                ", streetAddress='" + streetAddress + '\'' +
//                ", gramaNiladhari='" + gramaNiladhari + '\'' +
//                ", district='" + district + '\'' +
//                ", province='" + province + '\'' +
//                '}';
//    }
//}
package com.example.disastermanagement;

import java.time.LocalDate;

public class DisasterReport {
    private Long id;  // Added id field
    private String typeOfDisaster;
    private LocalDate dateOfIncident;
    private String timeOfIncident;
    private String impactDescription;
    private int affectedIndividuals;
    private String urgencyLevel;
    private String fullName;
    private String contactNumber;
    private String email;
    private String nationalId;
    private String streetAddress;
    private String gramaNiladhari;
    private String district;
    private String province;
    private String status;  // Added status field

    public DisasterReport(String typeOfDisaster, LocalDate dateOfIncident, String timeOfIncident,
                          String impactDescription, int affectedIndividuals, String urgencyLevel,
                          String fullName, String contactNumber, String email, String nationalId,
                          String streetAddress, String gramaNiladhari, String district, String province) {
        this.typeOfDisaster = typeOfDisaster;
        this.dateOfIncident = dateOfIncident;
        this.timeOfIncident = timeOfIncident;
        this.impactDescription = impactDescription;
        this.affectedIndividuals = affectedIndividuals;
        this.urgencyLevel = urgencyLevel;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.nationalId = nationalId;
        this.streetAddress = streetAddress;
        this.gramaNiladhari = gramaNiladhari;
        this.district = district;
        this.province = province;
        this.status = "Pending";  // Default status
    }

    // Add getters and setters for id
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // Add getters and setters for status
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Existing getters
    public String getTypeOfDisaster() { return typeOfDisaster; }
    public LocalDate getDateOfIncident() { return dateOfIncident; }
    public String getTimeOfIncident() { return timeOfIncident; }
    public String getImpactDescription() { return impactDescription; }
    public int getAffectedIndividuals() { return affectedIndividuals; }
    public String getUrgencyLevel() { return urgencyLevel; }
    public String getFullName() { return fullName; }
    public String getContactNumber() { return contactNumber; }
    public String getEmail() { return email; }
    public String getNationalId() { return nationalId; }
    public String getStreetAddress() { return streetAddress; }
    public String getGramaNiladhari() { return gramaNiladhari; }
    public String getDistrict() { return district; }
    public String getProvince() { return province; }

    // Existing setters
    public void setTypeOfDisaster(String typeOfDisaster) { this.typeOfDisaster = typeOfDisaster; }
    public void setDateOfIncident(LocalDate dateOfIncident) { this.dateOfIncident = dateOfIncident; }
    public void setTimeOfIncident(String timeOfIncident) { this.timeOfIncident = timeOfIncident; }
    public void setImpactDescription(String impactDescription) { this.impactDescription = impactDescription; }
    public void setAffectedIndividuals(int affectedIndividuals) { this.affectedIndividuals = affectedIndividuals; }
    public void setUrgencyLevel(String urgencyLevel) { this.urgencyLevel = urgencyLevel; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setEmail(String email) { this.email = email; }
    public void setNationalId(String nationalId) { this.nationalId = nationalId; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
    public void setGramaNiladhari(String gramaNiladhari) { this.gramaNiladhari = gramaNiladhari; }
    public void setDistrict(String district) { this.district = district; }
    public void setProvince(String province) { this.province = province; }

    @Override
    public String toString() {
        return "DisasterReport{" +
                "id=" + id +
                ", typeOfDisaster='" + typeOfDisaster + '\'' +
                ", dateOfIncident=" + dateOfIncident +
                ", timeOfIncident='" + timeOfIncident + '\'' +
                ", impactDescription='" + impactDescription + '\'' +
                ", affectedIndividuals=" + affectedIndividuals +
                ", urgencyLevel='" + urgencyLevel + '\'' +
                ", fullName='" + fullName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", gramaNiladhari='" + gramaNiladhari + '\'' +
                ", district='" + district + '\'' +
                ", province='" + province + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}