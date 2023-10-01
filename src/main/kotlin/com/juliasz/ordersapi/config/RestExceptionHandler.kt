package com.juliasz.ordersapi.config

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {
    protected fun handleHttpMessageNotReadable(
        ex: MissingServletRequestParameterException?, headers: HttpHeaders?,
        status: HttpStatus?, request: WebRequest?
    ): ResponseEntity<Any> {
        val name = ex?.parameterName
        return ResponseEntity<Any>("Parameter '$name' is missing", HttpStatus.BAD_REQUEST)
    }
}