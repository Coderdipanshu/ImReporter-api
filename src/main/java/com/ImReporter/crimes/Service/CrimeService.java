package com.ImReporter.crimes.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ImReporter.crimes.Model.Crime;
import com.ImReporter.crimes.Repository.CrimeRepository;

import java.time.LocalDate;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CrimeService {

    @Autowired
    private CrimeRepository crimeRepository;

    public CrimeService(CrimeRepository crimeRepository) {
        this.crimeRepository = crimeRepository;
    }


    // Convert image bytes to Base64 format
    private String convertImageToBase64(byte[] image) {
        return (image != null) ? "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(image) : null;
    }

    // Format Crime data into a Map (JSON-friendly format)
    private Map<String, Object> formatCrimeData(Crime crime) {
        Map<String, Object> crimeData = new HashMap<>();
        crimeData.put("id", crime.getId());
        crimeData.put("state", crime.getState());
        crimeData.put("district", crime.getDistrict());
        crimeData.put("crimeType", crime.getCrimeType());
        crimeData.put("category", crime.getCategory());
        crimeData.put("date", crime.getDate().toString());
        crimeData.put("crimepic", convertImageToBase64(crime.getCrimepic())); // ✅ Convert image

        return crimeData;
    }



    // Add a new crime
    public Crime addCrime(Crime crime) {
        return crimeRepository.save(crime);
    }

    // Get crimes by state with image conversion
    public List<Map<String, Object>> getByState(String state) {
        List<Crime> crimes = crimeRepository.findByState(state);
        return crimes.stream().map(this::formatCrimeData).toList();
    }

    // Get crimes by state and district
    public List<Map<String, Object>> getByStateAndDistrict(String state, String district) {
        List<Crime> crimes = crimeRepository.findByStateAndDistrict(state, district);
        return crimes.stream().map(this::formatCrimeData).toList();
    }

    // Get crimes by state, district, and crime type
    public List<Map<String, Object>> getByStateDistrictAndCrimeType(String state, String district, String crimeType) {
        List<Crime> crimes = crimeRepository.findByStateDistrictAndCrimeType(state, district, crimeType);
        return crimes.stream().map(this::formatCrimeData).toList();
    }

    // Get crimes by state, district, crime type, and category
    public List<Map<String, Object>> getByStateDistrictCrimeTypeAndCategory(String state, String district, String crimeType, String category) {
        List<Crime> crimes = crimeRepository.findByStateDistrictCrimeTypeAndCategory(state, district, crimeType, category);
        return crimes.stream().map(this::formatCrimeData).toList();
    }

    // Get crimes by state, district, crime type, category, and date
    public List<Map<String, Object>> getByStateDistrictCrimeTypeCategoryAndDate(String state, String district, String crimeType, String category, LocalDate parsedDate) {
        List<Crime> crimes = crimeRepository.findByStateDistrictCrimeTypeCategoryAndDate(state, district, crimeType, category, parsedDate);
        return crimes.stream().map(this::formatCrimeData).toList();
    }
}
