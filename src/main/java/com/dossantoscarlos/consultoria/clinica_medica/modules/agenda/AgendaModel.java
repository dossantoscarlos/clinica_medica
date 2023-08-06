package com.dossantoscarlos.consultoria.clinica_medica.modules.agenda;

import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.consulta.ConsultaModel;
import com.dossantoscarlos.consultoria.clinica_medica.modules.medico.MedicoModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "agendas")
public class AgendaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@ManyToOne
	private MedicoModel medico;
	
	@ManyToOne
	private ConsultaModel consulta;
	
}
