package food_delivery.services;

import java.util.List;
import food_delivery.entities.*;
import java.util.ArrayList;

public class FoodService {
    
    public List<Restaurant> restaurants = new ArrayList<>();

    public void addRestaurant(Restaurant restaurant){
        restaurants.add(restaurant);
    }

    public List<FoodItem> getAllFoodItems(){
        List<FoodItem> allFoodItems= new ArrayList<>();
        for(Restaurant restaurant: restaurants){
            allFoodItems.addAll(restaurant.getMenu());
        }
        return allFoodItems;
    }

    public void addFoodItemToRestaurant(int restaurantId, FoodItem foodItem){
        Restaurant restaurantid = restaurants.get(restaurantId);
        restaurantid.addFoodItem(foodItem);

    }

    public void removeFoodItemFromRestaurant(int restaurantId,int foodItemId){
        
    }
}
