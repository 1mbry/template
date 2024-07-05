package it.syncroweb.template.config;

import it.syncroweb.template.domain.dto.error.ErrorCode;
import it.syncroweb.template.domain.dto.error.ErrorResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;

@EnableWebMvc
@RestControllerAdvice
public class ServiceExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ServiceExceptionHandler.class);

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> noHandlerFoundException(Exception ex) {
        logger.error(ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.RNF);
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(Exception ex) {
        logger.error(ex.getMessage());
        BindingResult result = ((MethodArgumentNotValidException) ex).getBindingResult();
        Map<String, String> errors = new HashMap<>();
        for (ObjectError objError : result.getAllErrors()) {
            FieldError fieldError = (FieldError) objError;
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorResponse errorResponse = new ErrorResponse("The given data was invalid", errors);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> httpMessageNotReadableException(Exception ex) {
        String errMsg = ex.getMessage() != null ? ex.getMessage() : "";
        logger.error(errMsg);
        ErrorResponse errorResponse = new ErrorResponse(errMsg);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> missingRequestHeaderException(Exception ex) {
        String errMsg = ex.getMessage() != null ? ex.getMessage() : "";
        logger.error(errMsg);
        ErrorResponse errorResponse = new ErrorResponse(errMsg);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> genericException(Exception ex) {
        String errMsg = ex.getMessage() != null ? ex.getMessage() : "";
        if (errMsg.isBlank()) {
            logger.error(ExceptionUtils.getStackTrace(ex));
        } else {
            logger.error(errMsg);
        }
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.ISE, errMsg);
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    /* Example
    @ExceptionHandler(OrderException.class)
    public ResponseEntity<ErrorResponse> expiredTokenException(OrderException ex) {
        logger.error(ex.getErrorResponse().getMessage());
        ErrorResponse errorResponse = ex.getErrorResponse();
        HttpStatus httpStatus = ex.getErrorResponse().getErrorCode().getHttpStatus();
        return new ResponseEntity<>(errorResponse, httpStatus);
    }*/
}
