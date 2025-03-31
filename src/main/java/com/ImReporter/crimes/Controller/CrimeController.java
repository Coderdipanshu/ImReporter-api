package com.ImReporter.crimes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ImReporter.crimes.Model.Crime;
import com.ImReporter.crimes.Service.CrimeService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://127.0.0.1:5500") 
@RestController
@RequestMapping("/api/crimes")
public class CrimeController {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    private CrimeService crimeService;

    public CrimeController(CrimeService crimeService) {
        this.crimeService = crimeService;
    }

    /**
     * Upload a crime entry with an optional crimepic
     */
    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<String> uploadCrime(
            @RequestParam("district") String district,
            @RequestParam("state") String state,
            @RequestParam("crimeType") String crimeType,
            @RequestParam("category") String category,
            @RequestParam("description") String description,
            @RequestParam("date") String date, // Format: YYYY-MM-DD
            @RequestParam(value = "crimepic", required = true) MultipartFile crimepic) {

        try {
            byte[] crimepicData = null;
            
            if (crimepic != null && !crimepic.isEmpty()) {
                crimepicData = crimepic.getBytes();
            }

            Crime crime = new Crime(
                    district, crimeType, category, LocalDate.parse(date), description, state, crimepicData);
            crimeService.addCrime(crime);

            return ResponseEntity.ok("Crime uploaded successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to upload crime: " + e.getMessage());
        }
    }

  /**
     * Get all crimes by state (returns Base64 image)
     */
    @GetMapping("/state/{state}")
    public ResponseEntity<List<Map<String, Object>>> getCrimesByState(@PathVariable String state) {
        List<Map<String, Object>> crimes = crimeService.getByState(state);
        return ResponseEntity.ok(crimes);
    }

    /**
     * Get all crimes by state and district
     */
    @GetMapping("/state/{state}/district/{district}")
    public ResponseEntity<List<Map<String, Object>>> getCrimesByStateAndDistrict(
            @PathVariable String state,
            @PathVariable String district) {
        List<Map<String, Object>> crimes = crimeService.getByStateAndDistrict(state, district);
        return ResponseEntity.ok(crimes);
    }

    /**
     * Get crimes by state, district, and crime type
     */
    @GetMapping("/state/{state}/district/{district}/{crimeType}")
    public ResponseEntity<List<Map<String, Object>>> getCrimesByStateDistrictAndCrimeType(
            @PathVariable String state,
            @PathVariable String district,
            @PathVariable String crimeType) {
        List<Map<String, Object>> crimes = crimeService.getByStateDistrictAndCrimeType(state, district, crimeType);
        return ResponseEntity.ok(crimes);
    }

    /**
     * Get crimes by state, district, crime type, and category
     */
    @GetMapping("/state/{state}/district/{district}/{crimeType}/{category}")
    public ResponseEntity<List<Map<String, Object>>> getCrimesByStateDistrictCrimeTypeAndCategory(
            @PathVariable String state,
            @PathVariable String district,
            @PathVariable String crimeType,
            @PathVariable String category) {
        List<Map<String, Object>> crimes = crimeService.getByStateDistrictCrimeTypeAndCategory(state, district, crimeType, category);
        return ResponseEntity.ok(crimes);
    }

    /**
     * Get crimes by state, district, crime type, category, and date
     */
    @GetMapping("/state/{state}/district/{district}/{crimeType}/{category}/{date}")
    public ResponseEntity<?> getCrimesByStateDistrictCrimeTypeCategoryAndDate(
            @PathVariable String state,
            @PathVariable String district,
            @PathVariable String crimeType,
            @PathVariable String category,
            @PathVariable String date) {

        try {
            LocalDate parsedDate = LocalDate.parse(date, DATE_FORMATTER);
            List<Map<String, Object>> crimes = crimeService.getByStateDistrictCrimeTypeCategoryAndDate(state, district, crimeType, category, parsedDate);
            return ResponseEntity.ok(crimes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid date format. Please use 'yyyy-MM-dd'.");
        }
    }
}
