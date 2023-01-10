package com.rkorp.logisticapi.domain.repository;

import com.rkorp.logisticapi.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByNome(String nome);
    Optional<Customer> findByEmail(String email);
}
