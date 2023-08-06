package com.dossantoscarlos.consultoria.clinica_medica.config;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerResponseExceptionApiController extends MessageError {
	
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(TransactionSystemException.class)
    public Map<String, String> handleTransactionSystemException(TransactionSystemException ex) {
		return handleMessage(ex.getMessage());
    }

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MissingPathVariableException.class)
    public Map<String, String> handleMissingPathVariableException(MissingPathVariableException ex) {
		return handleMessage(ex.getMessage());
    }
	
	
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(OptimisticLockingFailureException.class)
    public Map<String, String> handleOptimisticLockingFailureExceptions(OptimisticLockingFailureException ex) {
		return handleMessage(ex.getMessage());
    }
 
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Map<String, String> handleHttpRequestMethodNotSupportedExceptions(HttpRequestMethodNotSupportedException ex) {
		return handleMessage(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, String> handleIllegalArgumentExceptions(IllegalArgumentException ex) {
		return handleMessage(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String, String> handleNoSuchElementExceptions(NoSuchElementException ex) {
		return handleMessage("Recurso não encontrado.");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    	return errorMessageRequest(ex);
    }
}
