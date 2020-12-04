package com.academiavivere.semana3.services;

import com.academiavivere.semana3.exceptions.ResourceNotFoundException;
import com.academiavivere.semana3.models.Customer;
import com.academiavivere.semana3.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Customer getById(int customerId){
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));
    }

    public Customer createCustomer(Customer customer) throws Exception {

        if(customer.validadeCpfCnpj(customer.getCpfCnpj())) {
            return customerRepository.save(customer);
        }else{
            throw new Exception("Don't use . or -");
        }
    }

    public Customer updateCustomer(int customerId, Customer customerUpdate ) throws Exception {
        if(customerUpdate.validadeCpfCnpj(customerUpdate.getCpfCnpj())){
            return customerRepository.findById(customerId).map(customer ->{
                customer.setName(customerUpdate.getName());
                customer.setAddress(customerUpdate.getAddress());
                customer.setCpfCnpj(customerUpdate.getCpfCnpj());
                customer.setCity(customerUpdate.getCity());
                customer.setState(customerUpdate.getState());
                customer.setCEP(customerUpdate.getCEP());
                customer.setEmail(customerUpdate.getEmail());
                customer.setPhone(customerUpdate.getPhone());
                return customerRepository.save(customer);
            }).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));
        }else{
            throw new Exception("Don't use . or -");
            }



    }

    public void deleteCustomer(int customerId){
        customerRepository.delete(customerRepository.findById(customerId)
                .orElseThrow(() ->  new ResourceNotFoundException("Customer not found with id: " + customerId) ));
    }

    public Iterable<Customer> getByName(String name){
        return customerRepository.findByName(name);
    }

    public Iterable<Customer> getByCpfCnpj(String cpfCnpj){
        return customerRepository.findByCpfCnpj(cpfCnpj);
    }

    public Iterable<Customer> getByCity(String city){
        return customerRepository.findByCity(city);
    }

    public Iterable<Customer> getByState(String state){
        return customerRepository.findByState(state);
    }

    public Iterable<Customer> getByNameAndCpfCnpjAndCityAndState(String name, String cpfCnpj, String city, String state){
        return customerRepository.findByNameAndCpfCnpjAndCityAndState(name, cpfCnpj, city ,state);
    }

    public Iterable<Customer> getByNameAndCpfCnpj(String name, String cpfCnpj){
        return customerRepository.findByNameAndCpfCnpj(name, cpfCnpj);
    }

    public Iterable<Customer> getByNameAndCpfCnpjAndCity(String name, String cpfCnpj, String city){
        return customerRepository.findByNameAndCpfCnpjAndCity(name, cpfCnpj, city);
    }

    public Iterable<Customer> getByNameAndCpfCnpjAndState(String name, String cpfCnpj, String state){
        return customerRepository.findByNameAndCpfCnpjAndState(name, cpfCnpj, state);
    }

    public Iterable<Customer> getByNameAndCityAndState(String name, String city, String state){
        return customerRepository.findByNameAndCityAndState(name, city ,state);
    }

    public Iterable<Customer> getByNameAndCity(String name, String city){
        return customerRepository.findByNameAndCity(name, city);
    }

    public Iterable<Customer> getByNameAndState(String name, String state){
        return customerRepository.findByNameAndState(name, state);
    }

    public Iterable<Customer> getByCityAndState(String city, String state){
        return customerRepository.findByCityAndState(city, state);
    }

    public Iterable<Customer> getByCpfCnpjAndState(String cpfCnpj, String state){
        return customerRepository.findByCpfCnpjAndState(cpfCnpj, state);
    }

    public Iterable<Customer> getByCpfCnpjAndCity(String cpfCnpj, String city){
        return customerRepository.findByCpfCnpjAndCity(cpfCnpj, city);
    }

    public Iterable<Customer> getByCpfCnpjAndCityAndState(String cpfCnpj, String city, String state){
        return customerRepository.findByCpfCnpjAndCityAndState(cpfCnpj,city,state);
    }



}
