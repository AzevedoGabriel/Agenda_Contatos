package com.crud.demo.agendacontatos;


import com.crud.demo.agendacontatos.model.Contato;
import com.crud.demo.agendacontatos.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(contato, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Contato> addContato(@RequestBody Contato contato) {
        Contato newContato = contatoService.addContato(contato);
        return new ResponseEntity<>(newContato, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Contato> updateContato(@RequestBody Contato contato) {
        Contato updateContato = contatoService.updateContato(contato);
        return new ResponseEntity<>(updateContato, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteContato(@PathVariable("id") Long id) {
        contatoService.deleteContato(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
