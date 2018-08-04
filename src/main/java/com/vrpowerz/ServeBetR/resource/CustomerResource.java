package com.vrpowerz.ServeBetR.resource;

import com.vrpowerz.ServeBetR.model.Customer;
import com.vrpowerz.ServeBetR.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

/**
 * @author Venkataraghavan Yanamandram
 *
 */

@RestController
@RequestMapping("/api/customers/")
public class CustomerResource {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/{page}/{size}")
    public Response getAllCustomers(@PathVariable("page") final Integer page, @PathVariable("size") final Integer size){
        try {
            Page<Customer> customers = customerRepository.findAll(PageRequest.of(page + 1, size));
            return new Response(customers);
        }catch (Exception e){
            return new Response(null, "Unable to get customers list.", false, e.toString());
        }
    }

    @GetMapping("/{id}")
    public Response getCustomer(@PathVariable("id") final Long id){
        try {
            return new Response(customerRepository.findById(id).orElse(null));
        }catch (Exception e){
            return new Response(null, "Unable to get the customer.", false, e.toString());
        }
    }

    @PostMapping("/save")
    public Response saveCustomer(@RequestBody final Customer customer){
        try {
            customer.setTimestamp(Calendar.getInstance().getTime());
            customerRepository.save(customer);
            return new Response(customer);
        }catch (Exception e){
            return new Response(null, "Unable to create the customer.", false, e.toString());
        }
    }

    @PutMapping("/update")
    public Response updateCustomer(@RequestBody final Customer customer){
        try {
            Customer customer1 = customerRepository.findById(customer.getId()).orElse(null);
            customer.setTimestamp(customer1.getTimestamp());
            customerRepository.save(customer);
            return new Response(customer);
        }catch (Exception e){
            return new Response(null, "Unable to update the customer.", false, e.toString());
        }
    }

    @DeleteMapping("/{id}")
    public Response deleteCustomer(@PathVariable("id") final Long id){
        try {
            customerRepository.deleteById(id);
            return new Response(null, "Customer deleted successfully");
        }catch (Exception e){
            return new Response(null, "Unable to delete the customer. The Customer might be participated in any Service calls.", false, e.toString());
        }
    }

}
