package iftm.orm.emails.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import iftm.orm.emails.service.exceptions.NaoEncontrado;

@ControllerAdvice
public class ExceptionsController {

	@ExceptionHandler(NaoEncontrado.class)
	public ResponseEntity<?> naoAchei(NaoEncontrado e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}