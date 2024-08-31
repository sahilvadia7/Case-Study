package food_delivery.services;

import java.util.*;
import customer.Customer;

public class CustomerService {
    
    private List<Customer> CustomerList = new ArrayList<>();

    public void addCustomer(Customer customer){
        CustomerList.add(customer);
    }

    public Customer getCustomer(int userId){
        return CustomerList.get(userId);
    }

    public List<Customer> getCustomers(){
        return CustomerList;
    }
}
