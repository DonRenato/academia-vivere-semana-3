package com.academiavivere.semana3.controllers;

import com.academiavivere.semana3.models.Customer;
import com.academiavivere.semana3.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/search")
    public ResponseEntity<Iterable<Customer>> getFilters(@RequestParam(value = "name", required = false) String name,
                                                         @RequestParam(value = "cpfCnpj", required = false) String cpfCnpj,
                                                         @RequestParam(value = "city", required = false) String city,
                                                         @RequestParam(value = "state", required = false) String state){

        if(name != null && cpfCnpj != null && city != null && state != null){
            return ResponseEntity.ok().body(customerService.getByNameAndCpfCnpjAndCityAndState(name,cpfCnpj,city,state));
        }else if(name != null && cpfCnpj != null && city != null){
            return ResponseEntity.ok().body(customerService.getByNameAndCpfCnpjAndCity(name,cpfCnpj,city));
        }else if(name != null && cpfCnpj != null && state != null){
            return ResponseEntity.ok().body(customerService.getByNameAndCpfCnpjAndState(name,cpfCnpj,state));
        } else if(name != null && city != null && state != null){
            return ResponseEntity.ok().body(customerService.getByNameAndCityAndState(name,city,state));
        }else if(name != null && cpfCnpj != null){
            return ResponseEntity.ok().body(customerService.getByNameAndCpfCnpj(name,cpfCnpj));
        }else if(name != null && city != null){
            return ResponseEntity.ok().body(customerService.getByNameAndCity(name,city));
        }else if(name != null && state != null){
            return ResponseEntity.ok().body(customerService.getByNameAndState(name,state));
        }else if(cpfCnpj != null && city != null && state != null) {
            return ResponseEntity.ok().body(customerService.getByCpfCnpjAndCityAndState(cpfCnpj,city,state));
        }else if(cpfCnpj != null && city != null) {
            return ResponseEntity.ok().body(customerService.getByCpfCnpjAndCity(cpfCnpj,city));
        }else if(cpfCnpj != null && state != null) {
            return ResponseEntity.ok().body(customerService.getByCpfCnpjAndState(cpfCnpj, state));
        }else if(city != null && state != null) {
            return ResponseEntity.ok().body(customerService.getByCityAndState(city, state));
        }else if(name != null ){
            return ResponseEntity.ok().body(customerService.getByName(name));
        }else if(cpfCnpj != null){
            return ResponseEntity.ok().body(customerService.getByCpfCnpj(cpfCnpj));
        }else if(city != null){
            return ResponseEntity.ok().body(customerService.getByCity(city));
        }else if(state != null){
            return ResponseEntity.ok().body(customerService.getByState(state));
        }
        else {
            return ResponseEntity.ok().body(customerService.getAll());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable(value = "id") int id){
        return ResponseEntity.ok().body(customerService.getById(id));
    }

    @PostMapping
    public  ResponseEntity<Customer> create(@RequestBody Customer customer) throws Exception {
        return ResponseEntity.status(201).body(customerService.createCustomer(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable(value = "id") int id, @RequestBody Customer customer) throws Exception {
        return ResponseEntity.ok().body(customerService.updateCustomer(id, customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id")int id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

}
