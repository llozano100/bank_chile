package com.bank.user.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String fullName;
    private String email;
    private String password;
    private List<Phone> phones;

    @Data
    public static class Phone{
        private String number;
        private String cityCode;
        private String countryCode;
    }


}
