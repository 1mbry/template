package it.syncroweb.template.exception;

import it.syncroweb.template.domain.dto.error.ErrorResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private ErrorResponse errorResponse;

    public UserNotFoundException(ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
        this.errorResponse = errorResponse;
    }

    public UserNotFoundException(ErrorResponse errorResponse, Throwable cause) {
        super(errorResponse.getMessage(), cause);
        this.errorResponse = errorResponse;
    }

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException(final Throwable cause) {
        super(cause);
    }
}
