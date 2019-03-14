package com.kamarou.pokershmoker.service.config;

import com.kamarou.pokershmoker.service.dto.entity.ErrorDTO;
import com.kamarou.pokershmoker.service.exception.InternalServerException;
import com.kamarou.pokershmoker.service.exception.LogicException;
import com.kamarou.pokershmoker.service.exception.NotFoundException;
import com.kamarou.pokershmoker.service.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(value = NotFoundException.class)
  public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException e) {
    return createErrorResponse(e, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = ValidationException.class)
  public ResponseEntity<ErrorDTO> handleValidationException(ValidationException e) {
    return createErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = LogicException.class)
  public ResponseEntity<ErrorDTO> handleLogicException(LogicException e) {
    return createErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = InternalServerException.class)
  public ResponseEntity<ErrorDTO> handleInternalServerException(InternalServerException e) {
    return createErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ResponseEntity<ErrorDTO> createErrorResponse(RuntimeException e, HttpStatus httpStatus) {
    return ResponseEntity.status(httpStatus).body(new ErrorDTO(e.getMessage()));
  }
}
