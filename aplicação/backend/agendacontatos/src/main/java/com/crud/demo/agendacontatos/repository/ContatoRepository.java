package com.crud.demo.agendacontatos.repository;

import com.crud.demo.agendacontatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
