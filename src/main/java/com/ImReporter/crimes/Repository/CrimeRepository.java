package com.ImReporter.crimes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ImReporter.crimes.Model.Crime;

import java.time.LocalDate;
import java.util.List;

public interface CrimeRepository extends JpaRepository<Crime, Long> {

    // Get all crimes by state
    @Query("SELECT c FROM Crime c WHERE c.state = :state")
    List<Crime> findByState(@Param("state") String state);

    // Get all crimes by state and district
    @Query("SELECT c FROM Crime c WHERE c.state = :state AND c.district = :district")
    List<Crime> findByStateAndDistrict(@Param("state") String state, 
                                       @Param("district") String district);

    // Get all crimes by state, district, and crime type
    @Query("SELECT c FROM Crime c WHERE c.state = :state AND c.district = :district AND c.crimeType = :crimeType")
    List<Crime> findByStateDistrictAndCrimeType(@Param("state") String state, 
                                                @Param("district") String district, 
                                                @Param("crimeType") String crimeType);

    // Get all crimes by state, district, crime type, and category
    @Query("SELECT c FROM Crime c WHERE c.state = :state AND c.district = :district AND c.crimeType = :crimeType AND c.category = :category")
    List<Crime> findByStateDistrictCrimeTypeAndCategory(@Param("state") String state, 
                                                        @Param("district") String district, 
                                                        @Param("crimeType") String crimeType, 
                                                        @Param("category") String category);

    // Get all crimes by state, district, crime type, category, and date
    @Query("SELECT c FROM Crime c WHERE c.state = :state AND c.district = :district AND c.crimeType = :crimeType AND c.category = :category AND c.date = :date")
    List<Crime> findByStateDistrictCrimeTypeCategoryAndDate(@Param("state") String state, 
                                                            @Param("district") String district, 
                                                            @Param("crimeType") String crimeType, 
                                                            @Param("category") String category, 
                                                            @Param("date") LocalDate date);
}
