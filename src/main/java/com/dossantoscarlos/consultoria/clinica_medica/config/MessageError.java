package com.dossantoscarlos.consultoria.clinica_medica.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class MessageError {
	
	public Map<String, String> handleMessage(String error) {
		Map<String, String> errors = new HashMap<>();
        String fieldName = "Message";
        errors.put(fieldName, error);
        return errors;
	}
	
	public Map<String,String> errorMessageRequest (MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            errors.put(fieldName, error.getDefaultMessage());
        });
        return errors;
	}
}
