package com.aguiardafa.gerenciamentoentregasapi.domain.repository;

import com.aguiardafa.gerenciamentoentregasapi.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
