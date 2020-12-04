package com.academiavivere.semana3.services;

import com.academiavivere.semana3.exceptions.ResourceNotFoundException;
import com.academiavivere.semana3.models.CashBook;
import com.academiavivere.semana3.models.Customer;
import com.academiavivere.semana3.models.DTO.AccoutingDTO;
import com.academiavivere.semana3.models.DTO.CashBookDTO;
import com.academiavivere.semana3.repositories.CashBookRepository;
import com.academiavivere.semana3.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class AccountingService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CashBookRepository cashBookRepository;

    public AccoutingDTO accountById(int customerId){
        AccoutingDTO filter = new AccoutingDTO();

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("customer not found with id: " + customerId));

        List<CashBook> cashBook = cashBookRepository.findByCustomerId(customer.getId());

        filter.setId(customer.getId());
        filter.setName(customer.getName());
        filter.setCpfCnpj(customer.getCpfCnpj());
        filter.setPhone(customer.getPhone());

        List<CashBookDTO> cashBooks = accountings(cashBook);

        for(CashBookDTO cashBookDTO : cashBooks){
            filter.getAccouting().add(cashBookDTO);
        }

        return filter;
    }

   public AccoutingDTO getByIdAndDate(int customerId, String startDate, String endDate) throws ParseException {
       SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date start = dateFormat.parse(startDate);
        Date end = dateFormat.parse(endDate);

        AccoutingDTO filter = new AccoutingDTO();

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("customer not found with id: " + customerId));

        List<CashBook> cashBooks =  cashBookRepository.findByCustomerIdAndReleaseDateBetween(customer.getId(),start,end);

        filter.setId(customer.getId());
        filter.setName(customer.getName());
        filter.setCpfCnpj(customer.getCpfCnpj());
        filter.setPhone(customer.getPhone());

        List<CashBookDTO> cashBookDTOS = accountings(cashBooks);


        for (CashBookDTO cashBookDTO: cashBookDTOS){
            filter.getAccouting().add(cashBookDTO);
        }

        return filter;

    }

    private List<CashBookDTO> accountings(List<CashBook> cashBook) {
        List<CashBookDTO> cashBookDTOList = new ArrayList<>();
        double total = 0.0;

        for(CashBook cashbook : cashBook){
            if(cashbook.getType().getDescription().equals("C")){
                total += cashbook.getAmount();

                CashBookDTO cashBookDTO = new CashBookDTO();

                cashBookDTO.setReleaseDate(cashbook.getReleaseDate());
                cashBookDTO.setDescription(cashbook.getDescription());
                cashBookDTO.setType(cashbook.getType());
                cashBookDTO.setAmount(cashbook.getAmount());
                cashBookDTO.setBalance(total);

                cashBookDTOList.add(cashBookDTO);
            }else{
                total -= cashbook.getAmount();

                CashBookDTO cashBookDTO = new CashBookDTO();

                cashBookDTO.setReleaseDate(cashbook.getReleaseDate());
                cashBookDTO.setDescription(cashbook.getDescription());
                cashBookDTO.setType(cashbook.getType());
                cashBookDTO.setAmount(cashbook.getAmount());
                cashBookDTO.setBalance(total);

                cashBookDTOList.add(cashBookDTO);
            }
        }

       return cashBookDTOList;


    }


}
