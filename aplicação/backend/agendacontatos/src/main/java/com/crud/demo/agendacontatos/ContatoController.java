package com.crud.demo.agendacontatos;


import com.crud.demo.agendacontatos.model.Contato;
import com.crud.demo.agendacontatos.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contato>> getAllContatos() {
        List<Contato> contatos = contatoService.findAllContatos();
        return new ResponseEntity<>(contatos, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Contato> getContatoById (@PathVariable("id") Long id) {
        Contato contato = contatoService.findContatoById(id);
        return new ResponseEntity<>((contato, HttpStatus.OK);
    }

}
