package com.example.portalparlamentar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Erro 400 - Bad Request (exemplo: dados inválidos ou malformados)
    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(NegocioException ex) {
        ErrorResponse errorResponse = new ErrorResponse("400", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Erro 500 - Internal Server Error (erro genérico para falhas no servidor)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleInternalServerError(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("500", "Erro interno no servidor. Tente novamente mais tarde.");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Erro 404 - Not Found (quando o recurso não for encontrado)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
        String dynamicMessage = "O recurso solicitado não foi encontrado.";  // Mensagem padrão
        if (ex.getResourceType() != null) {
            dynamicMessage = "O " + ex.getResourceType() + " não foi encontrado.";
        }
        ErrorResponse errorResponse = new ErrorResponse("404", dynamicMessage);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
