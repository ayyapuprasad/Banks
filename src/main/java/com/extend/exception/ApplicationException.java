package com.extend.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class ApplicationException {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String>handlenInvalidArgument(MethodArgumentNotValidException excpection){
		Map<String,String>errorMap = new HashMap<>();
		excpection.getBindingResult().getFieldErrors().forEach(error->{errorMap.put(error.getField(),error.getDefaultMessage());});
		return errorMap;
		
	}

}
