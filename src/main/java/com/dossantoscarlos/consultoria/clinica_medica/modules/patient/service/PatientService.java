package com.dossantoscarlos.consultoria.clinica_medica.modules.patient.service;

import com.dossantoscarlos.consultoria.clinica_medica.modules.patient.dto.PatientDTO;
import com.dossantoscarlos.consultoria.clinica_medica.modules.patient.model.Patient;
import com.dossantoscarlos.consultoria.clinica_medica.modules.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class PatientService {
	
	@Autowired
    private PatientRepository repository;

    public List<Patient> findAll() throws Exception {
        return  repository.findAll();
    }

    public Patient findById(UUID id) throws Exception {
        return  repository.findById(id).orElseThrow();
    }

    public Patient create(PatientDTO patientDTO) {
        return repository.saveAndFlush(this.patientCreateDTOConvertPatient(patientDTO));
    }

    public String delete(UUID id) {
         repository.deleteById(id);
        return "OK";
    }
    
    private Patient patientCreateDTOConvertPatient ( PatientDTO patientDTO) {
         Patient patient = new Patient();
         patient.setRg(patientDTO.rg());
         patient.setCpf(patientDTO.cpf());
         patient.setName(patientDTO.nome());
         patient.setDataNascimento(patientDTO.dataNascimento());
         patient.setSexoBiologico(patientDTO.sexoBiologico());
         return patient;
    }
    
}
