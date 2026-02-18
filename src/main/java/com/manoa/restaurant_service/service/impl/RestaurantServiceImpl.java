package com.manoa.restaurant_service.service.impl;

import com.manoa.restaurant_service.dao.RestaurantDao;
import com.manoa.restaurant_service.dto.RestaurantDto;
import com.manoa.restaurant_service.entity.Restaurant;
import com.manoa.restaurant_service.mapper.RestaurantMapper;
import com.manoa.restaurant_service.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantDao restaurantDao;

    public RestaurantServiceImpl(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }
    @Override
    public List<RestaurantDto> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantDao.findAll();
        if (!restaurants.isEmpty()) {
            return restaurants.stream()
                    .map(RestaurantMapper.INSTANCE::toRestaurantDto)
                    .toList();
        }
        return null;
    }

    @Override
    public RestaurantDto createRestaurant(RestaurantDto restaurantDto) {
        if(restaurantDto != null) {
            Restaurant restaurant = restaurantDao.save(RestaurantMapper.INSTANCE.toRestaurant(restaurantDto));
            return RestaurantMapper.INSTANCE.toRestaurantDto(restaurant);
        }
        return null;
    }

    @Override
    public void deleteRestaurantById(Long id) {
        if (id != null) {
            Optional<Restaurant> restaurant = restaurantDao.findById(id);
            restaurant.ifPresent(value -> restaurantDao.delete(value));
        }
    }

    @Override
    public RestaurantDto getRestaurantById(Long id) {
        return restaurantDao.findById(id).map(RestaurantMapper.INSTANCE::toRestaurantDto).orElse(null);
    }
}
