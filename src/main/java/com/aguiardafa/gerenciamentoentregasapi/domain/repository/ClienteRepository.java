package com.aguiardafa.gerenciamentoentregasapi.domain.repository;

import com.aguiardafa.gerenciamentoentregasapi.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
