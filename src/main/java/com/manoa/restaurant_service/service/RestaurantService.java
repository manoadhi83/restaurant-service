package com.manoa.restaurant_service.service;

import com.manoa.restaurant_service.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {

    public List<RestaurantDto> getAllRestaurants();

    public RestaurantDto createRestaurant(RestaurantDto restaurantDto);

    public void deleteRestaurantById(Long id);

    RestaurantDto getRestaurantById(Long id);
}
