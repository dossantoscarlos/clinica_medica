package com.dossantoscarlos.consultoria.clinica_medica.modules.consulta.service;

import com.dossantoscarlos.consultoria.clinica_medica.modules.consulta.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {
    
    @Autowired
    public ConsultaRepository repository;
    
}
