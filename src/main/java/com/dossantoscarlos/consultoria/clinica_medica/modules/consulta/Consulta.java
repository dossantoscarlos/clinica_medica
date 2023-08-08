package com.dossantoscarlos.consultoria.clinica_medica.modules.consulta;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.agenda.Agenda;

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

    @Column()
    private Date diaConsulta;
    
    @Column()
    private String horaConsulta;

    @Column()
    private String medicoId;
    
    @Column()
    private String exameId;
    
    @Column()
    private String pacienteId;
    
    @OneToMany
    private List<Agenda> agenda;
}
