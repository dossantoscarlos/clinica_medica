package com.dossantoscarlos.consultoria.clinica_medica.modules.consulta;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@Slf4j
@RequestMapping(value="/consultas", produces = {"application/json"})
@Tag(name = "Consulta")
public class ConsultaController {
    
    @Autowired
    ConsultaService service;

    @GetMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<Consulta> pegaTodasConsulta() {
        return service.repository.findAll(); 
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Optional<Consulta> getConsultaOne(@PathVariable String id ) {
        UUID uuid = UUID.fromString(id);
        return service.repository.findById(uuid);
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Consulta salvaConsulta(@RequestBody @Valid Consulta model) {
        return service.repository.save(model); 
    }

}
