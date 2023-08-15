package com.dossantoscarlos.consultoria.clinica_medica.modules.consulta.model;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.patient.model.Patient;
import com.dossantoscarlos.consultoria.clinica_medica.modules.schedule.model.Schedule;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="consultas")
public class Consulta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Date diaConsulta;
    private String horaConsulta;
    private String medicoId;

    @OneToMany
    private List<Patient> patient;

    @OneToMany
    private List<Schedule> agenda;
}
