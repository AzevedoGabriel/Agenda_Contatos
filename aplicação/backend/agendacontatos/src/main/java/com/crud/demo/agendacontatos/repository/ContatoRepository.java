package com.crud.demo.agendacontatos.repository;

import com.crud.demo.agendacontatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    void deleteContatoById(Long id);

    Optional<Contato> findContatoById(Long id);
}
