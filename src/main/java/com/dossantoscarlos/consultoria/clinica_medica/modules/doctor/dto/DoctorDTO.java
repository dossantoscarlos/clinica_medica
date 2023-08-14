package com.dossantoscarlos.consultoria.clinica_medica.modules.doctor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record DoctorDTO(
   @NotBlank
   @JsonProperty(value="nome")
   String nome,

   @NotBlank
   @JsonProperty(value="sobrenome")
   String sobrenome,

   @NotBlank
   @JsonProperty(value = "CRM")
   String crm,

   @NotBlank
   @JsonProperty(value = "RG")
   String rg,

   @NotBlank
   @JsonProperty(value = "CPF")
   String cpf
){}
