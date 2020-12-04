package com.academiavivere.semana3.repositories;

import com.academiavivere.semana3.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Iterable<Customer> findByName(String name);
    Iterable<Customer> findByCpfCnpj(String cpfCnpj);
    Iterable<Customer> findByCity(String city);
    Iterable<Customer> findByState(String state);
    Iterable<Customer> findByNameAndCpfCnpjAndCityAndState(String name, String cpfCnpj, String city, String state);
    Iterable<Customer> findByNameAndCpfCnpjAndCity(String name, String cpfCnpj,String city);
    Iterable<Customer> findByNameAndCpfCnpj(String name, String cpfCnpj);
    Iterable<Customer> findByCpfCnpjAndCityAndState(String cpfCnpj,String city, String state);
    Iterable<Customer> findByCityAndState(String city, String state);
    Iterable<Customer> findByNameAndState(String name, String state);
    Iterable<Customer> findByNameAndCity(String name, String city);
    Iterable<Customer> findByNameAndCityAndState(String name, String city, String state);
    Iterable<Customer> findByNameAndCpfCnpjAndState(String name, String cpfCnpj,String state);
    Iterable<Customer> findByCpfCnpjAndCity(String cpfCnpj, String city);
    Iterable<Customer> findByCpfCnpjAndState(String cpfCnpj, String state);

}
