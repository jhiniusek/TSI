package api.components.sakilaproject.customer;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepo;
    public CustomerService (CustomerRepository customerRepo){
        this.customerRepo = customerRepo;
    }

    public String readCustomers() throws JsonProcessingException {
        List<Customer> objectCustomers = customerRepo.findAll();
        List<String> customers = new ArrayList<String>();

        for(Customer customer : objectCustomers){
            JSONObject jo = JSONFix.fixOrder(customer, JsonViews.Customer.class);
            customers.add(jo.toString());
        }
        return customers.toString();
    }

    public String readCustomer(Integer id) throws JsonProcessingException {
        Customer customer;
        try{
            customer = customerRepo.findById(id).get();
        } catch (Exception e){
            return "Invalid actor ID.";
        }
        return (JSONFix.fixOrder(customer, JsonViews.Customer.class)).toString();
    }

    public String readCustomersByName(String name) throws JsonProcessingException {
        List<Customer> objectCustomers = customerRepo.findCustomerByName(name);
        List<String> customers = new ArrayList<String>();

        for(Customer customer : objectCustomers){
            JSONObject jo = JSONFix.fixOrder(customer, JsonViews.Customer.class);
            customers.add(jo.toString());
        }
        return customers.toString();
    }

    public Customer createCustomer(Customer customer){
        customerRepo.save(customer);
        return customer;
    }
}
