package com.service;

import java.util.List;

import com.milind.dto.RestaurantDto;
import com.milind.model.Restaurant;
import com.milind.model.User;

public class RestaurantService {
    public Restaurant createRestaurant(CreateRestaurantRequest req, User user);

    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant) throws Exception;

    public void deleteRestaurant(Long restaurantId) throws Exception;

    public List<Restaurant> getAllRestaurant();

    public List<Restaurant> searchRestaurant(String keyword);

    public Restaurant findRestaurantById(Long id) throws Exception;

    public RestaurantDto addToFavorites(Long restaurantID,User user) throws Exception;

    public Restaurant updateRestaurant (Long id) throws Exception;

    
}
