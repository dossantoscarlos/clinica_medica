package com.dossantoscarlos.consultoria.clinica_medica.modules.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {
    
    @Autowired
    ConsultaRepository repository;
    
}
