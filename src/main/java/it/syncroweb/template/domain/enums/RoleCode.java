package it.syncroweb.template.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RoleCode {
    AUTISTA("USER_AUTISTA"),
    AMMINISTRATORE("AMMINISTRATORE");

    private String name;

    public static RoleCode fromRole(String role) {
        for (RoleCode roleCode : RoleCode.values()) {
            if (roleCode.getName().equals(role)) {
                return roleCode;
            }
        }
        throw new IllegalArgumentException("No enum constant with role " + role);
    }
}
