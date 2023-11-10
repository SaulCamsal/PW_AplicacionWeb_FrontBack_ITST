package mx.edu.caidt.calzadoapi.controller;

import mx.edu.caidt.calzadoapi.exception.ResourceNotFoundEception;
import mx.edu.caidt.calzadoapi.model.Zapato;
import mx.edu.caidt.calzadoapi.repository.ZapatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.*;
import java.net.URI;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/zapato")
public class ZapatoController {

    @Autowired
    private ZapatoRepository zapatoRepository;

    @GetMapping()
    public ResponseEntity<Iterable<Zapato>> findAll(){
        return ResponseEntity.ok(zapatoRepository.findAll());

    }

    @GetMapping("/{idModelo}")
    public ResponseEntity<Zapato> findById(@PathVariable Long idModelo) {
        Zapato zapato = zapatoRepository.findById(idModelo).
                orElseThrow(()-> new ResourceNotFoundEception("El calzado con ID>: "+ idModelo+ " no existe." ));
        return ResponseEntity.ok(zapato);
        /*Optional<Zapato> zapatoOptional = zapatoRepository.findById(idModelo);
        if (zapatoOptional.isPresent()){
           return ResponseEntity.ok(zapatoOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }*/
    }

    @PostMapping("/zapato")
    public Zapato create(@RequestBody Zapato zapato) {
        return zapatoRepository.save(zapato);
    }

    @PutMapping("/zapato/{idModelo}")
    public ResponseEntity<Zapato> update(@PathVariable Long idModelo, @RequestBody Zapato zapatoAct){
        Zapato zapato = zapatoRepository.findById(idModelo)
                .orElseThrow(() -> new ResourceNotFoundEception("El calzado con ID:"+ idModelo +"no existe."));
        zapatoAct.setIdModelo(zapato.getIdModelo());
        zapato = zapatoRepository.save(zapatoAct);
        return ResponseEntity.ok(zapato);
    }


    /*@PostMapping
    public ResponseEntity<Void> create(@RequestBody Zapato newZapato, UriComponentsBuilder ucb){
        Zapato savedZapato = zapatoRepository.save(newZapato);
        URI uri = ucb
                .path("tarea/{idModelo}")
                .buildAndExpand(savedZapato.getIdModelo())
                .toUri();
        return ResponseEntity.created(uri).build();
    }*/

/*
    @PutMapping("/{idModelo}")
    public ResponseEntity<Void> update(@PathVariable Long idModelo, @RequestBody Zapato zapatoAct){
        Zapato zapatoAnt = zapatoRepository.findById(idModelo).get();
        if(zapatoAnt != null){
            zapatoRepository.save(zapatoAct);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }*/

    @DeleteMapping("/{idModelo}")
    public ResponseEntity<Void> delete(@PathVariable Long idModelo) {
        if (zapatoRepository.findById(idModelo).get() != null){
            zapatoRepository.deleteById(idModelo);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
