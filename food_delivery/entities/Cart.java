package food_delivery.entities;

import java.util.HashMap;
import java.util.Map;




public class Cart {
    
    private Map<FoodItem,Integer> items = new HashMap<>();

    public Cart(){

    }

    public void addItem(FoodItem foodItem, int quantity){
        //update quantity in fooditem
        items.put(foodItem, quantity);
    }

    public void removeItem(FoodItem foodItem){
        items.remove(foodItem);
    }

    public Map<FoodItem, Integer> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Cart [items=" + items + "]";
    }
   
}
