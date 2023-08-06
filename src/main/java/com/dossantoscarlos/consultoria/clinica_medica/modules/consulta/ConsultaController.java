package com.dossantoscarlos.consultoria.clinica_medica.modules.consulta;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
@RequestMapping("/api/v1/clinica/consulta")
public class ConsultaController {
    
    @Autowired
    ConsultaService service;

    @GetMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<ConsultaModel> pegaTodasConsulta() {
        return service.repository.findAll(); 
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Optional<ConsultaModel> getConsultaOne( @PathVariable UUID id ) {
        return service.repository.findById(id); 
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ConsultaModel salvaConsulta(@RequestBody @Valid ConsultaModel model) {
        return service.repository.save(model); 
    }

}
