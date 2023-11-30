package com.bank.user.service;

import com.bank.user.dto.request.UserDto;
import com.bank.user.dto.response.UserResponse;
import com.bank.user.entity.Phone;
import com.bank.user.entity.User;
import com.bank.user.repository.PhoneRepository;
import com.bank.user.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private PhoneRepository phoneRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void save_in_database() throws JsonProcessingException {
        UserDto userDto = convertStringToObject();

        when(userRepository.findByEmail(anyString())).thenReturn(null);
        when(userRepository.saveAndFlush(Mockito.any(User.class)))
                .thenAnswer(i -> i.getArguments()[0]);
        when(phoneRepository.saveAndFlush(Mockito.any(Phone.class)))
                .thenAnswer(i -> i.getArguments()[0]);

        UserResponse userResponse = userService.saveUser(userDto);
        assertNotNull(userResponse);

    }

    private UserDto convertStringToObject() throws JsonProcessingException {
        String requestJson ="{\n" +
                "    \"fullName\": \"Juan Rodriguez\",\n" +
                "    \"email\": \"juan@rodriguez.org\",\n" +
                "    \"password\": \"hunter2\",\n" +
                "    \"phones\": [\n" +
                "        {\n" +
                "            \"number\": \"1234567\",\n" +
                "            \"cityCode\": \"1\",\n" +
                "            \"countryCode\": \"57\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(requestJson, UserDto.class);
    }

    @Test
    void save_in_database_fail() throws JsonProcessingException {
        UserDto userDto = convertStringToObject();
        User user = new User();
        user.setUuid("4ce7e446-c4c2-49a6-89bd-d6cb9c7f7cca");

        when(userRepository.findByEmail(anyString())).thenReturn(user);
        UserResponse userResponse = userService.saveUser(userDto);
        assertEquals("Email is already exists in database", userResponse.getMessage());

    }

}
