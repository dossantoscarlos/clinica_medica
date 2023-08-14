package com.dossantoscarlos.consultoria.clinica_medica.modules.consulta.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.consulta.model.Consulta;
import com.dossantoscarlos.consultoria.clinica_medica.modules.consulta.service.ConsultaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/api/v1/consultas", produces = {"application/json"})
@Tag(name = "Consulta" , description = "Rotas de consulta" )
public class ConsultaController {
    
    @Autowired
    ConsultaService service;

    @GetMapping()
    public List<Consulta> pegaTodasConsulta() {
        return service.repository.findAll(); 
    }

    @GetMapping("/{id}")
    public Consulta getConsultaOne(@RequestAttribute UUID id ) {
         var consulta = service.repository.findById(id);
         return consulta.orElseThrow();
    }
    
    @PostMapping()
    public Consulta salvaConsulta(@RequestBody @Valid Consulta model) {
        return service.repository.save(model); 
    }

}
