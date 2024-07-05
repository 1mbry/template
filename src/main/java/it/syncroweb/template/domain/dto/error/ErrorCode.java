package it.syncroweb.template.domain.dto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorCode {
    FB("Forbidden", HttpStatus.FORBIDDEN),
    UA("Unauthorized", HttpStatus.UNAUTHORIZED),
    ISE("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR),
    IB("Invalid Body", HttpStatus.BAD_REQUEST),
    IH("Invalid Header", HttpStatus.BAD_REQUEST),
    FE("Bad Request", HttpStatus.BAD_REQUEST),
    RNF("The URL you have reached is not in service at this time", HttpStatus.NOT_FOUND);

    private String message;
    private HttpStatus httpStatus;

}
