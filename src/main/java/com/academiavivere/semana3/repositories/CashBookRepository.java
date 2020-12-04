package com.academiavivere.semana3.repositories;

import com.academiavivere.semana3.models.CashBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface CashBookRepository extends JpaRepository<CashBook, Integer> {

        List<CashBook> findByCustomerId(int customerId);

        List<CashBook> findByCustomerIdAndReleaseDateBetween(int customerId, Date start, Date end);
}
