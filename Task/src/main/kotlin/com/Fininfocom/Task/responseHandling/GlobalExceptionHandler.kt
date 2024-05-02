package com.Fininfocom.Task.responseHandling

import com.Fininfocom.Task.responseHandling.models.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException::class)
    fun <T> handleValidationException(ex: ValidationException): ResponseEntity<Response<T>> {
        val errorResponse = Response<T>(false ,ex.message ?: "Validation failed" )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }

}