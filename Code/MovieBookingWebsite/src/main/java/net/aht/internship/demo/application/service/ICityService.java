package net.aht.internship.demo.application.service;

import net.aht.internship.demo.domain.dto.UserSearchDTO;
import net.aht.internship.demo.domain.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICityService {

    Page<City> getAllCities(Pageable pageable);

    List<City> getAllCities();

    City getCityById(Long cityId);

    City getCityByName(String cityName);

    void addCity(City newCity);

    void updateCity(City updatedCity);

    void deleteCity(Long cityId);

    void setCityActiveFlag(Long cityId, boolean activeFlag);

    Page<City> searchCities(UserSearchDTO userSearchDTO, Pageable pageable);

}
