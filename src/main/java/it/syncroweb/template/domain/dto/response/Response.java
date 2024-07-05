package it.syncroweb.template.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private String message;

    public Response() {
        super();
    }

    public Response(String message) {
        super();
        this.message = message;
    }
}
