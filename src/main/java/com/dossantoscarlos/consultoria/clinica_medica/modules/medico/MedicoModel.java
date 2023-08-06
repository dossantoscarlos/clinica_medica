package com.dossantoscarlos.consultoria.clinica_medica.modules.medico;

import java.util.List;
import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.agenda.AgendaModel;

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
@Table(name = "medicos")
public class MedicoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column
	private String nome;
	
	@Column
	private String sobrenome;
	
	@Column
	private String crm;
	
	@Column
	private String rg;
	
	@Column 
	private String cpf;
	
	@OneToMany
	private List<AgendaModel> agenda;
	
}
