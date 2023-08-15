package com.dossantoscarlos.consultoria.clinica_medica.modules.exams.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.exams.dto.ExamDTO;
import com.dossantoscarlos.consultoria.clinica_medica.modules.exams.dto.ExamUpdateDTO;
import com.dossantoscarlos.consultoria.clinica_medica.modules.exams.model.Exam;
import com.dossantoscarlos.consultoria.clinica_medica.modules.exams.repository.ExamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
	
	@Autowired
	private ExamRepository repository;

	public Exam save(ExamDTO examDTO) {
		return this.repository.saveAndFlush(this.examCreateDTOConvertExam(examDTO));
	}

	public Exam update(ExamUpdateDTO exameUpdateDTO, UUID uuid) {
		var findExam = this.repository.findById(uuid).orElseThrow();
		return this.repository.saveAndFlush(this.examUpdateDTOConvertExam(findExam, exameUpdateDTO));
	}
	
	public String delete( UUID id ) {
		repository.deleteById(id);
		return "OK";
	}

	public List<Exam> findAll() {
		return this.repository.findAll();
	}

	public Exam findById(UUID id) {
		return this.repository.findById(id).orElseThrow();
	}

	private Exam examCreateDTOConvertExam(ExamDTO examDTO) {
		Exam exam = new Exam();
		exam.setNome(examDTO.nome());
		exam.setDescricaoCurta(examDTO.descricaoCurta());
		exam.setDescricaoLonga(examDTO.descricaoLonga());
		return exam;
	}

	private Exam examUpdateDTOConvertExam(Exam examUpdate, ExamUpdateDTO examUpdateDTO) {
		examUpdate.setNome(examUpdateDTO.nome());
		examUpdate.setDescricaoCurta(examUpdateDTO.descricaoCurta());
		examUpdate.setDescricaoLonga(examUpdateDTO.descricaoLonga());
		return examUpdate;
	}
}
