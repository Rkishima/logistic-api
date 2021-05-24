package br.com.rkishima.domain.repository;

import br.com.rkishima.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {

    List<Cliente> findByName(String name);
}
