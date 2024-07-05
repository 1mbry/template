package it.syncroweb.template.domain.dto.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.syncroweb.template.domain.dto.response.Response;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse extends Response {

    private Map<String, String> errors;
    private String message;
    private ErrorCode errorCode;


    public ErrorResponse(String message) {
        super(message);
        this.message = message;
    }

    public ErrorResponse(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorResponse(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public ErrorResponse(String message, Map<String, String> errors) {
        super(message);
        this.message = message;
        this.errors = errors;
    }

    public ErrorResponse(ErrorCode errorCode, Map<String, String> errors) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public ErrorResponse(Map<String, String> errors, String message, ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errors = errors;
        this.message = message;
        this.errorCode = errorCode;
    }

}
