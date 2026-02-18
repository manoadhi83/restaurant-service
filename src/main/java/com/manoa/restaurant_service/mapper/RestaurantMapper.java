package com.manoa.restaurant_service.mapper;

import com.manoa.restaurant_service.dto.RestaurantDto;
import com.manoa.restaurant_service.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    @Mapping(target = "id", ignore = true)
    Restaurant toRestaurant(RestaurantDto restaurantDto);

    RestaurantDto toRestaurantDto(Restaurant restaurant);

}
