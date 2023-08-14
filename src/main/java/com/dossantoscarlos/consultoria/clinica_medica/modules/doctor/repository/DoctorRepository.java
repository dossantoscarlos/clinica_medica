package com.dossantoscarlos.consultoria.clinica_medica.modules.doctor.repository;

import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.doctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, UUID>{

}
