package com.academiavivere.semana3.services;

import com.academiavivere.semana3.exceptions.ResourceNotFoundException;
import com.academiavivere.semana3.models.CashBook;
import com.academiavivere.semana3.repositories.CashBookRepository;
import com.academiavivere.semana3.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CashBookService {

    @Autowired
    private CashBookRepository cashBookRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public List<CashBook> getAll(){
        return cashBookRepository.findAll();
    }

    public  CashBook getById(int cashbookId){
        return cashBookRepository.findById(cashbookId)
                .orElseThrow(() -> new ResourceNotFoundException("Cash book not found with cashbookId: " + cashbookId));
    }

    public CashBook createCashBook(CashBook cashBook){
        return cashBookRepository.save(cashBook);
    }

    public CashBook updateCashbook(int cashBookId, CashBook cashBook){
        return cashBookRepository.findById(cashBookId).map(cb -> {
                cb.setAmount(cashBook.getAmount());
                cb.setCustomer(cashBook.getCustomer());
                cb.setDescription(cashBook.getDescription());
                cb.setType(cashBook.getType());
                return cashBookRepository.save(cb);
        }).orElseThrow(() -> new ResourceNotFoundException("Cash book not found with cashBookId: " + cashBookId));
    }

    public  void deleteCashBook(int cashBookId){
        cashBookRepository.delete(cashBookRepository.findById(cashBookId)
                .orElseThrow(() -> new ResourceNotFoundException("Cash book not found with cashBookId: " + cashBookId )));
    }

    public  Iterable<CashBook> getCustomerById(int customerId){
        return cashBookRepository.findByCustomerId(customerId);
    }
}
