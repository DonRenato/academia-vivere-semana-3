package com.academiavivere.semana3.controllers;

import com.academiavivere.semana3.models.DTO.AccoutingDTO;
import com.academiavivere.semana3.services.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


@RestController
@RequestMapping("/accounting")
public class AccountingController {
    @Autowired
    private AccountingService accountingService;

    @GetMapping("/{id}")
    public ResponseEntity<AccoutingDTO>getById(@PathVariable(value = "id") int id,
                                               @RequestParam(value = "startDate", required = false) String start,
                                               @RequestParam(value = "endDate", required = false) String end) throws ParseException {
        if(start == null || end == null) {
            return ResponseEntity.ok().body(accountingService.accountById(id));
        }
        else{
            return ResponseEntity.ok().body(accountingService.getByIdAndDate(id, start,end));
        }
    }


}