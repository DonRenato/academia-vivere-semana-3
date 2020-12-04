package com.academiavivere.semana3.controllers;

import com.academiavivere.semana3.models.CashBook;
import com.academiavivere.semana3.services.CashBookService;
import com.academiavivere.semana3.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cashbook")
public class CashBookController {

    @Autowired
    private CashBookService cashBookService;

    @Autowired
    private CustomerService customerService;
    @GetMapping
    public ResponseEntity<List<CashBook>> getAll(){
        return ResponseEntity.ok().body(cashBookService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CashBook> getAll(@PathVariable(value = "id") int id){
        return ResponseEntity.ok().body(cashBookService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CashBook> create (@RequestBody CashBook cashbook){
        return ResponseEntity.status(201).body(cashBookService.createCashBook(cashbook));
    }

    @PutMapping("{id}")
    public ResponseEntity<CashBook> update(@PathVariable(value = "id") int id, @RequestBody CashBook cashBook){
        return ResponseEntity.ok().body(cashBookService.updateCashbook(id, cashBook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id){
        cashBookService.deleteCashBook(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Iterable<CashBook>> findCustomerById(@PathVariable(value = "id") int id){
        return ResponseEntity.ok().body(cashBookService.getCustomerById(id));
    }


}
