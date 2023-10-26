package me.dio.creditapplicationsystem.Exception

import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(DataAccessException::class)
    fun handlerMethodException(ex: DataAccessException): ResponseEntity<ExceptionDatails> {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            ExceptionDatails(
                title = "Conflict, consult the documentation!!",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.CONFLICT.value(),
                exeception = ex.javaClass.toString(),
                datails = mutableMapOf(ex.cause.toString() to ex.message)
            )
        )
    }


    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerMethodException(ex: MethodArgumentNotValidException): ResponseEntity<ExceptionDatails> {
        val erros: MutableMap<String, String?> = HashMap()
        ex.bindingResult.allErrors.stream().forEach() { erro: ObjectError ->
            val fieldName: String = (erro as FieldError).field
            val messageError: String? = erro.defaultMessage


            erros[fieldName] = messageError
        }

        return ResponseEntity(
            ExceptionDatails(
                title = "Bad request, consult the documentation!!",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exeception = ex.javaClass.toString(),
                datails = erros
            ), HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(BusinessException::class)
    fun handlerMethodException(ex: BusinessException): ResponseEntity<ExceptionDatails> {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            ExceptionDatails(
                title = "Conflict, consult the documentation!!",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exeception = ex.javaClass.toString(),
                datails = mutableMapOf(ex.cause.toString() to ex.message)
            )
        )
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handlerMethodException(ex: IllegalArgumentException): ResponseEntity<ExceptionDatails> {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            ExceptionDatails(
                title = "Conflict, consult the documentation!!",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exeception = ex.javaClass.toString(),
                datails = mutableMapOf(ex.cause.toString() to ex.message)
            )
        )
    }
}