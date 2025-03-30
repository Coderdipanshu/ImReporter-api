package com.ImReporter.crimes.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "crimes")
public class Crime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String district;
    private String state;
    private String crimeType;
    private String category;
    private LocalDate date;
    private String description;
    @Lob
    @Column(columnDefinition = "LONGBLOB") 
    private byte[] crimepic;
    

    // Constructors
    public Crime() {
    }

    public Crime(String district, String crimeType, String category, LocalDate date, String description, String state,
            byte[] crimepic) {
        this.district = district;
        this.crimeType = crimeType;
        this.category = category;
        this.date = date;
        this.description = description;
        this.state = state;
        this.crimepic = crimepic;

    }
    // Getters and Setters

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public byte[] getCrimepic() {
        return crimepic;
    }

    public void setCrimepic(byte[] crimepic) {
        this.crimepic = crimepic;
    }

    public Long getId() {
        return id;
    }

    public String getDistrict() {
        return district;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
