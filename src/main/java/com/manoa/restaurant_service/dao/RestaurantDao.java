package com.manoa.restaurant_service.dao;

import com.manoa.restaurant_service.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Long> {

     Optional<Restaurant> findRestaurantByName(String name);

}
