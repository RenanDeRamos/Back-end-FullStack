package com.ibeus.Comanda.Digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ibeus.Comanda.Digital.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
