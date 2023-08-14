package com.dossantoscarlos.consultoria.clinica_medica.modules.exams.repository;

import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.exams.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, UUID> {

}
