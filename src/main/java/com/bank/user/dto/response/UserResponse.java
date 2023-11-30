package com.bank.user.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    private String uuid;
    private String creationDate;
    private String modifiedDate;
    private String lastLogin;
    private String token;
    private Boolean isActive;
    private String message ;

}
