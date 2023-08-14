package com.dossantoscarlos.consultoria.clinica_medica.modules.schedule.repository;

import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.schedule.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, UUID>{

}
