package br.com.desafio.application.exception;

import java.nio.file.AccessDeniedException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.context.request.WebRequest;

import br.com.desafio.domain.common.entity.DefaultErrorMessage;
import br.com.desafio.domain.exception.BadRequestException;
import br.com.desafio.domain.exception.ForbiddenException;
import br.com.desafio.domain.exception.NotFoundException;
import br.com.desafio.domain.exception.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;


@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<DefaultErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
	DefaultErrorMessage errorMessage = new DefaultErrorMessage(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
	
	log.error(errorMessage.toString());
    
    return new ResponseEntity<DefaultErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  @ExceptionHandler(RestClientResponseException.class)
  public ResponseEntity<DefaultErrorMessage> restClientResponseException(RestClientResponseException ex, WebRequest request) throws Exception {
	int statusCode = ex.getRawStatusCode();
	
	switch (statusCode) {
		case 400:
			return badRequestException(ex, request);
		case 401:
			return unauthorizedException(ex, request);
		case 403:
			return forbiddenException(ex, request);
		case 404:
			return notFoundException(ex, request);
		default:
			return globalExceptionHandler(ex, request);
	}
  }
  
  // 400
  @ExceptionHandler({BadRequestException.class})
  public ResponseEntity<DefaultErrorMessage> badRequestException(Exception ex, WebRequest request) {
    DefaultErrorMessage errorMessage = new DefaultErrorMessage(
        HttpStatus.BAD_REQUEST.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
    
	log.error(errorMessage.toString());
    
    return new ResponseEntity<DefaultErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
  }
  
  // 401
  @ExceptionHandler({UnauthorizedException.class})
  public ResponseEntity<DefaultErrorMessage> unauthorizedException(Exception ex, WebRequest request) {
    DefaultErrorMessage errorMessage = new DefaultErrorMessage(
        HttpStatus.UNAUTHORIZED.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
    
	log.error(errorMessage.toString());
    
    return new ResponseEntity<DefaultErrorMessage>(errorMessage, HttpStatus.UNAUTHORIZED);
  }
  
  // 403
  @ExceptionHandler({ForbiddenException.class, AccessDeniedException.class})
  public ResponseEntity<DefaultErrorMessage> forbiddenException(Exception ex, WebRequest request) {
    DefaultErrorMessage errorMessage = new DefaultErrorMessage(
        HttpStatus.FORBIDDEN.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
    
	log.error(errorMessage.toString());
    
    return new ResponseEntity<DefaultErrorMessage>(errorMessage, HttpStatus.FORBIDDEN);
  }
  
  // 404
  @ExceptionHandler({NotFoundException.class})
  public ResponseEntity<DefaultErrorMessage> notFoundException(Exception ex, WebRequest request) {
    DefaultErrorMessage errorMessage = new DefaultErrorMessage(
        HttpStatus.NOT_FOUND.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));

	log.error(errorMessage.toString());
    
    return new ResponseEntity<DefaultErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
  }
}
