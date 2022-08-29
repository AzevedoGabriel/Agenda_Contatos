package com.crud.demo.agendacontatos.service;

import com.crud.demo.agendacontatos.exception.UserNotFouhndException;
import com.crud.demo.agendacontatos.model.Contato;
import com.crud.demo.agendacontatos.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContatoService {
    private final ContatoRepository contatoRepository;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public Contato addContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    public List<Contato> findAllContatos() {
        return contatoRepository.findAll();
    }

    public Contato updateContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    public Contato findContatoById(Long id){
        return contatoRepository.findContatoById(id)
                .orElseThrow(() -> new UserNotFouhndException("User by id " + id + " was not found!"));
    }

    public void deleteContato(Long id) {
        contatoRepository.deleteContatoById(id);
    }

}
