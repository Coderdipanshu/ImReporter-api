package com.ImReporter.crimes.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ImReporter.crimes.Model.Crime;
import com.ImReporter.crimes.Repository.CrimeRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class CrimeService {

    @Autowired
    private CrimeRepository crimeRepository;

    public CrimeService(CrimeRepository crimeRepository) {
        this.crimeRepository = crimeRepository;
    }

    // Add a new crime
    public Crime addCrime(Crime crime) {
        return crimeRepository.save(crime);
    }

    // Get crimes by state
    public List<Crime> getByState(String state) {
        return crimeRepository.findByState(state);
    }

    // Get crimes by state and district
    public List<Crime> getByStateAndDistrict(String state, String district) {
        return crimeRepository.findByStateAndDistrict(state, district);
    }

    // Get crimes by state, district, and crime type
    public List<Crime> getByStateDistrictAndCrimeType(String state, String district, String crimeType) {
        return crimeRepository.findByStateDistrictAndCrimeType(state, district, crimeType);
    }

    // Get crimes by state, district, crime type, and category
    public List<Crime> getByStateDistrictCrimeTypeAndCategory(String state, String district, String crimeType, String category) {
        return crimeRepository.findByStateDistrictCrimeTypeAndCategory(state, district, crimeType, category);
    }

    // Get crimes by state, district, crime type, category, and date
    public List<Crime> getByStateDistrictCrimeTypeCategoryAndDate(String state, String district, String crimeType, String category, LocalDate parsedDate) {
        return crimeRepository.findByStateDistrictCrimeTypeCategoryAndDate(state, district, crimeType, category, parsedDate);
    }
}
